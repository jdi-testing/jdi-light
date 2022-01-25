package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.carouselsPage;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.GREY_DARKEN_3;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.Colors.ORANGE;
import static io.github.com.enums.Colors.ORANGE_DARKEN_1;
import static io.github.com.enums.Colors.PINK_DARKEN_2;
import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.RED_LIGHTEN_1;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.YELLOW_DARKEN_2;
import static io.github.com.enums.Colors.YELLOW_DARKEN_4;
import static io.github.com.pages.CarouselsPage.customDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.customTransitionCarousel;
import static io.github.com.pages.CarouselsPage.customizedArrowsCarousel;
import static io.github.com.pages.CarouselsPage.cycleCarousel;
import static io.github.com.pages.CarouselsPage.hideControlsCarousel;
import static io.github.com.pages.CarouselsPage.hideDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.modelCarousel;

public class CarouselsTests extends TestsInit {

    private static final String SQUIRREL_JPG = "https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg";
    private static final String SKY_JPG = "https://cdn.vuetifyjs.com/images/carousel/sky.jpg";
    private static final String BIRD_JPG = "https://cdn.vuetifyjs.com/images/carousel/bird.jpg";
    private static final String PLANET_JPG = "https://cdn.vuetifyjs.com/images/carousel/planet.jpg";

    @BeforeClass
    public void beforeTest() {
        carouselsPage.open();
        waitCondition(() -> carouselsPage.isOpened());
        carouselsPage.checkOpened();
    }

    @Test
    public void customDelimitersCarouselTests() {
        customDelimitersCarousel.is().displayed();
        customDelimitersCarousel.delimiters().have().size(5);
        customDelimitersCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-minus"));
        customDelimitersCarousel.has().currentSlideColor(GREEN.value());
        customDelimitersCarousel.has().currentSlideText("First Slide");
        customDelimitersCarousel.goToSlide(2);
        customDelimitersCarousel.has().currentSlideText("Second Slide");
        customDelimitersCarousel.has().currentSlideColor(GREY_DARKEN_3.value());
        customDelimitersCarousel.goToSlide(3);
        customDelimitersCarousel.has().currentSlideText("Third Slide");
        customDelimitersCarousel.has().currentSlideColor(YELLOW_DARKEN_4.value());
        customDelimitersCarousel.goToSlide(4);
        customDelimitersCarousel.has().currentSlideText("Fourth Slide");
        customDelimitersCarousel.has().currentSlideColor(RED_LIGHTEN_2.value());
        customDelimitersCarousel.goToSlide(5);
        customDelimitersCarousel.has().currentSlideText("Fifth Slide");
        customDelimitersCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
    }

    @Test
    public void customTransitionCarouselTests() {
        customTransitionCarousel.is().displayed();
        customTransitionCarousel.hover();
        customTransitionCarousel.delimiters().have().size(4);
        customTransitionCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        customTransitionCarousel.nextButton().is().displayed();
        customTransitionCarousel.previousButton().is().displayed();
        customTransitionCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        customTransitionCarousel.nextButton().click();
        customTransitionCarousel.currentSlideImage().has().sourcePath(SKY_JPG);
        customTransitionCarousel.previousButton().click();
        customTransitionCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        customTransitionCarousel.goToSlide(4);
        customTransitionCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
        customTransitionCarousel.nextButton().click();
        customTransitionCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        customTransitionCarousel.previousButton().click();
        customTransitionCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
        customTransitionCarousel.goToSlide(3);
        customTransitionCarousel.currentSlideImage().has().sourcePath(BIRD_JPG);
    }

    @Test
    public void cycleCarouselTests() {
        cycleCarousel.is().displayed();
        cycleCarousel.nextButton().is().notVisible();
        cycleCarousel.previousButton().is().notVisible();
        cycleCarousel.hover();
        cycleCarousel.nextButton().is().visible();
        cycleCarousel.previousButton().is().visible();
        cycleCarousel.delimiters().have().size(5);
        cycleCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        cycleCarousel.goToSlide(1);
        cycleCarousel.has().currentSlideColor(INDIGO.value());
        cycleCarousel.has().currentSlideText("First Slide");
        cycleCarousel.goToSlide(2);
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        cycleCarousel.nextButton().click();
        cycleCarousel.has().currentSlideText("Third Slide");
        cycleCarousel.has().currentSlideColor(PINK_DARKEN_2.value());
        cycleCarousel.previousButton().click();
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        cycleCarousel.goToSlide(5);
        cycleCarousel.has().currentSlideText("Fifth Slide");
        cycleCarousel.has().currentSlideColor(DEEP_PURPLE_ACCENT_4.value());
        cycleCarousel.goToSlide(4);
        cycleCarousel.has().currentSlideText("Fourth Slide");
        cycleCarousel.has().currentSlideColor(RED_LIGHTEN_1.value());
        cycleCarousel.goToSlide(1);
        cycleCarousel.has().currentSlideColor(INDIGO.value());
        cycleCarousel.has().currentSlideText("First Slide");
        cycleCarousel.waitUntilSlideChange("Second Slide", ORANGE_DARKEN_1.value());
        cycleCarousel.has().currentSlideText("Second Slide");
        cycleCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
    }

