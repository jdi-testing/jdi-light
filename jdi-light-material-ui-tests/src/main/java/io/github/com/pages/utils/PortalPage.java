package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class PortalPage extends WebPage {
    @UI("//button")
    public static MaterialButton button;

    @UI("//button/following::div[1]")
    public static Text field1;

    @UI("//button/following::div[2]")
    public static Text field2;
}
