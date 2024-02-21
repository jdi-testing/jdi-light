package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewNode;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import java.util.List;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewNodeAssert extends UISelectAssert<TreeViewNodeAssert, TreeViewNode> implements
        RoundedAssert<TreeViewNodeAssert, TreeViewNode>, ShapedAssert<TreeViewNodeAssert, TreeViewNode>,
        LoadingAssert<TreeViewNodeAssert, TreeViewNode>, ColorAssert<TreeViewNodeAssert, TreeViewNode> {

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public TreeViewNodeAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "TreeViewNode is collapsed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is collapsed", isAssert = true)
    public TreeViewNodeAssert collapsed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "TreeViewNode is expanded");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has label", isAssert = true)
    public TreeViewNodeAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "TreeViewNode has no label");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is a leaf", isAssert = true)
    public TreeViewNodeAssert leaf() {
        jdiAssert(element().isLeaf(), Matchers.is(true), "TreeViewNode is not a leaf");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not a leaf", isAssert = true)
    public TreeViewNodeAssert notLeaf() {
        jdiAssert(element().isLeaf(), Matchers.is(false), "TreeViewNode is a leaf");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is active", isAssert = true)
    public TreeViewNodeAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "TreeViewNode is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active", isAssert = true)
    public TreeViewNodeAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "TreeViewNode is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public TreeViewNodeAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "TreeViewNode is not selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public TreeViewNodeAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "TreeViewNode is selected");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has checkbox", isAssert = true)
    public TreeViewNodeAssert checkbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(true), "TreeViewNode has no checkbox");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no checkbox", isAssert = true)
    public TreeViewNodeAssert noCheckbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(false), "TreeViewNode has checkbox");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fully marked", isAssert = true)
    public TreeViewNodeAssert fullyMarked() {
        jdiAssert(element().isFullyMarked(), Matchers.is(true), "TreeViewNode is not fully marked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not marked", isAssert = true)
    public TreeViewNodeAssert notMarked() {
        jdiAssert(element().isNotMarked(), Matchers.is(true), "TreeViewNode is marked");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' checked are matched condition", isAssert = true)
    public TreeViewNodeAssert checked(Matcher<? super List<String>> values) {
        jdiAssert(element().checked(), values);
        return this;
    }

    @JDIAction(value = "Assert that only '{0}' values are checked in '{name}'", isAssert = true)
    public TreeViewNodeAssert checked(String... values) {
        return checked(equalTo(asList(values)));
    }

    @JDIAction(value = "Assert that only '{0}' values are checked in '{name}'", isAssert = true)
    public TreeViewNodeAssert checked(List<String> values) {
        return checked(equalTo(values));
    }

    @JDIAction(value = "Assert that color of '{name}' is equal to '{0}'", isAssert = true)
    public TreeViewNodeAssert color(String color) {
        jdiAssert(element().color(), equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that checkbox color of '{name}' is equal to '{0}'", isAssert = true)
    public TreeViewNodeAssert checkboxColor(String color) {
        jdiAssert(element().checkboxColor(), equalTo(color));
        return this;
    }


    public TreeViewNodeAssert and() {
        return this;
    }
}
