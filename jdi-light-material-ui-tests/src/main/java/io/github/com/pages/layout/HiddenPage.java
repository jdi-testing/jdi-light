package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Paper;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class HiddenPage extends WebPage {
    @UI(".MuiTypography-subtitle1")
    public static Text currentWidth;

    @UI(".MuiPaper-root")
    public static List<Paper> papers;
}
