package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.FooterAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.IsContainer;

/**
 * To see an example of Footer web element please visit https://vuetifyjs.com/en/components/footer/
 *
 * According to the documentation:
 * "The v-footer component in its simplest form is a container."
 *
 * No other specification is given.
 *
 * Created by Nikita Nechepurenko on 29.09.2021
 */
public class Footer extends UIBaseElement<FooterAssert> implements IsText, HasColor, HasTheme, HasElevation,
        HasMeasurement, IsOutlined, HasRounded, IsShaped, IsTile, IsContainer {
    @Override
    public FooterAssert is() {
        return new FooterAssert().set(this);
    }

    @JDIAction("Get if '{name}' is padless")
    public boolean isPadless() {
        return hasClass("v-footer--padless");
    }

    @JDIAction("Get if '{name}' is absolute")
    public boolean isAbsolute() {
        return hasClass("v-footer--absolute");
    }

    @JDIAction("Get if '{name}' is fixed")
    public boolean isFixed() {
        return hasClass("v-footer--fixed");
    }

    @JDIAction("Get if '{name}' is fixed")
    public UIElement content() {
        return core().firstChild();
    }

    @JDIAction("Get {name} content")
    public <T extends UIElement> T content(Class<T> clazz) {
        return this.content().with(clazz);
    }
}
