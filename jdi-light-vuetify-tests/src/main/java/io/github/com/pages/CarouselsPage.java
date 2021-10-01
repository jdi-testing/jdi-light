package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Carousel;
import io.github.com.custom.ProfileCard;

public class CarouselsPage extends VuetifyPage {

    @UI("#CustomDelimitersCarousel")
    public static Carousel customDelimitersCarousel;

    @UI("#CustomTransitionCarousel")
    public static Carousel customTransitionCarousel;

    @UI("#CycleCarousel")
    public static Carousel cycleCarousel;

    @UI("#HideControlsCarousel")
    public static Carousel hideControlsCarousel;

    @UI("#CustomizedArrowsCarousel")
    public static Carousel customizedArrowsCarousel;

    @UI("#HideDelimitersCarousel")
    public static Carousel hideDelimitersCarousel;

    @UI("#ModelCarousel")
    public static Carousel modelCarousel;

    @UI("#CustomDelimitersCarousel .v-list-item")
    public static ProfileCard profileCard;

}
