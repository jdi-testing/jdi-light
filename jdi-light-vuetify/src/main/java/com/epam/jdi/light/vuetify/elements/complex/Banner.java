package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BannerAssert;
import com.epam.jdi.light.vuetify.elements.common.Icon;

/**
 * To see an example of Banner web element please visit https://vuetifyjs.com/en/components/banners/
 */

public class Banner extends UIBaseElement<BannerAssert> implements IsText {

    @JDIAction("Get '{name}'s button group")
    public ButtonGroup buttons() {
        return new ButtonGroup(find(".v-banner__actions"));
   }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find("i"));
    }

    @JDIAction("Get '{name}'s text content")
    public String getText() {
        return this.core().find(".v-banner__text").getText();
    }

    public BannerAssert is() {
        return new BannerAssert().set(this);
    }
}
