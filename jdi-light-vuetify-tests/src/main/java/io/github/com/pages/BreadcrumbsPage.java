package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.vuetify.elements.complex.Breadcrumbs;

public class BreadcrumbsPage extends VuetifyPage {

    // dividers section
    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(1)")
    public static Breadcrumbs dashedBreadcrumbs;

    @JDIBreadcrumbs(
            root = "#differentDividersBreadcrumbs > ul:nth-child(2)",
            items = ".v-breadcrumbs__item",
            dividers = ".v-breadcrumbs__divider"
    ) // you can specify selectors explicitly
    public static Breadcrumbs forwardSlashedBreadcrumbs;

    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(3)")
    public static Breadcrumbs backwardSlashedBreadcrumbs;

    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(4)")
    public static Breadcrumbs dottedBreadcrumbs;

    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(5)")
    public static Breadcrumbs semicolonBreadcrumbs;

    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(6)")
    public static Breadcrumbs greaterSignBreadcrumbs;

    // large breadcrumbs
    @JDIBreadcrumbs(root = "#largeBreadcrumbs > ul")
    public static Breadcrumbs largeBreadcrumbs;

    // icon breadcrumbs
    @JDIBreadcrumbs(root = "#customDividersBreadcrumbs > ul:nth-child(1)")
    public static Breadcrumbs mdiForwardBreadcrumbs;

    @JDIBreadcrumbs(root = "#customDividersBreadcrumbs > ul:nth-child(2)")
    public static Breadcrumbs mdiChevronRightBreadcrumbs;

    // item slots breadcrumbs
    @JDIBreadcrumbs(root = "#itemSlotBreadcrumbs > ul")
    public static Breadcrumbs itemSlotsBreadcrumbs;

}
