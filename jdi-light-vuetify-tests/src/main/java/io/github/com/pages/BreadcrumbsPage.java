package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumbs;

public class BreadcrumbsPage extends VuetifyPage {

    // @todo #5298 locator should use .v-breadcrumbs, not ul tag
    @UI("#differentDividersBreadcrumbs > ul:nth-child(1)")
    public static Breadcrumbs dashedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > ul:nth-child(2)")
    public static Breadcrumbs forwardSlashedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > ul:nth-child(4)")
    public static Breadcrumbs dottedBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > ul:nth-child(5)")
    public static Breadcrumbs semicolonBreadcrumbs;

    @UI("#differentDividersBreadcrumbs > ul:nth-child(6)")
    public static Breadcrumbs greaterSignBreadcrumbs;

    @UI("#largeBreadcrumbs > ul")
    public static Breadcrumbs largeBreadcrumbs;

    @UI("#customDividersBreadcrumbs > ul:nth-child(1)")
    public static Breadcrumbs mdiForwardBreadcrumbs;

    @UI("#customDividersBreadcrumbs > ul:nth-child(2)")
    public static Breadcrumbs mdiChevronRightBreadcrumbs;

    @UI("#itemSlotBreadcrumbs > ul")
    public static Breadcrumbs itemSlotsBreadcrumbs;

    @UI("#darkThemeRippleBreadcrumbs > ul")
    public static Breadcrumbs darkThemeRippleBreadcrumbs;

}
