package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.*;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.inputs.Buttons.CustomizedButton;
import com.epam.jdi.light.material.elements.inputs.Buttons.IconButton;
import com.epam.jdi.light.material.elements.inputs.Buttons.IconLabelButton;
import com.epam.jdi.light.material.elements.inputs.Buttons.TextButton;

public class ButtonFrame extends WebPage {

    @UI("p#simpleLastClick")
    public static Button checkContainedField;

    @UI("p#textLastClick")
    public static TextButton checkTextField;

    @UI("p#labeledLastClick")
    public static IconLabelButton checkIconLabelField;

    @UI("p#iconLastClick")
    public static IconButton checkIconField;

    @UI("p#customizedLastClick")
    public static CustomizedButton checkCustomizedField;

    @JDIContainedButtons(
            defaultButton = "//span[text()='Default']/parent::button[contains(@class,'MuiButton-contained')]",
            primaryButton = "//span[text()='Primary']/parent::button[contains(@class,'MuiButton-contained')]",
            secondaryButton = "//span[text()='Secondary']/parent::button[contains(@class,'MuiButton-contained')]",
            disabledButton = "//span[text()='Disabled']/parent::button[contains(@class,'MuiButton-contained')]",
            linkButton = "//span[text()='Link']/parent::a[contains(@class,'MuiButton-contained')]"
    )
    public static Button containedButton;

    @JDITextButtons(
            defaultButton = "//span[text()='Default']/parent::button[contains(@class,'MuiButton-text')]",
            primaryButton = "//span[text()='Primary']/parent::button[contains(@class,'MuiButton-text')]",
            secondaryButton = "//span[text()='Secondary']/parent::button[contains(@class,'MuiButton-text')]",
            disabledButton = "//span[text()='Disabled']/parent::button[contains(@class,'MuiButton-text')]",
            linkButton = "//span[text()='Link']/parent::a[contains(@class,'MuiButton-text')]"
    )
    public static TextButton textButton;

    @JDIIconLabelButtons(
            deleteButton = "//span[text()='Delete']/parent::button[contains(@class,'MuiButton-contained')]",
            deleteIcon = "//span[text()='Delete']/child::span[contains(@class,'MuiButton-iconSizeMedium')]",
            sendButton = "//span[text()='Send']/parent::button[contains(@class,'MuiButton-contained')]",
            sendIcon = "//span[text()='send']",
            uploadButton = "//span[text()='Upload']/parent::button[contains(@class,'MuiButton-contained')]",
            uploadIcon = "//span[text()='Upload']/child::span[contains(@class,'MuiButton-iconSizeMedium')]",
            talkButton = "//span[text()='Talk']/parent::button[contains(@class,'MuiButton-contained')]",
            talkIcon = "//span[text()='Talk']/child::span[contains(@class,'MuiButton-iconSizeMedium')]",
            saveButton = "//span[text()='Save']/parent::button[contains(@class,'MuiButton-contained')]",
            saveIcon = "//span[text()='Save']/child::span[contains(@class,'MuiButton-iconSizeSmall')]",
            saveAllButton = "//span[text()='Save all']/parent::button[contains(@class,'MuiButton-contained')]",
            saveAllIcon = "//span[text()='Save all']/child::span[contains(@class,'MuiButton-iconSizeLarge')]"
    )
    public static IconLabelButton iconLabelButton;

    @JDIIconButtons(
            deleteEnabledButton = "//button[contains(@class,'MuiIconButton-root')][1]",
            deleteEnabledIcon = "//button[contains(@class,'MuiIconButton-root')][1]/child::span[1]",
            deleteDisabledButton = "//button[contains(@class,'MuiIconButton-root')][2]",
            deleteDisabledIcon = "//button[contains(@class,'MuiIconButton-root')][1]/following::span[1]",
            alarmButton = "//button[contains(@aria-label,'add an alarm')]",
            alarmIcon = "//button[contains(@aria-label,'add an alarm')]/child::span[1]",
            shoppingCardButton = "//button[contains(@aria-label,'add to shopping cart')]",
            shoppingCardIcon = "//button[contains(@aria-label,'add to shopping cart')][1]/child::span[1]"
    )
    public static IconButton iconButton;

    @JDICustomizedButtons(
            customCSSButton = "//span[text()='Custom CSS']/parent::button[contains(@class,'MuiButton-contained')]",
            themeProviderButton = "//span[text()='Theme Provider']/parent::button[contains(@class,'MuiButton-contained')]",
            bootstrapButton = "//span[text()='Bootstrap']/parent::button[contains(@class,'MuiButton-contained')]"
    )
    public static CustomizedButton customizedButton;
}
