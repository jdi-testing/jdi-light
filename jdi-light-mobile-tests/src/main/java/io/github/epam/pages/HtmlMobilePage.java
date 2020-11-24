package io.github.epam.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class HtmlMobilePage extends WebPage {

    @FindBy(xpath = "//input[@type='radio']/..")
    public static UIElement radioButtons;
}
