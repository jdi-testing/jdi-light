package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Breadcrumb;

import java.util.List;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class RouterBreadcrumbsPage extends WebPage {

    @UI(".MuiBreadcrumbs-li")
    public static List<Breadcrumb> breadcrumbs;

    @UI("//span[text()='Trash']")
    public static UIElement trashDisplayBlock;

    @UI("//span[text()='Important']")
    public static UIElement importantDisplayBlock;

    @UI("//span[text()='Inbox']")
    public static UIElement inboxDisplayBlock;

}
