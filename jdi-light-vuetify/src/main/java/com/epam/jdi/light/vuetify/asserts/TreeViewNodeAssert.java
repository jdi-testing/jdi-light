package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewNode;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import java.util.List;
import java.util.Map;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewNodeAssert extends UISelectAssert<TreeViewNodeAssert, TreeViewNode> implements
        RoundedAssert<TreeViewNodeAssert, TreeViewNode>, ShapedAssert<TreeViewNodeAssert, TreeViewNode>,
        LoadingAssert<TreeViewNodeAssert, TreeViewNode>, ColorAssert<TreeViewNodeAssert, TreeViewNode> {

    @JDIAction("Assert that '{name}' is expanded")
    public TreeViewNodeAssert expanded() {
        jdiAssert(waitCondition(element()::isExpanded), Matchers.is(true), "Element is collapsed");
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public TreeViewNodeAssert collapsed() {
        jdiAssert(waitCondition(element()::isExpanded), Matchers.is(false), "Element is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public TreeViewNodeAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' is a leaf")
    public TreeViewNodeAssert leaf() {
        jdiAssert(element().isLeaf(), Matchers.is(true), "Element is not a leaf");
        return this;
    }

    @JDIAction("Assert that '{name}' is not a leaf")
    public TreeViewNodeAssert notLeaf() {
        jdiAssert(element().isLeaf(), Matchers.is(false), "Element is a leaf");
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public TreeViewNodeAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public TreeViewNodeAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TreeViewNodeAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public TreeViewNodeAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox")
    public TreeViewNodeAssert checkbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(true), "Element has no checkbox");
        return this;
    }

    @JDIAction("Assert that '{name}' has no checkbox")
    public TreeViewNodeAssert noCheckbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(false), "Element has checkbox");
        return this;
    }

    @JDIAction("Assert that '{name}' is fully marked")
    public TreeViewNodeAssert fullyMarked() {
        jdiAssert(element().isFullyMarked(), Matchers.is(true), "Element is not fully marked");
        return this;
    }

    @JDIAction("Assert that '{name}' is partly marked")
    public TreeViewNodeAssert isPartlyMarked() {
        jdiAssert(element().isPartlyMarked(), Matchers.is(true), "Element is not partly marked");
        return this;
    }

    @JDIAction("Assert that '{name}' is not marked")
    public TreeViewNodeAssert notMarked() {
        jdiAssert(element().isNotMarked(), Matchers.is(true), "Element is marked");
        return this;
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewNodeAssert checked(Matcher<? super List<String>> values) {
        List<String> actualCheckedValues = element().checked();
        jdiAssert(element().checked(), values);
        return this;
    }

    @JDIAction("Assert that only '{0}' values are checked in '{name}'")
    public TreeViewNodeAssert checked(String... values) {
        return checked(equalTo(asList(values)));
    }

    @JDIAction("Assert that only '{0}' values are checked in '{name}'")
    public TreeViewNodeAssert checked(List<String> values) {
        return checked(equalTo(values));
    }

    @JDIAction("Assert that color of '{name}' is equal to '{0}'")
    public TreeViewNodeAssert color(String color) {
        jdiAssert(element().color(), equalTo(color));
        return this;
    }

    @JDIAction("Assert that checkbox color of '{name}' is equal to '{0}'")
    public TreeViewNodeAssert checkboxColor(String color) {
        jdiAssert(element().checkboxColor(), equalTo(color));
        return this;
    }


    public TreeViewNodeAssert and() {
        return this;
    }
}
