package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.OverflowButton;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FilledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FullWidthAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.LoadingAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MessagesAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReverseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class OverflowButtonAssert extends UIAssert<OverflowButtonAssert, OverflowButton> implements
        MessagesAssert<OverflowButtonAssert, OverflowButton>, ReadOnlyAssert<OverflowButtonAssert, OverflowButton>,
        LoadingAssert<OverflowButtonAssert, OverflowButton>, DenseAssert<OverflowButtonAssert, OverflowButton>,
        FilledAssert<OverflowButtonAssert, OverflowButton>, ReverseAssert<OverflowButtonAssert, OverflowButton>,
        RoundedAssert<OverflowButtonAssert, OverflowButton>, FlatAssert<OverflowButtonAssert, OverflowButton>,
        ThemeAssert<OverflowButtonAssert, OverflowButton>, OutlinedAssert<OverflowButtonAssert, OverflowButton>,
        ShapedAssert<OverflowButtonAssert, OverflowButton>, SingleLineAssert<OverflowButtonAssert, OverflowButton>,
        FullWidthAssert<OverflowButtonAssert, OverflowButton> {

    @JDIAction("Assert that '{name}' is expanded")
    public OverflowButtonAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Element is not expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public OverflowButtonAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true), "Element is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' selected value is '{0}'")
    public OverflowButtonAssert selected(String value) {
        String actualSelectedValue = element().selected();
        jdiAssert(actualSelectedValue, Matchers.is(value), String.format("Actual selected value '%s' is not equal to " +
                "expected '%s'", actualSelectedValue, value));
        return this;
    }

    @JDIAction("Assert that '{name}' placeholder has text '{0}'")
    public OverflowButtonAssert placeholder(String text) {
        String actualPlaceholderText = element().placeholder();
        jdiAssert(actualPlaceholderText, Matchers.is(text), String.format("Element's actual placeholder text '%s' " +
                "is not equal to expected '%s'", actualPlaceholderText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' has counter")
    public OverflowButtonAssert counter() {
        jdiAssert(element().hasCounter(), Matchers.is(true), "Element has not counter");
        return this;
    }

    @JDIAction("Assert that '{name}' has not counter")
    public OverflowButtonAssert notCounter() {
        jdiAssert(element().hasCounter(), Matchers.is(false), "Element has counter");
        return this;
    }

    @JDIAction("Assert that '{name}' counter is '{0}'")
    public OverflowButtonAssert counter(int value) {
        int actualCounterValue = element().counterValue();
        jdiAssert(actualCounterValue, Matchers.equalTo(value), String.format("Actual counter value '%s' is not equal " +
                "to expected '%s'", actualCounterValue, value));
        return this;
    }

    @JDIAction("Assert that '{name}' is editable")
    public OverflowButtonAssert editable() {
        jdiAssert(element().isEditable(), Matchers.is(true), "Element is not editable");
        return this;
    }

    @JDIAction("Assert that '{name}' is not editable")
    public OverflowButtonAssert notEditable() {
        jdiAssert(element().isEditable(), Matchers.is(false), "Element is editable");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public OverflowButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "Element is disabled");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public OverflowButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "Element is enabled");
        return this;
    }

    @JDIAction("Assert that '{name}' has loader")
    public OverflowButtonAssert hasLoader() {
        jdiAssert(element().loader().isExist(), Matchers.equalTo(true), "Loader is not exists");
        return this;
    }

    @JDIAction("Assert that '{name}' has no loader")
    public OverflowButtonAssert hasNoLoader() {
        jdiAssert(element().loader().isNotExist(), Matchers.equalTo(true), "Loader is exists");
        return this;
    }

    @JDIAction("Assert that '{name}' is segmented")
    public OverflowButtonAssert segmented() {
        jdiAssert(element().isSegmented(), Matchers.is(true), "Element is not segmented");
        return this;
    }

    @JDIAction("Assert that '{name}' is not segmented")
    public OverflowButtonAssert notSegmented() {
        jdiAssert(element().isSegmented(), Matchers.is(false), "Element is segmented");
        return this;
    }

    @JDIAction("Assert that '{name}' has chips")
    public OverflowButtonAssert chips() {
        jdiAssert(element().hasChips(), Matchers.is(true), "Element has no chips");
        return this;
    }

    @JDIAction("Assert that '{name}' has no chips")
    public OverflowButtonAssert noChips() {
        jdiAssert(element().hasChips(), Matchers.is(false), "Element has chips");
        return this;
    }

    @JDIAction("Assert that '{name}' has small chips")
    public OverflowButtonAssert smallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(true), "Element has no small chips");
        return this;
    }

    @JDIAction("Assert that '{name}' has no small chips")
    public OverflowButtonAssert noSmallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(false), "Element has small chips");
        return this;
    }
}
