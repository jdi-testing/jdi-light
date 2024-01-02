package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Avatar;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.openqa.selenium.Dimension;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AvatarAssert extends UIAssert<AvatarAssert, Avatar> implements AlignmentAssert<AvatarAssert, Avatar>,
        ColorAssert<AvatarAssert, Avatar>, ITextAssert<AvatarAssert>,
        MeasurementAssert<AvatarAssert, Avatar>, RoundedAssert<AvatarAssert, Avatar>,
        TileAssert<AvatarAssert, Avatar> {

    @Override
    @JDIAction(value = "Assert that '{name}' text {0}")
    public AvatarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is {0} px")
    public AvatarAssert size(int size) {
        Dimension actualSize = element().core().getSize();
        jdiAssert(actualSize, Matchers.is(new Dimension(size, size)),
                String.format("Actual avatar size is '%d', but expected size is '%d')", actualSize.getHeight(), size));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon")
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element does not have icon");
        return this;
    }
}
