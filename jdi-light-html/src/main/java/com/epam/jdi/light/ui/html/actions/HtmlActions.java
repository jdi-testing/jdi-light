package com.epam.jdi.light.ui.html.actions;

import com.epam.jdi.light.actions.ActionObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.LinqUtils.safeException;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class HtmlActions {
    @Pointcut("within(com.epam.jdi.light.ui.html..*) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {        String classMethod = "";
        try {
            classMethod = getJpClass(jp).getSimpleName() + "." + getMethodName(jp);
            logger.trace("<>@HA: " + classMethod);
        } catch (Exception ignore) { }
        ActionObject jInfo = newInfo(jp, "AO");
        failedMethods.clear();
        try {
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = isTop.get()
                ? stableAction(jInfo)
                : defaultAction(jInfo);
            logger.trace("<>@HA: %s >>> %s",classMethod, (result == null ? "NO RESULT" : result));
            AFTER_JDI_ACTION.execute(jInfo, result);
            return result;
        } catch (Throwable ex) {
            logger.debug("<>@HA exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
}
