package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREY_DARKEN_3;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE_DARKEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PINK_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_1;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.YELLOW_DARKEN_4;
import static io.github.com.StaticSite.carouselsPage;
import static io.github.com.pages.CarouselsPage.customDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.customTransitionCarousel;
import static io.github.com.pages.CarouselsPage.customizedArrowsCarousel;
import static io.github.com.pages.CarouselsPage.cycleCarousel;
import static io.github.com.pages.CarouselsPage.hideControlsCarousel;
import static io.github.com.pages.CarouselsPage.hideDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.modelCarousel;
import static io.github.com.pages.CarouselsPage.profileCard;

public class CarouselsTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        carouselsPage.open();
    }

    @Test
    public void customDelimitersCarouselTests() {
        customDelimitersCarousel.is().displayed();
        customDelimitersCarousel.has().numberOfDelimiters(5);
        customDelimitersCarousel.has().delimiterIcons("mdi-minus");
        customDelimitersCarousel.has().currentSlideColor(GREEN.value());
        customDelimitersCarousel.has().currentSlideText("First Slide");
        customDelimitersCarousel.getDelimiters().get(2).click();
        customDelimitersCarousel.has().currentSlideText("Second Slide");
        customDelimitersCarousel.has().currentSlideColor(GREY_DARKEN_3.value());
        customDelimitersCarousel.getDelimiters().get(3).click();
        customDelimitersCarousel.has().currentSlideText("Third Slide");
        customDelimitersCarousel.has().currentSlideColor(YELLOW_DARKEN_4.value());
        customDelimitersCarousel.getDelimiters().get(4).click();
        customDelimitersCarousel.has().currentSlideText("Fourth Slide");
        customDelimitersCarousel.has().currentSlideColor(RED_LIGHTEN_2.value());
        customDelimitersCarousel.getDelimiters().get(5).click();
        customDelimitersCarousel.has().currentSlideText("Fifth Slide");
        customDelimitersCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        profileCard.is().displayed();
        profileCard.has().backgroundImage();
        profileCard.has().properName("John Leider");
        profileCard.has().properJobFunction("Author");
        customDelimitersCarousel.has().toggle();
        customDelimitersCarousel.has().toggleUnchecked();
        customDelimitersCarousel.getToggle().click();
        customDelimitersCarousel.has().toggleChecked();
        customDelimitersCarousel.getToggle().click();
        customDelimitersCarousel.has().toggleUnchecked();
    }

    @Test
    public void customTransitionCarouselTests() {
        customTransitionCarousel.is().displayed();
        customTransitionCarousel.has().numberOfDelimiters(4);
        customTransitionCarousel.has().delimiterIcons("mdi-circle");
        customTransitionCarousel.has().nextButtonVisible();
        customTransitionCarousel.has().previousButtonVisible();
        customTransitionCarousel.has().currentSlideImage("squirrel");
        customTransitionCarousel.getNextButton().click();
        customTransitionCarousel.has().currentSlideImage("sky");
        customTransitionCarousel.getPreviousButton().click();
        customTransitionCarousel.has().currentSlideImage("squirrel");
        customTransitionCarousel.getDelimiters().get(4).click();
        customTransitionCarousel.has().currentSlideImage("planet");
        customTransitionCarousel.getNextButton().click();
        customTransitionCarousel.has().currentSlideImage("squirrel");
        customTransitionCarousel.getPreviousButton().click();
        customTransitionCarousel.has().currentSlideImage("planet");
        customTransitionCarousel.getDelimiters().get(3).click();
        customTransitionCarousel.has().currentSlideImage("bird");
    }

    @Test
    public void cycleCarouselTests() {
        cycleCarousel.is().displayed();
        cycleCarousel.has().previousButtonHidden();
        cycleCarousel.has().nextButtonHidden();
        cycleCarousel.hover();
        cycleCarousel.has().previousButtonVisible();
        cycleCarousel.has().nextButtonVisible();
        cycleCarousel.has().numberOfDelimiters(5);
        cycleCarousel.has().delimiterIcons("mdi-circle");
        cycleCarousel.getDelimiters().get(1).click();
        cycleCarousel.has().currentSlideColor(INDIGO.value());
        cycleCarousel.has().currentSlideText("First Slide");
        cycleCarousel.getDelimiters().get(2).click();
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        cycleCarousel.getNextButton().click();
        cycleCarousel.has().currentSlideText("Third Slide");
        cycleCarousel.has().currentSlideColor(PINK_DARKEN_2.value());
        cycleCarousel.getPreviousButton().click();
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        cycleCarousel.getDelimiters().get(5).click();
        cycleCarousel.has().currentSlideText("Fifth Slide");
        cycleCarousel.has().currentSlideColor(DEEP_PURPLE_ACCENT_4.value());
        cycleCarousel.getDelimiters().get(4).click();
        cycleCarousel.has().currentSlideText("Fourth Slide");
        cycleCarousel.has().currentSlideColor(RED_LIGHTEN_1.value());
        cycleCarousel.getDelimiters().get(1).click();
        cycleCarousel.has().currentSlideColor(INDIGO.value());
        cycleCarousel.has().currentSlideText("First Slide");
        cycleCarousel.waitUntilSlideAutomaticallyChangeTo("Second Slide", ORANGE_DARKEN_1.value());
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
    }

    @Test
    public void hideControlsCarouselTests() {
        hideControlsCarousel.is().displayed();
        hideControlsCarousel.has().numberOfDelimiters(4);
        hideControlsCarousel.has().delimiterIcons("mdi-circle");
        hideControlsCarousel.has().nextButtonHidden();
        hideControlsCarousel.has().previousButtonHidden();
        hideControlsCarousel.has().currentSlideImage("squirrel");
        hideControlsCarousel.getDelimiters().get(2).click();
        hideControlsCarousel.has().currentSlideImage("sky");
        hideControlsCarousel.getDelimiters().get(3).click();
        hideControlsCarousel.has().currentSlideImage("bird");
        hideControlsCarousel.getDelimiters().get(4).click();
        hideControlsCarousel.has().currentSlideImage("planet");
    }

    @Test
    public void customizedArrowsCarouselTests() {
        customizedArrowsCarousel.is().displayed();
        customizedArrowsCarousel.has().previousButtonHidden();
        customizedArrowsCarousel.has().nextButtonHidden();
        customizedArrowsCarousel.hover();
        customizedArrowsCarousel.has().previousButtonVisible();
        customizedArrowsCarousel.has().nextButtonVisible();
        //TODO: add checking of custom text
        customizedArrowsCarousel.has().numberOfDelimiters(5);
        customizedArrowsCarousel.has().delimiterIcons("mdi-circle");
        customizedArrowsCarousel.getDelimiters().get(1).click();
        customizedArrowsCarousel.has().currentSlideColor(INDIGO.value());
        customizedArrowsCarousel.has().currentSlideText("First Slide");
        customizedArrowsCarousel.getDelimiters().get(2).click();
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.getNextButton().click();
        customizedArrowsCarousel.has().currentSlideText("Third Slide");
        customizedArrowsCarousel.has().currentSlideColor(PINK_DARKEN_2.value());
        customizedArrowsCarousel.getPreviousButton().click();
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.getDelimiters().get(5).click();
        customizedArrowsCarousel.has().currentSlideText("Fifth Slide");
        customizedArrowsCarousel.has().currentSlideColor(DEEP_PURPLE_ACCENT_4.value());
        customizedArrowsCarousel.getDelimiters().get(4).click();
        customizedArrowsCarousel.has().currentSlideText("Fourth Slide");
        customizedArrowsCarousel.has().currentSlideColor(RED_LIGHTEN_1.value());
        customizedArrowsCarousel.getDelimiters().get(1).click();
        customizedArrowsCarousel.has().currentSlideColor(INDIGO.value());
        customizedArrowsCarousel.has().currentSlideText("First Slide");
        customizedArrowsCarousel.waitUntilSlideAutomaticallyChangeTo("Second Slide", ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());

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
