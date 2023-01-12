package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
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

public class TreeViewAssert extends UISelectAssert<TreeViewAssert, TreeView> implements RoundedAssert<TreeViewAssert, TreeView>,
        ShapedAssert<TreeViewAssert, TreeView>, DenseAssert<TreeViewAssert, TreeView>,
        LoadingAssert<TreeViewAssert, TreeView> {
    @JDIAction("Assert that '{name}' is expanded")
    public TreeViewAssert expanded() {
        jdiAssert(waitCondition(element()::isExpanded), Matchers.is(true), "Element is collapsed");
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public TreeViewAssert collapsed() {
        jdiAssert(waitCondition(element()::isExpanded), Matchers.is(false), "Element is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' has label")
    public TreeViewAssert hasLabel() {
        jdiAssert(element().hasLabel(), Matchers.is(true), "Element has no label");
        return this;
    }

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewAssert pseudoCore() {
        jdiAssert(element().isPseudoCore(), Matchers.is(true), "Element is not pseudo-core");
        return this;
    }

    @JDIAction("Assert that '{name}' is not a pseudo core node")
    public TreeViewAssert notPseudoCore() {
        jdiAssert(element().isPseudoCore(), Matchers.is(false), "Element is pseudo-core");
        return this;
    }

    @JDIAction("Assert that '{name}' is a leaf")
    public TreeViewAssert leaf() {
        jdiAssert(element().isLeaf(), Matchers.is(true), "Element is not a leaf");
        return this;
    }

    @JDIAction("Assert that '{name}' is not a leaf")
    public TreeViewAssert notLeaf() {
        jdiAssert(element().isLeaf(), Matchers.is(false), "Element is a leaf");
        return this;
    }

    @JDIAction("Assert that '{name}' is hoverable")
    public TreeViewAssert hoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(true), "Element is not hoverable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not hoverable")
    public TreeViewAssert notHoverable() {
        jdiAssert(element().isHoverable(), Matchers.is(false), "Element is hoverable");
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public TreeViewAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public TreeViewAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TreeViewAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Element is not selected");
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public TreeViewAssert notSelected() {
        jdiAssert(element().isSelected(), Matchers.is(false), "Element is selected");
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox")
    public TreeViewAssert checkbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(true), "Element has no checkbox");
        return this;
    }

    @JDIAction("Assert that '{name}' has no checkbox")
    public TreeViewAssert noCheckbox() {
        jdiAssert(element().checkbox().isExist(), Matchers.is(false), "Element has checkbox");
        return this;
    }

    @JDIAction("Assert that '{name}' is fully marked")
    public TreeViewAssert fullyMarked() {
        jdiAssert(element().isFullyMarked(), Matchers.is(true), "Element is not fully marked");
        return this;
    }

    @JDIAction("Assert that '{name}' is partly marked")
    public TreeViewAssert isPartlyMarked() {
        jdiAssert(element().isPartlyMarked(), Matchers.is(true), "Element is not partly marked");
        return this;
    }

    @JDIAction("Assert that '{name}' is not marked")
    public TreeViewAssert notMarked() {
        jdiAssert(element().isNotMarked(), Matchers.is(true), "Element is marked");
        return this;
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewAssert checked(Matcher<? super List<String>> values) {
        List<String> actualCheckedValues = element().checked();
        jdiAssert(actualCheckedValues, values, String.format("Actual checked values '%s' doesn't contain all of the " +
                "expected values '%s'", actualCheckedValues, values));
        return this;
    }

    @JDIAction("Assert that only '{0}' values are checked in '{name}'")
    public TreeViewAssert checked(String... values) {
        return checked(equalTo(asList(values)));
    }

    @JDIAction("Assert that only '{0}' values are checked in '{name}'")
    public TreeViewAssert checked(List<String> values) {
        return checked(equalTo(values));
    }

    @JDIAction("Assert that structure of '{name}' is equal to '{0}'")
    public TreeViewAssert structure(Map<String, List<String>> structure) {
        Map<String, List<String>> actualStructure = element().structure();
        jdiAssert(actualStructure, equalTo(structure), String.format("Actual element's structure '%s' is not equal " +
                "to expected '%s'", actualStructure, structure));
        return this;
    }

    @JDIAction("Assert that color of '{name}' is equal to '{0}'")
    public TreeViewAssert color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, equalTo(color), String.format("Element's actual color '%s' is not equal to expected " +
                "'%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that checkbox color of '{name}' is equal to '{0}'")
    public TreeViewAssert checkboxColor(String color) {
        String actualColor = element().checkboxColor();
        jdiAssert(actualColor, equalTo(color), String.format("Element's actual checkbox color '%s' is not equal to " +
                "expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' values '{0}' is enabled")
    public TreeViewAssert enabled(List<String> values) {
        List<String> actualEnabledValues = element().listEnabled();
        jdiAssert(actualEnabledValues, Matchers.equalTo(values), String.format("Actual enabled values '%s' " +
                "doesn't contain all of the expected values '%s'", actualEnabledValues, values));
        return this;
    }

    @JDIAction("Assert that '{name}' values '{0}' is disabled")
    public TreeViewAssert disabled(List<String> values) {
        List<String> actualDisabledValues = element().listDisabled();
        jdiAssert(actualDisabledValues, Matchers.equalTo(values), String.format("Actual disabled values '%s' " +
                "doesn't contain all of the expected values '%s'", actualDisabledValues, values));
        return this;
    }

    public TreeViewAssert and() {
        return this;
    }
}
