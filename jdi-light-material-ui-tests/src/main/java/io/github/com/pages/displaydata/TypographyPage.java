package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;

import java.util.List;

public class TypographyPage extends WebPage {

    @UI(".MuiBox-root .MuiTypography-root")
    public static List<Typography> typographyTexts;
}
