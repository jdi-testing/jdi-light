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
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public AvatarAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is {0} px", isAssert = true)
    public AvatarAssert size(int size) {
        jdiAssert(element().core().getSize(), Matchers.is(new Dimension(size, size)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public AvatarAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Avatar does not have icon");
        return this;
    }
}
