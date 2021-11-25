package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.RadioButtons;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class RadioButtonsPage extends WebPage {

    @UI("#simpleRadio .MuiRadio-root")
    public static RadioButtons simpleRadioButtons;

    @UI("#lastClickContent")
    public static Text lastRadioText;

    @UI(".MuiFormControl-root[2] .MuiRadio-root")
    public static RadioButtons labelPlacementRadioButtons;

    @UI(".MuiFormControl-root[3] .MuiRadio-root")
    public static RadioButtons quizRadioButtons;

    @UI(".MuiFormControl-root[3] .MuiFormHelperText-root")
    public static Text quizText;

    @UI(".MuiFormControl-root[3] button")
    public static Button checkAnswer;
}
