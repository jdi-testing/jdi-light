package com.epam.jdi.light.mobile.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.ACTION_FAILED;
import static com.epam.jdi.light.actions.ActionHelper.AFTER_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionHelper.BEFORE_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionHelper.aroundCount;
import static com.epam.jdi.light.actions.ActionHelper.defaultAction;
import static com.epam.jdi.light.actions.ActionHelper.failedMethods;
import static com.epam.jdi.light.actions.ActionHelper.notThisAround;
import static com.epam.jdi.light.actions.ActionHelper.stableAction;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class MobileActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    private final String className = "com.epam.jdi.light.mobile.actions.MobileActions";
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) throws Throwable {
        if (notThisAround(className))
            return jp.proceed();
        ActionObject jInfo = new ActionObject(jp, className);
        try {
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = aroundCount(className) == 1
                ? stableAction(jInfo)
                : defaultAction(jInfo);
            return AFTER_JDI_ACTION.execute(jInfo, result);
        } catch (Throwable ex) {
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            jInfo.clear();
        }
    }
}
