package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.GetOverrideAction;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.base.OutputTemplates.FAILED_ACTION_TEMPLATE;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.LinqUtils.where;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static com.epam.jdi.tools.StringUtils.msgFormat;
import static com.epam.jdi.tools.Timer.nowTime;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { }
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        try {
            if (aroundCount() > 1)
                return defaultAction(jp);
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jp);
            if (aroundCount() == 1)
                getDriver().manage().timeouts().implicitlyWait(TIMEOUT.get(), TimeUnit.SECONDS);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            Object element = jp.getThis() != null ? jp.getThis() : new Object();
            throw exception("["+nowTime("mm:ss.S")+"] " + ACTION_FAILED.execute(element, safeException(ex)));
        }
    }

    public static int aroundCount() {
        return where(currentThread().getStackTrace(),
                s -> s.getMethodName().equals("jdiAround")/* ||
                s.getClassName().equals("io.qameta.allure.aspects.StepsAspects")*/)
                .size();
    }
    public static Object defaultAction(ProceedingJoinPoint jp) throws Throwable {
        JDIBase obj = getJdi(jp);
        JFunc1<JDIBase, Object> overrideAction = getOverride(jp, obj);
        return overrideAction != null
                ? overrideAction.execute(obj) : jp.proceed();
    }
    public static JDIBase getJdi(ProceedingJoinPoint jp) {
        return jp.getThis() != null && isInterface(getJpClass(jp), IBaseElement.class)
            ? ((IBaseElement) jp.getThis()).base() : null;
    }
    public static Object stableAction(ProceedingJoinPoint jp) {
        JDIBase obj = null;
        try {
            //logger.logOff();
            //TIMEOUT.freeze();
            String exception = "";
            if (jp.getThis() != null && isInterface(getJpClass(jp), IBaseElement.class))
                obj = ((IBaseElement) jp.getThis()).base();
            JDIAction ja = getJpMethod(jp).getMethod().getAnnotation(JDIAction.class);
            JFunc1<JDIBase, Object> overrideAction = getOverride(jp, obj);
            int timeout = getTimeout(ja, obj);
            long start = currentTimeMillis();
            do {
                try {
                    Object result = overrideAction != null
                        ? overrideAction.execute(obj) : jp.proceed();
                    if (!condition(jp)) continue;
                    return result;
                } catch (Throwable ex) {
                    try {
                        exception = safeException(ex);
                        Thread.sleep(200);
                    } catch (Exception ignore) {
                    }
                }
            } while (currentTimeMillis() - start < timeout * 1000);
            throw exception(getFailedMessage(jp, exception));
        } finally {
            /*if (obj != null)
                obj.dropToGlobalTimeout();
            logger.logOn();
            TIMEOUT.unfreeze();*/
        }
    }
    private static JFunc1<JDIBase, Object> getOverride(ProceedingJoinPoint jp, JDIBase obj) {
        return obj != null ? GetOverrideAction(jp) : null;
    }
    private static int getTimeout(JDIAction ja, IBaseElement obj) {
        if (ja != null && ja.timeout() != -1)
            return ja.timeout();
        if (obj != null && obj.base().getTimeout() != -1)
            return obj.base().getTimeout();
        return TIMEOUT.get();
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
                    "Can't get failed message: " + safeException(ex));
        }
    }

    private static String getConditionName(ProceedingJoinPoint jp) {
        JDIAction ja = ((MethodSignature)jp.getSignature()).getMethod().getAnnotation(JDIAction.class);
        return ja != null ? ja.condition() : "";
    }
    public static MapArray<String, JFunc1<Object, Boolean>> CONDITIONS = map(
        $("", result -> true),
        $("true", result -> result instanceof Boolean && (Boolean)result),
        $("false", result -> result instanceof Boolean && !(Boolean)result),
        $("not empty", result -> result instanceof List && ((List)result).size() > 0),
        $("empty", result -> result instanceof List && ((List)result).size() == 0)
    );
    private static boolean condition(ProceedingJoinPoint jp) {
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
            throw exception(ACTION_FAILED.execute(element, safeException(ex)));
        }
    }
}
