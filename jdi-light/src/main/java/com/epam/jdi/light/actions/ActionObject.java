package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.logger.LogLevels;
import com.jdiai.tools.CacheValue;
import com.jdiai.tools.PrintUtils;
import com.jdiai.tools.Safe;
import com.jdiai.tools.func.JFunc1;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.*;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.settings.JDISettings.TIMEOUTS;
import static com.jdiai.tools.LinqUtils.map;
import static com.jdiai.tools.ReflectionUtils.isClass;
import static com.jdiai.tools.ReflectionUtils.isInterface;

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
            elementTimeout = isBase()
                ? element().getTimeout()
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
            () -> instance() != null ? instance() : jp().getSignature().getDeclaringType().getSimpleName());

    public Object instance() {
        return getJpInstance(jp());
    }
    public JDIBase element() {
        try {
            if (instance() != null && isInterface(getJpClass(jp()), IBaseElement.class)) {
                IBaseElement element = (IBaseElement) instance();
                if (element.base() != null)
                    return element.base();
            }
            return null;
        } catch (Throwable ex) {
            return null;
        }
    }
    public boolean isBase() {
        return element() != null;
    }
    public boolean isPage() {
        return instance() != null && isClass(instance().getClass(), WebPage.class);
    }
    public boolean isCore() {
        return core() != null;
    }
    public WebPage page() {
        return (WebPage) instance();
    }
    public ICoreElement core() {
        try {
            if (instance() != null && isInterface(getJpClass(jp()), ICoreElement.class)) {
                ICoreElement element = (ICoreElement) instance();
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
        if (isBase()) {
            element().waitSec(elementTimeout());
        }
    }
    public void setElementTimeout() {
        if (isBase()) {
            elementTimeout = element().getTimeout();
            element().waitSec(timeout());
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
    public boolean isAssert() {
        return isClass(jpClass(), Alerts.class);
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

    public String print() {
        String result = processor;
        try {
            result += "[" + aroundCount() + "]: ";
        } catch (Throwable ignore) { }
        try {
            result += className() + "." + methodName() + "(";
            if (jp().getArgs().length > 0) {
                result += PrintUtils.print(map(jp().getArgs(), o -> o.getClass().getSimpleName()));
            }
            result += "); ";
        } catch (Throwable ignore) { }
        try {
            if (isBase())
                result += "Element: " + element().toString() + "; ";
        } catch (Throwable ignore) { }
        return result;
    }
}
