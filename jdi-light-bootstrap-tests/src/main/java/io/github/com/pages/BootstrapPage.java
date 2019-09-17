package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import io.github.com.sections.CardExample;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.Jumbotron;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;

    @Css(".btn-group .btn-danger")
    public static Button redButtonGroup;

    @Css(".btn-group .btn-success:not(.dropdown-toggle)")
    public static Button greenButtonGroup;

    @Css("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("#jumbotron") public static Jumbotron jumbotron;

    //public static Dropdown dropdownButtonGroup;
    
    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    //endregion

    //region Complex Elements
    @Css("#card-example") public static CardExample cardExample;

    //endregion
}