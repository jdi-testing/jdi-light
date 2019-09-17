package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    @Css(".btn-group .btn-danger")
    public static Button redButtonGroup;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button greenButtonGroup;

    //public static Dropdown dropdownButtonGroup;

    //endregion

    //region Complex Elements

    //endregion

}