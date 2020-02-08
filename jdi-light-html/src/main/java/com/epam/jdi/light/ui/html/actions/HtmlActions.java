package com.epam.jdi.light.ui.html.actions;

import com.epam.jdi.light.actions.ActionObject;
import com.epam.jdi.tools.PrintUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionProcessor.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.util.Collections.reverse;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class HtmlActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        ActionObject jInfo = new ActionObject(jp);
        try {
            failedMethods.clear();
            if (aroundCount() > 1)
                return defaultAction(jInfo);
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jInfo);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            addFailedMethod(jp);
            if (aroundCount() == 1) {
                logFailure(jInfo.object());
                reverse(failedMethods);
                logger.error("Failed actions chain: " + PrintUtils.print(failedMethods, " > "));
            }
            throw exception(ex, ACTION_FAILED.execute(jInfo.object(), getExceptionAround(ex, aroundCount() == 1)));
        }
        finally {
            jInfo.clear();
        }
    }
}
