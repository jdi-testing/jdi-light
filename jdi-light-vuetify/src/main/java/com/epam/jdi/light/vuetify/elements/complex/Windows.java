package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static com.epam.jdi.light.common.UIUtils.initT;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

public class Windows<T extends ICoreElement> extends UIBaseElement<UIAssert<?,?>> implements ISetup {

    protected Class<T> itemClass;

    private UIElement active() {
        return core().find(".v-window-item--active");
    }

    @JDIAction("Get active window from '{name}'")
    public T getActive() {
        if (itemClass != null) {
            return initT(active(), this, itemClass);
        }
        throw new UnsupportedOperationException("Can't return active window, item class in diamond operator not found");
    }

    @JDIAction("Get active window as '{0}' from '{name}'")
    public <U> U getActive(Class<U> clazz) {
        return clazz.cast(initT(active(), this, clazz));
    }

    @Override
    public void setup(Field field) {
        Type type = getGenericTypes(field)[0];
        itemClass = type.toString().equals("?") ? null : (Class<T>) type;
    }
}
