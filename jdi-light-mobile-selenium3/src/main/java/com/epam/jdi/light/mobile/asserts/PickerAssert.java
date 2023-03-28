package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.common.app.android.Picker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PickerAssert extends UIAssert<PickerAssert, Picker> implements ITextAssert<PickerAssert> {

    @JDIAction(value = "Assert that {0} value selected for '{name}'")
    public PickerAssert selected(String selectedElement) {
        jdiAssert(element().getSelected(selectedElement), Matchers.is(selectedElement));
        return this;
    }

    @Override
    public PickerAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    public PickerAssert text(String text) { return text(Matchers.is(text)); }

}
