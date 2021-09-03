package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;

public class BackdropPage extends WebPage {

    @UI(".MuiButton-root")
    public static MaterialButton showBackdropButton;

    @UI(".MuiBackdrop-root")
    public static UIElement backdrop;

}
