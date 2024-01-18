package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.utils.PositionAssert;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Drawer}.
 */
public class DrawerAssert extends PositionAssert<DrawerAssert, Drawer> {

    @Override
    @JDIAction(value = "Assert that '{name}' is displayed", isAssert = true)
    public DrawerAssert displayed() {
        jdiAssert(element().core().isDisplayed(), Matchers.is(true), "Drawer is not displayed");
        return this;
    }

    /**
     * Checks that drawer has given number of items in all lists.
     *
     * @param totalNumber expected number of list items
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has {0} list items", isAssert = true)
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
     * @param listIndex list index (based on 1)
     * @param expectedSize expected number of list items
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has {1} items in list {0}", isAssert = true)
    public DrawerAssert sublistWithSize(int listIndex, int expectedSize) {
        jdiAssert(element().lists().get(listIndex).size(), Matchers.is(expectedSize));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is hidden", isAssert = true)
    public DrawerAssert hidden() {
        jdiAssert(element().isHidden(), Matchers.is(true),
                "Drawer is not hidden");
        return this;
    }

    /**
     * Checks that drawer does not exist on page.
     *
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is not exist", isAssert = true)
    public DrawerAssert notExist() {
        jdiAssert(element().core().isNotExist(), Matchers.is(true),
                "Drawer is exists");
        return this;
    }
}
