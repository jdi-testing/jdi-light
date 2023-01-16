package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.complex.Rating;
import io.github.com.dataproviders.RatingDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.ratingsPage;
import static io.github.com.pages.RatingsPage.advancedUsageRating;
import static io.github.com.pages.RatingsPage.cardRatingsRating;
import static io.github.com.pages.RatingsPage.clearableRating;
import static io.github.com.pages.RatingsPage.incrementedRating;
import static io.github.com.pages.RatingsPage.incrementedRatingCard;
import static io.github.com.pages.RatingsPage.itemSlotRating;
import static io.github.com.pages.RatingsPage.lengthRating;
import static io.github.com.pages.RatingsPage.lengthRatingSlider;

public class RatingsTests extends TestsInit {

    @BeforeClass
    public void before() {
        ratingsPage.open();
        waitCondition(() -> ratingsPage.isOpened());
        ratingsPage.checkOpened();
    }

    @Test(description = "Test checks rating's color", dataProvider = "colorRatingTestData", dataProviderClass = RatingDataProvider.class)
    public void colorRatingTest(String expectedColor, Rating rating) {
        for (int testedValue = 1; testedValue <= rating.length(); testedValue++) {
            rating.setValue(testedValue);
            rating.has().value(testedValue);
            rating.has().color(expectedColor);
        }
    }

    @Test(description = "Test checks rating's item color", dataProvider = "itemSlotRatingTestData", dataProviderClass = RatingDataProvider.class)
    public void itemColorRatingTest(int index, String expectedColor) {
        itemSlotRating.setValue(index);
        waitCondition(() -> itemSlotRating.color().equals(expectedColor));
        itemSlotRating.has().color(index, expectedColor);
    }

    @Test(description = "Test checks rating's length")
    public void lengthRatingTest() {
        IntStream.range(1, 15).forEach(index -> {
            lengthRatingSlider.slideHorizontalTo(Double.valueOf(index));
            waitCondition(() -> lengthRating.length() == index);
            lengthRating.has().length(index);
        });
    }

    @Test(description = "Test checks rating's value")
    public void valueRatingTest() {
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

    @Test(description = "Test checks rating's size", dataProvider = "sizeRatingTestData", dataProviderClass = RatingDataProvider.class)
    public void sizeRatingTest(int expectedSize, Rating rating) {
        rating.has().size(expectedSize);
    }

    @Test(description = "Test checks if rating is readonly or not")
    public void readonlyRatingTest() {
        advancedUsageRating.show();
        advancedUsageRating.is().readonly();
        cardRatingsRating.show();
        cardRatingsRating.is().notReadonly();
    }

    @Test(description = "Test checks if rating is dense or not : dense(y/n)")
    public void denseRatingTest() {
        cardRatingsRating.show();
        cardRatingsRating.is().dense();
        advancedUsageRating.show();
        advancedUsageRating.is().notDense();
    }

    @Test(description = "Test checks that rating is clearable : clearable")
    public void clearableRatingTest() {
        clearableRating.show();
        clearableRating.setValue(1);
        waitCondition(() -> clearableRating.getValue().equals(1.0));
        clearableRating.has().value(1);
        clearableRating.setValue(1);
        clearableRating.has().value(0);
    }

    @Test(description = "Test checks rating's theme : theme(dark/light)")
    public void themeRatingTest() {
        cardRatingsRating.show();
        cardRatingsRating.has().darkTheme();
        clearableRating.show();
        clearableRating.has().lightTheme();
    }
}
