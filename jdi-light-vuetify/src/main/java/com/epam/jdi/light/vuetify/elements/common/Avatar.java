package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;

/**
 * To see an example of Avatar web element please visit https://vuetifyjs.com/en/components/avatars/
 */

public class Avatar extends UIBaseElement<AvatarAssert> implements HasIcon, HasImage, IsText {

    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }
}
