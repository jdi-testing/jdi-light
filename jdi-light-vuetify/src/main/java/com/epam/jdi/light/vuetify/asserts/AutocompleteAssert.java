package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AutocompleteAssert extends UIAssert<AutocompleteAssert, Autocomplete> {

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
                "Autocomplete is not disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AutocompleteAssert active() {
        jdiAssert(element().isDisabled(), Matchers.is(false),
                "Autocomplete is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AutocompleteAssert empty() {
        jdiAssert(element().value().attr("value"), Matchers.is(""));
        return this;
    }

    // @todo #5048 Create methods in Autocomplete class with all styles below
    @JDIAction(value = "Assert that 'name' has solo style", isAssert = true)
    public AutocompleteAssert solo() {
        jdiAssert(
                element().root().getAttribute("class"),
                Matchers.containsString("v-text-field--solo")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has filled style", isAssert = true)
    public AutocompleteAssert filled() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-text-field--filled")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has solo-inverted style", isAssert = true)
    public AutocompleteAssert soloInverted() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-text-field--solo-inverted")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has outlined style", isAssert = true)
    public AutocompleteAssert outlined() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-text-field--outlined")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has dense style", isAssert = true)
    public AutocompleteAssert dense() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-input--dense")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has shaped style", isAssert = true)
    public AutocompleteAssert shaped() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-text-field--shaped")
        );
        return this;
    }

    @JDIAction(value = "Assert that 'name' has rounded style", isAssert = true)
    public AutocompleteAssert rounded() {
        jdiAssert(
                element().root().attr("class"),
                Matchers.containsString("v-text-field--rounded")
        );
        return this;
    }

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
