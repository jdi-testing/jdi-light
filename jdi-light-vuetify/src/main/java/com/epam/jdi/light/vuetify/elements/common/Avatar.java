package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;
import com.epam.jdi.tools.Timer;

/**
 * To see an example of Avatar web element please visit https://vuetifyjs.com/en/components/avatars/
 */

public class Avatar extends UIBaseElement<AvatarAssert> {


    @JDIAction("Get '{name}' photo")
    private UIElement getPhoto() {
        return this.find("img");
    }

    @JDIAction("Get '{name}' icon")
    private UIElement getIcon() {
        return this.find("i");
    }

    @JDIAction("'{name}' has photo")
    public String hasPhoto() {
        Timer.waitCondition(getPhoto()::isDisplayed);
        return getPhoto().getTagName();
    }

    @JDIAction("'{name}' has icon")
    public boolean hasIcon() {
        Timer.waitCondition(getIcon()::isDisplayed);
        return getIcon().getAttribute("class").contains("v-icon");
    }

    @JDIAction("Get {name} size")
    public String hasSize() {
        return this.core().getAttribute("style");
    }

    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }

    public AvatarAssert has() {
        return this.is();
    }
}
