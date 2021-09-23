package com.epam.jdi.light.vuetify.elements.common;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.AvatarAssert;

/**
 * To see an example of Avatar web element please visit https://jdi-testing.github.io/jdi-light/vuetify/avatars
 *
 * From vuetify docs: "The v-avatar component is typically used to display circular user profile pictures.
 * This component will allow you to dynamically size and add a border radius of responsive images, icons, and text.
 * A tile variation is available for displaying an avatar without border radius."
 *
 */

public class Avatar extends UIBaseElement<AvatarAssert> {

    @JDIAction("Get {name} photo")
    public String hasPhoto() {
        return this.find("img").getTagName();
    }

    @JDIAction("Get {name} size")
    public String properSize() {
        return this.core().getAttribute("style");
    }

    @JDIAction("Get {name} icon")
    public boolean hasIcon() {
        return this.find("i").getAttribute("class").contains("v-icon");
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public AvatarAssert is() {
        return new AvatarAssert().set(this);
    }

    public AvatarAssert has() {
        return this.is();
    }
}
