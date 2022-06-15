package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

/**
 * Assertions for {@link Drawer}.
 */
public class DrawerAssert extends UIAssert<DrawerAssert, Drawer> {

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public DrawerAssert displayed() {
        jdiAssert(element().core().isDisplayed(), Matchers.is(true));
        return this;
    }

    /**
     * Checks that drawer has given position.
     *
     * @param position expected position
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' has position '{0}'")
    public DrawerAssert position(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return this;
    }

    /**
     * Checks that drawer has given number of list items.
     *
     * @param numberOfMUIListItems expected number of list items
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' has {0} list items")
    public DrawerAssert numberOfListItems(int numberOfMUIListItems) {
        List<Button> listItems = element().lists().stream()
                .flatMap(list -> list.items().stream())
                .collect(Collectors.toList());
        jdiAssert(listItems.size(), Matchers.is(numberOfMUIListItems));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public DrawerAssert hidden() {
        jdiAssert(waitCondition(() -> element().isHidden()) ? "is hidden" : "is visible", Matchers.is("is hidden"));
        return this;
    }

    /**
     * Checks that drawer does not exist on page.
     *
     * @return this {@link DrawerAssert} instance
     */
    @JDIAction("Assert that '{name}' is not exist")
    public DrawerAssert notExist() {
        jdiAssert(waitCondition(() -> element().core().isNotExist()) ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }
}
