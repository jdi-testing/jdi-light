package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.navigation.Breadcrumb;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class SimpleBreadcrumbsPage extends WebPage {

    @UI(".MuiBreadcrumbs-li")
    public static List<Breadcrumb> breadcrumbs;

    @UI(".MuiBreadcrumbs-separator")
    public static List<UIElement> separators;

    @UI(".MuiBreadcrumbs-li .MuiSvgIcon-root")
    public static List<Icon> icons;

    @UI(".MuiSvgIcon-root.jss6")
    public static Button collapsedButton;

    @UI("//h3[text()='Material UI']")
    public static Text materialElement;

    @UI("//h3[text()='Core']")
    public static Text coreElement;

}
