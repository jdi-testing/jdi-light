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

    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public MenuAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Menu is not displayed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected top position", isAssert = true)
    public MenuAssert positionTop(int top) {
        jdiAssert(element().topPosition(), Matchers.equalTo(top));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected left position", isAssert = true)
    public MenuAssert positionLeft(int left) {
        jdiAssert(element().leftPosition(), Matchers.equalTo(left));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected number of options", isAssert = true)
    public MenuAssert countOfOptions(int numberOfOptions) {
        jdiAssert(element().countOfOptions(), Matchers.is(numberOfOptions));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has expected options titles", isAssert = true)
    public MenuAssert optionsTitles(List<String> optionsTitles) {
        jdiAssert(element().optionsTitles(), Matchers.is(optionsTitles));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has removed radius", isAssert = true)
    public MenuAssert removedRadius() {
        jdiAssert(element().hasRemovedRadius(), Matchers.is(true), "Menu doesn't have rounded-0");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has large radius", isAssert = true)
    public MenuAssert largeRadius() {
        jdiAssert(element().hasLargeRadius(), Matchers.is(true), "Menu doesn't have large rounded");
        return this;
    }
}
