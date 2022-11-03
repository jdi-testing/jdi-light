package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AlertAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.IsOutlined;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;
import com.epam.jdi.light.vuetify.interfaces.IsTile;
import com.epam.jdi.light.vuetify.interfaces.HasStyledText;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<AlertAssert> implements IsText, HasIcon, HasColor, HasTheme,
        IsDense, HasMeasurement, HasElevation, IsOutlined, HasRounded, IsShaped, IsTile, HasStyledText {

    @Override
    public AlertAssert is() {
        return new AlertAssert().set(this);
    }
}
