package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.CardAssert;
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
        return this.find(".mat-card-header");
    }

    @JDIAction("Get '{name}' avatar")
    public UIElement getAvatar() {
        return this.find(".mat-card-avatar");
    }

    @JDIAction("Get '{name}' header text")
    public UIElement getHeaderText() {
        return this.find(".mat-card-header-text");
    }

    @JDIAction("Get '{name}' title")
    public UIElement getTitle() {
        return this.find(".mat-card-title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement getSubtitle() {
        return this.find(".mat-card-subtitle");
    }

    @JDIAction("Get '{name}' image")
    public UIElement getImage() {
        return this.find(".mat-card-image");
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return this.find(".mat-card-content");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getButtons() {
        return this.finds(".mat-button");
    }

    @JDIAction("Get '{name}' text")
    public String getCardText() {
        return uiElement.getText();
    }

    @JDIAction("Get button with text '{text}'")
    public UIElement getButtonByText(String text){
        return this.getButtons().get(text);
    }

    @JDIAction("Get button with number '{number}'")
    public UIElement getButtonByNumber(int number){
        return this.getButtons().get(number);
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
