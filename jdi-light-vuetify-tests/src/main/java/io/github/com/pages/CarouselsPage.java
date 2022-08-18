package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import io.github.com.custom.CarouselContent;

public class CarouselsPage extends VuetifyPage {

    @UI("#CustomDelimitersCarousel")
    public static Carousel customDelimitersCarousel;

    @UI("#CustomDelimitersCarousel .v-window__container")
    public static CarouselContent customDelimitersCarouseContent;

    @UI("#CustomTransitionCarousel")
    public static Carousel customTransitionCarousel;

    @UI("#CustomTransitionCarousel .v-window__container")
    public static CarouselContent customTransitionCarouselContent;

    @UI("#CycleCarousel")
    public static Carousel cycleCarousel;

    @UI("#CycleCarousel .v-window__container")
    public static CarouselContent cycleCarouselContent;

    @UI("#HideControlsCarousel")
    public static Carousel hideControlsCarousel;

    @UI("#HideControlsCarousel .v-window__container")
    public static CarouselContent hideControlsCarouselContent;

    @UI("#CustomizedArrowsCarousel")
    public static Carousel customizedArrowsCarousel;

    @UI("#CustomizedArrowsCarousel .v-window__container")
    public static CarouselContent customizedArrowsCarouselContent;

    @UI("#HideDelimitersCarousel")
    public static Carousel hideDelimitersCarousel;

    @UI("#HideDelimitersCarousel .v-window__container")
    public static CarouselContent hideDelimitersCarouselContent;

    @UI("#ModelCarousel")
    public static Carousel modelCarousel;

    @UI("#ModelCarousel .v-window__container")
    public static CarouselContent modelCarouselContent;

}
