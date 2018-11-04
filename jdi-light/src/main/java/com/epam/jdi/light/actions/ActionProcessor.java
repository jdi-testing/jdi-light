package com.epam.jdi.light.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import static com.epam.jdi.light.actions.ActionHelper.*;

@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() { }

    @Before("jdiPointcut()")
    public void before(JoinPoint joinPoint) {
        if (jdiBefore != null)
            jdiBefore.execute(joinPoint);
    }

    @AfterReturning(pointcut = "jdiPointcut()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        if (jdiAfter != null)
            jdiAfter.execute(joinPoint, result);
    }

    @AfterThrowing(pointcut = "jdiPointcut()", throwing = "error")
    public void error(JoinPoint joinPoint, Throwable error) {
        if (jdiError != null) {
            if (!ERROR_THROWN) {
                ERROR_THROWN = true;
                jdiError.execute(joinPoint, error);
            }
        }
    }
    @Before("stepPointcut()")
    public void beforeStep(JoinPoint joinPoint) {
        if (stepBefore != null)
            stepBefore.execute(joinPoint);
    }

    @AfterReturning(pointcut = "stepPointcut()", returning = "result")
    public void afterStep(JoinPoint joinPoint, Object result) {
        if (stepAfter != null)
            stepAfter.execute(joinPoint, result);
    }

    @AfterThrowing(pointcut = "stepPointcut()", throwing = "error")
    public void errorStep(JoinPoint joinPoint, Throwable error) {
        if (jdiError != null)
            jdiError.execute(joinPoint, error);
    }
}
