package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.AutoComplete;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AutoCompleteAssert extends UIAssert<AutoCompleteAssert, AutoComplete> implements ITextAssert<AutoCompleteAssert> {

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AutoCompleteAssert expanded() {
        jdiAssert(element().expanded(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is collapsed", isAssert = true)
    public AutoCompleteAssert collapsed() {
        jdiAssert(element().collapsed(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    @Override
    public AutoCompleteAssert text(String expected) {
        jdiAssert(element().getText(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    @Override
    public AutoCompleteAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has placeholder {0}", isAssert = true)
    public AutoCompleteAssert placeholder(String expected) {
        jdiAssert(element().placeholder(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name} is mandatory", isAssert = true)
    public AutoCompleteAssert mandatory() {
        jdiAssert(element().isMandatory(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name} is not mandatory", isAssert = true)
    public AutoCompleteAssert notMandatory() {
        jdiAssert(element().isMandatory(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has empty value", isAssert = true)
    @Override
    public AutoCompleteAssert empty() {
        jdiAssert(element().getValue(), Matchers.is(""));
        return this;
    }

    @JDIAction(value = "Assert that '{name} is invalid", isAssert = true)
    public AutoCompleteAssert invalid() {
        jdiAssert(element().isInvalidated(), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name} is valid", isAssert = true)
    public AutoCompleteAssert valid() {
        jdiAssert(element().isInvalidated(), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has display value", isAssert = true)
    public AutoCompleteAssert displayValue(String expected) {
        jdiAssert(element().getValue(), Matchers.is(expected));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has options", isAssert = true)
    public AutoCompleteAssert options(List<String> options) {
        jdiAssert(element().options(), Matchers.is(options));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has groups", isAssert = true)
    public AutoCompleteAssert groups(List<String> groups) {
        jdiAssert(element().groups(), Matchers.is(groups));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has groups and options", isAssert = true)
    public AutoCompleteAssert groupsAndOptions(Map<String, List<String>> expectedGroupsAndOptions) {
        jdiAssert(element().groupsAndOptionsValues(), Matchers.is(expectedGroupsAndOptions));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has the {0} option being highlighted", isAssert = true)
    public AutoCompleteAssert optionHighlighted(String option) {
        jdiAssert(element().isOptionHighlighted(option), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has the {0} option being not highlighted", isAssert = true)
    public AutoCompleteAssert optionNotHighlighted(String option) {
        jdiAssert(element().isOptionHighlighted(option), Matchers.is(false), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

}
