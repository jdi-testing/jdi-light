package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Backdrop;
import com.epam.jdi.light.material.elements.inputs.Button;

public class BackdropFrame extends Section {

    @UI(".MuiButton-root")
    public Button showBackdropButton;

    @UI(".MuiBackdrop-root")
    public Backdrop backdrop;

}
