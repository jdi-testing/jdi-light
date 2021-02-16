package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIDialog;
import com.epam.jdi.light.material.elements.feedback.Dialog;
import com.epam.jdi.light.material.elements.inputs.Button;

public class DialogFrame extends Section {

    @JDIDialog(root = "#root")
    public Dialog dialog;

    @UI(".MuiButton-label")
    public Button button;

    @UI(".MuiButtonBase-root")
    public Button confirmButton;

}
