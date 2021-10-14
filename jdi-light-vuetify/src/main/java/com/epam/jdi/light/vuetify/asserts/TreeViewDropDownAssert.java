package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.complex.DropdownAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeViewDropDown;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.assertSoft;
import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TreeViewDropDownAssert extends DropdownAssert {

    @Override
    public TreeViewDropDown element() {
        return (TreeViewDropDown) super.element();
    }

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewDropDownAssert pseudo() {
        jdiAssert(element().isPseudoCore() ? "pseudo core" : "not a pseudo core", Matchers.is("pseudo core"));
        return this;
    }

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewDropDownAssert leaf() {
        jdiAssert(element().isLeaf() ? "leaf" : "not a leaf", Matchers.is("leaf"));
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public TreeViewDropDownAssert active() {
        jdiAssert(element().isActive() ? "active" : "not active", Matchers.is("active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public TreeViewDropDownAssert notActive() {
        jdiAssert(element().isActive() ? "active" : "not active", Matchers.is("not active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public TreeViewDropDownAssert selected() {
        jdiAssert(element().isSelected() ? "selected" : "not selected", Matchers.is("selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public TreeViewDropDownAssert notSelected() {
        jdiAssert(element().isSelected() ? "selected" : "not selected", Matchers.is("not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox is '{0}'")
    public TreeViewDropDownAssert checkbox(boolean status) {
        jdiAssert(element().checkbox().isExist(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that {0} values checked in '{name}'")
    public TreeViewDropDownAssert checked(Matcher<? super List<String>> values) {
        jdiAssert(element().checked(), values);
        return this;
    }
    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewDropDownAssert checked(String... values) {
        return checked(containsInAnyOrder(values));
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewDropDownAssert checked(List<String> values) {
        return checked(containsInAnyOrder(values.toArray()));
    }


    @Override
    public TreeViewDropDownAssert is() {
        return this;
    }

    @Override
    public TreeViewDropDownAssert assertThat() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert has() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert waitFor() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert waitFor(int sec) {
        this.waitSec(sec);
        return is();
    }

    @Override
    public TreeViewDropDownAssert shouldBe() {
        return is();
    }

    @Override
    public TreeViewDropDownAssert verify() {
        assertSoft();
        return is();
    }
}
