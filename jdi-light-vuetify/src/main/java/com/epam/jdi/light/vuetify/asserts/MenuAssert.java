package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Menu;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class MenuAssert extends UIAssert<MenuAssert, Menu> {

    @JDIAction("Assert that '{name}' is displayed")
    public MenuAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public MenuAssert position(int top, int left) {
        jdiAssert(element().hasPosition(), Matchers.equalTo(String.format("top: %spx; left: %dpx", top, left)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected top position")
    public MenuAssert positionTop(int top) {
        jdiAssert(element().hasTopPosition(), Matchers.equalTo(String.format("top: %spx", top)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected left position")
    public MenuAssert positionLeft(int left) {
        jdiAssert(element().hasLeftPosition(), Matchers.equalTo(String.format("left: %dpx",left)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of options")
    public MenuAssert numberOfOptions(int numberOfOptions) {
        jdiAssert(element().hasNumberOfOptions(), Matchers.is(numberOfOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected options titles")
    public MenuAssert optionsTitles(List<String> optionsTitles) {
        jdiAssert(element().hasOptionsTitles(), Matchers.is(optionsTitles));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected options")
    public MenuAssert optionsList(List<String> optionsTitles) {
        jdiAssert(element().hasOptions(), Matchers.is(optionsTitles));
        return this;
    }

    @JDIAction("Assert that '{name}' has removed radius")
    public MenuAssert removedRadius() {
        jdiAssert(element().hasRemovedRadius() ? "has removed radius" : "has radius",
                Matchers.is("has removed radius"));
        return this;
    }

    @JDIAction("Assert that '{name}' has large radius")
    public MenuAssert largeRadius() {
        jdiAssert(element().hasLargeRadius() ? "has large radius" : "does not have large radius",
                Matchers.is("has large radius"));
        return this;
    }

    @JDIAction("Assert that '{name}' has custom radius")
    public MenuAssert customRadius() {
        jdiAssert(element().hasCustomRadius() ? "has custom radius" : "does not have custom radius",
                Matchers.is("has custom radius"));
        return this;
    }
}
