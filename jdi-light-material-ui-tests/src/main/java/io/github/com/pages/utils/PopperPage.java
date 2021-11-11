package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popper;

public class PopperPage extends WebPage {

    @UI("[role='tooltip']")
    public static Popper popper;

}
