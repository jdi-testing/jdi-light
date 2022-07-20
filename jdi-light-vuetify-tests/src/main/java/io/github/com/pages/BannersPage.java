package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.banners.*;

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

    @UI(".v-input--switch")
    public static Switch stickSwitch;

    @UI(".v-input--checkbox")
    public static Checkbox visibilityCheckbox;

}
