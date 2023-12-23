package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.WindowsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.UIUtils.initT;
import static com.jdiai.tools.ReflectionUtils.getGenericTypes;

/**
 * To see an example of Windows web element please visit
 * https://vuetifyjs.com/en/components/windows/
 */
public class Windows<T extends ICoreElement> extends UIBaseElement<WindowsAssert> implements ISetup, HasTheme {
    protected Class<T> itemClass;

    @Override
    public WindowsAssert is() {
        return new WindowsAssert().set(this);
    }

    @JDIAction("Get active window from '{name}'")
    public UIElement active() {
        return core().find(".v-window-item--active");
    }

    @JDIAction("Get '{name}' previous button")
    public Button previousButton() {
        return new Button().setCore(Button.class, core().find(".v-window__prev > button"));
    }

    @JDIAction("Get '{name}' next button")
    public Button nextButton() {
        return new Button().setCore(Button.class, core().find(".v-window__next > button"));
    }

    @JDIAction("Get active window from '{name}'")
    public T activeItem() {
        return itemClass.cast(initT(active(), this, itemClass));
    }

    @JDIAction("Get active window as '{0}' from '{name}'")
    public <W> W activeItem(Class<W> clazz) {
        return clazz.cast(initT(active(), this, clazz));
    }

    @JDIAction("Get active window as '{0}' from '{name}'")
    public List<T> items() {
        return core().finds(".v-window-item").stream()
                .map(e -> itemClass.cast(initT(e, this, itemClass)))
                .collect(Collectors.toList());
    }

    @Override
    public void setup(Field field) {
        Type type = getGenericTypes(field)[0];
        itemClass = type.toString().equals("?") ? null : (Class<T>) type;
    }

    @JDIAction("Get if '{name}' shows arrows on hover")
    public boolean showArrowsOnHover() {
        return core().hasClass("v-window--show-arrows-on-hover");
    }
}
