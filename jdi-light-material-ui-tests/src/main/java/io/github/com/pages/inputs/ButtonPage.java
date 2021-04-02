package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.*;
import com.epam.jdi.light.material.elements.inputs.Button;

public class ButtonPage extends WebPage {

    @UI("p#simpleLastClick")
    public static Button checkContainedField;

    @UI("p#textLastClick")
    public static Button checkTextField;

    @UI("p#labeledLastClick")
    public static Button checkIconLabelField;

    @UI("p#iconLastClick")
    public static Button checkIconField;

    @UI("p#customizedLastClick")
    public static Button checkCustomizedField;

    @UI("p#complexLastClick")
    public static Button checkComplexField;

    @JDIButtons(
            containedButton = "//h2[text()='Contained buttons']/following::*[contains(@class,'MuiButtonBase-root')]",
            textButton = "//h2[text()='Text buttons']/following::*[contains(@class,'MuiButton-text')]",
            iconLabelButton = "//h2[text()='Buttons with icons and label']/following::button[contains(@class,'MuiButton-contained')]",
            iconLabelIcon = "//h2[text()='Buttons with icons and label']/following::span[contains(@class,'MuiButton-startIcon')]",
            iconLabelSpanIcon = "//h2[text()='Buttons with icons and label']/following::span[contains(@class,'MuiButton-endIcon')]",
            iconButton = "//button[contains(@class,'MuiIconButton-root')]",
            customizedButton = "//h2[text()='Customized buttons']/following::button[contains(@class,'MuiButton-contained')]",
            complexButton = "//h2[text()='Complex buttons']/following::button[contains(@class,'MuiButtonBase-root')]"
    )
    public static Button button;
}
