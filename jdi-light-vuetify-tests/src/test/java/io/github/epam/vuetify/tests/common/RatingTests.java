package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Rating;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.stream.IntStream;

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
        ratingsPage.checkOpened();
    }

    @Test
    public void colorRatingTest() {
        new HashMap<String, Rating>() {{
            put("purple", colorRatingPurple);
            put("pink", colorRatingPink);
            put("orange", colorRatingOrange);
            put("green", colorRatingGreen);
            put("red", colorRatingRed);
            put("indigo", colorRatingIndigo);
        }}
                .forEach((color, rating) -> {
                    double i = rating.getValue();
                    if (rating.getValue() > 1)
                        i -= 1;
                    else
                        i = rating.length();
                    rating.setValue(i);
                    rating.is().value(i);
                    rating.is().color(color);
                });
    }

    @Test
    public void lengthRatingTest() {
        IntStream.range(1, 15).forEach(index -> {
            lengthRatingSlider.slideHorizontalTo(index);
            lengthRating.is().length(index);
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

    @Test
    public void sizeRatingTest() {
        new HashMap<Integer, Rating>() {{
            put(16, sizeRatingPurple);
            put(24, sizeRatingPink);
            put(36, sizeRatingGreen);
            put(40, sizeRatingRed);
            put(64, sizeRatingIndigo);
        }}
                .forEach((size, rating) -> rating.is().size(size));
    }

    @Test
    public void itemSlotRatingTest() {
        new HashMap<Integer, String>() {{
            put(1, "green");
            put(2, "purple");
            put(3, "orange");
            put(4, "indigo");
            put(5, "red");
        }}
                .forEach((index, color) -> {
                    itemSlotRating.setValue(index);
                    itemSlotRating.is().color(index, color);
                });
    }

    @Test
    public void advancedUsageRatingTest() {
        advancedUsageRating.is().readonly();
    }

    @Test
    public void cardRatingsRatingTest() {
        cardRatingsRatingSpan.is().text("(4.3)");
        cardRatingsRating.setValue(0.5);
        cardRatingsRating.setValue(1);
        cardRatingsRatingSpan.is().text("(1)");

        cardRatingsRating.hoverSetValue(2);
        cardRatingsRating.is().value(2);
        cardRatingsRatingSpan.is().text("(1)");

        cardRatingsRatingCard.hover();
        cardRatingsRating.is().value(1);
    }
}
