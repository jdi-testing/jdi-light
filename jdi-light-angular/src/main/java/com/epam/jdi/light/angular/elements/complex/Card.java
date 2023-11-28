package com.epam.jdi.light.angular.elements.complex;

import static com.epam.jdi.light.angular.elements.enums.CardImageSize.EXTRALARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.LARGE;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.MEDIUM;
import static com.epam.jdi.light.angular.elements.enums.CardImageSize.SMALL;

import com.epam.jdi.light.angular.asserts.CardAssert;
import com.epam.jdi.light.angular.elements.enums.CardImageSize;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

/**
 * To see an example of Card web element please visit https://material.angular.io/components/card/overview.
 */

public class Card extends UIBaseElement<CardAssert> {
    @JDIAction("Get '{name}' header")
    public UIElement getHeader() {
        return this.find(".mat-mdc-card-header");
    }

    @JDIAction("Get '{name}' footer")
    public UIElement getFooter() {
        return this.find(".mat-mdc-card-footer");
    }

    @JDIAction("Get '{name}' avatar")
    public UIElement getAvatar() {
        return this.find(".mat-mdc-card-avatar");
    }

    @JDIAction("Get '{name}' header text")
    public UIElement getHeaderText() {
        return this.find(".mat-mdc-card-header-text");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".mat-mdc-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement getSubtitle() {
        return this.find(".mat-mdc-card-subtitle");
    }

    @JDIAction("Get '{name}' image")
    public UIElement getImage() {
        return this.find("//img");
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return this.find(".mat-mdc-card-content");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getButtons() {
        return this.finds("//button");
    }

    @JDIAction("Get '{name}' text")
    public String getCardText() {
        return core().getText();
    }

    @JDIAction("Get button with text '{text}'")
    public UIElement getButtonByText(String text) {
        return this.getButtons().get(text);
    }

    @JDIAction("Get button with number '{number}'")
    public UIElement getButtonByNumber(int number) {
        return this.getButtons().get(number);
    }

    @JDIAction("Get if {name} has align end actions")
    public boolean actionsEndAlign() {
        return finds("mat-card-actions")
            .hasClass("mat-mdc-card-actions-align-end");
    }

    @JDIAction("Get '{name}' size")
    public CardImageSize cardImageSize() {
        UIElement e = core().find("//img");
        if (e.hasClass("mat-mdc-card-xl-image")) {
            return EXTRALARGE;
        }
        if (e.hasClass("mat-mdc-card-lg-image")) {
            return LARGE;
        }
        if (e.hasClass("mat-mdc-card-md-image")) {
            return MEDIUM;
        }
        if (e.hasClass("mat-mdc-card-sm-image")) {
            return SMALL;
        }
        return CardImageSize.UNKNOWN;
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }

    @Override
    public CardAssert has() {
        return is();
    }
}
