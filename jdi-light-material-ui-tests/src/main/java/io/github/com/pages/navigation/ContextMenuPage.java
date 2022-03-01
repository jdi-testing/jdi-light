package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ContextMenuPage extends WebPage {

    @UI("p.MuiTypography-root")
    public static Text pageText;

    @UI(".MuiList-padding")
    public static List contextList;
}
