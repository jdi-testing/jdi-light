package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.IHasSize;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.base.HasUIList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.WindowsAssert;
import com.epam.jdi.tools.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.UIUtils.initT;
import static com.epam.jdi.tools.ReflectionUtils.getGenericTypes;

public class Windows<T extends ICoreElement> extends UIBaseElement<WindowsAssert> implements ISetup {

    protected String ACTIVE_LOCATOR = ".v-window-item--active";
    protected String HIDDEN_LOCATOR = "style=\"display: none;\"";

    protected String ITEMS_LOCATOR = ".v-window-item";

    protected Class<?> itemClass;

    public T getActive() {
        return initT(core().find(ACTIVE_LOCATOR), this, itemClass);
    }

    public <G> G getActive(Class<G> activeClass) {
        return initT(core().find(ACTIVE_LOCATOR), this, activeClass);
    }

    @Override
    public void setup(Field field) {
        itemClass = ReflectionUtils.getGenericType(field);
    }
}
