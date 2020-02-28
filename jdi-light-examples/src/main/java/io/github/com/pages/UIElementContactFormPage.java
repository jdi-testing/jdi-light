package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;

public class UIElementContactFormPage extends WebPage {
    //Elements are described in different formats to cover all variants of initialization
    @ByText("Submit") public static UIElement submit;
    @Css("li[class='summ-res']") public static UIElement sum;
    @Css("textarea[class='uui-form-element']") public static UIElement description;
    @Css("[id='p1']") public static UIElement forCalculateOne;
    @XPath(UIElementConstants.firstRowForCalculate + "//*[@id='p2']") public static UIElement forCalculateThree;
    @UI("['SubmitNotDisplayed']") public static UIElement submitNotDisplayed;
    @XPath("//*[contains(text(), 'Result')]") public static UIElement result;
    @Css("[for='accept-conditions']") public static UIElement acceptConditions;
    public static UIElement smartLocator;
    @XPath("//a[@title='Tip title']") public static UIElement about;
}

final class UIElementConstants{
    public static final String  firstRowForCalculate = "//*[@class='horizontal-group'][1]";
}
