package io.github.com.pages;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.elements.common.uiElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.SClass;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.SId;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.SText;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.Smart;

import static com.epam.jdi.light.common.TextTypes.TEXT;

public class UIElementContactFormPage extends WebPage {
    //Elements are described in different formats to cover all variants of initialization
    @ByText("Submit") public static uiElement submit;
    @Css("li[class='summ-res']") public static uiElement sum;
    @Css("textarea[class='uui-form-element']") public static uiElement description;
    @Css("[id='p1']") public static uiElement forCalculateOne;
    @XPath(UIElementConstants.firstRowForCalculate + "//*[@id='p2']") public static uiElement forCalculateThree;
    @UI("['SubmitNotDisplayed']") public static uiElement submitNotDisplayed;
    @WithText("Result") public static uiElement result;
    public static uiElement smartLocator;
    @XPath("//a[@title='Tip title']") public static uiElement about;
    //Region locators with different another JDI annotations
    @ByText("Submit") @ClickArea(ElementArea.CENTER) public static uiElement submitClickArea;
    @Css("li[class='summ-res']") @GetTextAs(TEXT) @Root public static uiElement sumGetTextAs;
    @Css("textarea[class='uui-form-element']") @SetTextAs(SetTextTypes.SEND_KEYS) @NoCache public static uiElement descriptionSetTextAs;
    @UI("['SubmitNotDisplayed']") @NoWait @Name("HappyName") public static uiElement submitNotDisplayedNoWait;
    @Css("textarea[class='uui-form-element']") @WaitTimeout(100) public static uiElement descriptionWaitTimeout;
    @Css("li[class='summ-res']") @GetAny @GetVisible @GetVisibleEnabled public static uiElement sumGet;
    @ByText("Submit") @GetShowInView public static uiElement submitGetShowInView;
    @ByText("Submit") @PageName("Metal and Colors") public static uiElement submitPage; //as contact page is default set different page
    @Name("SId") @SId public static uiElement sId;
    @Name("SText") @SText public static uiElement sText;
    @Name("Smart") @Smart public static uiElement smart;
    @Name("Smart") @Smart("id") public static uiElement smartId;
    @Name("SClass") @SClass public static uiElement sClass;
    @UI public static uiElement uiNull;
    @FindBy(css="findBy") public static uiElement findBy;
    @FindBy public static uiElement findByNull;
    @VisualCheck public static uiElement visualCheck;
}

final class UIElementConstants {
    public static final String  firstRowForCalculate = "//*[@class='horizontal-group'][1]";
}