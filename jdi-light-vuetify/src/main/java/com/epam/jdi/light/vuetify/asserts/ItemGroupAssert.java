package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

public class ItemGroupAssert extends UISelectAssert<ItemGroupAssert, ItemGroup>
    implements ThemeAssert<ItemGroupAssert, ItemGroup> {

    @Override
    @JDIAction("Assert that {0} item is selected in {name}")
    public ItemGroupAssert selected(int index) {
        jdiAssert(element().selected(index) ? "is selected" : "is not selected",
                Matchers.is("is selected"));
        return this;
    }

    @JDIAction("Assert that {0} item is not selected in {name}")
    public ItemGroupAssert notSelected(int index) {
        jdiAssert(element().notSelected(index) ? "is not selected" : "is selected",
                Matchers.is("is not selected"));
        return this;
    }
}
