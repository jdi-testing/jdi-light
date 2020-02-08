package com.epam.jdi.light.actions;

import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.CacheValue;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc1;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.actions.ActionHelper.getJpClass;
import static com.epam.jdi.light.actions.ActionOverride.getOverrideAction;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ActionObject {
    public ActionObject(ProceedingJoinPoint joinPoint) {
        this.jp = joinPoint;
    }
    public ProceedingJoinPoint jp() { return jp; }
    private ProceedingJoinPoint jp;
    public Object object() { return obj.get(); }
    private CacheValue<Object> obj = new CacheValue<>(
        () -> jp.getThis() != null ? jp.getThis() : new Object());

    public IBaseElement element() { return element.get(); }
    private CacheValue<IBaseElement> element = new CacheValue<>(this::getElement);
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
    private CacheValue<Integer> timeout = new CacheValue<>(
        () -> element() != null ? element().base().getTimeout(): TIMEOUT.get());

    void setElementTimeout() {
        if (element() != null)
            element().base().waitSec(timeout());
    }

    public JFunc1<Object, Object> overrideAction() { return overrideAction.get(); }
    private CacheValue<JFunc1<Object, Object>> overrideAction = new CacheValue<>(this::getOverride);
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
    private static Safe<List<String>> isOverride = new Safe<>(ArrayList::new);
    public void clear() {
        setElementTimeout();
        isOverride.get().clear();
    }
}
