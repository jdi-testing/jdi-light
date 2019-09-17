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
    @Css("#carousel-example-slides-only") public static Carousel carouselSlidesOnly;
    @Css("#carousel-example-controls") public static Carousel carouselControls;
    @Css("#carousel-example-indicators") public static Carousel carouselIndicators;
    @Css("#carousel-example-captions") public static Carousel carouselCaptions;
    @Css("#carousel-example-fade") public static Carousel carouselFade;
    @Css("#carousel-example-interval") public static Carousel carouselInterval;
    @Css("#card-example") public static CardExample cardExample;
    //endregion
}