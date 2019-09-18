package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;

import io.github.com.sections.CardExample;
import io.github.com.sections.InputGroupInputWithCheckBox;
import io.github.com.sections.InputGroupInputWithRadio;
import io.github.com.sections.InputGroupInputWithText;
import io.github.com.sections.Jumbotron;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton, disabledButton;
    @Css("#jumbotron-fluid") public static Jumbotron jumbotronFluid;
    @Css("#jumbotron") public static Jumbotron jumbotron;
    //endregion

    //region Complex Elements
    @Css("#carousel-example-slides-only") public static Carousel carouselWithSlidesOnly;
    @Css("#carousel-example-controls") public static Carousel carouselWithControls;
    @Css("#carousel-example-indicators") public static Carousel carouselWithIndicators;
    @Css("#carousel-example-captions") public static Carousel carouselWithCaptions;
    @Css("#carousel-example-fade") public static Carousel carouselWithFadeTransition;
    @Css("#carousel-example-interval") public static Carousel carouselWithCustomInterval;
    //endregion
    
    //region Composite Elements
    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    @Css("#input-group-checkbox") public static InputGroupInputWithCheckBox inputGroupCheckBox;
    @Css("#input-group-radio") public static InputGroupInputWithRadio inputGroupRadio;
    @Css("#card-example") public static CardExample cardExample;
    //endregion
}