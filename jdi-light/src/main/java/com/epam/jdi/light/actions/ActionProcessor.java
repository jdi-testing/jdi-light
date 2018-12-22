package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.WebSettings.TIMEOUT;
import static com.epam.jdi.light.settings.WebSettings.logger;
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
        do { try {
            logger.logOff();
            Object result =  jp.proceed();
            logger.logOn();
            return result;
        } catch (Throwable ex) {
            try {
                Thread.sleep(200);
            } catch (Exception ignore) {} }
        } while (currentTimeMillis() - start < TIMEOUT*1000);
        throw exception("Failed to execute %s action during %s seconds",
                jp.getSignature().getName(), TIMEOUT);
    }

    @Around("stepPointcut()")
    public Object stepAround(ProceedingJoinPoint jp) {
        BEFORE_STEP_ACTION.execute(jp);
        Object result = stableAction(jp);
        return AFTER_STEP_ACTION.execute(jp, result);
    }
}
