package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Sheet;
import com.epam.jdi.light.vuetify.interfaces.asserts.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SheetAssert extends UIAssert<SheetAssert, Sheet> implements ITextAssert<SheetAssert>,
        ThemeAssert<SheetAssert, Sheet>, TileAssert<SheetAssert, Sheet>,
        ShapedAssert<SheetAssert, Sheet>, OutlinedAssert<SheetAssert, Sheet>,
        ElevationAssert<SheetAssert, Sheet>, ColorAssert<SheetAssert, Sheet>,
        MeasurementAssert<SheetAssert, Sheet>, RoundedAssert<SheetAssert, Sheet> {

    @JDIAction("Assert that '{name}' border radius is {0}")
    public SheetAssert borderRadius(int value) {
        jdiAssert(element().borderRadius(), Matchers.is(value));
        return this;
    }

    @Override
    public SheetAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
