package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JBreadcrumbs;
import com.epam.jdi.light.material.elements.displaydata.MUISimpleList;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;


public class RouterBreadcrumbsPage extends WebPage {

    @JBreadcrumbs(root = ".MuiBreadcrumbs-root")
    public static Breadcrumbs routerBreadcrumbs;

    @UI("//nav[@aria-label = 'mailbox folders']/ul[contains(@class, 'MuiList-root')]")
    public static MUISimpleList mailBoxList;
}
