package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> {

    @JDIAction("Assert that '{name}' is displayed")
    public BannerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has 'checker' element")
    public BannerAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' 'checker' element is checked")
    public BannerAssert checkerChecked() {
        jdiAssert(element().hasCheckerChecked() ? "checker is checked" : "checker is not checked",
                Matchers.is("checker is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' 'checker' element is unchecked")
    public BannerAssert checkerUnchecked() {
        jdiAssert(element().hasCheckerUnchecked() ? "checker is not checked" : "checker is checked",
                Matchers.is("checker is not checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected title")
    public BannerAssert title(String title) {
        jdiAssert(element().hasTitle(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected title")
    public BannerAssert text(String text) {
        jdiAssert(element().hasText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public BannerAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has alert after clicking on icon")
    public BannerAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of buttons")
    public BannerAssert buttons(int number) {
        jdiAssert(element().hasButtons(), Matchers.is(number));
        return this;
    }

    @JDIAction("Assert that '{name}'s buttons are hidden")
    public BannerAssert hiddenButtons() {
        jdiAssert(element().hasHiddenButtons() ? "buttons are hidden" : "buttons are visible",
                Matchers.is("buttons are hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}'s buttons are visible")
    public BannerAssert visibleButtons() {
        element().show();
        jdiAssert(element().hasVisibleButtons() ? "buttons are visible" : "buttons are hidden",
                Matchers.is("buttons are visible"));
        return this;
    }

    @JDIAction("Assert that '{name}'s text field is hidden")
    public BannerAssert hiddenTextField() {
        jdiAssert(element().hasHiddenTextField() ? "text field is hidden" : "text field is visible",
                Matchers.is("text field is hidden"));
        return this;
    }
}
