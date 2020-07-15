package io.github.com.pages.sections;

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

    @UI("//*[contains(@id,'cdk-overlay')]//snack-bar-container//simple-snack-bar")
    public Section basicSnackbar;

    @UI("#snack-bar-custom-component-input")
    public TextField durationInput;

    @UI("#snack-bar-custom-component-button")
    public Button customSnackbarOpenButton;

    @UI("#snack-bar-custom-component")
    public Section customSnackbar;
}
