package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Autocomplete;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;

public class TextFieldsPage extends VuetifyPage {

    @UI("#CounterTextField .v-text-field")
    public static List<TextField> counterTextField;

    @UI("#ClearableTextField .v-text-field")
    public static List<TextField> clearableTextField;

    @UI("#CustomColorsTextField .v-text-field")
    public static List<TextField> customColorsTextField;

    @UI("#DenseTextField .v-text-field")
    public static List<TextField> denseTextField;

    @UI("#DisabledAndReadonlyTextField .col-sm-6:nth-child(odd) .v-text-field")
    public static List<TextField> disabledTextField;

    @UI("#DisabledAndReadonlyTextField .col-sm-6:nth-child(even) .v-text-field")
    public static List<TextField> readonlyTextField;

    @UI("#FilledTextField .v-text-field")
    public static List<TextField> filledTextField;

    @UI("#HideDetailsTextField .v-text-field")
    public static List<TextField> hideDetailsTextField;

    @UI("#HintTextField .col-sm-6:nth-child(odd) .v-text-field")
    public static List<TextField> hintTextField;

    @UI("#HintTextField .col-sm-6:nth-child(even) .v-text-field")
    public static List<TextField> visibleHintTextField;

    @UI("#IconsTextField .v-text-field")
    public static List<TextField> iconsTextField;

    @UI("#OutlinedTextField .v-text-field")
    public static List<TextField> outlinedTextField;

    @UI("#PrefixesAndSuffixesTextField .v-text-field")
    public static List<TextField> prefixesAndSuffixesTextField;

    @UI("#ShapedTextField .v-text-field")
    public static List<TextField> shapedTextField;

    @UI("#SingleLineTextField .v-text-field")
    public static List<TextField> singleLineTextField;

    @UI("#SoloTextField .v-text-field")
    public static List<TextField> soloTextField;

    @UI("#ValidationTextField .v-text-field")
    public static List<TextField> validationTextField;

    @UI("#IconEventsTextField .v-text-field")
    public static TextField iconEventsTextField;

    @UI("#IconSlotsTextField .v-text-field")
    public static TextField iconSlotsTextField;

    @UI("#LabelTextField .v-text-field")
    public static TextField labelTextField;

    @UI("#ProgressTextField .v-text-field")
    public static TextField progressTextField;

    // TODO: Implement ProgressTextField
    @UI("#ProgressTextField .v-text-field .v-progress-linear")
    public static UIElement progressTextFieldProgressbar;

    @UI("#CustomValidationTextField .v-text-field")
    public static List<TextField> customValidationTextField;
    @UI("#CustomValidationTextField .v-autocomplete")
    public static Autocomplete customValidationCountryField;
    @UI("//div[@id='CustomValidationTextField']//button[.='Cancel']")
    public static Button customValidationCancelBtn;
    @UI("//div[@id='CustomValidationTextField']//button[.='Submit']")
    public static Button customValidationSubmitBtn;

    @UI("#FullWidthWithCounterTextField .v-text-field")
    public static List<TextField> fullWidthWithCounterTextField;

    @UI("#PasswordInputTextField .v-text-field")
    public static List<TextField> passwordInputTextField;
}
