package io.github.epam.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class HtmlMobilePage extends WebPage {
  
    @FindBy(xpath = "//select[@id='multi-dropdown']/..")
    public static UIElement multiDropdown;

    @FindBy(xpath = "//input[@type='radio']/..")
    public static UIElement radioButtons;

    @FindBy(css = "#name")
    public static TextField nameArea;
}
