package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;

public class FileInputsPage extends VuetifyPage {

    @UI("#AcceptFileInput.v-file-input")
    public static FileInput acceptFileInput;

    @UI("#ChipsFileInput .v-file-input[1]")
    public static FileInput chipsFileInput;

    @UI("#ChipsFileInput .v-file-input[2]")
    public static FileInput smallChipsFileInput;

    @UI("#CounterFileInput.v-file-input")
    public static FileInput counterFileInput;

    @UI("#DenseFileInput.v-file-input")
    public static FileInput denseFileInput;

    @UI("#MultipleFileInput.v-file-input")
    public static FileInput multiplyFileInput;

    @UI("#PrependIconFileInput.v-file-input")
    public static FileInput prependIconFileInput;

    @UI("#ShowSizeFileInput.v-file-input")
    public static FileInput showSizeFileInput;

    @UI("#ValidationFileInput.v-file-input")
    public static FileInput validationFileInput;

    @UI("#SelectionFileInput.v-file-input")
    public static FileInput selectionFileInput;

    @UI("#ComplexSelectionSlotFileInput.v-file-input")
    public static FileInput complexFileInput;
}
