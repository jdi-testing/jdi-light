package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.material.elements.feedback.Backdrop;

public class BackdropPage extends WebPage {

    @UI(".MuiButton-root")
    public static MaterialButton showBackdropButton;

    @UI(".MuiBackdrop-root")
    public static Backdrop backdrop;

}
