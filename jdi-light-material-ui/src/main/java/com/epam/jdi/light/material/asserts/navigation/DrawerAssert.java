package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.PositionAssert;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Drawer}.
 */
public class DrawerAssert extends PositionAssert<DrawerAssert, Drawer> {

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public DrawerAssert displayed() {
        jdiAssert(element().core().isDisplayed(), Matchers.is(true));
        return this;
    }

    /**
     * Checks that drawer has given number of items in all lists.
     *
     * @param totalNumber expected number of list items
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' has {0} list items")
    public DrawerAssert totalSize(int totalNumber) {
        int sumLen = element().lists().stream()
                .mapToInt(list -> list.size())
                .sum();
        jdiAssert(sumLen, Matchers.is(totalNumber));
        return this;
    }

    /**
     * Checks that drawer has given number of items in specific list.
     *
     * @param listIndex list index
     * @param expectedSize expected number of list items
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' has {1} items in list {0}")
    public DrawerAssert sublistWithSize(int listIndex, int expectedSize) {
        jdiAssert(element().lists().get(listIndex).size(), Matchers.is(expectedSize));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public DrawerAssert hidden() {
        jdiAssert(waitCondition(() -> element().isHidden()) ? "is hidden" : "is visible",
                Matchers.is("is hidden"));
        return this;
    }

    /**
     * Checks that drawer does not exist on page.
     *
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' is not exist")
    public DrawerAssert notExist() {
        jdiAssert(waitCondition(() -> element().core().isNotExist()) ? "is not exist" : "is exist",
                Matchers.is("is not exist"));
        return this;
    }
}
