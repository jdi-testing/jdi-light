package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;

import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TextStyledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import org.hamcrest.Matchers;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar>
        implements ThemeAssert<SnackbarAssert, Snackbar>, OrientationAssert<SnackbarAssert, Snackbar>,
        OutlinedAssert<SnackbarAssert, Snackbar>, ColorAssert<SnackbarAssert, Snackbar>,
        RoundedAssert<SnackbarAssert, Snackbar>, ElevationAssert<SnackbarAssert, Snackbar>,
        MeasurementAssert<SnackbarAssert, Snackbar>,
        TextStyledAssert<SnackbarAssert, Snackbar>, ShapedAssert<SnackbarAssert, Snackbar>,
        AlignmentAssert<SnackbarAssert, Snackbar> {

    @Override
    public SnackbarAssert and() {
        return super.and();
    }

    @JDIAction(value = "Assert that {name} is visible", isAssert = true)
    public SnackbarAssert visible() {
        jdiAssert(element().isOpen(), Matchers.is(true), "Snackbar is not opened");
        return this;
    }

    @JDIAction(value = "Assert that {name} is closed", isAssert = true)
    public SnackbarAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true), "Snackbar is not closed");
        return this;
    }

    @JDIAction(value = "Assert that {name} has text", isAssert = true)
    public SnackbarAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction(value = "Assert that {name} is centered", isAssert = true)
    public SnackbarAssert centered() {
        jdiAssert(element().isCentered(), Matchers.is(true), "Snackbar is not centered");
        return this;
    }

    @JDIAction(value = "Assert that {name} is top", isAssert = true)
    public SnackbarAssert top() {
        jdiAssert(element().isTop(), Matchers.is(true), "Snackbar is not top");
        return this;
    }

    @JDIAction(value = "Assert that {name} is bottom", isAssert = true)
    public SnackbarAssert bottom() {
        jdiAssert(element().isBottom(), Matchers.is(true), "Snackbar is not bottom");
        return this;
    }

    @JDIAction(value = "Assert that {name} is multi-line", isAssert = true)
    public SnackbarAssert multiLine() {
        jdiAssert(element().isMultiLine(), Matchers.is(true), "Snackbar is not multiline");
        return this;
    }
}
