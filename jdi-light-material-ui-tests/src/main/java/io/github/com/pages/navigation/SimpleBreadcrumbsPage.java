package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import io.github.com.custom.elements.CollapsedBreadcrumbs;


public class SimpleBreadcrumbsPage extends WebPage {

    @JDIBreadcrumbs(
            root = ".MuiBreadcrumbs-root[1]",
            items = ".MuiBreadcrumbs-li .MuiTypography-root",
            separators = ".MuiBreadcrumbs-separator"
    )
    public static Breadcrumbs simpleBreadcrumbs;

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root[2]")
    public static Breadcrumbs breadcrumbsWithIcons;

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root[3]")
    public static Breadcrumbs customSeparatorBreadcrumbsMore;

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root[4]")
    public static Breadcrumbs customSeparatorBreadcrumbsMinus;

    @JDIBreadcrumbs(
            root = ".MuiBreadcrumbs-root[5]",
            separators = ".MuiBreadcrumbs-separator .MuiSvgIcon-root"
    )
    public static Breadcrumbs customSeparatorBreadcrumbsIcon;

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root[6]")
    public static CollapsedBreadcrumbs collapsedBreadcrumbs;

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root[7]")
    public static Breadcrumbs customizedBreadcrumbs;
}
