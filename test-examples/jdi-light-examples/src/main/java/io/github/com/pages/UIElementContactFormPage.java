package io.github.com.pages;

import com.epam.jdi.light.common.ElementArea;
import com.epam.jdi.light.common.SetTextTypes;
import com.epam.jdi.light.elements.common.UIElement;
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
    @ByText("Submit") public static UIElement submit;
    @Css("li[class='summ-res']") public static UIElement sum;
    @Css("textarea[class='uui-form-element']") public static UIElement description;
    @Css("[id='p1']") public static UIElement forCalculateOne;
    @XPath(UIElementConstants.firstRowForCalculate + "//*[@id='p2']") public static UIElement forCalculateThree;
    @UI("['SubmitNotDisplayed']") public static UIElement submitNotDisplayed;
    @WithText("Result") public static UIElement result;
    public static UIElement smartLocator;
    @XPath("//a[@title='Tip title']") public static UIElement about;
    //Region locators with different another JDI annotations
    @ByText("Submit") @ClickArea(ElementArea.CENTER) public static UIElement submitClickArea;
    @Css("li[class='summ-res']") @GetTextAs(TEXT) @Root public static UIElement sumGetTextAs;
    @Css("textarea[class='uui-form-element']") @SetTextAs(SetTextTypes.SEND_KEYS) @NoCache public static UIElement descriptionSetTextAs;
    @UI("['SubmitNotDisplayed']") @NoWait @Name("HappyName") public static UIElement submitNotDisplayedNoWait;
    @Css("textarea[class='uui-form-element']") @WaitTimeout(100) public static UIElement descriptionWaitTimeout;
    @Css("li[class='summ-res']") @GetAny @GetVisible @GetVisibleEnabled public static UIElement sumGet;
    @ByText("Submit") @GetShowInView public static UIElement submitGetShowInView;
    @ByText("Submit") @PageName("Metal and Colors") public static UIElement submitPage; //as contact page is default set different page
    @Name("SId") @SId public static UIElement sId;
    @Name("SText") @SText public static UIElement sText;
    @Name("Smart") @Smart public static UIElement smart;
    @Name("Smart") @Smart("id") public static UIElement smartId;
    @Name("SClass") @SClass public static UIElement sClass;
    @UI public static UIElement uiNull;
    @FindBy(css="findBy") public static UIElement findBy;
    @FindBy public static UIElement findByNull;
    @VisualCheck public static UIElement visualCheck;
}

final class UIElementConstants {
    public static final String  firstRowForCalculate = "//*[@class='horizontal-group'][1]";
}