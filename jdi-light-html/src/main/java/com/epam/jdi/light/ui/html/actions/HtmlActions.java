package com.epam.jdi.mobile.ui.html.actions;

import com.epam.jdi.tools.PrintUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.TimeUnit;

import static com.epam.jdi.mobile.actions.ActionHelper.*;
import static com.epam.jdi.mobile.actions.ActionProcessor.*;
import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.mobile.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.mobile.settings.WebSettings.logger;
import static java.util.Collections.reverse;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
@SuppressWarnings("unused")
@Aspect
public class HtmlActions {
    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.mobile.common.JDIAction)")
    protected void jdiPointcut() { }
    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        try {
            failedMethods.clear();
            if (aroundCount() > 1)
                return defaultAction(jp);
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jp);
            isOverride.get().clear();
            if (aroundCount() == 1)
                getDriver().manage().timeouts().implicitlyWait(TIMEOUT.get(), TimeUnit.SECONDS);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            Object element = getObjAround(jp);
            addFailedMethod(jp);
            if (aroundCount() == 1) {
                logFailure(element);
                reverse(failedMethods);
                logger.error("Failed actions chain: " + PrintUtils.print(failedMethods, " > "));
            }
            throw exception(ex, ACTION_FAILED.execute(element, getExceptionAround(ex, aroundCount() == 1)));
        }
    }
}
