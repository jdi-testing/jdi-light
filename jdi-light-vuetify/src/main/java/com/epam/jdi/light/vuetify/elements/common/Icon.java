package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.IconAssert;
import com.epam.jdi.tools.Timer;

import static com.epam.jdi.light.driver.WebDriverFactory.jsExecute;

public class Icon extends UIBaseElement<IconAssert> {


    @JDIAction("Get {name} photo")
    public UIElement getPhoto() {
        return this.find("img");
    }

    @JDIAction("Get {name} photo")
    public UIElement getIcon() {
        return this.find("i");
    }

    @JDIAction("Get {name} photo")
    public String hasPhoto() {
        Timer.waitCondition(getPhoto()::isDisplayed);
        return getPhoto().getTagName();
    }

    @JDIAction("Get {name} icon")
    public boolean hasIcon() {
        Timer.waitCondition(getIcon()::isDisplayed);
        return getIcon().getAttribute("class").contains("v-icon");
    }

    @JDIAction("Get {name} size")
    public String properSize() {
        return this.core().getAttribute("style");
    }

    public void scrollIntoView() {
        jsExecute("arguments[0].scrollIntoView(true);", this.core().getFast());
    }

    public IconAssert is() {
        return new IconAssert().set(this);
    }

    public IconAssert has() {
        return this.is();
    }
}
