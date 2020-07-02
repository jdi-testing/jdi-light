package io.github.com.pages.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class InputSection extends Section {

    @UI("#inputs_basic_food")
    public static TextField foodBasicInput;

    @UI("#inputs_basic_comment")
    public static TextField leaveACommentBasicInput;

    @UI("#inputs_errorStateMatcher_email")
    public static TextField emailErrorStateMatcherInput;

    @UI("#inputs_errorStateMatcher_message")
    public static Text errorStateMatcherMessageInput;

    @UI("#inputs_autosize_textarea")
    public static TextArea autoSizeTextArea;

    @UI("#inputs_clearable_textbox")
    public static TextArea clearableInput;

    @UI("#inputs_clearable_button")
    public static Button clearableInputButton;

    @UI("#inputs_error_email")
    public static TextField emailInput;

    @UI("#inputs_error_message")
    public static Text errorMessageInput;

    @UI("input-form-example form")
    public static InputsForm inputsForm;

    @UI("#inputs_hints_message")
    public static TextField messageHintInput;

    @UI("#inputs_hints_text")
    public static Text messageHint;

    @UI("#inputs_hints_counter")
    public static Text messageCounterHint;

    @UI("#inputs_prefixes")
    public static Text prefixInput;

    @UI("#inputs_suffixes")
    public static Icon suffixInput;

    @UI("#inputs_prefixes_suffixes_phone")
    public static TextField telephoneInput;
}
