package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.banners.Banner;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BannerAssert extends UIAssert<BannerAssert, Banner> implements RoundedAssert<BannerAssert, Banner>,
        TileAssert<BannerAssert, Banner>, ShapedAssert<BannerAssert, Banner>, OutlinedAssert<BannerAssert, Banner>,
        ThemeAssert<BannerAssert, Banner>, ElevationAssert<BannerAssert, Banner>, ColorAssert<BannerAssert, Banner> {

    @JDIAction("Assert that '{name}' alert has expected text '{0}'")
    public BannerAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
