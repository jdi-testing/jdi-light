package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.vuetify.elements.complex.Breadcrumbs;

public class BreadcrumbsPage extends VuetifyPage {
    // dividers section
    @JDIBreadcrumbs(root = "#differentDividersBreadcrumbs > ul:nth-child(1)")
    public static Breadcrumbs dashedBreadcrumbs;
}
