package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.CardExample;
import io.github.com.sections.Jumbotron;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;

    @Css("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("#jumbotron") public static Jumbotron jumbotron;

    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    //endregion

    //region Complex Elements
    @Css("#carouselExampleSlidesOnly") public static Carousel carouselSlidesOnly;
    @Css("#carouselExampleControls") public static Carousel carouselControls;
    @Css("#carouselExampleIndicators") public static Carousel carouselIndicators;
    @Css("#carouselExampleCaptions") public static Carousel carouselCaptions;
    @Css("#carouselExampleFade") public static Carousel carouselFade;
    @Css("#carouselExampleInterval") public static Carousel carouselInterval;
    @Css("#card-example") public static CardExample cardExample;

>>>>>>> 5926c91d93f79e2b59ebac3cd170b74eea5f161c
    //endregion
}