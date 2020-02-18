package com.epam.jdi.light.actions;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { // empty
    }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { // empty
    }
    private final String className = "com.epam.jdi.light.actions.ActionProcessor";
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) throws Throwable {
        if (notThisAround(className))
            return jp.proceed();
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            if (aroundCount(className) > 1)
                return defaultAction(jInfo);
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = stableAction(jInfo);
            return AFTER_JDI_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            throw exceptionJdiAround(jInfo, className, ex);
        }
        finally {
            jInfo.clear();
        }
    }
    @Around("stepPointcut()")
    public Object stepAround(ProceedingJoinPoint jp) {
        try {
            ActionObject jInfo = new ActionObject(jp);
            BEFORE_STEP_ACTION.execute(jInfo);
            Object result = jp.proceed();
            return AFTER_STEP_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            Object element = jp.getThis() != null ? jp.getThis() : new Object();
            throw exception(ex, ACTION_FAILED.execute(element, safeException(ex)));
        }
    }
}
