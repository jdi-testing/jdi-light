package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextArea;

public class ClickAwayListenerPage extends WebPage {

    @UI("//h2[text()='Portal']/preceding::button")
    public static Button exampleButton;

    @UI("//h2[text()='Portal']/following::button")
    public static Button portalButton;

    @UI("//div[text()='Click me, I will stay visible until you click outside.']")
    public static TextArea text;
}
