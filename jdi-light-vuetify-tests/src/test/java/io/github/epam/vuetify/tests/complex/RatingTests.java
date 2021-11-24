package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.Rating;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.ratingsPage;
import static io.github.com.pages.RatingsPage.advancedUsageRating;
import static io.github.com.pages.RatingsPage.cardRatingsRating;
import static io.github.com.pages.RatingsPage.cardRatingsRatingCard;
import static io.github.com.pages.RatingsPage.cardRatingsRatingSpan;
import static io.github.com.pages.RatingsPage.colorRatingGreen;
import static io.github.com.pages.RatingsPage.colorRatingIndigo;
import static io.github.com.pages.RatingsPage.colorRatingOrange;
import static io.github.com.pages.RatingsPage.colorRatingPink;
import static io.github.com.pages.RatingsPage.colorRatingPurple;
import static io.github.com.pages.RatingsPage.colorRatingRed;
import static io.github.com.pages.RatingsPage.incrementedRating;
import static io.github.com.pages.RatingsPage.incrementedRatingCard;
import static io.github.com.pages.RatingsPage.itemSlotRating;
import static io.github.com.pages.RatingsPage.lengthRating;
import static io.github.com.pages.RatingsPage.lengthRatingSlider;
import static io.github.com.pages.RatingsPage.sizeRatingGreen;
import static io.github.com.pages.RatingsPage.sizeRatingIndigo;
import static io.github.com.pages.RatingsPage.sizeRatingPink;
import static io.github.com.pages.RatingsPage.sizeRatingPurple;
import static io.github.com.pages.RatingsPage.sizeRatingRed;

public class RatingTests extends TestsInit {

    @BeforeClass
    public void before() {
        ratingsPage.open();
        waitCondition(() -> ratingsPage.isOpened());
    }

    @DataProvider(name = "colorRatingTestData")
    public Object[][] colorRatingTestData() {
        return new Object[][] {
                {"purple", colorRatingPurple},
                {"pink", colorRatingPink},
                {"orange", colorRatingOrange},
                {"green", colorRatingGreen},
                {"red", colorRatingRed},
                {"indigo", colorRatingIndigo},
        };
    }

    @Test(dataProvider = "colorRatingTestData")
    public void colorRatingTest(String expectedColor, Rating rating) {
        for (int testedValue = 1; testedValue <= rating.length(); testedValue++) {
            rating.setValue(testedValue);
            rating.has().value(testedValue);
            rating.has().color(expectedColor);
        }
    }

    @Test
    public void lengthRatingTest() {
        IntStream.range(1, 15).forEach(index -> {
            lengthRatingSlider.slideHorizontalTo(index);
            lengthRating.has().length(index);
        });
    }

    @Test
    public void incrementedRatingTest() {
        incrementedRating.setValue(3);
        incrementedRating.is().value(3);
        incrementedRating.setValue(3.5);
        incrementedRating.is().value(3.5);

        incrementedRating.hoverSetValue(5);
        incrementedRating.is().value(5);
        incrementedRating.hoverSetValue(4.5);
        incrementedRating.is().value(4.5);
        incrementedRatingCard.hover();
        incrementedRating.is().value(3.5);
    }

    @DataProvider(name = "sizeRatingTestData")
    public Object[][] sizeRatingTestTestData() {
        return new Object[][] {
                {16, sizeRatingPurple},
                {24, sizeRatingPink},
                {36, sizeRatingGreen},
                {40, sizeRatingRed},
                {64, sizeRatingIndigo},
        };
    }

    @Test(dataProvider = "sizeRatingTestData")
    public void sizeRatingTest(int expectedSize, Rating rating) {
        rating.has().size(expectedSize);
    }

    @DataProvider(name = "itemSlotRatingTestData")
    public Object[][] itemSlotRatingTestData() {
        return new Object[][] {
                {1, "green"},
                {2, "purple"},
                {3, "orange"},
                {4, "indigo"},
                {5, "red"},
        };
    }

    @Test(dataProvider = "itemSlotRatingTestData")
    public void itemSlotRatingTest(int index, String expectedColor) {
        itemSlotRating.setValue(index);
        itemSlotRating.has().color(index, expectedColor);
    }

    @Test
    public void advancedUsageRatingTest() {
        advancedUsageRating.is().readonly();
    }

    @Test
    public void cardRatingsRatingTest() {
        cardRatingsRatingSpan.click();
        cardRatingsRating.setValue(0.5);
        cardRatingsRatingSpan.has().text("(0.5)");

        cardRatingsRating.hoverSetValue(2);
        cardRatingsRating.has().value(2);
        cardRatingsRatingSpan.has().text("(0.5)");

        cardRatingsRatingCard.hover();
        cardRatingsRating.has().value(0.5);
    }
}
