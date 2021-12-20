package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Portal;

public class PortalPage extends WebPage {

    @UI(".MuiBox-root")
    public static Portal portal;

}
