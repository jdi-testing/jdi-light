package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import io.github.com.entities.InputsForm;

public class InputPage extends NewAngularPage {

    @UI("#inputs_basic_food")
    public static Input foodBasicInput;

    @UI("#inputs_basic_comment")
    public static Input leaveACommentBasicInput;

    @UI("#inputs_errorStateMatcher_email")
    public static Input emailErrorStateMatcherInput;

    @UI("#inputs_errorStateMatcher_message")
    public static Text errorStateMatcherMessage;

    @UI("#inputs_autosize_textarea")
    public static Input autoSizeTextArea;

    @UI("#inputs_clearable_textbox")
    public static Input inputWithClearButton;

    @UI("#inputs_clearable_button")
    public static Button clearButton;

    @UI("#inputs_error_email")
    public static Input inputErrorMail;

    @UI("#inputs_error_message")
    public static Text errorMessage;

    @UI("input-form-example form")
    public static InputsForm inputsForm;

    @UI("#inputs_hints_message")
    public static Input messageHintInput;

    @UI("#inputs_hints_text")
    public static Text hintMassage;

    @UI("#inputs_hints_counter")
    public static Text counterHintMassage;

    @UI("#inputs_prefixes")
    public static Text inputPrefix;

    @UI("#inputs_suffixes")
    public static Icon inputSuffix;

    @UI("#inputs_prefixes_suffixes_phone")
    public static Input telephoneInput;

    @UI("#mat-input-16")
    public static Input ariaLabelInput;

    @UI("#input-readonly-option")
    public static Input readonlyInput;
}
