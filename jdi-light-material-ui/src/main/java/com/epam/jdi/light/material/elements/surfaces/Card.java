package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.CardAssert;

/**
 * To see an example of Card web element please visit
 * https://material-ui.com/components/cards/
 */

public class Card extends UIBaseElement<CardAssert> {

    @JDIAction("Get '{name}' title")
    public UIElement title() {
        return core().find(".MuiCardHeader-title");
    }

    @JDIAction("Get '{name}' subheader")
    public UIElement subtitle() {
        return core().find(".MuiCardHeader-subheader");
    }

    @JDIAction("Get '{name}' actions")
    public UIElement actions() {
        return core().find(".MuiCardActions-root");
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
