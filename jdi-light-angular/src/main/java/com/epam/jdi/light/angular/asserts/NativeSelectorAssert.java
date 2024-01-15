package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.NativeSelector;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.common.TextTypes;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.EnumUtils.getEnumValue;
import static com.jdiai.tools.LinqUtils.toStringArray;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class NativeSelectorAssert extends UIAssert<NativeSelectorAssert, NativeSelector> {
    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public NativeSelectorAssert selected(final Matcher<String> condition) {
        jdiAssert(element().selected(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{0}' option selected for '{name}'", isAssert = true)
    public NativeSelectorAssert selected(final String option) {
        return selected(Matchers.is(option));
    }

    public <TEnum extends Enum<?>> NativeSelectorAssert selected(final TEnum option) {
        return selected(getEnumValue(option));
    }

    public <TEnum extends Enum<?>> NativeSelectorAssert value(final TEnum option) {
        jdiAssert(element().values(), hasItem(getEnumValue(option)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' value '{0}'", isAssert = true)
    public NativeSelectorAssert value(final Matcher<String> condition) {
        return values(hasItem(condition));
    }

    @JDIAction(value = "Assert that '{name}' has value '{0}'", isAssert = true)
    public NativeSelectorAssert value(final String value) {
        return values(hasItem(value));
    }

    @JDIAction(value = "Assert that '{name}' values '{0}'", isAssert = true)
    public NativeSelectorAssert values(final Matcher<? super List<String>> condition) {
        jdiAssert(element().values(), condition);
        return this;
    }

    public NativeSelectorAssert values(final String... values) {
        return values(hasItems(values));
    }

    public NativeSelectorAssert values(final List<String> values) {
        return values(toStringArray(values));
    }

    @JDIAction(value = "Assert that '{name}' values '{0}'", isAssert = true)
    public NativeSelectorAssert values(final TextTypes type, final Matcher<? super List<String>> condition) {
        jdiAssert(element().values(type), condition);
        return this;
    }

    public NativeSelectorAssert values(final TextTypes type, final String... values) {
        return values(type, hasItems(values));
    }

    @JDIAction(value = "Assert that '{name}' has groups '{0}'", isAssert = true)
    public NativeSelectorAssert groups(final Matcher<? super List<String>> condition) {
        jdiAssert(element().groups(), condition);
        return this;
    }

    public NativeSelectorAssert groups(final List<String> groups) {
        return groups(toStringArray(groups));
    }

    public NativeSelectorAssert groups(final String... values) {
        return groups(hasItems(values));
    }

    @JDIAction(value = "Assert that '{name}' has groups and options '{0}'", isAssert = true)
    public NativeSelectorAssert groupsAndOptions(final Map<String, List<String>> expectedGroupsAndOptions) {
        jdiAssert(element().groupsAndOptions(), Matchers.is(expectedGroupsAndOptions));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has enabled values '{0}'", isAssert = true)
    public NativeSelectorAssert listEnabled(final Matcher<? super List<String>> condition) {
        jdiAssert(element().listEnabled(), condition);
        return this;
    }

    public NativeSelectorAssert listEnabled(final List<String> listEnabled) {
        return listEnabled(toStringArray(listEnabled));
    }

    public NativeSelectorAssert listEnabled(final String... values) {
        return listEnabled(hasItems(values));
    }

    @JDIAction(value = "Assert that '{name}' has disabled values '{0}'", isAssert = true)
    public NativeSelectorAssert listDisabled(final Matcher<? super List<String>> condition) {
        jdiAssert(element().listDisabled(), condition);
        return this;
    }

    public NativeSelectorAssert listDisabled(final List<String> listDisabled) {
        return listDisabled(toStringArray(listDisabled));
    }

    public NativeSelectorAssert listDisabled(final String... values) {
        return listDisabled(hasItems(values));
    }
}
