package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.asserts.surfaces.CardAssert;

/**
 * To see an example of Tooltip web element please visit
 * https://material-ui.com/components/cards/
 */

public class Card extends UIBaseElement<CardAssert> {

    @JDIAction("Get '{name}' header")
    public UIElement getHeader() {
        return this.find(".MuiCardHeader-root");
    }

    @JDIAction("Get '{name}' header avatar")
    public UIElement getHeaderAvatar() {
        return this.getHeader().find(".MuiCardHeader-avatar");
    }

    @JDIAction("Get '{name}' header title")
    public UIElement getHeaderTitle() {
        return this.getHeader().find(".MuiCardHeader-title");
    }

    @JDIAction("Get '{name}' header subheader")
    public UIElement getHeaderSubheader() {
        return this.getHeader().find(".MuiCardHeader-subheader");
    }

    @JDIAction("Get '{name}' header content")
    public UIElement getHeaderContent() {
        return this.getHeader().find(".MuiCardHeader-content");
    }

    @JDIAction("Get '{name}' header action")
    public UIElement getHeaderAction() {
        return this.getHeader().find(".MuiCardHeader-action");
    }

    @JDIAction("Get '{name}' header action buttons")
    public WebList getHeaderActionButtons() {
        return this.getHeaderAction().finds("button");
    }

    @JDIAction("Get '{name}' content")
    public UIElement getContent() {
        return this.find(".MuiCardContent-root");
    }

    @JDIAction("Get '{name}' buttons")
    public WebList getActionButtons() {
        return this.finds(".MuiCardActions-root button");
    }

    @JDIAction("Get button with number '{number}'")
    public UIElement getActionButtonByNumber(int number) {
        return this.getActionButtons().get(number);
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }

    @Override
    public CardAssert has() {
        return this.is();
    }
}
