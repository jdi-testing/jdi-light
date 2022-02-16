package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Banner;

public class BannersPage extends VuetifyPage {

    @UI(".v-banner--single-line")
    public static Banner singleBanner;

    @UI("#EventsBanner")
    public static Banner eventsBanner;

    @UI("#ActionsBanner")
    public static Banner actionsBanner;

    @UI("#IconBanner")
    public static Banner iconBanner;

    @UI("#TwoLineBanner")
    public static Banner twoLineBanner;

    @UI(".v-input--switch")
    public static Switch stickSwitch;

    @UI(".v-input--checkbox")
    public static Checkbox visibilityCheckbox;

}
