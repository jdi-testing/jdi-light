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
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.composite.WebPage.log;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class ActionProcessor {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {  }
    @Pointcut("execution(* *(..)) && @annotation(io.qameta.allure.Step)")
    protected void stepPointcut() {  }
    public static Safe<List<ActionObject>> jStack = new Safe<>(new ArrayList<>());

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        log("!!! ActionProcessor");
        ActionObject jInfo = null;
        try {
            jInfo = newInfo(jp);
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel()
                ? stableAction(jInfo)
                : defaultAction(jInfo);
            return AFTER_JDI_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            logger.debug("ActionProcessor exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
            log("!!! OUT ActionProcessor");
        }
    }

    @Before("stepPointcut()")
    public void step(JoinPoint jp) {
        log("!!! Step");
        ActionObject jInfo = null;
        try {
            jInfo = newInfo(jp);
            beforeStepAction(jp);
        } catch (Throwable ex) {
            logger.debug("StepProcessor exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
            log("!!! OUT Step");
        }
    }
}
