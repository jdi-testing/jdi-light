package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;

public class UIElementContactFormPage extends WebPage {
    @ByText("Submit") public static UIElement submit;
    @Css("li[class='summ-res']") public static UIElement sum;
    @Css("textarea[class='uui-form-element']") public static UIElement description;
    @Css("[id='p1']") public static UIElement forCalculateOne;
    @Css("[id='p2']") public static UIElement forCalculateThree;
    @ByText("Submitt") public static UIElement submitNotDisplayed;
    @XPath("//*[contains(text(), 'Result')]") public static UIElement result;
    @Css("[for='accept-conditions']") public static UIElement acceptConditions;
}