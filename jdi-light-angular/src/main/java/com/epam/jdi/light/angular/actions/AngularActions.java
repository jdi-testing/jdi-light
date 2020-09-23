package com.epam.jdi.light.angular.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.settings.WebSettings.logger;

/**
 * Created by Roman Iovlev on 14.02.2018.
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class AngularActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {
        // this method is created only for passing as a parameter in the annotation @Around
    }

    @Around("jdiPointcut()")
    public Object jdiAround(final ProceedingJoinPoint jp) {
        try {
            logger.debug("AngularActions.jdiAround(): " + getMethodName(jp));
        } catch (Exception ignore) { }
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
            logger.debug("AngularActions exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
}
