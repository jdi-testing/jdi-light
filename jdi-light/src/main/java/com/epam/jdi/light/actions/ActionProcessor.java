package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.ScreenshotMaker;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.GetOverrideAction;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.base.OutputTemplates.FAILED_ACTION_TEMPLATE;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.Timer.nowTime;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {

    public static Safe<JDIBase> jdiBaseLastProcessed = new Safe<>(() -> null);

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }

    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        return jdiBeforeAfter(jp);
    }

    public static Object jdiBeforeAfter(ProceedingJoinPoint jp) {
        try {
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jp);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable exception) {
            if (!(exception instanceof RuntimeException)) {
                provideExtraInfoOnFail(jp.getSignature().toShortString());
            }
            throw exception("[" + nowTime("mm:ss.S") + "] " + ACTION_FAILED.execute(jdiBaseLastProcessed, exception.getMessage()));
        }
    }

    protected static Object stableAction(ProceedingJoinPoint jp) {
        try {
            logger.logOff();
            TIMEOUT.freeze();
            String exception = "";
            JDIAction ja = getJpMethod(jp).getMethod().getAnnotation(JDIAction.class);
            int timeout = ja != null && ja.timeout() != -1
                    ? ja.timeout()
                    : TIMEOUT.get();
            JFunc1<JDIBase, Object> overrideAction = null;
            boolean replace = false;
            if (jp.getThis() != null && JDIBase.class.isAssignableFrom(jp.getThis().getClass())) {
                jdiBaseLastProcessed.set((JDIBase) jp.getThis());
                overrideAction = GetOverrideAction(jp);
                replace = overrideAction != null;
            }
            long start = currentTimeMillis();
            do {
                try {
                    Object result = replace ? overrideAction.execute(jdiBaseLastProcessed.get()) : jp.proceed();
                    if (!condition(jp)) continue;
                    return result;
                } catch (Throwable ex) {
                    try {
                        exception = ex.getMessage();
                        Thread.sleep(200);
                    } catch (Exception ignore) {
                    }
                }
            } while (currentTimeMillis() - start < timeout * 1000);
            throw exception(getFailedMessage(jp, exception));
        } finally {
            logger.logOn();
            TIMEOUT.unfreeze();
        }
    }

    private static String getFailedMessage(ProceedingJoinPoint jp, String exception) {
        MethodSignature method = getJpMethod(jp);
        try {
            String result = msgFormat(FAILED_ACTION_TEMPLATE, map(
                $("exception", exception),
                $("timeout", TIMEOUT.get()),
                $("action", method.getMethod().getName())
            ));
            return fillTemplate(result, jp, method);
        } catch (Exception ex) {
            throw new RuntimeException("Surround method issue: " +
                    "Can't get failed message: " + ex.getMessage());
        }
    }

    private static String getConditionName(ProceedingJoinPoint jp) {
        JDIAction ja = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
        return ja != null ? ja.condition() : "";
    }

    private static MapArray<String, JFunc1<Object, Boolean>> CONDITIONS = map(
        $("", result -> true),
        $("true", result -> result instanceof Boolean && (Boolean)result),
        $("false", result -> result instanceof Boolean && !(Boolean)result),
        $("not empty", result -> result instanceof List && !((List) result).isEmpty()),
        $("empty", result -> result instanceof List && ((List) result).isEmpty())
    );

    private static boolean condition(ProceedingJoinPoint jp) {
        String conditionName = getConditionName(jp);
        return CONDITIONS.has(conditionName)
            ? CONDITIONS.get(conditionName).execute(jp)
            : true;
    }

    public static void provideExtraInfoOnFail(String method) {
        if (jdiBaseLastProcessed == null) {
            return;
        }

        boolean screenOnFail = SCREENSHOT_STRATEGY.equals("on fail");
        boolean htmlCodeLogOnFail = HTML_CODE_LOGGING.equals("on fail");

        if (htmlCodeLogOnFail || screenOnFail) {
            logger.step(format("Method \"%s\" failure details:", method));
        }
        if (htmlCodeLogOnFail) {
            try {
                logger.step(format("Last processed element's html code: %s", jdiBaseLastProcessed.get().printHtml()));
            } catch (Exception e) {
                logger.step("Can't get element's html code.");
            }
        }
        if (screenOnFail) {
            try {
                jdiBaseLastProcessed.get().highlight();
            } catch (Exception e) {
                logger.step("Can't highlight element.");
            }
            try {
                new ScreenshotMaker().takeScreenshot(format("Method_%s_failed_at_", method), "dd-MM-yyyy_HH-mm-ss");
            } catch (Exception e) {
                logger.step("Can't take page screenshot.");
            }
        }
    }

    @Around("stepPointcut()")
    public Object stepAround(ProceedingJoinPoint jp) throws Throwable {
        try {
            BEFORE_STEP_ACTION.execute(jp);
            Object result = jp.proceed();
            return AFTER_STEP_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            Object element = jp.getThis() != null ? jp.getThis() : new Object();
            throw exception(ACTION_FAILED.execute(element, ex.getMessage()));
        }
    }

}
