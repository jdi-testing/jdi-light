package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class ItemGroupAssert extends UIAssert<ItemGroupAssert, ItemGroup>
    implements ThemeAssert<ItemGroupAssert, ItemGroup> {

    @JDIAction(value = "Assert that {name} has subheader", isAssert = true)
    public ItemGroupAssert subheader(Matcher<String> matcher) {
        jdiAssert(element().subheader().text(), matcher);
        return this;
    }

    @JDIAction(value = "Assert that {0} item is selected in {name}", isAssert = true)
    public ItemGroupAssert selected(int index) {
        jdiAssert(element().selected(index), Matchers.is(true),
                String.format("Item with index %d is not selected", index));
        return this;
    }

    @JDIAction(value = "Assert that {0} item is not selected in {name}", isAssert = true)
    public ItemGroupAssert notSelected(int index) {
        jdiAssert(element().selected(index), Matchers.is(false),
                String.format("Item with index %d is selected", index));
        return this;
    }
}