    @Test
    public void hideControlsCarouselTests() {
        hideControlsCarousel.is().displayed();
        hideControlsCarousel.delimiters().have().size(4);
        hideControlsCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        hideControlsCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        hideControlsCarousel.goToSlide(2);
        hideControlsCarousel.currentSlideImage().has().sourcePath(SKY_JPG);
        hideControlsCarousel.goToSlide(3);
        hideControlsCarousel.currentSlideImage().has().sourcePath(BIRD_JPG);
        hideControlsCarousel.goToSlide(4);
        hideControlsCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
    }

    @Test
    public void customizedArrowsCarouselTests() {
        customizedArrowsCarousel.is().displayed();
        customizedArrowsCarousel.nextButton().is().notVisible();
        customizedArrowsCarousel.previousButton().is().notVisible();
        customizedArrowsCarousel.hover();
        customizedArrowsCarousel.nextButton().is().visible();
        customizedArrowsCarousel.previousButton().is().visible();
        customizedArrowsCarousel.previousButton().has().text("PREVIOUS SLIDE");
        customizedArrowsCarousel.previousButton().has().color(GREEN.value());
        customizedArrowsCarousel.nextButton().has().text("NEXT SLIDE");
        customizedArrowsCarousel.nextButton().has().color(BLUE.value());
        customizedArrowsCarousel.delimiters().have().size(5);
        customizedArrowsCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        customizedArrowsCarousel.goToSlide(1);
        customizedArrowsCarousel.has().currentSlideColor(INDIGO.value());
        customizedArrowsCarousel.has().currentSlideText("First Slide");
        customizedArrowsCarousel.goToSlide(2);
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.nextButton().click();
        customizedArrowsCarousel.has().currentSlideText("Third Slide");
        customizedArrowsCarousel.has().currentSlideColor(PINK_DARKEN_2.value());
        customizedArrowsCarousel.previousButton().click();
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.goToSlide(5);
        customizedArrowsCarousel.has().currentSlideText("Fifth Slide");
        customizedArrowsCarousel.has().currentSlideColor(DEEP_PURPLE_ACCENT_4.value());
        customizedArrowsCarousel.goToSlide(4);
        customizedArrowsCarousel.has().currentSlideText("Fourth Slide");
        customizedArrowsCarousel.has().currentSlideColor(RED_LIGHTEN_1.value());
        customizedArrowsCarousel.goToSlide(1);
        customizedArrowsCarousel.has().currentSlideColor(INDIGO.value());
        customizedArrowsCarousel.has().currentSlideText("First Slide");
        customizedArrowsCarousel.waitUntilSlideChange("Second Slide", ORANGE_DARKEN_1.value());
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
        customizedArrowsCarousel.has().currentSlideColor(ORANGE_DARKEN_1.value());
    }

    @Test
    public void hideDelimitersCarouselTests() {
        hideDelimitersCarousel.is().displayed();
        hideDelimitersCarousel.delimiters().are().hidden();
        hideDelimitersCarousel.nextButton().is().displayed();
        hideDelimitersCarousel.previousButton().is().displayed();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        hideDelimitersCarousel.nextButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(SKY_JPG);
        hideDelimitersCarousel.nextButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(BIRD_JPG);
        hideDelimitersCarousel.nextButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
        hideDelimitersCarousel.nextButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
        hideDelimitersCarousel.previousButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
        hideDelimitersCarousel.previousButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(BIRD_JPG);
    }

    @Test
    public void modelCarouselTests() {
        modelCarousel.is().displayed();
        modelCarousel.delimiters().have().size(5);
        modelCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        modelCarousel.slideCounter().has().text("0");
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
        modelCarousel.goToSlide(2);
        modelCarousel.slideCounter().has().text("1");
        modelCarousel.has().currentSlideText("Slide 2");
        modelCarousel.has().currentSlideColor(GREY_DARKEN_3.value());
        modelCarousel.goToSlide(3);
        modelCarousel.slideCounter().has().text("2");
        modelCarousel.has().currentSlideText("Slide 3");
        modelCarousel.has().currentSlideColor(YELLOW_DARKEN_2.value());
        modelCarousel.goToSlide(4);
        modelCarousel.slideCounter().has().text("3");
        modelCarousel.has().currentSlideText("Slide 4");
        modelCarousel.has().currentSlideColor(RED.value());
        modelCarousel.goToSlide(5);
        modelCarousel.slideCounter().has().text("4");
        modelCarousel.has().currentSlideText("Slide 5");
        modelCarousel.has().currentSlideColor(ORANGE.value());
        modelCarousel.nextButton().click();
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
        modelCarousel.nextButton().click();
        modelCarousel.has().currentSlideText("Slide 2");
        modelCarousel.has().currentSlideColor(GREY_DARKEN_3.value());
        modelCarousel.previousButton().click();
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
        modelCarousel.previousButton().click();
        modelCarousel.has().currentSlideText("Slide 5");
        modelCarousel.has().currentSlideColor(ORANGE.value());
        modelCarousel.plusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
        modelCarousel.plusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideText("Slide 2");
        modelCarousel.has().currentSlideColor(GREY_DARKEN_3.value());
        modelCarousel.minusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
        modelCarousel.minusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideColor(BLUE_DARKEN_2.value());
        modelCarousel.has().currentSlideText("Slide 1");
    }
}
