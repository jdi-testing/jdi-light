package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class SimpleBreadcrumbsPage extends WebPage {

    @UI(".MuiBox-root>div>:nth-child(3)")
    public static Breadcrumbs simpleBreadcrumbs;

    @UI(".MuiBox-root>div>:nth-child(5)>nav")
    public static Breadcrumbs breadcrumbsWithIcons;

    @UI(".MuiBox-root>div>:nth-child(7)>nav")
    public static List<Breadcrumbs> customSeparatorBreadcrumbs;

    @UI(".MuiBox-root>div>:nth-child(9)")
    public static Breadcrumbs collapsedBreadcrumbs;

    @UI(".MuiBox-root>div>:nth-child(11)")
    public static Breadcrumbs customizedBreadcrumbs;

    @UI(".MuiSvgIcon-root.jss6")
    public static MaterialButton collapsedButton;

    @UI("//h3[text()='Material UI']")
    public static Text materialElement;

    @UI("//h3[text()='Core']")
    public static Text coreElement;

}
