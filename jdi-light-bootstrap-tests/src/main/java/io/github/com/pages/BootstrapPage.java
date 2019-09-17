package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;
import io.github.com.sections.InputGroupInputWithText;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;
    @Css("#input-group-username") public static InputGroupInputWithText inputGroupUsername;
    //endregion

    //region Complex Elements
    @UI("#carouselExampleSlidesOnly") public static Carousel carouselSlidesOnly;
    @UI("#carouselExampleControls") public static Carousel carouselControls;
    @UI("#carouselExampleIndicators") public static Carousel carouselIndicators;
    @UI("#carouselExampleCaptions") public static Carousel carouselCaptions;
    @UI("#carouselExampleFade") public static Carousel carouselFade;
    @UI("#carouselExampleInterval") public static Carousel carouselInterval;
    //endregion

}