package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.vuetify.annotations.JDILazy;
import com.epam.jdi.light.vuetify.asserts.LazyAssert;
import com.epam.jdi.tools.Timer;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class Lazy extends UIBaseElement<LazyAssert> implements ISetup {

    protected String itemLocator = ".mx-auto.v-card";

    public UIElement hiddenItem() {
        if (itemLocator.isEmpty()) {
            return core();
        }
        return $(itemLocator);
    }

    @Override
    public boolean isHidden() {
        return core().isHidden();
    }

    @Override
    @JDIAction("Check that '{name}' is displayed")
    public boolean isDisplayed() {
        return core().isDisplayed();
    }

    @JDIAction("Scroll to '{name}'")
    public void scrollIntoView() {
        Timer.waitCondition(this::isDisplayed);
        core().jsExecute("scrollIntoView()");
    }

    public LazyAssert is() {
        return new LazyAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!field.isAnnotationPresent(JDILazy.class)) {
            return;
        }
        itemLocator = field.getAnnotation(JDILazy.class).item();
    }
}
