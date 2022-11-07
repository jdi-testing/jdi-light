package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.banners.ActionsBanner;
import com.epam.jdi.light.vuetify.elements.complex.banners.Banner;
import com.epam.jdi.light.vuetify.elements.complex.banners.EventsBanner;
import com.epam.jdi.light.vuetify.elements.complex.banners.IconBanner;
import com.epam.jdi.light.vuetify.elements.complex.banners.SingleBanner;
import com.epam.jdi.light.vuetify.elements.complex.banners.TwoLineBanner;

public class BannersPage extends VuetifyPage {

    @UI("#SingleBanner")
    public static SingleBanner singleBanner;

    @UI("#EventsBanner")
    public static EventsBanner eventsBanner;

    @UI("#ActionsBanner")
    public static ActionsBanner actionsBanner;

    @UI("#IconBanner")
    public static IconBanner iconBanner;

    @UI("#TwoLineBanner")
    public static TwoLineBanner twoLineBanner;

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
