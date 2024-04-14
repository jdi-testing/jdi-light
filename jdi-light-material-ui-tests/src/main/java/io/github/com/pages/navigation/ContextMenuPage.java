package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ContextMenuPage extends WebPage {

    @UI("p.MuiTypography-root")
    public static Text pageText;

    @UI(".MuiMenu-list")
    public static Menu contextMenuList;
}
