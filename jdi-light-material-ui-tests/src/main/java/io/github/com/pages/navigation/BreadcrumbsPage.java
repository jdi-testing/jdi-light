package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BreadcrumbsPage extends WebPage {
    @JDIBreadcrumbs(
            icon = ".MuiBreadcrumbs-li .MuiSvgIcon-root"
    )
    public static Breadcrumbs simpleBreadcrumb;

    @UI(".MuiSvgIcon-root.jss6")
    public static Button collapsedButton;

    @JDIBreadcrumbs
    public static Breadcrumbs routerBreadcrumb;

    @UI("//span[text()='Important']")
    public static Text breadcrumbsSectionImportant;
}
