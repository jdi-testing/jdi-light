package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.elements.displaydata.Chip;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;
import org.hamcrest.Matcher;
import static org.hamcrest.Matchers.containsString;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ChipAssert extends UIAssert<ChipAssert, Chip> {
    @JDIAction("Assert that chip label with index {index} is displayed")
    public ChipAssert displayed(final int index) {
        jdiAssert(element().getChipLabel(index).isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that of chip label {index} text is '{0}'")
    public ChipAssert text(final int index, Matcher<String> condition) {
        jdiAssert(element().getChipLabel(index).getText(), condition);
        return this;
    }

    @JDIAction("Assert that chip root with index {index} is disabled")
    public ChipAssert disabled(final int index){
        element().getChipRoot(index).is().classValue(containsString("Mui-disabled"));
        return this;
    }

    @JDIAction("Assert that chip root with index {index} is clickable")
    public ChipAssert clickable(final int index){
        jdiAssert(element().getChipLabel(index).isClickable(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that URL contains {url}")
    public ChipAssert urlContains(String url){
        boolean urlContains = new Timer(base().getTimeout() * 1000L)
                .wait(() -> WebPage.verifyUrl(url));
        jdiAssert(urlContains, Matchers.is(true));
        return this;
    }
}
