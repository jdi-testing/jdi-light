package com.epam.jdi.light.ui.bootstrap.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.TimeUnit;

import static com.epam.jdi.light.actions.ActionHelper.ACTION_FAILED;
import static com.epam.jdi.light.actions.ActionHelper.AFTER_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionHelper.BEFORE_JDI_ACTION;
import static com.epam.jdi.light.actions.ActionProcessor.aroundCount;
import static com.epam.jdi.light.actions.ActionProcessor.defaultAction;
import static com.epam.jdi.light.actions.ActionProcessor.getExceptionAround;
import static com.epam.jdi.light.actions.ActionProcessor.getObjAround;
import static com.epam.jdi.light.actions.ActionProcessor.stableAction;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.TimeoutSettingsUtils.TIMEOUT;

@SuppressWarnings("unused")
@Aspect
public class BSActions {

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() {
        // hollow-method
        //required d not remove
    }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        try {
            if (aroundCount() > 1)
                return defaultAction(jp);
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jp);
            if (aroundCount() == 1)
                getDriver().manage().timeouts().implicitlyWait(TIMEOUT.get(), TimeUnit.SECONDS);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            throw exception(ex, ACTION_FAILED.execute(getObjAround(jp), jp, getExceptionAround(ex, aroundCount() == 1)));
        }
    }

}
