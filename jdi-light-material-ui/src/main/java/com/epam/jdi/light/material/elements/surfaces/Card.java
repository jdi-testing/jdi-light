package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.CardAssert;

/**
 * Represents Card MUI component on GUI.
 * <p>Cards are surfaces that display content and actions on a single topic.
 * They should be easy to scan for relevant and actionable information.
 * Elements, like text and images, should be placed on them in a way that clearly indicates hierarchy.</p>
 *
 * @see <a href="https://v4.mui.com/components/cards/">Card MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/card_surface">MUI test page</a>
 */
public class Card extends UIBaseElement<CardAssert> {

    /**
     * Gets title element of this Card.
     *
     * @return title element of this Card as {@link UIElement}
     */
    @JDIAction("Get '{name}' title")
    public UIElement title() {
        return core().find(".MuiCardHeader-title");
    }

    /**
     * Gets sub header element of this Card.
     *
     * @return sub header element of this Card as {@link UIElement}
     */
    @JDIAction("Get '{name}' sub header")
    public UIElement subHeader() {
        return core().find(".MuiCardHeader-subheader");
    }

    /**
     * Gets actions element of this Card.
     *
     * @return actions element of this Card as {@link UIElement}
     */
    @JDIAction("Get '{name}' actions")
    public UIElement actions() {
        return core().find(".MuiCardActions-root");
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
