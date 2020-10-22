package com.epam.jdi.light.actions;

import com.epam.jdi.tools.Safe;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.safeException;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    @Pointcut("within(com.epam.jdi.light..*) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {  }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() {  }
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDebug)")
    protected void debugPointcut() {  }

    public static Safe<List<ActionObject>> jStack = new Safe<>(new ArrayList<>());

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        try {
            logger.trace("<> AO: " + getMethodName(jp));
        } catch (Exception ignore) { }
        ActionObject jInfo = null;
        try {
            jInfo = newInfo(jp, "AO");
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel()
                ? stableAction(jInfo)
                : defaultAction(jInfo);
            logger.trace("<> AO: " + getMethodName(jp) + " >>> " +
                (result == null ? "NO RESULT" : result));
            AFTER_JDI_ACTION.execute(jInfo, result);
            return result;
        } catch (Throwable ex) {
            logger.debug("AO exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
    @Around("debugPointcut()")
    public Object debugAround(ProceedingJoinPoint jp) {
        logger.debug("<> JDebug: " + getMethodName(jp));
        ActionObject jInfo = newInfo(jp, "AO");
        try {
            Object result = jp.proceed();
            logger.debug("<> JDebug: " + getMethodName(jp) + " >>> " +
                (result == null ? "NO RESULT" : result));
            return result;
        } catch (Throwable ex) {
            throw exception(safeException(ex));
        }
    }

    @Before("stepPointcut()")
    public void step(JoinPoint jp) {
        ActionObject jInfo = null;
        try {
            jInfo = newInfo(jp, "AO");
            beforeStepAction(jInfo);
        } catch (Throwable ex) {
            logger.debug("StepProcessor exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
}
