package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Alert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
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


    @JDIAction("Assert that '{name}' text {0}")
    public AlertAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' is dismissible")
    public AlertAssert dismissible() {
        jdiAssert(element().isDismissible(), Matchers.is(true), "Alert is not dismissible");
        return this;
    }

    @JDIAction("Assert that '{name}' is not dismissible")
    public AlertAssert notDismissible() {
        jdiAssert(element().isDismissible(), Matchers.is(false), "Alert is dismissible");
        return this;
    }

    @JDIAction("Assert that '{name}' is prominent")
    public AlertAssert prominent() {
        jdiAssert(element().isProminent(), Matchers.is(true), "Alert is not prominent");
        return this;
    }

    @JDIAction("Assert that '{name}' is not prominent")
    public AlertAssert notProminent() {
        jdiAssert(element().isProminent(), Matchers.is(false), "Alert is prominent");
        return this;
    }

    @JDIAction("Assert that '{name}' has border")
    public AlertAssert border() {
        jdiAssert(element().hasBorder(), Matchers.is(true), "Alert has no border");
        return this;
    }

    @JDIAction("Assert that '{name}' has no border")
    public AlertAssert noBorder() {
        jdiAssert(element().hasBorder(), Matchers.is(false), "Alert has border");
        return this;
    }

    @JDIAction("Assert that '{name}' has {0} border")
    public AlertAssert border(String boardValue) {
        String actualBorderValue = element().borderValue();
        jdiAssert(actualBorderValue, Matchers.is(boardValue),
                String.format("Alert has '%s' border, but expected '%s'", actualBorderValue, boardValue));
        return this;
    }

    @JDIAction("Assert that '{name}' has colored border")
    public AlertAssert coloredBorder() {
        jdiAssert(element().hasColoredBorder(), Matchers.is(true),
                "Alert has no colored border");
        return this;
    }

    @JDIAction("Assert that '{name}' has no colored border")
    public AlertAssert noColoredBorder() {
        jdiAssert(element().hasColoredBorder(), Matchers.is(false),
                "Alert has colored border");
        return this;
    }

    @JDIAction("Assert that '{name}' has border background color '{0}'")
    public AlertAssert backgroundBorderColor(String borderBackgroundColor) {
        if (element().hasColoredBorder()) {
            String actualBackgroundBorderColor = element().borderBackGroundColor();
            jdiAssert(actualBackgroundBorderColor, Matchers.is(borderBackgroundColor),
                    String.format("Actual alert background border color is '%s', but expected '%s'", actualBackgroundBorderColor, borderBackgroundColor));
            return this;
        } else {
            return coloredBorder();
        }
    }

    @JDIAction("Assert that '{name}' has '{0}' type")
    public AlertAssert type(String type) {
        String actualType = element().type();
        jdiAssert(actualType, Matchers.is(type),
                String.format("Actual alert type is '%s', bur expected '%s'", actualType, type));
        return this;
    }
}
