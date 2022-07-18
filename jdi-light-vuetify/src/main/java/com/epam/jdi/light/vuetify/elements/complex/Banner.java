package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/banners/
 */

public class Banner extends UIBaseElement<BannerAssert> implements IsText {

    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttons() {
        return new ButtonGroup(actions());
   }

    @JDIAction("Get '{name}' text content")
    public String getText() {
        return core().find(".v-banner__text").getText();
    }

    @JDIAction("Get '{name}' content element")
    public UIElement content() {
        return core().find(".v-banner__content");
    }

    public UIElement getIconFromContent() {
        return content().find("div.v-banner__icon");
    }

    @JDIAction("Get '{name}' actions element")
    public UIElement actions() {
        return core().find(".v-banner__actions");
    }

    public String[] getLines() {
        return getText().split("\n");
    }
    public BannerAssert is() {
        return new BannerAssert().set(this);
    }
}
