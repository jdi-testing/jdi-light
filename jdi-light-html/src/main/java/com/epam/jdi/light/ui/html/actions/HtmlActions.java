package com.epam.jdi.light.ui.html.actions;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.ui.html.elements.complex.Dropdown;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionProcessor.stableAction;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.InitActions.INTERFACES;
import static com.epam.jdi.tools.Timer.nowTime;

@SuppressWarnings("unused")
@Aspect
public class HtmlActions {

    @Pointcut("execution(* *(..)) && @annotation(com.epam.jdi.light.common.JDIAction)")
    protected void jdiPointcut() { }

    @Around("jdiPointcut()")
    public Object jdiAround(ProceedingJoinPoint jp) {
        try {
            BEFORE_JDI_ACTION.execute(jp);
            Object result = stableAction(jp);
            return AFTER_JDI_ACTION.execute(jp, result);
        } catch (Throwable ex) {
            Object element = jp.getThis() != null ? jp.getThis() : new Object();
            throw exception("["+nowTime("mm:ss.S")+"] " + ACTION_FAILED.execute(element, ex.getMessage()));
        }
    }
    @Before("execution(* com.epam.jdi.light.elements.init.preInit())")
    public void before() {
        INTERFACES.add(IsDropdown.class, Dropdown.class);
    }
}
