package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Banner;

public class BannersPage extends VuetifyPage {

    @UI("#SingleBanner")
    public static Banner singleBanner;

    @UI("#EventsBanner")
    public static Banner eventsBanner;

    @UI("#ActionsBanner")
    public static Banner actionsBanner;

    @UI("#IconBanner")
    public static Banner iconBanner;

    @UI("#TwoLineBanner")
    public static Banner twoLineBanner;

}
