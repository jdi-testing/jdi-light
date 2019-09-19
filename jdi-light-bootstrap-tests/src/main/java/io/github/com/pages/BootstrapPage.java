package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.*;
import io.github.com.sections.buttongroup.DefaultButtonGroup;
import io.github.com.sections.buttongroup.SpecificButtonGroup;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;

    @Css("#button-group1")
    public static DefaultButtonGroup defaultButtonGroup;

    @Css("#button-group2")
    public static SpecificButtonGroup specificButtonGroup;

    @Css("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("#jumbotron") public static Jumbotron jumbotron;

    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    @Css("#input-group-checkbox") public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @Css("#input-group-radio") public static InputGroupInputWithRadio inputGroupRadio;
    //endregion

    //region Complex Elements
    @Css("#card-example") public static CardExample cardExample;

    //endregion
}