package com.epam.jdi.light.vuetify.actions;

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
import static com.epam.jdi.light.actions.ActionHelper.getJpClass;
import static com.epam.jdi.light.actions.ActionHelper.getMethodName;
import static com.epam.jdi.light.actions.ActionHelper.newInfo;
import static com.epam.jdi.light.actions.ActionHelper.stableAction;
import static com.epam.jdi.light.actions.ActionProcessor.isTop;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.safeException;

@SuppressWarnings("unused")
@Aspect
public class VuetifyActions {
    @Pointcut("within(com.epam.jdi.light.vuetify..*) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {
        // this method is created only for passing as a parameter in the annotation @Around
    }

    @Around("jdiPointcut()")
    public Object jdiAround(final ProceedingJoinPoint jp) {        String classMethod = "";
        try {
            classMethod = getJpClass(jp).getSimpleName() + "." + getMethodName(jp);
            logger.trace("<>@AA: " + classMethod);
        } catch (Exception ignore) { }
        ActionObject jInfo = newInfo(jp, "AO");
        failedMethods.clear();
        try {
            BEFORE_JDI_ACTION.execute(jInfo);
            Object result = isTop.get()
                    ? stableAction(jInfo)
                    : defaultAction(jInfo);
            logger.trace("<>@AA: %s >>> %s",classMethod, (result == null ? "NO RESULT" : result));
            AFTER_JDI_ACTION.execute(jInfo, result);
            return result;
        } catch (Throwable ex) {
            logger.debug("<>@AA exception:" + safeException(ex));
            throw ACTION_FAILED.execute(jInfo, ex);
        }
        finally {
            if (jInfo != null)
                jInfo.clear();
        }
    }
}
