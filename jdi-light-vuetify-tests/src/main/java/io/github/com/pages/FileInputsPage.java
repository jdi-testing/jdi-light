package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
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

    @JDIFileInput(root = "#CounterFileInput .v-file-input")
    public static FileInput counterFileInput;

    @JDIFileInput(root = "#DenseFileInput.v-file-input")
    public static FileInput denseFileInput;

    @JDIFileInput(root = "#MultipleFileInput.v-file-input")
    public static FileInput multipleFileInput;

    @JDIFileInput(root = "//*[@id='AppendPrependIconFileInput']/div[1]")
    public static FileInput prependIconFileInput;

    @JDIFileInput(root = "//*[@id='AppendPrependIconFileInput']/div[2]")
    public static FileInput prependInnerIconFileInput;

    @JDIFileInput(root = "//*[@id='AppendPrependIconFileInput']/div[3]")
    public static FileInput appendIconWithSuffixFileInput;

    @JDIFileInput(root = "//*[@id='AppendPrependIconFileInput']/div[4]")
    public static FileInput appendOuterIconWithPrefixFileInput;

    @JDIFileInput(root = "#ShowSizeFileInput.v-file-input")
    public static FileInput showSizeFileInput;

    @UI("//*[contains(text(), 'Validation file input')]")
    public static UIElement validationFileInputHeader;

    @JDIFileInput(root = "#ValidationFileInput.v-file-input")
    public static FileInput validationFileInput;

    @JDIFileInput(root = "#SelectionFileInput.v-file-input")
    public static FileInput selectionFileInput;

    @JDIFileInput(
            root = "#ComplexSelectionSlotFileInput.v-file-input",
            files = ".v-file-input__text > span"
    )
    public static FileInput complexFileInput;

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
