package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

public class TreeViewAssert extends DropdownAssert {

    @Override
    public TreeView element() {
        return (TreeView) super.element();
    }

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewAssert pseudoCore() {
        jdiAssert(element().isPseudoCore() ? "pseudo core" : "not a pseudo core", Matchers.is("pseudo core"));
        return this;
    }

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewAssert leaf() {
        jdiAssert(element().isLeaf() ? "leaf" : "not a leaf", Matchers.is("leaf"));
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public TreeViewAssert active() {
        jdiAssert(element().isActive() ? "active" : "not active", Matchers.is("active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public TreeViewAssert notActive() {
        jdiAssert(element().isActive() ? "active" : "not active", Matchers.is("not active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TreeViewAssert selected() {
        jdiAssert(element().isSelected() ? "selected" : "not selected", Matchers.is("selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public TreeViewAssert notSelected() {
        jdiAssert(element().isSelected() ? "selected" : "not selected", Matchers.is("not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox is '{0}'")
    public TreeViewAssert checkbox(boolean status) {
        jdiAssert(element().checkbox().isExist(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that {0} values checked in '{name}'")
    public TreeViewAssert checked(Matcher<? super List<String>> values) {
        jdiAssert(element().checked(), values);
        return this;
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewAssert checked(String... values) {
        return checked(containsInAnyOrder(values));
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewAssert checked(List<String> values) {
        return checked(containsInAnyOrder(values.toArray()));
    }

    @JDIAction("Assert structure of '{name}' is equal to '{0}'")
    public TreeViewAssert structure(Map<String, List<String>> structure) {
        jdiAssert(element().structure(), equalTo(structure));
        return this;
    }

    @JDIAction("Assert that every node is match consumer")
    public TreeViewAssert recursive(Consumer<? super TreeView> assertion) {
        element().walk(assertion);
        return this;
    }

    @Override
    public TreeViewAssert is() {
        return this;
    }

    @Override
    public TreeViewAssert assertThat() {
        return is();
    }

    @Override
    public TreeViewAssert has() {
        return is();
    }

    @Override
    public TreeViewAssert waitFor() {
        return is();
    }

    @Override
    public TreeViewAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public TreeViewAssert shouldBe() {
        return is();
    }

    @Override
    public TreeViewAssert verify() {
        assertSoft();
        return is();
    }
}
