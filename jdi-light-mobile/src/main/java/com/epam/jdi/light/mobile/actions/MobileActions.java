package com.epam.jdi.light.mobile.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;

/**
 * Created by Roman Iovlev on 20.03.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class MobileActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel()
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
