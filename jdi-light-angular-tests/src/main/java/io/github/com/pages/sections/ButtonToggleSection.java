package io.github.com.pages.sections;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ButtonToggleSection {
    @UI("#bold-button-toggle-button")
    public Button basicButtonToggleBold;

    @UI("#italic-button-toggle-button")
    public Button basicButtonToggleItalic;

    @UI("#underline-button-toggle-button")
    public Button basicButtonToggleUnderline;

    @UI("#left-align-button-toggle-button")
    public Button exclusiveButtonToggleLeft;

    @UI("#center-align-button-toggle-button")
    public Button exclusiveButtonToggleCenter;

    @UI("#right-align-button-toggle-button")
    public Button exclusiveButtonToggleRight;

    @UI("#justify-align-button-toggle-button")
    public Button exclusiveButtonToggleJustify;

    @UI("div.example-selected-value")
    public Text selectedValue;
}
