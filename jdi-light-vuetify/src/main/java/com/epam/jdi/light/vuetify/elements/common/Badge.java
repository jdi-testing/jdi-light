package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BadgeAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;

/**
 * To see an example of Badge web element please visit https://vuetifyjs.com/en/components/badges/
 */

public class Badge extends UIBaseElement<BadgeAssert> implements IsText, HasIcon, HasClick {

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    public UIElement body() {
        return find("/*");
    }

    @Override
    public Icon icon() {
        return new Icon().setCore(Icon.class, badge().find("i"));
    }

    public UIElement image() {
        return badge().find(".v-image__image");
    }
    public UIElement dot() {
        return badge();
    }
    public boolean hasDot() {
        return iCore().getAttribute("class").contains("v-badge--dot") && dot().isDisplayed();
    }

    public boolean hasImage() {
        return iCore().getAttribute("class").contains("v-badge--avatar")
                && badge().isDisplayed();
    }

    @Override
    public boolean hasIcon() {
        return iCore().getAttribute("class").contains("v-badge--icon")
                && badge().isDisplayed();
    }

    public String getType() {
        String type = "Text";
        if (hasDot()) {
            type = "Dot";
        } else if (hasImage()) {
            type = "Image";
        } else if (hasIcon()) {
            type = "Icon";
        }
        return type;
    }

    public UIElement badge() {
        return find(".v-badge__wrapper").find("span");
    }
    public String badgeText() {
        return badge().getText();
    }
    public int badgeNumber() {
        return Integer.parseInt(badge().getText());
    }
}
