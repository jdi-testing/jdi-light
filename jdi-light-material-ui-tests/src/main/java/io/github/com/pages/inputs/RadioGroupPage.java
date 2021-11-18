package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.RadioGroup;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class RadioGroupPage extends WebPage {

    @UI("#simpleRadio [role='radiogroup']")
    public static RadioGroup simpleRadioGroup;

    @UI("#lastClickContent")
    public static Text lastRadioText;

    @UI(".MuiFormControl-root[2] [role='radiogroup']")
    public static RadioGroup labelPlacementRadioGroup;

    @UI(".MuiFormControl-root[3] [role='radiogroup']")
    public static RadioGroup quizRadioGroup;

    @UI(".MuiFormControl-root[3] .MuiFormHelperText-root")
    public static Text errorText;

    @UI(".MuiFormControl-root[3] button")
    public static Button checkAnswer;
}
