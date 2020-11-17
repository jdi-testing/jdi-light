package io.github.epam.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;


public class HtmlMobilePage extends WebPage {

    @FindBy(css = "#accept-conditions")
    public UIElement singleCheckBox;

    @FindBy(xpath = "//input[@name='checks-group']/..")
    public UIElement checkList;
}
