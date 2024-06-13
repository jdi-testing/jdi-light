package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;
import com.epam.jdi.light.vuetify.interfaces.asserts.*;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AutocompleteAssert extends UIAssert<AutocompleteAssert, Autocomplete>
        implements FilledAssert<AutocompleteAssert, Autocomplete>,
        OutlinedAssert<AutocompleteAssert, Autocomplete>,
        DenseAssert<AutocompleteAssert, Autocomplete>,
        RoundedAssert<AutocompleteAssert, Autocomplete>,
        ShapedAssert<AutocompleteAssert, Autocomplete> {

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AutocompleteAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Autocomplete is not expanded");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is closed", isAssert = true)
    public AutocompleteAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "Autocomplete is not closed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public AutocompleteAssert selected(String value) {
        jdiAssert(element().selected().get(0), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public AutocompleteAssert options(List<String> values) {
        jdiAssert(element().options().stream().map(IsText::getText).collect(Collectors.toList()),
                Matchers.is(values));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is selected", isAssert = true)
    public AutocompleteAssert selected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(true), "Autocomplete doesn't have selected value");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public AutocompleteAssert notSelected(String value) {
        jdiAssert(element().isSelected(value), Matchers.is(false),
                "Autocomplete doesn't have selected value " + value);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not selected", isAssert = true)
    public AutocompleteAssert notSelected(List<String> values) {
        jdiAssert(element().isSelected(values), Matchers.is(false),
                "Autocomplete doesn't have selected values ");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public AutocompleteAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true),
                "Autocomplete is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AutocompleteAssert empty() {
        jdiAssert(element().value().attr("value"), Matchers.is(""));
        return this;
    }

    @JDIAction(value = "Assert that 'name' only one element can be selected", isAssert = true)
    public AutocompleteAssert solo() {
        jdiAssert(
            element().isSolo(),
            Matchers.is(true),
            "Autocomplete is can have many values"
        );
        return this;
    }

    // @todo #5308 create interface for Themes
    @JDIAction(value = "Assert that 'name' has dark style", isAssert = true)
    public AutocompleteAssert dark() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("theme--dark")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has dark style", isAssert = true)
    public AutocompleteAssert light() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("theme--light")
        );
        return this;
    }
}
