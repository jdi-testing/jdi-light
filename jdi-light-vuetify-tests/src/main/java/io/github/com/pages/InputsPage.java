package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Input;

public class InputsPage extends VuetifyPage {
    @UI("#ErrorCountInput1")
    public static Input disabledInput;

    @UI("#ErrorCountInput2")
    public static Input fewErrorsCountInput;

    @UI("#HideDetailsInput .v-input--hide-details")
    public static Input hideDetailsMainInput;

    @UI("#HideDetailsInput .v-input:nth-child(2)")
    public static Input hideDetailsAnotherInput;

    @UI(".v-input--switch")
    public static Input showMessagesInput;

    @UI("#HintInput .v-input:nth-child(2)")
    public static Input hintInput;

    @UI("//span[text()[contains(., 'Toggle loading')]]")
    public static Button toggleLoadingButton;

    @UI("#LoadingInput > .v-input")
    public static Input loadingInput;

    @UI("#RulesInput > .v-input")
    public static Input rulesInput;

    @UI("#SuccessInput")
    public static Input successInput;

    @UI("#SlotClicksInput .v-input")
    public static Input slotClicksInput;

    @UI("#AppendAndPrependInput")
    public static Input appendAndPrependInput;

    @UI("#readonlyInput .v-input")
    public static Input readonlyInput;

    @UI("#ValidateOnBlurInput .v-input")
    public static Input validateOnBlurInput;
}
