package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIContainedButtons;
import com.epam.jdi.light.material.annotations.JDITextButtons;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.inputs.Buttons.TextButton;

public class ButtonFrame extends WebPage {

    @UI("p#simpleLastClick")
    public static Button checkContainedField;

    @UI("p#textLastClick")
    public static Button checkTextField;

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
}
