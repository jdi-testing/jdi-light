package com.epam.jdi.light.material.asserts.surfaces;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Card;
import org.hamcrest.Matcher;

public class CardAssert extends UIAssert<CardAssert, Card> {

    @JDIAction("Assert that '{name}' title {0}")
    public CardAssert title(final Matcher<String> condition) {
        jdiAssert(element().title().getText(), condition);
        return this;
    }

    public CardAssert title(String text) {
        return this.title(equalTo(text));
    }

    @JDIAction("Assert that '{name}' subtitle {0}")
    public CardAssert subtitle(final Matcher<String> condition) {
        jdiAssert(element().subtitle().getText(), condition);
        return this;
    }
}
