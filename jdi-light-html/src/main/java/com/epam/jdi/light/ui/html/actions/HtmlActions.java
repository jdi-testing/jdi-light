package com.epam.jdi.light.ui.html.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class HtmlActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    private final String className = "com.epam.jdi.light.ui.html.actions.HtmlActions";
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
}
