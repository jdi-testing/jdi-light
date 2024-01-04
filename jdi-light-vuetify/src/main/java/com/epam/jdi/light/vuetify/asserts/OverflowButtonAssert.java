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

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public OverflowButtonAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "OverflowButton is not expanded");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is closed", isAssert = true)
    public OverflowButtonAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true), "OverflowButton is not closed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' selected value is '{0}'", isAssert = true)
    public OverflowButtonAssert selected(String value) {
        jdiAssert(element().selected(), Matchers.is(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' placeholder has text '{0}'", isAssert = true)
    public OverflowButtonAssert placeholder(String text) {
        jdiAssert(element().placeholder(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has counter", isAssert = true)
    public OverflowButtonAssert counter() {
        jdiAssert(element().hasCounter(), Matchers.is(true), "OverflowButton has not counter");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not counter", isAssert = true)
    public OverflowButtonAssert notCounter() {
        jdiAssert(element().hasCounter(), Matchers.is(false), "OverflowButton has counter");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' counter is '{0}'", isAssert = true)
    public OverflowButtonAssert counter(int value) {
        jdiAssert(element().counterValue(), Matchers.equalTo(value));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is editable", isAssert = true)
    public OverflowButtonAssert editable() {
        jdiAssert(element().isEditable(), Matchers.is(true), "OverflowButton is not editable");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not editable", isAssert = true)
    public OverflowButtonAssert notEditable() {
        jdiAssert(element().isEditable(), Matchers.is(false), "OverflowButton is editable");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public OverflowButtonAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true), "OverflowButton is disabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public OverflowButtonAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "OverflowButton is enabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has loader", isAssert = true)
    public OverflowButtonAssert hasLoader() {
        jdiAssert(element().loader().isExist(), Matchers.equalTo(true), "Loader is not exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no loader", isAssert = true)
    public OverflowButtonAssert hasNoLoader() {
        jdiAssert(element().loader().isNotExist(), Matchers.equalTo(true), "Loader is exists");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is segmented", isAssert = true)
    public OverflowButtonAssert segmented() {
        jdiAssert(element().isSegmented(), Matchers.is(true), "OverflowButton is not segmented");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not segmented", isAssert = true)
    public OverflowButtonAssert notSegmented() {
        jdiAssert(element().isSegmented(), Matchers.is(false), "OverflowButton is segmented");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has chips", isAssert = true)
    public OverflowButtonAssert chips() {
        jdiAssert(element().hasChips(), Matchers.is(true), "OverflowButton has no chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no chips", isAssert = true)
    public OverflowButtonAssert noChips() {
        jdiAssert(element().hasChips(), Matchers.is(false), "OverflowButton has chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has small chips", isAssert = true)
    public OverflowButtonAssert smallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(true), "OverflowButton has no small chips");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no small chips", isAssert = true)
    public OverflowButtonAssert noSmallChips() {
        jdiAssert(element().hasSmallChips(), Matchers.is(false), "OverflowButton has small chips");
        return this;
    }
}
