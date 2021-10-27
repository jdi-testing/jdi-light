package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Subheader;

import java.util.List;

public class SubheadersPage extends VuetifyPage {

    @UI("#InsetSubheader .v-subheader")
    public static Subheader insetSubheader;

    @UI("#GridSubheader .v-subheader")
    public static List<Subheader> gridSubheader;

    @UI("#MenuSubheader .v-subheader")
    public static Subheader menuSubheader;

    @UI("#SocialMediaSubheader .v-subheader")
    public static List<Subheader> socialMediaSubheader;
}
