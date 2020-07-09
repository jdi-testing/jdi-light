package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.*;
import com.epam.jdi.light.asserts.generic.*;
import com.epam.jdi.light.common.*;
import org.hamcrest.*;

import java.util.*;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;

public class AutoCompleteAssert extends UIAssert<AutoCompleteAssert, AutoComplete> implements ITextAssert<AutoCompleteAssert> {

    @JDIAction("Assert that '{name}' is expanded")
    public AutoCompleteAssert expanded() {
        jdiAssert(element.expanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public AutoCompleteAssert collapsed() {
        jdiAssert(element.collapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    @Override
    public AutoCompleteAssert text(String expected) {
        jdiAssert(element().getValue(), Matchers.is(expected));
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    @Override
    public AutoCompleteAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has placeholder {0}")
    public AutoCompleteAssert placeholder(String expected) {
        jdiAssert(element.placeholder(), Matchers.is(expected));
        return this;
    }

    @JDIAction("Assert that '{name} is mandatory")
    public AutoCompleteAssert mandatory() {
        jdiAssert(element.isMandatory(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name} is not mandatory")
    public AutoCompleteAssert notMandatory() {
        jdiAssert(element.isMandatory(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has empty value")
    @Override
    public AutoCompleteAssert empty() {
        jdiAssert(element.getValue(), Matchers.is(""));
        return this;
    }

    @JDIAction("Assert that '{name} is invalid")
    public AutoCompleteAssert invalid() {
        jdiAssert(element.isInvalidated(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name} is valid")
    public AutoCompleteAssert valid() {
        jdiAssert(element.isInvalidated(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has display value")
    public AutoCompleteAssert displayValue(String expected) {
        jdiAssert(element.displayValue(), Matchers.is(expected));
        return this;
    }

    @JDIAction("Assert that '{name}' has options")
    public AutoCompleteAssert options(List<String> options) {
        jdiAssert(element.options(), Matchers.is(options));
        return this;
    }

    @JDIAction("Assert that '{name}' has groups")
    public AutoCompleteAssert groups(List<String> groups) {
        jdiAssert(element.groups(), Matchers.is(groups));
        return this;
    }

    @JDIAction("Assert that '{name}' has groups and options")
    public AutoCompleteAssert groupsAndOptions(Map<String, List<String>> expectedGroupsAndOptions) {
        jdiAssert(element.groupsAndOptionsValues(), Matchers.is(expectedGroupsAndOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' has the {0} option being highlighted")
    public AutoCompleteAssert optionHighlighted(String option) {
        jdiAssert(element.isOptionHighlighted(option), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has the {0} option being not highlighted")
    public AutoCompleteAssert optionNotHighlighted(String option) {
        jdiAssert(element.isOptionHighlighted(option), Matchers.is(false));
        return this;
    }

}