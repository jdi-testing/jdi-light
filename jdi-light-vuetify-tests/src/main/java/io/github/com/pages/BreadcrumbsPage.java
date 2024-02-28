package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumbs;

public class BreadcrumbsPage extends VuetifyPage {

    @UI("#differentDividersBreadcrumbs > .v-breadcrumbs[1]")
    public static Breadcrumbs dashedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > .v-breadcrumbs[2]")
    public static Breadcrumbs forwardSlashedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > .v-breadcrumbs[4]")
    public static Breadcrumbs dottedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > .v-breadcrumbs[5]")
    public static Breadcrumbs semicolonBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > .v-breadcrumbs[6]")
    public static Breadcrumbs greaterSignBreadcrumbs;

    @UI("#largeBreadcrumbs > .v-breadcrumbs")
    public static Breadcrumbs largeBreadcrumbs;

    @UI("#customDividersBreadcrumbs > .v-breadcrumbs[1]")
    public static Breadcrumbs mdiForwardBreadcrumbs;

    @UI("#customDividersBreadcrumbs > .v-breadcrumbs[2]")
    public static Breadcrumbs mdiChevronRightBreadcrumbs;

    @UI("#itemSlotBreadcrumbs > .v-breadcrumbs")
    public static Breadcrumbs itemSlotsBreadcrumbs;

    @UI("#darkThemeRippleBreadcrumbs > .v-breadcrumbs")
    public static Breadcrumbs darkThemeRippleBreadcrumbs;

}
