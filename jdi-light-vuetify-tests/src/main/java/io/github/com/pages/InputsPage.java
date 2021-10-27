package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.common.Input;

public class InputsPage extends VuetifyPage {

    @UI("#ErrorCountInput2")
    public static Input fewErrorsCountInput;

    @UI("//form[@id='HideDetailsInput']/div[1]")
    public static Input hideDetailsMainInput;

    @UI("//form[@id='HideDetailsInput']/div[2]")
    public static Input hideDetailsAnotherInput;

    @UI(".v-input--switch")
    public static Input showMessagesInput;

    @UI("//div[@id='HintInput']/div[contains(@class, 'v-input')][2]")
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
}
