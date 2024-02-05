package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Banner;
import com.epam.jdi.light.asserts.generic.ColorAssert;
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
    @JDIAction(value = "Assert that '{name}' alert has expected text '{0}'", isAssert = true)
    public BannerAssert text(Matcher<String> text) {
        jdiAssert(element().getText(), text);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is sticky", isAssert = true)
    public BannerAssert sticky() {
        jdiAssert(element().isSticky(), Matchers.is(true), "Banner is not sticky");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not sticky", isAssert = true)
    public BannerAssert notSticky() {
        jdiAssert(element().isSticky(), Matchers.is(false), "Banner is sticky");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public BannerAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Banner has not icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not icon", isAssert = true)
    public BannerAssert notIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Banner has icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' number of buttons is '{0}'", isAssert = true)
    public BannerAssert numberOfButtons(int n) {
        jdiAssert(element().hasNumberOfButtons(), Matchers.equalTo(n));
        return this;
    }
}
