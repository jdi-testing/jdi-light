package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class MenuAssert extends UIAssert<MenuAssert, Menu> {
    @JDIAction("Assert that {name} is displayed")
    @Override
    public MenuAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that menu item is displayed")
    public MenuAssert displayedMenuItem(List listLocator, String menuItem) {
        jdiAssert(listLocator.getItemByText(menuItem).core().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s child svg is visible")
    public MenuAssert displayedSvg() {
        try {
            boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                    .wait(() -> element().find(".MuiSvgIcon-root").isDisplayed());
            jdiAssert(isDisplayed, Matchers.is(true));
        } catch (AssertionError e){
            new AssertionError("Svg not found");
        }
        return this;
    }
    // TODO: add method with Matcher in parameter: Matcher<String> condition
    @JDIAction("Assert that '{name}' text is '{0}'")
    public MenuAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that all menu items are correct")
    public MenuAssert properMenuItems(List listLocator, java.util.List<String> expectedItems) {
        jdiAssert(element().getMenuItems(listLocator), Matchers.containsInAnyOrder(expectedItems.toArray()));
        return this;
    }
}
