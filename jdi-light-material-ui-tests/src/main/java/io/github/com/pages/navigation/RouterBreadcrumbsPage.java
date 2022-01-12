package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;


public class RouterBreadcrumbsPage extends WebPage {

    @JDIBreadcrumbs(root = ".MuiBreadcrumbs-root")
    public static Breadcrumbs routerBreadcrumbs;

    @UI("//nav[@aria-label = 'mailbox folders']/ul[contains(@class, 'MuiList-root')]")
    public static List mailBoxList;
}
