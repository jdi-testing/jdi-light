package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;

import java.util.List;

/**
 * To see an example of Accordion web element please visit
 * https://material-ui.com/ru/components/breadcrumbs/
 */

public class BreadcrumbsPage extends WebPage {

    @UI(".MuiBreadcrumbs-li")
    public static List<UIElement> breadcrumbs;

    @UI(".MuiBreadcrumbs-separator")
    public static List<UIElement> separators;

    @UI(".MuiBreadcrumbs-li .MuiSvgIcon-root")
    public static List<UIElement> icons;

    @UI(".MuiSvgIcon-root.jss6")
    public static Button collapsedButton;

    @UI("//span[text()='Trash']")
    public static UIElement trashDisplayBlock;

    @UI("//span[text()='Important']")
    public static UIElement importantDisplayBlock;

    @UI("//span[text()='Inbox']")
    public static UIElement inboxDisplayBlock;

    @UI("//h3[text()='Material UI']")
    public static UIElement materialElement;

    @UI("//h3[text()='Core']")
    public static UIElement coreElement;


}
