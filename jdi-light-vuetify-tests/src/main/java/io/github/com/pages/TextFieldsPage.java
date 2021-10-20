package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;

public class TextFieldsPage extends VuetifyPage {

    @UI("#ClearableTextField .v-text-field")
    public static List<TextField> clearableTextField;
}
