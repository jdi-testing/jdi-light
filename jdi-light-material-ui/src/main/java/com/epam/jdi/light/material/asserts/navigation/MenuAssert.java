package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Menu;
import java.util.List;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class MenuAssert extends UISelectAssert<MenuAssert, Menu> {

    @JDIAction("Assert that '{name}' has items: {0}")
    public MenuAssert itemsTexts(List<String> expectedItems) {
        return itemsTexts(Matchers.contains(expectedItems.toArray()));
    }

    @JDIAction("Assert that '{name}' has items {0}")
    public MenuAssert itemsTexts(Matcher<? super List<String>> condition) {
        jdiAssert(element().itemsTexts(), condition);
        return this;
    }
}
