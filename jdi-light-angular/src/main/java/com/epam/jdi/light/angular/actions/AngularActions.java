package com.epam.jdi.light.angular.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.ACTION_FAILED;
import static com.epam.jdi.light.actions.ActionHelper.AFTER_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionHelper.BEFORE_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionHelper.defaultAction;
import static com.epam.jdi.light.actions.ActionHelper.failedMethods;
import static com.epam.jdi.light.actions.ActionHelper.stableAction;
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
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel() ? stableAction(jInfo) : defaultAction(jInfo);
            return AFTER_JDI_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            logger.debug("ActionProcessor exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        } finally {
            jInfo.clear();
        }
    }
}
