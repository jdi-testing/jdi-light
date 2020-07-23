package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Snackbar;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class SnackbarSection extends Section {

    @UI("#snack-bar-message-input")
    public TextField messageInput;

    @UI("#snack-bar-action-input")
    public TextField actionInput;

    @UI("#snack-bar-open-button")
    public Button openButton;

    @UI("//simple-snack-bar")
    public Snackbar basicSnackbar;

    @UI("#snack-bar-custom-component-input")
    public TextField durationInput;

    @UI("#snack-bar-custom-component-button")
    public Button customSnackbarOpenButton;

    @UI("#snack-bar-custom-component")
    public Snackbar customSnackbar;
}
