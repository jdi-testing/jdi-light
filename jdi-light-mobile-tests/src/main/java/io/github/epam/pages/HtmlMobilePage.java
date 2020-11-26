package io.github.epam.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.app.android.TextField;
import com.epam.jdi.light.ui.html.elements.common.ProgressBar;
import com.epam.jdi.light.ui.html.elements.common.TextArea;


public class HtmlMobilePage extends WebPage {

    @FindBy(xpath = "//select[@id='multi-dropdown']/..")
    public static UIElement multiDropdown;

    @FindBy(css = "#progress")
    public static ProgressBar staticProgressBar;
    @FindBy(css = "#accept-conditions")
    public UIElement singleCheckBox;

    @FindBy(xpath = "//input[@type='radio']/..")
    public static UIElement radioButtons;

    @FindBy(css = "#name")
    public static TextField nameArea;

    @FindBy(xpath = "//input[@name='checks-group']/..")
    public UIElement checkList;

    @FindBy(css = "#text-area")
    public static TextArea textArea;
}
