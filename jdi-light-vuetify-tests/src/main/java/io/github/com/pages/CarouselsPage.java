package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;

public class CarouselsPage extends VuetifyPage {

    @UI("#carousel-custom-delimiters")
    public static Carousel customDelimitersCarousel;

    @UI("#CustomTransitionCarousel")
    public static Carousel customTransitionCarousel;

    @UI("#CycleCarousel")
    public static Carousel cycleCarousel;

    @UI("#HideDelimitersCarousel")
    public static Carousel hideDelimitersCarousel;

    @UI("#ModelCarousel")
    public static Carousel modelCarousel;

    @UI("#VerticalCarousel")
    public static Carousel verticalCarousel;
}
