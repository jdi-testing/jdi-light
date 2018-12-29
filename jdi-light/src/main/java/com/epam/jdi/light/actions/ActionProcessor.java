package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.WebSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.map.MapArray.map;
import static com.epam.jdi.tools.pairs.Pair.$;
import static java.lang.System.currentTimeMillis;

@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        BEFORE_JDI_ACTION.execute(jp);
        Object result = stableAction(jp);
        return AFTER_JDI_ACTION.execute(jp, result);
    }

    private static Object stableAction(ProceedingJoinPoint jp) {
        long start = currentTimeMillis();
        Throwable exception = null;
        logger.logOff();
        do { try {
            Object result =  jp.proceed();
            boolean c = condition(jp);
            if (!condition(jp)) continue;
            logger.logOn();
            return result;
        } catch (Throwable ex) {
            try {
                exception = ex;
                Thread.sleep(200);
            } catch (Exception ignore) {  } }
        } while (currentTimeMillis() - start < TIMEOUT*1000);
        logger.logOn();
        throw exception("Failed to execute %s action during %s seconds. Exception: %s",
                jp.getSignature().getName(), TIMEOUT, exception);
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
    public Object stepAround(ProceedingJoinPoint jp) throws Throwable {
        BEFORE_STEP_ACTION.execute(jp);
        Object result = jp.proceed();
        return AFTER_STEP_ACTION.execute(jp, result);
    }
}
