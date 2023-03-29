package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.SingleLineAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> implements RoundedAssert<BannerAssert, Banner>,
        TileAssert<BannerAssert, Banner>, ShapedAssert<BannerAssert, Banner>, OutlinedAssert<BannerAssert, Banner>,
        ThemeAssert<BannerAssert, Banner>, ElevationAssert<BannerAssert, Banner>, ColorAssert<BannerAssert, Banner>,
        SingleLineAssert<BannerAssert, Banner>, ITextAssert<BannerAssert> {

    @Override
    @JDIAction("Assert that '{name}' alert has expected text '{0}'")
    public BannerAssert text(Matcher<String> text) {
        String actualText = element().getText();
        jdiAssert(actualText, text,
                String.format("Element's actual text '%s' is not equal to expected '%s'", actualText, text));
        return this;
    }

    @JDIAction("Assert that '{name}' is sticky")
    public BannerAssert sticky() {
        jdiAssert(element().isSticky(), Matchers.is(true), "Element is not sticky");
        return this;
    }

    @JDIAction("Assert that '{name}' is not sticky")
    public BannerAssert notSticky() {
        jdiAssert(element().isSticky(), Matchers.is(false), "Element is sticky");
        return this;
    }

    @JDIAction("Assert that '{name}' has icon")
    public BannerAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element has not icon");
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon")
    public BannerAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Element has icon");
        return this;
    }

    @JDIAction("Assert that '{name}' number of buttons is '{0}'")
    public BannerAssert numberOfButtons(int n) {
        int actualNumberOfButtons = element().hasNumberOfButtons();
        jdiAssert(actualNumberOfButtons, Matchers.equalTo(n), String.format("Actual number of element's buttons '%s' " +
                "is not equal to expected '%s'", actualNumberOfButtons, n));
        return this;
    }
}
