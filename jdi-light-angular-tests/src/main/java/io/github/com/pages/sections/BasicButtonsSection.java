package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class BasicButtonsSection extends Section {

    public static Button basicBasicButton;
    public static Button basicPrimaryButton;
    public static Button basicAccentButton;
    public static Button basicWarnButton;
    public static Button basicLinkButton;
    public static Button basicDisabledButton;

    @UI("#basic-buttons-label")
    public Label basicButtonsLabel;

}
