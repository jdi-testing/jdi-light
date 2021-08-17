package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popper;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.util.List;

public class PopperPage extends WebPage {
    @UI("button")
    public static List<Button> buttons;

    @UI("[role='tooltip']")
    public static Popper popper;
}
