package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Banner;

public class BannersPage extends VuetifyPage {

    @UI("#SingleBanner .v-banner")
    public static Banner singleBanner;

    @UI("#SingleBanner .v-input--switch")
    public static Switch singleBannerSwitch;

    @UI("#EventsBanner")
    public static Banner eventsBanner;

    @UI("#ActionsBanner .v-banner")
    public static Banner actionsBanner;

    @UI("#IconBanner")
    public static Banner iconBanner;

    @UI("#TwoLineBanner")
    public static Banner twoLineBanner;

    @UI("#RoundedBanner")
    public static Banner roundedBanner;

    @UI("#TileBanner [type='checkbox']")
    public static Checkbox enableTileCheckbox;

    @UI("#TileBanner > .v-banner")
    public static Banner tileBanner;

    @UI("#ShapedBanner")
    public static Banner shapedBanner;

    @UI("#OutlinedBanner")
    public static Banner outlinedBanner;

    @UI("#DarkBanner")
    public static Banner darkBanner;

    @UI("#ElevatedBanner")
    public static Banner elevatedBanner;
}
