package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Menu;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Menu}
 */
public class MenuAssert extends UISelectAssert<MenuAssert, Menu> {

    /**
     * Checks that menu contains items with given texts.
     *
     * @param expectedItems expected texts as {@link List} of {@link String}
     * @return this {@link MenuAssert} instance
     */
    @JDIAction("Assert that '{name}' has items {0}")
    public MenuAssert itemsTexts(List<String> expectedItems) {
        return itemsTexts(Matchers.contains(expectedItems.toArray()));
    }

    /**
     * Checks that menu contains items with texts matching given condition.
     *
     * @param condition expected texts as {@link Matcher}
     * @return this {@link MenuAssert} instance
     */
    @JDIAction("Assert that '{name}' has items {0}")
    public MenuAssert itemsTexts(Matcher<? super List<String>> condition) {
        jdiAssert(element().itemsTexts(), condition);
        return this;
    }
}
