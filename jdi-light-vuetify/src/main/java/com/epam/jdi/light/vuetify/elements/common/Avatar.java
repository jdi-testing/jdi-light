package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;

/**
 * Represents avatar Vuetify component on GUI.
 * Avatar used to display rounded or square user profile pictures.
 * Avatar can contain icon, image or text.
 *
 * @see <a href="https://vuetifyjs.com/en/components/avatars/">Avatars</a>
 */
public class Avatar extends UIBaseElement<AvatarAssert> implements HasIcon, HasImage, IsText {

    @Override
    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }
}
