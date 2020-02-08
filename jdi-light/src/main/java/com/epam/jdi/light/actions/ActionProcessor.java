package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.PrintUtils;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.base.OutputTemplates.FAILED_ACTION_TEMPLATE;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.where;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.Timer.nowTime;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;
import static java.util.Collections.reverse;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    public static MapArray<String, JFunc1<Object, Boolean>> CONDITIONS = map(
        $("", result -> true),
        $("true", result -> result instanceof Boolean && (Boolean) result),
        $("false", result -> result instanceof Boolean && !(Boolean) result),
        $("not empty", result -> result instanceof List && ((List) result).size() > 0),
        $("empty", result -> result instanceof List && ((List) result).size() == 0)
    );
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { // empty
    }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { // empty
    }
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            if (aroundCount() > 1)
                return defaultAction(jInfo);
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jInfo);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            addFailedMethod(jp);
            if (aroundCount() == 1) {
                logFailure(jInfo.object());
                reverse(failedMethods);
                logger.error("Failed actions chain: " + PrintUtils.print(failedMethods, " > "));
            }
            throw exception(ex, ACTION_FAILED.execute(jInfo.object(), getExceptionAround(ex, aroundCount() == 1)));
        }
        finally {
            jInfo.clear();
        }
    }
    public static void addFailedMethod(ProceedingJoinPoint jp) {
        String[] s = jp.toString().split("\\.");
        String result = s[s.length-2]+"."+s[s.length-1].replaceAll("\\)\\)", ")");
        if (!failedMethods.contains(result))
            failedMethods.add(result);
    }
    public static List<String> failedMethods = new ArrayList<>();
    public static String getExceptionAround(Throwable ex, boolean time) {
        String result = safeException(ex);
        while (result.contains("\n\n"))
            result = result.replaceFirst("\\n\\n", LINE_BREAK);
        result = result.replace("java.lang.RuntimeException:", "").trim();
        if (aroundCount() == 1)
            result = "[" + nowTime("mm:ss.S") + "] " + result.replaceFirst("\n", "");
        return result;
    }
    public static int aroundCount() {
        return where(currentThread().getStackTrace(),
                s -> s.getMethodName().equals("jdiAround")/* ||
                s.getClassName().equals("io.qameta.allure.aspects.StepsAspects")*/)
                .size();
    }
    public static Object defaultAction(ActionObject jInfo) throws Throwable {
        jInfo.setElementTimeout();
        return jInfo.overrideAction() != null
                ? jInfo.overrideAction().execute(jInfo.object()) : jInfo.jp().proceed();
    }
    public static Object stableAction(ActionObject jInfo) {
        String exceptionMsg = "";
        jInfo.setElementTimeout();
        long start = currentTimeMillis();
        Throwable exception = null;
        do {
            try {
                logger.info("!>>");
                Object result = jInfo.overrideAction() != null
                        ? jInfo.overrideAction().execute(jInfo.object()) : jInfo.jp().proceed();
                logger.info("!<<");
                if (!condition(jInfo.jp())) continue;
                return result;
            } catch (Throwable ex) {
                exception = ex;
                try {
                    exceptionMsg = safeException(ex);
                    Thread.sleep(200);
                } catch (Exception ignore) {
                }
            }
        } while (currentTimeMillis() - start < jInfo.timeout() * 1000);
        throw exception(exception, getFailedMessage(jInfo, exceptionMsg));
    }
    static String getFailedMessage(ActionObject jInfo, String exception) {
        MethodSignature method = getJpMethod(jInfo.jp());
        try {
            String result = msgFormat(FAILED_ACTION_TEMPLATE, map(
                $("exception", exception),
                $("timeout", jInfo.timeout()),
                $("action", method.getMethod().getName())
            ));
            return fillTemplate(result, jInfo.jp(), method);
        } catch (Exception ex) {
            throw exception(ex, "Surround method issue: Can't get failed message");
        }
    }
    static String getConditionName(ProceedingJoinPoint jp) {
        JDIAction ja = getJdiAction(jp);
        return ja != null ? ja.condition() : "";
    }
    static boolean condition(ProceedingJoinPoint jp) {
        String conditionName = getConditionName(jp);
        return CONDITIONS.has(conditionName)
            ? CONDITIONS.get(conditionName).execute(jp)
            : true;
    }
    @Around("stepPointcut()")
    public Object stepAround(ProceedingJoinPoint jp) {
        try {
            BEFORE_STEP_ACTION.execute(jp);
            Object result = jp.proceed();
            return AFTER_STEP_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            Object element = jp.getThis() != null ? jp.getThis() : new Object();
            throw exception(ex, ACTION_FAILED.execute(element, safeException(ex)));
        }
    }
}
