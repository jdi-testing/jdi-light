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
import static io.github.com.pages.CarouselsPage.customDelimitersCarouseContent;
import static io.github.com.pages.CarouselsPage.customTransitionCarouselContent;
import static io.github.com.pages.CarouselsPage.customizedArrowsCarouselContent;
import static io.github.com.pages.CarouselsPage.cycleCarouselContent;
import static io.github.com.pages.CarouselsPage.hideControlsCarouselContent;
import static io.github.com.pages.CarouselsPage.hideDelimitersCarouselContent;
import static io.github.com.pages.CarouselsPage.modelCarouselContent;

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
        customDelimitersCarouseContent.has().text("First Slide");

        customDelimitersCarousel.goToSlide(2);
        customDelimitersCarouseContent.has().text("Second Slide");

        customDelimitersCarousel.goToSlide(3);
        customDelimitersCarouseContent.has().text("Third Slide");
    }

    @Test
    public void customTransitionCarouselTests() {
        customTransitionCarousel.is().displayed();
        customTransitionCarousel.hover();
        customTransitionCarousel.delimiters().have().size(4);
        customTransitionCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));

        customTransitionCarousel.nextButton().is().displayed();
        customTransitionCarousel.previousButton().is().displayed();
        customTransitionCarouselContent.contentImage().has().sourcePath(SQUIRREL_JPG);

        customTransitionCarousel.nextButton().click();
        customTransitionCarouselContent.contentImage().has().sourcePath(SKY_JPG);

        customTransitionCarousel.previousButton().click();
        customTransitionCarouselContent.contentImage().has().sourcePath(SQUIRREL_JPG);

        customTransitionCarousel.goToSlide(4);
        customTransitionCarouselContent.contentImage().has().sourcePath(PLANET_JPG);
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
        cycleCarouselContent.has().text("Third Slide");

        cycleCarousel.nextButton().click();
        cycleCarouselContent.has().text("Fourth Slide");

        cycleCarousel.previousButton().click();
        cycleCarouselContent.has().text("Third Slide");
    }

    @Test
    public void hideControlsCarouselTests() {
        hideControlsCarousel.is().displayed();
        hideControlsCarousel.delimiters().have().size(4);
        hideControlsCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        hideControlsCarouselContent.contentImage().has().sourcePath(SQUIRREL_JPG);

        hideControlsCarousel.goToSlide(2);
        hideControlsCarouselContent.contentImage().has().sourcePath(SKY_JPG);
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
        customizedArrowsCarouselContent.has().text("First Slide");


        customizedArrowsCarousel.nextButton().click();
        customizedArrowsCarouselContent.has().text("Second Slide");

        customizedArrowsCarousel.previousButton().click();
        customizedArrowsCarouselContent.has().text("First Slide");
    }

    @Test
    public void hideDelimitersCarouselTests() {
        hideDelimitersCarousel.is().displayed();
        hideDelimitersCarousel.delimiters().are().hidden();
        hideDelimitersCarousel.nextButton().is().displayed();
        hideDelimitersCarousel.previousButton().is().displayed();
        hideDelimitersCarousel.goToSlide(1);
        hideDelimitersCarouselContent.contentImage().has().sourcePath(SQUIRREL_JPG);

        hideDelimitersCarousel.goToSlide(3);
        hideDelimitersCarouselContent.contentImage().has().sourcePath(BIRD_JPG);
    }

    @Test
    public void modelCarouselTests() {
        modelCarousel.is().displayed();
        modelCarousel.delimiters().have().size(5);
        modelCarousel.getDelimitersIcons().forEach(icon -> icon.has().type("mdi-circle"));
        modelCarousel.slideCounter().has().text("0");
        modelCarouselContent.has().text("Slide 1");

        modelCarousel.goToSlide(2);
        modelCarousel.slideCounter().has().text("1");
        modelCarouselContent.has().text("Slide 2");

        modelCarousel.nextButton().click();
        modelCarouselContent.has().text("Slide 3");

        modelCarousel.previousButton().click();
        modelCarouselContent.has().text("Slide 2");

        modelCarousel.plusButton().click(TOP_LEFT);
        modelCarouselContent.has().text("Slide 3");

        modelCarousel.minusButton().click(TOP_LEFT);
        modelCarouselContent.has().text("Slide 2");
    }
}
