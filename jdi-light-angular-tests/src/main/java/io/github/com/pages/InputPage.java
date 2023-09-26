package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Input;
import com.epam.jdi.light.angular.elements.common.TextArea;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.github.com.entities.InputsForm;

public class InputPage extends NewAngularPage {

    @UI("#inputs_basic_food")
    public static Input inputBasicFood;

    @UI("#inputs_basic_comment")
    public static TextArea textAreaBasicLeaveAComment;

    @UI("#inputs_errorStateMatcher_email")
    public static Input inputEmailErrorStateMatcher;

    @UI("#inputs_errorStateMatcher_message")
    public static Text messageErrorStateMatcher;

    @UI("#inputs_autosize_textarea")
    public static TextArea textAreaAutoSize;

    @UI("#inputs_clearable_textbox")
    public static Input inputWithClearButton;

    @UI("#inputs_clearable_button")
    public static Button buttonClear;

    @UI("#inputs_error_email")
    public static Input inputErrorMail;

    @UI("#inputs_error_message")
    public static Text messageError;

    @UI("input-form-example form")
    public static InputsForm inputsForm;

    @UI("#inputs_hints_message")
    public static Input inputWithMessageHint;

    @UI("#inputs_hints_text")
    public static Text messageHint;

    @UI("#inputs_hints_counter")
    public static Text messageHintCounter;

    @UI("#inputs_prefixes")
    public static Text prefixForInput;

    @UI("#inputs_suffixes")
    public static Icon suffixForInput;

    @UI("#inputs_prefixes_suffixes_phone")
    public static Input inputTelephone;

    @UI("#input-readonly-option")
    public static Input inputWithReadonly;
}
