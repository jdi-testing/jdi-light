package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;

public class DrawerAssert extends UIAssert<DrawerAssert, Drawer> {

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public DrawerAssert displayed() {
        jdiAssert(element().core().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has position {0}")
    public DrawerAssert position(Position position) {
        jdiAssert(element().getPosition(), Matchers.is(position));
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} list items")
    public DrawerAssert numberOfListItems(int numberOfListItems) {
        List<ListItem> listItems = element().lists().stream()
                        .flatMap(list -> list.items().stream())
                        .collect(Collectors.toList());
        jdiAssert(listItems.size(), Matchers.is(numberOfListItems));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public DrawerAssert hidden() {
        jdiAssert(waitCondition(() -> element().isHidden()) ? "is hidden" : "is visible", Matchers.is("is hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not exist")
    public DrawerAssert notExist() {
        jdiAssert(waitCondition(() -> element().core().isNotExist()) ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }
}
