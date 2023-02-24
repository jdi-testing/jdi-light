package io.github.epam.vuetify.tests.complex;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.ElementArea.TOP_LEFT;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.carouselsPage;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_087;
import static io.github.com.enums.Colors.BLUE;
import static io.github.com.enums.Colors.INDIGO;
import static io.github.com.enums.MdiIcons.CIRCLE;
import static io.github.com.enums.MdiIcons.MINUS;
import static io.github.com.pages.CarouselsPage.customDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.customTransitionCarousel;
import static io.github.com.pages.CarouselsPage.cycleCarousel;
import static io.github.com.pages.CarouselsPage.hideDelimitersCarousel;
import static io.github.com.pages.CarouselsPage.modelCarousel;
import static io.github.com.pages.CarouselsPage.verticalCarousel;

public class CarouselsTests extends TestsInit {

    private static final String SQUIRREL_JPG = "https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg";
    private static final String SKY_JPG = "https://cdn.vuetifyjs.com/images/carousel/sky.jpg";
    private static final String PLANET_JPG = "https://cdn.vuetifyjs.com/images/carousel/planet.jpg";

    @BeforeClass
    public void beforeTest() {
        carouselsPage.open();
        waitCondition(() -> carouselsPage.isOpened());
        carouselsPage.checkOpened();
    }

    @Test(description = "Test checks carousel delimiters")
    public void delimitersCarouselTests() {
        customDelimitersCarousel.show();
        customDelimitersCarousel.delimiters().have().size(5);
        customDelimitersCarousel.getDelimitersIcons().forEach(icon -> icon.has().type(MINUS.mdi()));
        customTransitionCarousel.show();
        customTransitionCarousel.hover();
        customTransitionCarousel.delimiters().have().size(4);
        customTransitionCarousel.getDelimitersIcons().forEach(icon -> icon.has().type(CIRCLE.mdi()));
    }

    @Test(description = "Test checks carousel delimiters")
    public void changeSlideAndCheckTextCarouselTests() {
        String firstSlide = "First Slide";
        String secondSlide = "Second Slide";
        String thirdSlide = "Third Slide";
        customDelimitersCarousel.show();
        customDelimitersCarousel.has().contentText(firstSlide);

        customDelimitersCarousel.goToSlide(2);
        Timer.waitCondition(() -> !customDelimitersCarousel.getContentText().equals(firstSlide));
        customDelimitersCarousel.has().contentText(secondSlide);

        customDelimitersCarousel.goToSlide(3);
        Timer.waitCondition(() -> !customDelimitersCarousel.getContentText().equals(secondSlide));
        customDelimitersCarousel.has().contentText(thirdSlide);
    }

    @Test(description = "Test changes slide by buttons and checks image content")
    public void changeSlideByButtonsAndCheckImageContentCarouselTests() {
        customTransitionCarousel.show();
        customTransitionCarousel.nextButton().is().displayed();
        customTransitionCarousel.previousButton().is().displayed();
        Timer.waitCondition(() -> customTransitionCarousel.contentImage().sourcePath().equals(SQUIRREL_JPG));
        customTransitionCarousel.contentImage().has().sourcePath(SQUIRREL_JPG);
        customTransitionCarousel.nextButton().click();
        Timer.waitCondition(() -> customTransitionCarousel.contentImage().sourcePath().equals(SKY_JPG));
        customTransitionCarousel.contentImage().has().sourcePath(SKY_JPG);
        customTransitionCarousel.previousButton().click();
        Timer.waitCondition(() -> customTransitionCarousel.contentImage().sourcePath().equals(SQUIRREL_JPG));
        customTransitionCarousel.contentImage().has().sourcePath(SQUIRREL_JPG);
        customTransitionCarousel.goToSlide(4);
        Timer.waitCondition(() -> customTransitionCarousel.contentImage().sourcePath().equals(PLANET_JPG));
        customTransitionCarousel.contentImage().has().sourcePath(PLANET_JPG);
    }

    @Test(description = "Test checks that carousel buttons are visible only on hover")
    public void buttonsOnHoverCarouselTests() {
        cycleCarousel.show();
        cycleCarousel.is().showArrowsOnHover();
        hideDelimitersCarousel.show();
        hideDelimitersCarousel.is().notShowArrowsOnHover();
    }

    @Test(description = "Test checks carousel content color")
    public void contentColorCarouselTests() {
        cycleCarousel.show();
        cycleCarousel.goToSlide(1);
        cycleCarousel.has().backgroundColor(INDIGO.value())
                .and().color(BLACK_TRANSPARENT_087.value());
    }

    @Test(description = "Test checks slide counter value and content text")
    public void modelCarouselTests() {
        String slide1 = "Slide 1";
        String slide2 = "Slide 2";
        String slide3 = "Slide 3";
        String zero = "0";
        String one = "1";
        String two = "2";
        modelCarousel.show();
        modelCarousel.slideCounter().has().text(zero);
        modelCarousel.has().contentText(slide1);
        modelCarousel.goToSlide(2);
        Timer.waitCondition(() -> !modelCarousel.getContentText().equals(slide1));
        modelCarousel.slideCounter().has().text(one);
        modelCarousel.plusButton().click(TOP_LEFT);
        Timer.waitCondition(() -> !modelCarousel.getContentText().equals(slide2));
        modelCarousel.slideCounter().has().text(two);
        modelCarousel.has().contentText(slide3);
        modelCarousel.minusButton().click(TOP_LEFT);
        Timer.waitCondition(() -> !modelCarousel.getContentText().equals(slide3));
        modelCarousel.slideCounter().has().text(one);
        modelCarousel.has().contentText(slide2);
    }

    @Test(description = "Test checks if delimiters are hidden or not")
    public void delimitersHiddenTest() {
        customDelimitersCarousel.show();
        customDelimitersCarousel.has().delimitersHidden();
        customTransitionCarousel.show();
        customTransitionCarousel.has().notDelimitersHidden();
    }

    @Test(description = "Test checks carousel's theme")
    public void themeCarouselTest() {
        customDelimitersCarousel.show();
        customDelimitersCarousel.has().darkTheme();
    }

    @Test(description = "Test checks if")
    public void verticalDelimitersCarouselTest() {
        verticalCarousel.show();
        verticalCarousel.has().verticalDelimiters();
        customTransitionCarousel.show();
        customTransitionCarousel.has().horizontalDelimiters();
    }

    @Test(description = "Test checks if carousel has progress bar or not, checks progress bar characteristics")
    public void loadingCarouselTest() {
        verticalCarousel.show();
        verticalCarousel.is().loading().and().has().loaderHeightPx(4);
        verticalCarousel.progressBar().has().barColor(BLUE.value());
        customTransitionCarousel.show();
        customTransitionCarousel.is().loaded();
    }

    @Test(description = "Check carousel's measurements")
    public void heightCarouselTest() {
        verticalCarousel.show();
        verticalCarousel.has().heightGreaterThan(350)
                .and().heightLessThan(450)
                .and().height(400);
    }
}
