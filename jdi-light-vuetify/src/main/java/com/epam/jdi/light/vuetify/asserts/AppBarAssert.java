package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.AppBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AppBarAssert extends UIAssert<AppBarAssert, AppBar> {

    @JDIAction("Assert that {name} is displayed")
    public AppBarAssert displayed() {
        new Timer(base().getTimeout() * 2000L)
            .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert menuButton() {
        jdiAssert(element().hasMenuButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert properTitleText(String text) {
        jdiAssert(element().getTitle().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert title() {
        new Timer(base().getTimeout() * 2000L)
            .wait(() -> element().getTitle().isDisplayed());
        jdiAssert(element().hasTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert hiddenTitle() {
        jdiAssert(element().hasHiddenTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert checker() {
        jdiAssert(element().hasChecker(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is checked")
    public AppBarAssert checkerChecked() {
        jdiAssert(element().getCheckerStatus(), Matchers.is("true"));
        return this;
    }

    @JDIAction("Assert that banner's 'checker' element is unchecked")
    public AppBarAssert checkerUnchecked() {
        jdiAssert(element().getCheckerStatus(), Matchers.is("false"));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert searchButton() {
        jdiAssert(element().hasSearchButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert heartButton() {
        jdiAssert(element().hasHeartButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public AppBarAssert verticalDotsButton() {
        jdiAssert(element().hasVerticalDotsButton(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerShadowHidden(String text) {
        new Timer(base().getTimeout() * 2000L)
            .wait(() -> element().getHeader().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerShadowVisible(String text) {
        jdiAssert(element().getHeaderStatus(), Matchers.containsString(text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerHeight(String text) {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("height: " + text));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerVisible() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(0px)"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerHidden() {
        jdiAssert(element().getHeaderStyle(), Matchers.containsString("transform: translateY(-128px)"));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert headerOpacity(Integer opacity) {
        jdiAssert(element().getHeaderOpacity(), Matchers.containsString("opacity: " + opacity));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert tabs() {
        for(UIElement tab: element().getTabs()) {
            jdiAssert(tab.isClickable(), Matchers.is(true));
        }
        jdiAssert(element().hasTabs(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public AppBarAssert navigationMenu() {
        jdiAssert(element().hasNavigationMenu(), Matchers.is(true));
        return this;
    }






//
//    @JDIAction("Assert that banner has button")
//    public AppBarAssert button() {
//        jdiAssert(element().hasButton(), Matchers.is(true));
//        return this;
//    }
//
//    @JDIAction("Assert that banner has icon")
//    public AppBarAssert icon() {
//        jdiAssert(element().hasIcon(), Matchers.is(true));
//        return this;
//    }
//
//    @JDIAction("Assert that banner has alert after clicking on icon")
//    public AppBarAssert alertOnIconClick(String text) {
//        jdiAssert(element().hasAlertOnIconClick(), Matchers.is(text));
//        return this;
//    }
//
//    @JDIAction("Assert that banner has buttons")
//    public AppBarAssert buttons() {
//        for (UIElement button : element().getButtons()) {
//            jdiAssert(button.getAttribute("type"), Matchers.is("button"));
//        }
//        jdiAssert(element().hasButtons(), Matchers.is(true));
//        return this;
//    }
//
//    @JDIAction("Assert that banner's buttons are hidden")
//    public AppBarAssert hiddenButtons() {
//        for(UIElement button: element().getButtons()) {
//            jdiAssert(button.isHidden(), Matchers.is(true));
//        }
//        return this;
//    }
//
//    @JDIAction("Assert that banner's text field is hidden")
//    public AppBarAssert hiddenTextField() {
//        jdiAssert(element().getTextField().isHidden(), Matchers.is(true));
//        return this;
//    }
}
