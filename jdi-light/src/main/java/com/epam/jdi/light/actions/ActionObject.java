package com.epam.jdi.light.actions;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.settings.JDISettings;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.aroundCount;
import static com.epam.jdi.light.actions.ActionHelper.getJdiAction;
import static com.epam.jdi.light.actions.ActionHelper.getJpClass;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.settings.JDISettings.getJDISettings;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ActionObject {
    private final JDISettings jdiSettings = getJDISettings();
    private ProceedingJoinPoint jp;
    private final CacheValue<Object> obj = new CacheValue<>(
            () -> jp.getThis() != null ? jp.getThis() : new Object());
    public String stepUId = "";
    private int elementTimeout;
    private final CacheValue<Integer> timeout = new CacheValue<>(this::getTimeout);
    private final CacheValue<JFunc1<Object, Object>> overrideAction = new CacheValue<>(this::getOverride);
    private static final Safe<List<String>> isOverride = new Safe<>(ArrayList::new);
    private final CacheValue<IBaseElement> element = new CacheValue<>(this::getElement);

    public ActionObject(ProceedingJoinPoint joinPoint) {
        this.jp = joinPoint;
        try {
            this.elementTimeout = element() != null
                    ? element().base().getTimeout()
                    : jdiSettings.TIMEOUTS.element.get();
        } catch (Throwable ex) {
            this.elementTimeout = 10;
        }
    }

    public ProceedingJoinPoint jp() {
        return jp;
    }

    public boolean topLevel() {
        return aroundCount() == 1;
    }

    public Object object() {
        return obj.get();
    }

    public IBaseElement element() {
        return element.get();
    }

    private IBaseElement getElement() {
        try {
            if (jp.getThis() != null && isInterface(getJpClass(jp), IBaseElement.class)) {
                IBaseElement element = (IBaseElement) jp.getThis();
                if (element.base() != null)
                    return element;
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public int timeout() { return timeout.get(); }

    private int getTimeout() {
        JDIAction ja = jp != null
                ? getJdiAction(jp)
                : null;
        return ja != null && ja.timeout() != -1
                ? ja.timeout()
                : elementTimeout;
    }

    private void resetElementTimeout() {
        if (element() != null)
            element().base().waitSec(elementTimeout);
    }

    public void setElementTimeout() {
        if (element() != null)
            element().base().waitSec(timeout());
    }

    public JFunc1<Object, Object> overrideAction() {
        return overrideAction.get();
    }

    private JFunc1<Object, Object> getOverride() {
        String name = jp.getSignature().getName();
        if (isOverride.get().contains(name)) {
            return null;
        }
        JFunc1<Object, Object> override = getOverrideAction(jp);
        if (override != null)
            isOverride.get().add(name);
        return override;
    }

    public void clear() {
        resetElementTimeout();
        isOverride.get().clear();
    }
}
