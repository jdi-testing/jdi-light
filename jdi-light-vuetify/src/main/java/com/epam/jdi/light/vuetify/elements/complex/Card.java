package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.asserts.CardAssert;

/**
 * To see an example of Card web element please visit https://vuetifyjs.com/en/components/cards
 *
 * There are 4 basic components, v-card-title, v-card-subtitle, v-card-text and v-card-actions
 * accordingly to documentation.
 *
 * If your component has a different locator, override the method in a descendant class.
 *
 */
public class Card extends UIBaseElement<CardAssert> {

    @JDIAction("Get '{name}' title")
    public UIElement title() {
        return core().find(".v-card__title");
    }

    @JDIAction("Get '{name}' subtitle")
    public UIElement subtitle() {
        return core().find(".v-card__subtitle");
    }

    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return core().find(".v-card__text");
    }

    @JDIAction("Get '{name}' actions")
    public UIElement actions() {
        return core().find(".v-card__actions");
    }

    @Override
    public CardAssert is() {
        return new CardAssert().set(this);
    }
}
