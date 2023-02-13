package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Menu;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class MenuAssert extends UIAssert<MenuAssert, Menu> implements ThemeAssert<MenuAssert, Menu> {

    @JDIAction("Assert that '{name}' is displayed")
    public MenuAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected top position")
    public MenuAssert positionTop(int top) {
        jdiAssert(element().topPosition(), Matchers.equalTo(top));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected left position")
    public MenuAssert positionLeft(int left) {
        jdiAssert(element().leftPosition(), Matchers.equalTo(left));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of options")
    public MenuAssert countOfOptions(int numberOfOptions) {
        jdiAssert(element().countOfOptions(), Matchers.is(numberOfOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected options titles")
    public MenuAssert optionsTitles(List<String> optionsTitles) {
        jdiAssert(element().optionsTitles(), Matchers.is(optionsTitles));
        return this;
    }

    @JDIAction("Assert that '{name}' has removed radius")
    public MenuAssert removedRadius() {
        jdiAssert(element().hasRemovedRadius(), Matchers.is(true), "Menu doesn't have rounded-0");
        return this;
    }

    @JDIAction("Assert that '{name}' has large radius")
    public MenuAssert largeRadius() {
        jdiAssert(element().hasLargeRadius(), Matchers.is(true), "Menu doesn't have large rounded");
        return this;
    }
}
