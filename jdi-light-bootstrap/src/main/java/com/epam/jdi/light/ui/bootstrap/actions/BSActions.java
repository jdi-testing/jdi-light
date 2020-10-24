package com.epam.jdi.light.ui.bootstrap.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.tools.LinqUtils.safeException;
import static com.epam.jdi.light.settings.WebSettings.logger;

@SuppressWarnings("unused")
@Aspect
public class BSActions {

    @Pointcut("within(com.epam.jdi.light.ui.bootstrap..*) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        String classMethod = "";
        try {
            classMethod = getJpClass(jp).getSimpleName() + "." + getMethodName(jp);
            logger.trace("<>@BS: " + classMethod);
        } catch (Exception ignore) { }
        ActionObject jInfo = null;
        jInfo = newInfo(jp, "BS");
        failedMethods.clear();
        try {
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = jInfo.topLevel()
                    ? stableAction(jInfo)
                    : defaultAction(jInfo);
            logger.trace("<>@BS: " + classMethod + " >>> " +
                    (result == null ? "NO RESULT" : result));
            AFTER_JDI_ACTION.execute(jInfo, result);
            return result;
        } catch (Throwable ex) {
            logger.debug("<>@BS exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
}
