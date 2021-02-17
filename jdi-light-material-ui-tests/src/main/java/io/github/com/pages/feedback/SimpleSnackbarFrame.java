package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDISnackbar;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.material.elements.inputs.Button;

public class SimpleSnackbarFrame extends Section {

    @UI(".MuiButton-root")
    public Button openSnackbarButton;

    @JDISnackbar(root = ".MuiSnackbar-root",
            message = ".MuiSnackbarContent-message",
            action = ".MuiSnackbarContent-action")
    public Snackbar snackbar;

}
