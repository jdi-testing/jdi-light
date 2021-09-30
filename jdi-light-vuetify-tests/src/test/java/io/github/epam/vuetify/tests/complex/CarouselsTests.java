package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.carouselsPage;
import static io.github.com.pages.CarouselsPage.customDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.customTransitionCarousel;
import static io.github.com.pages.CarouselsPage.customizedArrowsCarousel;
import static io.github.com.pages.CarouselsPage.cycleCarousel;
import static io.github.com.pages.CarouselsPage.hideControlsCarousel;
import static io.github.com.pages.CarouselsPage.hideDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.modelCarousel;

public class CarouselsTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        carouselsPage.open();
    }

    @Test
    public void customDelimitersCarouselTests() {
        customDelimitersCarousel.is().displayed();
    }

    @Test
    public void customTransitionCarouselTests() {
        customTransitionCarousel.is().displayed();
    }

    @Test
    public void cycleCarouselTests() {
        cycleCarousel.is().displayed();
    }

    @Test
    public void hideControlsCarouselTests() {
        hideControlsCarousel.is().displayed();
    }

    @Test
    public void customizedArrowsCarouselTests() {
        customizedArrowsCarousel.is().displayed();
    }

    @Test
    public void hideDelimitersCarouselTests() {
        hideDelimitersCarousel.is().displayed();
    }

    @Test
    public void modelCarouselTests() {
        modelCarousel.is().displayed();
    }
}
