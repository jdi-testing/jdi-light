package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.ui.bootstrap.elements.complex.CardImageCaps;

import static com.epam.jdi.light.asserts.core.SoftAssertUtils.jdiAssert;
import static org.hamcrest.Matchers.is;


public class CardImageCapsAssert extends UIAssert<CardImageCapsAssert, CardImageCaps> {
    @JDIAction("Assert that {0} is equal \'img\'")
    private CardImageCapsAssert assertTag(String tagName) {
        jdiAssert(tagName, is("img"));
        return this;
    }

    public CardImageCapsAssert imageOnTop() {
        String elementTag = element.childs().get(1).getTagName();
        assertTag(elementTag);

        return this;
    }

    public CardImageCapsAssert imageBelow() {
        WebList children = element.childs();
        String elementTag = children.get(children.size()).getTagName();
        assertTag(elementTag);

        return this;
    }
}
