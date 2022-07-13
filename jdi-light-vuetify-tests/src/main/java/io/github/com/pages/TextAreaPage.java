package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;
import io.github.com.custom.forms.textareas.SignUpForm;

public class TextAreaPage extends VuetifyPage {

    @UI("#AutoGrowTextarea .v-textarea")
    public static TextArea autoGrowTextArea;

    @UI("#BackgroundColorTextarea .v-textarea[1]")
    public static TextArea blueTextArea;

    @UI("#BackgroundColorTextarea .v-textarea[2]")
    public static TextArea greenTextArea;

    @UI("#BackgroundColorTextarea .v-textarea[3]")
    public static TextArea yellowTextArea;

    @UI("#BrowserAutocompleteTextarea .v-textarea")
    public static TextArea autocompleteTextArea;

    @UI("#ClearableTextarea .v-textarea")
    public static TextArea clearableTextArea;

    @UI("#CounterTextarea .v-textarea")
    public static TextArea counterTextArea;

    @UI("#IconsTextarea .v-textarea[1]")
    public static TextArea prependOuterTextArea;

    @UI("#IconsTextarea .v-textarea[2]")
    public static TextArea appendInnerTextArea;

    @UI("#IconsTextarea .v-textarea[3]")
    public static TextArea prependInnerTextArea;

    @UI("#IconsTextarea .v-textarea[4]")
    public static TextArea appendOuterTextArea;

    @UI("#NoResizeTextarea .v-textarea")
    public static TextArea noResizeTextArea;

    @UI("#RowsTextarea .v-textarea[1]")
    public static TextArea oneRowTextArea;

    @UI("#RowsTextarea .v-textarea[2]")
    public static TextArea twoRowsTextArea;

    @UI("#RowsTextarea .v-textarea[3]")
    public static TextArea threeRowsTextArea;

    @UI("#RowsTextarea .v-textarea[4]")
    public static TextArea fourRowsTextArea;

    @UI("#SignupFormTextarea")
    public static SignUpForm signUpForm;
}
