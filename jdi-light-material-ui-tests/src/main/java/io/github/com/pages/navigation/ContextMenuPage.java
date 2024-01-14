package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ContextMenuPage extends WebPage {

    @UI("p.MuiTypography-root")
    public static Text pageText;

    // @todo #5297 Check the locator, looks like it points to item, not for Menu
    @UI(".MuiMenuItem-root")
    public static Menu contextMenuList;
}
