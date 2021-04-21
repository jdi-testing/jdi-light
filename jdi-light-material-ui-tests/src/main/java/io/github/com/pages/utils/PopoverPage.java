package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class PopoverPage extends WebPage {

    @UI("//button[contains(@class,'MuiButtonBase-root')]/span[@class='MuiButton-label']")
    public static Button buttonToClick;

    @UI("//div[contains(@class,'MuiPaper-root')]/div")
    public static Button popoverContent;

    @UI("//span[@class='MuiTypography-root']")
    public static Text popoverHoverField;
}
