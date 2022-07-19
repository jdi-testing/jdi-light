package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.carouselsPage;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.GREEN;
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
        customDelimitersCarousel.has().currentSlideText("First Slide");

        customDelimitersCarousel.goToSlide(3);
        customDelimitersCarousel.has().currentSlideText("Third Slide");
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
        customTransitionCarousel.currentSlideImage().has().sourcePath(SKY_JPG); //todo sourcePath gets the first img link only

        customTransitionCarousel.previousButton().click();
        customTransitionCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);

        customTransitionCarousel.goToSlide(4);
        customTransitionCarousel.currentSlideImage().has().sourcePath(PLANET_JPG);
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

        cycleCarousel.goToSlide(3);
        cycleCarousel.has().currentSlideText("Third Slide");

        cycleCarousel.nextButton().click();
        cycleCarousel.has().currentSlideText("Fourth Slide");

        cycleCarousel.previousButton().click();
        cycleCarousel.has().currentSlideText("Third Slide");

        cycleCarousel.waitUntilSlideChange("Fourth Slide");
        cycleCarousel.has().currentSlideText("Fourth Slide");
    }

    @Test
    public void hideControlsCarouselTests() {
        hideControlsCarousel.is().displayed();
        hideControlsCarousel.delimiters().have().size(4);
        hideControlsCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        hideControlsCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);

        hideControlsCarousel.goToSlide(2);
        hideControlsCarousel.currentSlideImage().has().sourcePath(SKY_JPG);
    }

    @Test
    public void customizedArrowsCarouselTests() {
        customizedArrowsCarousel.is().displayed();
        customizedArrowsCarousel.nextButton().is().notVisible();
        customizedArrowsCarousel.previousButton().is().notVisible();

        customizedArrowsCarousel.hover();
        customizedArrowsCarousel.previousButton().is().visible();
        customizedArrowsCarousel.previousButton().has().text("PREVIOUS SLIDE");
        customizedArrowsCarousel.previousButton().has().color(GREEN.value());

        customizedArrowsCarousel.nextButton().is().visible();
        customizedArrowsCarousel.nextButton().has().text("NEXT SLIDE");
        customizedArrowsCarousel.nextButton().has().color(BLUE.value());

        customizedArrowsCarousel.delimiters().have().size(5);
        customizedArrowsCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));

        customizedArrowsCarousel.goToSlide(1);
        customizedArrowsCarousel.has().currentSlideText("First Slide");

        customizedArrowsCarousel.nextButton().click();
        customizedArrowsCarousel.has().currentSlideText("Second Slide");

        customizedArrowsCarousel.previousButton().click();
        customizedArrowsCarousel.has().currentSlideText("First Slide");

        customizedArrowsCarousel.waitUntilSlideChange("Second Slide");
        customizedArrowsCarousel.has().currentSlideText("Second Slide");
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

        hideDelimitersCarousel.previousButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(SKY_JPG);

        hideDelimitersCarousel.previousButton().click();
        hideDelimitersCarousel.currentSlideImage().has().sourcePath(SQUIRREL_JPG);
    }

    @Test
    public void modelCarouselTests() {
        modelCarousel.is().displayed();
        modelCarousel.delimiters().have().size(5);
        modelCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        modelCarousel.slideCounter().has().text("0");
        modelCarousel.has().currentSlideText("Slide 1");

        modelCarousel.goToSlide(2);
        modelCarousel.slideCounter().has().text("1");
        modelCarousel.has().currentSlideText("Slide 2");

        modelCarousel.nextButton().click();
        modelCarousel.has().currentSlideText("Slide 3");

        modelCarousel.previousButton().click();
        modelCarousel.has().currentSlideText("Slide 2");

        modelCarousel.plusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideText("Slide 3");

        modelCarousel.minusButton().click(TOP_LEFT);
        modelCarousel.has().currentSlideText("Slide 2");
    }
}
