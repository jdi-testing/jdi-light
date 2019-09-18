package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.ButtonWithDropdown;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;
    @Css("#simple-alert") public static Alert simpleAlert;
    @Css("#dismissible-alert") public static Alert dismissibleAlert;
    @Css("#dismissible-alert-close-button") public static Alert alertButton;
    //endregion

    //region Complex Elements

    @Css("#button-with-dropdown") public static ButtonWithDropdown buttonWithDropdown;

    //endregion

}