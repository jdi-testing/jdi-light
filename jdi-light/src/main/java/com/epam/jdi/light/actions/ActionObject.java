package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
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

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ActionObject {
    private JoinPoint jp;
    private ProceedingJoinPoint pjp;
    private String processor;

    private ActionObject(String name) {
        this.processor = name;
    }
    public ActionObject(JoinPoint joinPoint, String name) {
        this(name);
        this.jp = joinPoint;
    }
    public ActionObject(ProceedingJoinPoint joinPoint, String name) {
        this(name);
        this.pjp = joinPoint;
    }
    private int elementTimeout = -1;
    private int elementTimeout() {
        if (elementTimeout > -1)
            return elementTimeout;
        try {
            elementTimeout = element() != null
                ? element().base().getTimeout()
                : TIMEOUTS.element.get();
        } catch (Throwable ex) {
            elementTimeout = 10;
        }
        return elementTimeout;
    }
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

    public IBaseElement element() {
        try {
            if (jp().getThis() != null && isInterface(getJpClass(jp()), IBaseElement.class)) {
                IBaseElement element = (IBaseElement) jp().getThis();
                if (element.base() != null)
                    return element;
            }
            return null;
        } catch (Throwable ex) {
            return null;
        }
    }
    public ICoreElement core() {
        try {
            if (jp().getThis() != null && isInterface(getJpClass(jp()), ICoreElement.class)) {
                ICoreElement element = (ICoreElement) jp().getThis();
                if (element.core() != null)
                    return element;
            }
            return null;
        } catch (Throwable ex) {
            return null;
        }
    }

    public int timeout() { return timeout.get(); }
    private CacheValue<Integer> timeout = new CacheValue<>(this::getTimeout);
    private int getTimeout() {
        JDIAction ja = jp() != null
            ? jdiAnnotation()
            : null;
        return ja != null && ja.timeout() != -1
            ? ja.timeout()
            : elementTimeout();
    }
    public JDIAction jdiAnnotation() {
        return getJdiAction(jp());
    }
    public boolean isAssertAnnotation() {
        JDIAction ja = getJdiAction(jp());
        return ja != null && ja.isAssert();
    }

    private void resetElementTimeout() {
        if (element() != null) {
            element().base().waitSec(elementTimeout());
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

    @Override
    public String toString() {
        String result = processor;
        try {
            result += "[" + aroundCount() + "]: ";
        } catch (Throwable ignore) { }
        try {
            result += className() + "." + methodName() + "(";
            if (jp().getArgs().length > 0) {
                result += print(map(jp().getArgs(), o -> o.getClass().getSimpleName()));
            }
            result += "); ";
        } catch (Throwable ignore) { }
        try {
            result += "Element: " + element().base().toString() + "; ";
        } catch (Throwable ignore) { }
        return result;
    }
}
