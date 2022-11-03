package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Snackbar;

import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TextStyledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OrientationAssert;
import org.hamcrest.Matchers;

public class SnackbarAssert extends UIAssert<SnackbarAssert, Snackbar>
        implements ThemeAssert<SnackbarAssert, Snackbar>, OrientationAssert<SnackbarAssert, Snackbar>,
        OutlinedAssert<SnackbarAssert, Snackbar>, ColorAssert<SnackbarAssert, Snackbar>,
        RoundedAssert<SnackbarAssert, Snackbar>, ElevationAssert<SnackbarAssert, Snackbar>,
        TileAssert<SnackbarAssert, Snackbar>, MeasurementAssert<SnackbarAssert, Snackbar>,
        TextStyledAssert<SnackbarAssert, Snackbar>, ShapedAssert<SnackbarAssert, Snackbar>,
        AlignmentAssert<SnackbarAssert, Snackbar> {

    @Override
    public SnackbarAssert and() {
        return super.and();
    }

    @JDIAction("Assert that {name} is visible")
    public SnackbarAssert visible() {
        jdiAssert(element().isOpen(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public SnackbarAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has text")
    public SnackbarAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} is centered")
    public SnackbarAssert centered() {
        jdiAssert(element().isCentered(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is top")
    public SnackbarAssert top() {
        jdiAssert(element().isTop(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is bottom")
    public SnackbarAssert bottom() {
        jdiAssert(element().isBottom(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is multi-line")
    public SnackbarAssert multiLine() {
        jdiAssert(element().isMultiLine(), Matchers.is(true));
        return this;
    }
}
