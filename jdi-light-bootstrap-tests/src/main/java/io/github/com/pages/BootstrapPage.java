package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Alert;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;
    @Css("#simple_alert") public static Alert simpleAlert;
    @Css("#dismissible_alert") public static Alert dismissibleAlert;
    @Css(".close") public static Button alertButton;

    //endregion

    //region Complex Elements

    //endregion

}