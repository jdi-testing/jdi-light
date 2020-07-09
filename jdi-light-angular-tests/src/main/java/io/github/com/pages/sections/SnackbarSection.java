package io.github.com.pages.sections;

import com.epam.jdi.angular.elements.common.Snackbar;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;


public class SnackbarSection {

    @UI("#snack-bar-message-input")
    public TextField messageInput;

    @UI("#snack-bar-action-input")
    public TextField actionInput;

    @UI("#snack-bar-open-button")
    public Button openButton;

    @UI("#basic-snack-bar")
    public Snackbar basicSnackbar;
}