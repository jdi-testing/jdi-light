package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import io.github.com.sections.CardExample;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    //endregion

    //region Complex Elements
    @Css("#card-example") public static CardExample cardExample;

    //endregion

}