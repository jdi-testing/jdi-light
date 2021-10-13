package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewDropDown;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TreeViewDropDownAssert extends DropdownAssert {

    @Override
    public TreeViewDropDown element() {
        return (TreeViewDropDown) super.element();
    }

    public TreeViewDropDownAssert customAssertForVisualCheckThatAssertWork() {
        element().list().foreach(e -> e.find(".v-treeview-node__toggle").click());
        return this;
    }

    @JDIAction("Assert that '{name}' have all expanded children")
    public TreeViewDropDownAssert expandedAll() {
        for (UIElement uiElement : element().list()) {
            uiElement.highlight();
            jdiAssert(uiElement.attr("aria-expanded"), Matchers.is("true"));
        }
        return this;
    }

    @Override
    public TreeViewDropDownAssert is() {
        return this;
    }
}
