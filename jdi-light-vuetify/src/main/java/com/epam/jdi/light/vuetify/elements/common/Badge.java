package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
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

    @JDIAction("Get '{name}' body")
    public UIElement body() {
        return find("/*");
    }

    @Override
    public Icon icon() {
        return new Icon().setCore(Icon.class, badge().find("i"));
    }

    @JDIAction("Get '{name}' image")
    public UIElement image() {
        return badge().find(".v-image__image");
    }

    @JDIAction("Get '{name}' dot")
    public UIElement dot() {
        return badge();
    }

    @JDIAction("Get '{name}' type")
    public String type() {
        String type = "Text";
        if (isDot()) {
            type = "Dot";
        } else if (hasImage()) {
            type = "Image";
        } else if (hasIcon()) {
            type = "Icon";
        }
        return type;
    }

    @JDIAction("Get '{name}' badge")
    public UIElement badge() {
        return find(".v-badge__wrapper").find("span");
    }

    @JDIAction("Get '{name}' badge text")
    public String badgeText() {
        return badge().getText();
    }

    @JDIAction("Get '{name}' badge number")
    public int badgeNumber() {
        return Integer.parseInt(badge().getText());
    }

    @JDIAction("Check that '{name}' is bordered")
    public boolean isBordered() {
        return core().hasClass("v-badge--bordered");
    }

    @JDIAction("Check that '{name}' is inline")
    public boolean isInline() {
        return core().hasClass("v-badge--inline");
    }

    @JDIAction("Check that '{name}' is bottom")
    public boolean isBottom() {
        return core().hasClass("v-badge--bottom");
    }

    @JDIAction("Check that '{name}' is left")
    public boolean isLeft() {
        return core().hasClass("v-badge--left");
    }

    @JDIAction("Check that '{name}' is overlap")
    public boolean isOverlap() {
        return core().hasClass("v-badge--overlap");
    }

    @JDIAction("Check that '{name}' is dot")
    public boolean isDot() {
        return iCore().hasClass("v-badge--dot") && dot().isDisplayed();
    }

    @JDIAction("Check that '{name}' is tile")
    public boolean isTile() {
        return core().hasClass("v-badge--tile");
    }


    @JDIAction("Check that '{name}' has image")
    public boolean hasImage() {
        return iCore().hasClass("v-badge--avatar") && badge().isDisplayed();
    }

    @Override
    public boolean hasIcon() {
        return iCore().getAttribute("class").contains("v-badge--icon")
            && badge().isDisplayed();
    }
}
