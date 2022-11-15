package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BadgeAssert;
import com.epam.jdi.light.vuetify.interfaces.HasAlignment;
import com.epam.jdi.light.vuetify.interfaces.HasColor;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasImage;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsTile;

/**
 * To see an example of Badge web element please visit https://vuetifyjs.com/en/components/badges/
 */

public class Badge extends UIBaseElement<BadgeAssert> implements IsText, IsTile, HasAlignment,
        HasClick, HasColor, HasIcon, HasImage, HasTheme {

    @JDIAction("Get '{name}' badge")
    public UIElement badge() {
        return core().find(".v-badge__badge");
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

    @JDIAction("Check that '{name}' is overlap")
    public boolean isOverlap() {
        return core().hasClass("v-badge--overlap");
    }

    @JDIAction("Check that '{name}' is dot")
    public boolean isDot() {
        return core().hasClass("v-badge--dot");
    }

    @JDIAction("Check that '{name}' is avatar")
    public boolean isAvatar() {
        return core().hasClass("v-badge--avatar");
    }

    @Override
    @JDIAction("Get '{name}' background color")
    public String backgroundColor() {
        return badge().css("background-color");
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @Override
    @JDIAction("Get '{name}' image")
    public Image image() {
        return new Image().setCore(Image.class, badge().find(".v-image"));
    }

    @Override
    public boolean isDisplayed() {
        return badge().isDisplayed(); }

    @Override
    public boolean hasIcon() {
        return core().hasClass("v-badge--icon");
    }

    @Override
    @JDIAction("Get '{name}' badge text")
    public String getText() {
        return badge().getText();
    }
}
