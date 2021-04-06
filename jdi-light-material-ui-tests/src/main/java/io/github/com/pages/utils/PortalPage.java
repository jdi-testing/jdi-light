package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;

public class PortalPage extends WebPage {
    @UI("//button")
    public Button button;

    @UI("//button/following::div[1]")
    public UIElement field1;

    @UI("//button/following::div[2]")
    public UIElement field2;
}
