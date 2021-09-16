package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;

public class Avatar extends UIBaseElement<AvatarAssert> {

    @JDIAction("Get {name} photo")
    public String hasPhoto() {
        return core().firstChild().getTagName();
    }

    @JDIAction("Get {name} size")
    public String properSize() {
        return core().getAttribute("style");
    }

    @JDIAction("Get {name} icon")
    public boolean hasIcon() {
        return core().firstChild().hasClass("v-icon");
    }

    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }

    public AvatarAssert has() {
        return this.is();
    }
}
