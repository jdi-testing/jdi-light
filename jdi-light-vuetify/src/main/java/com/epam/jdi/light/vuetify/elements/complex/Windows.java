package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.WindowsAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import static com.epam.jdi.light.common.UIUtils.initT;
import static com.jdiai.tools.ReflectionUtils.getGenericTypes;

/**
 * To see an example of Windows web element please visit
 * https://vuetifyjs.com/en/components/windows/
 */
public class Windows<T extends ICoreElement> extends UIBaseElement<WindowsAssert> implements ISetup, HasTheme {
    @Override
    public WindowsAssert is() {
        return new WindowsAssert().set(this);
    }

    protected Class<T> itemClass;

    protected UIElement active() {
        return core().find(".v-window-item--active");
    }
    protected UIElement actions() {
        return core().find("//following-sibling::div[contains(@class, 'v-card__actions')]");
    }
    protected WebList nextPreviousButtons() {
        return actions().finds("button");
    }

    @JDIAction("Get '{name}' previous button")
    public Button previousButton() {
        return new Button().setCore(Button.class, nextPreviousButtons().get(1));
    }

    @JDIAction("Get '{name}' next button")
    public Button nextButton() {
        return new Button().setCore(Button.class, nextPreviousButtons().get(2));
    }

    public WebList navigation() {
        return actions().finds(".v-item-group button");
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

    @JDIAction("Check that '{name}' shows arrows on hover")
    public boolean showArrowsOnHover() {
        return hasClass("v-window--show-arrows-on-hover");
    }
}
