package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class TypographyPage extends WebPage {

    @UI("//*[contains(@class,'MuiTypography-gutterBottom')]")
    public static List<Text> typographyTexts;
}
