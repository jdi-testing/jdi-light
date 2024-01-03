package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import com.epam.jdi.light.vuetify.enums.AlertType;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TextStyledAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AlertAssert extends UIAssert<AlertAssert, Alert> implements ITextAssert<AlertAssert>,
        DenseAssert<AlertAssert, Alert>, ColorAssert<AlertAssert, Alert>,
        MeasurementAssert<AlertAssert, Alert>, ThemeAssert<AlertAssert, Alert>,
        TileAssert<AlertAssert, Alert>, TextStyledAssert<AlertAssert, Alert>,
        ShapedAssert<AlertAssert, Alert>, RoundedAssert<AlertAssert, Alert>,
        OutlinedAssert<AlertAssert, Alert>, ElevationAssert<AlertAssert, Alert> {


    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public AlertAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is dismissible", isAssert = true)
    public AlertAssert dismissible() {
        jdiAssert(element().isDismissible(), Matchers.is(true), "Alert is not dismissible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not dismissible", isAssert = true)
    public AlertAssert notDismissible() {
        jdiAssert(element().isDismissible(), Matchers.is(false), "Alert is dismissible");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is prominent", isAssert = true)
    public AlertAssert prominent() {
        jdiAssert(element().isProminent(), Matchers.is(true), "Alert is not prominent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not prominent", isAssert = true)
    public AlertAssert notProminent() {
        jdiAssert(element().isProminent(), Matchers.is(false), "Alert is prominent");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has border", isAssert = true)
    public AlertAssert border() {
        jdiAssert(element().hasBorder(), Matchers.is(true), "Alert has no border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no border", isAssert = true)
    public AlertAssert noBorder() {
        jdiAssert(element().hasBorder(), Matchers.is(false), "Alert has border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} border", isAssert = true)
    public AlertAssert border(String boardValue) {
        jdiAssert(element().borderValue(), Matchers.is(boardValue));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has colored border", isAssert = true)
    public AlertAssert coloredBorder() {
        jdiAssert(element().hasColoredBorder(), Matchers.is(true),
                "Alert has no colored border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no colored border", isAssert = true)
    public AlertAssert noColoredBorder() {
        jdiAssert(element().hasColoredBorder(), Matchers.is(false),
                "Alert has colored border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has border background color '{0}'", isAssert = true)
    public AlertAssert backgroundBorderColor(String borderBackgroundColor) {
        if (element().hasColoredBorder()) {
            jdiAssert(element().borderBackGroundColor(), Matchers.is(borderBackgroundColor));
            return this;
        } else {
            return coloredBorder();
        }
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' type", isAssert = true)
    public AlertAssert type(String type) {
        jdiAssert(element().type().toString(), Matchers.is(type));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' type", isAssert = true)
    public AlertAssert type(AlertType type) {
        jdiAssert(element().type(), Matchers.is(type));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has close button", isAssert = true)
    public AlertAssert hasCloseButton() {
        jdiAssert(element().hasCloseButton(), Matchers.is(true), "Alert has no close button");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has close button", isAssert = true)
    public AlertAssert hasNoCloseButton() {
        jdiAssert(element().hasCloseButton(), Matchers.is(false), "Alert has close button");
        return this;
    }
}
