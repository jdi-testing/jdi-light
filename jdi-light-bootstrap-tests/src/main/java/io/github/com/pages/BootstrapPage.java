package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Collapse;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    //endregion

    //region Complex Elements
    // COLLAPSE
    @UI("#bs-collapse-link") public static Collapse collapseLink;

    //endregion

}