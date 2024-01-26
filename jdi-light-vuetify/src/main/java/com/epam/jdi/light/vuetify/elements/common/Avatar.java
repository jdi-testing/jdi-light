package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;
import com.epam.jdi.light.elements.interfaces.base.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.HasAlignment;
import com.epam.jdi.light.vuetify.interfaces.HasMeasurement;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * Represents avatar Vuetify component on GUI.
 * Avatar is used to display rounded or square user profile pictures.
 * Avatar can contain icon, image or text.
 *
 * @see <a href="https://v2.vuetifyjs.com/en/components/avatars/">Avatars Vuetify documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/">Vuetify test page</a>
 */
public class Avatar extends UIBaseElement<AvatarAssert> implements IsText, IsTile, HasAlignment, HasColor,
        HasIcon, HasImage, HasMeasurement, HasRounded {

    @Override
    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }
}
