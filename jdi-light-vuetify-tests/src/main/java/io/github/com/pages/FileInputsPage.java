package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;

public class FileInputsPage extends VuetifyPage {

    @UI("#AcceptFileInput.v-file-input")
    public static FileInput acceptFileInput;

    @UI("#CounterFileInput.v-file-input")
    public static FileInput counterFileInput;

}
