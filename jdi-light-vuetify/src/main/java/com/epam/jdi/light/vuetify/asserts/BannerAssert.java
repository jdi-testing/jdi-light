package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> {

    @JDIAction("Assert that {name} is displayed")
    public BannerAssert displayed() {
        new Timer(base().getTimeout() * 2000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public BannerAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public BannerAssert checkerChecked() {
        jdiAssert(element().checkerState(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is unchecked")
    public BannerAssert checkerUnchecked() {
        jdiAssert(element().checkerState(), Matchers.is("false"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public BannerAssert properTitle(String title) {
        jdiAssert(element().hasTitle(), Matchers.is(title));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public BannerAssert properText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has button")
    public BannerAssert button() {
        new Timer(base().getTimeout() * 2000L)
                .wait(() -> element().getButton().isDisplayed());
        jdiAssert(element().hasButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has icon")
    public BannerAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has alert after clicking on icon")
    public BannerAssert alertOnIconClick(String text) {
        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that banner has buttons")
    public BannerAssert buttons() {
        for (UIElement button : element().getButtons()) {
            jdiAssert(button.getAttribute("type"), Matchers.is("button"));
        }
        jdiAssert(element().hasButtons(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's buttons are hidden")
    public BannerAssert hiddenButtons() {
        for(UIElement button: element().getButtons()) {
            jdiAssert(button.isHidden(), Matchers.is(true));
        }
        return this;
    }

    @JDIAction("Assert that banner's text field is hidden")
    public BannerAssert hiddenTextField() {
        jdiAssert(element().getTextField().isHidden(), Matchers.is(true));
        return this;
    }
}
