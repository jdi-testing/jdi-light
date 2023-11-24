package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SheetAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * To see an example of Sheet web element please visit <a href="https://jdi-testing.github.io/jdi-light/vuetify/sheets">Sheet</a>
 */
public class Sheet extends UIBaseElement<SheetAssert> implements IsText, HasColor, HasElevation,
    HasTheme, IsOutlined, IsShaped, IsTile, HasMeasurement, HasRounded, HasClick {

    @Override
    public SheetAssert is() {
        return new SheetAssert().set(this);
    }

    @Override
    @JDIAction("Get 'name' color")
    public String color() {
        return backgroundColor();
    }

    @JDIAction("Get '{name}' border-radius")
    public int borderRadius() {
        return Integer.parseInt(core().css("border-radius").replace("px", ""));
    }
}
