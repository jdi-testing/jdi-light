package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    //endregion

    //region Complex Elements

    //CardExample
    @Css("#bs-card-example-title") public static Text cardExampleTitle;
    @Css("#bs-card-example-text") public static Text cardExampleMainText;
    @Css("#bs-card-example-button") public static Button cardExampleButton;
    @Css("#bs-card-example-image") public static Image cardExampleImage;

    //endregion
    //endregion

}