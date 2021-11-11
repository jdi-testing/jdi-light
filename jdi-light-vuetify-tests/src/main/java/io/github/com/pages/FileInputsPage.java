package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDIFileInput;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;

public class FileInputsPage extends VuetifyPage {

    @JDIFileInput(root = "#AcceptFileInput.v-file-input")
    public static FileInput acceptFileInput;

    @JDIFileInput(root = "#ChipsFileInput .v-file-input[1]")
    public static FileInput chipsFileInput;

    @JDIFileInput(root = "#ChipsFileInput .v-file-input[2]")
    public static FileInput smallChipsFileInput;

    @JDIFileInput(root = "#CounterFileInput.v-file-input")
    public static FileInput counterFileInput;

    @JDIFileInput(root = "#DenseFileInput.v-file-input")
    public static FileInput denseFileInput;

    @JDIFileInput(root = "#MultipleFileInput.v-file-input")
    public static FileInput multiplyFileInput;

    @JDIFileInput(root = "#PrependIconFileInput.v-file-input")
    public static FileInput prependIconFileInput;

    @JDIFileInput(root = "#ShowSizeFileInput.v-file-input")
    public static FileInput showSizeFileInput;

    @JDIFileInput(root = "#ValidationFileInput.v-file-input")
    public static FileInput validationFileInput;

    @JDIFileInput(root = "#SelectionFileInput.v-file-input")
    public static FileInput selectionFileInput;

    @JDIFileInput(
            root = "#ComplexSelectionSlotFileInput.v-file-input",
            files = ".v-file-input__text > span"
    )
    public static FileInput complexFileInput;
}
