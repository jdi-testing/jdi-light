package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
import static java.util.UUID.randomUUID;

public class ActionObject {
    private JoinPoint jp;
    private ProceedingJoinPoint pjp;
    private UUID uuid;

    public ActionObject(JoinPoint joinPoint) {
        this.jp = joinPoint;
        baseInit();
    }
    public ActionObject(ProceedingJoinPoint joinPoint) {
        this.pjp = joinPoint;
        baseInit();
    }
    private void baseInit() {
        uuid = randomUUID();
        try {
            this.elementTimeout = element() != null
                ? element().base().getTimeout()
                : TIMEOUTS.element.get();
        } catch (Throwable ex) {
            this.elementTimeout = 10;
        }
    }
    public UUID uuid() { return uuid; }
    public JoinPoint jp() { return pjp != null ? pjp : jp; }
    public Object execute() throws Throwable {
        return pjp().proceed();
    }
    public ProceedingJoinPoint pjp() {
        return pjp;
    }
    public String stepUId = "";
    public boolean topLevel() {
        return aroundCount() == 1;
    }
    public LogLevels logLevel() {
        return ActionHelper.logLevel(jp());
    }
    public Object object() { return obj.get(); }
    private CacheValue<Object> obj = new CacheValue<>(
            () -> jp().getThis() != null ? jp().getThis() : jp().getSignature().getDeclaringType().getSimpleName());

    public IBaseElement element() { return element.get(); }
    private CacheValue<IBaseElement> element = new CacheValue<>(this::getElement);
    private IBaseElement getElement() {
        try {
            if (jp().getThis() != null && isInterface(getJpClass(jp()), IBaseElement.class)) {
                IBaseElement element = (IBaseElement) jp().getThis();
                if (element.base() != null)
                    return element;
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public int timeout() { return timeout.get(); }
    private int elementTimeout;
    private CacheValue<Integer> timeout = new CacheValue<>(this::getTimeout);
    private int getTimeout() {
        JDIAction ja = jp() != null
            ? getJdiAction(jp())
            : null;
        return ja != null && ja.timeout() != -1
            ? ja.timeout()
            : elementTimeout;
    }

    private void resetElementTimeout() {
        if (element() != null) {
            element().base().waitSec(elementTimeout);
        }
    }
    public void setElementTimeout() {
        if (element() != null) {
            element().base().waitSec(timeout());
        }
    }

    public JFunc1<Object, Object> overrideAction() { return overrideAction.get(); }
    private CacheValue<JFunc1<Object, Object>> overrideAction = new CacheValue<>(this::getOverride);
    private JFunc1<Object, Object> getOverride() {
        String name = jp().getSignature().getName();
        if (isOverride.get().contains(name)) {
            return null;
        }
        JFunc1<Object, Object> override = getOverrideAction(jp());
        if (override != null)
            isOverride.get().add(name);
        return override;
    }
    private static Safe<List<String>> isOverride = new Safe<>(ArrayList::new);
    public void clear() {
        resetElementTimeout();
        isOverride.get().clear();
    }
    public Method jpMethod() {
        return ((MethodSignature)jp().getSignature()).getMethod();
    }
    public Class<?> jpClass() {
        return getJpClass(jp());
    }

    public String methodName() {
        return getMethodName(jp());
    }
    public String className() {
        return getJpClass(jp()).getSimpleName();
    }
    public String methodFullName() {
        return getClassMethodName(jp());
    }
}
