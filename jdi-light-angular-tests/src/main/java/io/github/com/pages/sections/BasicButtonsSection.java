package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class BasicButtonsSection extends Section {

    @UI("#basic-basic-button")
    public static Button basicBasicButton;

    @UI("#basic-primary-button")
    public static Button basicPrimaryButton;

    @UI("#basic-accent-button")
    public static Button basicAccentButton;

    @UI("#basic-warn-button")
    public static Button basicWarnButton;

    @UI("#basic-disabled-button")
    public static Button basicLinkButton;

    @UI("#basic-link-button")
    public static Button basicDisabledButton;

    @UI("#basic-buttons-label")
    public Label basicButtonsLabel;
}
