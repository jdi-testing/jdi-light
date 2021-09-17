package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.MaterialSelector;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.EnumUtils.getEnumValue;
import static com.jdiai.tools.LinqUtils.toStringArray;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class MaterialSelectorAssert extends UIAssert<MaterialSelectorAssert, MaterialSelector> {
    @JDIAction("Assert that '{name}' expanded")
    public MaterialSelectorAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' collapsed")
    public MaterialSelectorAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public MaterialSelectorAssert selected(final Matcher<String> condition) {
        jdiAssert(element().selected(), condition);
        return this;
    }

    @JDIAction("Assert that '{0}' option selected for '{name}'")
    public MaterialSelectorAssert selected(final String option) {
        return selected(Matchers.is(option));
    }

    public <T extends Enum<?>> MaterialSelectorAssert selected(final T option) {
        return selected(getEnumValue(option));
    }

    public <T extends Enum<?>> MaterialSelectorAssert value(final T option) {
        jdiAssert(element().values(), hasItem(getEnumValue(option)));
        return this;
    }

    @JDIAction("Assert that '{name}' value '{0}'")
    public MaterialSelectorAssert value(final Matcher<String> condition) {
        return values(hasItem(condition));
    }

    @JDIAction("Assert that '{name}' has value '{0}'")
    public MaterialSelectorAssert value(final String value) {
        return values(hasItem(value));
    }

    @JDIAction("Assert that '{name}' values '{0}'")
    public MaterialSelectorAssert values(final Matcher<? super List<String>> condition) {
        jdiAssert(element().values(), condition);
        return this;
    }

    public MaterialSelectorAssert values(final String... values) {
        return values(hasItems(values));
    }

    public MaterialSelectorAssert values(final List<String> values) {
        return values(toStringArray(values));
    }

    @JDIAction("Assert that '{name}' has groups '{0}'")
    public MaterialSelectorAssert groups(final Matcher<? super List<String>> condition) {
        jdiAssert(element().groups(), condition);
        return this;
    }

    public MaterialSelectorAssert groups(final List<String> groups) {
        return groups(toStringArray(groups));
    }

    public MaterialSelectorAssert groups(final String... values) {
        return groups(hasItems(values));
    }

    @JDIAction("Assert that '{name}' has groups and options '{0}'")
    public MaterialSelectorAssert groupsAndOptions(final Map<String, List<String>> expectedGroupsAndOptions) {
        jdiAssert(element().groupsAndOptions(), Matchers.is(expectedGroupsAndOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' has enabled values '{0}'")
    public MaterialSelectorAssert listEnabled(final Matcher<? super List<String>> condition) {
        jdiAssert(element().listEnabled(), condition);
        return this;
    }

    public MaterialSelectorAssert listEnabled(final List<String> listEnabled) {
        return listEnabled(toStringArray(listEnabled));
    }

    public MaterialSelectorAssert listEnabled(final String... values) {
        return listEnabled(hasItems(values));
    }

    @JDIAction("Assert that '{name}' has disabled values '{0}'")
    public MaterialSelectorAssert listDisabled(final Matcher<? super List<String>> condition) {
        jdiAssert(element().listDisabled(), condition);
        return this;
    }

    public MaterialSelectorAssert listDisabled(final List<String> listDisabled) {
        return listDisabled(toStringArray(listDisabled));
    }

    public MaterialSelectorAssert listDisabled(final String... values) {
        return listDisabled(hasItems(values));
    }

    @JDIAction("Assert that rgba({0}, {1}, {2}, {3}) is the specified color")
    public MaterialSelectorAssert color(final int red, final int green, final int blue, final double a) {
        jdiAssert(element().color(red, green, blue, a), Matchers.is(true));
        return this;
    }
}
