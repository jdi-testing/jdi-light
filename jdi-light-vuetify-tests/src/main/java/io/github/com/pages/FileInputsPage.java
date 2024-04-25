package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDIFileInput;
import com.epam.jdi.light.vuetify.elements.complex.FileInput;

public class FileInputsPage extends VuetifyPage {
    @JDIFileInput(root = "#ChipsFileInput .v-file-input[1]")
    public static FileInput chipsFileInput;

    @JDIFileInput(root = "#ChipsFileInput .v-file-input[2]")
    public static FileInput smallChipsFileInput;

    @JDIFileInput(root = "#CounterFileInput .v-file-input")
    public static FileInput counterFileInput;

    @JDIFileInput(root = "#DenseFileInput.v-file-input")
    public static FileInput denseFileInput;

    @JDIFileInput(root = "#MultipleFileInput.v-file-input")
    public static FileInput multipleFileInput;

    @JDIFileInput(root = "#AppendPrependIconFileInput .v-file-input")
    public static FileInput prependIconFileInput;

    @JDIFileInput(root = "#AppendPrependIconFileInput .v-file-input:nth-child(2)")
    public static FileInput prependInnerIconFileInput;

    @JDIFileInput(root = "#AppendPrependIconFileInput .v-file-input:nth-child(3)")
    public static FileInput appendIconWithSuffixFileInput;

    @JDIFileInput(root = "#AppendPrependIconFileInput .v-file-input:nth-child(4)")
    public static FileInput appendOuterIconWithPrefixFileInput;

    @JDIFileInput(root = "#ShowSizeFileInput.v-file-input")
    public static FileInput showSizeFileInput;

    @JDIFileInput(root = "#ValidationFileInput.v-file-input")
    public static FileInput validationFileInput;

    @JDIFileInput(root = "#SelectionFileInput.v-file-input")
    public static FileInput selectionFileInput;

    @JDIFileInput(root = "#BackgroundColorFileInput")
    public static FileInput backgroundColorFileInput;

    @JDIFileInput(root = "#LoadingFileInput.v-file-input")
    public static FileInput loadingFileInput;

    @JDIFileInput(root = "#ErrorFileInput.v-file-input")
    public static FileInput errorFileInput;

    @JDIFileInput(root = "#SuccessFileInput.v-file-input")
    public static FileInput successFileInput;

    @JDIFileInput(root = "#FullWidthFileInput.v-file-input")
    public static FileInput fullWidthFileInput;

    @JDIFileInput(root = "#SoloFileInput.v-file-input")
    public static FileInput soloFileInput;

    @JDIFileInput(root = "#DisabledFileInput.v-file-input")
    public static FileInput disabledFileInput;
}
