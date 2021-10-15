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

    @JDIAction("Assert that '{name}' is a leaf")
    public TreeViewAssert leaf() {
        jdiAssert(element().isLeaf() ? "leaf" : "not a leaf", Matchers.is("leaf"));
        return this;
    }

    @JDIAction("Assert that '{name}' is hoverable is '{0}'")
    public TreeViewAssert hoverable(boolean status) {
        jdiAssert(
                element().isHoverable() ? "hoverable" : "not hoverable",
                status ? Matchers.is("hoverable") : Matchers.is("not hoverable")
        );
        return this;
    }

    @JDIAction("Assert that '{name}' is shaped is '{0}'")
    public TreeViewAssert shaped(boolean status) {
        jdiAssert(
                element().isShaped() ? "shaped" : "not shaped",
                status ? Matchers.is("shaped") : Matchers.is("not shaped")
        );
        return this;
    }

    @JDIAction("Assert that '{name}' is rounded is '{0}'")
    public TreeViewAssert rounded(boolean status) {
        jdiAssert(
                element().isRounded() ? "rounded" : "not rounded",
                status ? Matchers.is("rounded") : Matchers.is("not rounded")
        );
        return this;
    }

    @JDIAction("Assert that '{name}' is active is '{0}'")
    public TreeViewAssert active(boolean status) {
        jdiAssert(
                element().isActive() ? "active" : "not active",
                status ? Matchers.is("active") : Matchers.is("not active")
        );
        return this;
    }

    @JDIAction("Assert that '{name}' is selected is '{0}'")
    public TreeViewAssert selected(boolean status) {
        jdiAssert(
                element().isSelected() ? "selected" : "not selected",
                status ? Matchers.is("selected") : Matchers.is("not selected")
        );
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox is '{0}'")
    public TreeViewAssert checkbox(boolean status) {
        jdiAssert(element().checkbox().isExist(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that '{name}' is fully marked")
    public TreeViewAssert fullyMarked() {
        jdiAssert(element().isFullyMarked() ? "fully marked" : "not fully marked", Matchers.is("fully marked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is partly marked")
    public TreeViewAssert isPartlyMarked() {
        jdiAssert(element().isPartlyMarked() ? "partly marked" : "not partly marked", Matchers.is("partly marked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not marked")
    public TreeViewAssert notMarked() {
        jdiAssert(element().isNotMarked() ? "not marked" : "fully or partly marked", Matchers.is("not marked"));
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

    @Override
    public TreeViewAssert and() {
        return this;
    }
}
