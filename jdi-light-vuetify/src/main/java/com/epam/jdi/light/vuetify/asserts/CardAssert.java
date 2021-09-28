package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction("Assert that '{name}' title has value '{0}'")
    public CardAssert title(final Matcher<String> condition) {
        jdiAssert(element().title().getText(), condition);
        return this;
    }

    public CardAssert title(String text) {
        return this.title(equalTo(text));
    }

    @JDIAction("Assert that '{name}' subtitle has value '{0}'")
    public CardAssert subtitle(final Matcher<String> condition) {
        jdiAssert(element().subtitle().getText(), condition);
        return this;
    }

    public CardAssert subtitle(String text) {
        return this.subtitle(equalTo(text));
    }
}
