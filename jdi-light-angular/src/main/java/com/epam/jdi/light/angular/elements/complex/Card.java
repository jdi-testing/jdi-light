package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.CardAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.webList;

/**
 * To see an example of Card web element please visit https://material.angular.io/components/card/overview.
 */

public class Card extends UIBaseElement<CardAssert> {
    @JDIAction("Get '{name}' header")
    public com.epam.jdi.light.elements.common.uiElement getHeader() {
        return this.find(".mat-card-header");
    }

    @JDIAction("Get '{name}' avatar")
    public com.epam.jdi.light.elements.common.uiElement getAvatar() {
        return this.find(".mat-card-avatar");
    }

    @JDIAction("Get '{name}' header text")
    public com.epam.jdi.light.elements.common.uiElement getHeaderText() {
        return this.find(".mat-card-header-text");
    }

    @JDIAction("Get '{name}' title")
    public com.epam.jdi.light.elements.common.uiElement getTitle() {
        return this.find(".mat-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public com.epam.jdi.light.elements.common.uiElement getSubtitle() {
        return this.find(".mat-card-subtitle");
    }

    @JDIAction("Get '{name}' image")
    public com.epam.jdi.light.elements.common.uiElement getImage() {
        return this.find(".mat-card-image");
    }

    @JDIAction("Get '{name}' content")
    public com.epam.jdi.light.elements.common.uiElement getContent() {
        return this.find(".mat-card-content");
    }

    @JDIAction("Get '{name}' buttons")
    public webList getButtons() {
        return this.finds(".mat-button");
    }

    @JDIAction("Get '{name}' text")
    public String getCardText() {
        return core().getText();
    }

    @JDIAction("Get button with text '{text}'")
    public com.epam.jdi.light.elements.common.uiElement getButtonByText(String text) {
        return this.getButtons().get(text);
    }

    @JDIAction("Get button with number '{number}'")
    public com.epam.jdi.light.elements.common.uiElement getButtonByNumber(int number) {
        return this.getButtons().get(number);
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
