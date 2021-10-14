package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Rating;
import com.epam.jdi.tools.pairs.Pairs;
import io.github.epam.TestsInit;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.epam.jdi.tools.pairs.*;
import static io.github.com.StaticSite.ratingsPage;
import static io.github.com.pages.RatingsPage.*;

public class RatingTests extends TestsInit {

    @BeforeClass
    public void before() {
        ratingsPage.open();
        ratingsPage.checkOpened();
    }

    @Test
    public void colorRatingTest() {
        new HashMap<String, Rating>() {{put("purple", colorRatingPurple); put("pink", colorRatingPink); put("orange", colorRatingOrange); put("green", colorRatingGreen); put("red", colorRatingRed); put("indigo", colorRatingIndigo);}}
                .forEach((color, rating) -> {
                    double i = rating.getValue();
                    if(rating.getValue() > 1)
                        i -= 1;
                    else
                        i = rating.length();
                    rating.setValue(i);
                    rating.is().value(i);
                    rating.is().color(color);
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
        new HashMap<Integer, Rating>() {{put(16, sizeRatingPurple); put(24, sizeRatingPink); put(36, sizeRatingGreen); put(40, sizeRatingRed); put(64, sizeRatingIndigo);}}
                .forEach((size, rating) -> rating.is().size(size));
    }

    @Test
    public void itemSlotRatingTest() {
        new HashMap<Integer, String>() {{put(1, "green"); put(2, "purple"); put(3, "orange"); put(4, "indigo"); put(5, "red");}}
                .forEach((index, color) -> {
                    itemSlotRating.setValue(index);
                    itemSlotRating.is().color(index, color);
                });
    }

    @Test
    public void cardRatingsRatingTest() {
        cardRatingsRatingSpan.is().text("(4.3)");
        cardRatingsRating.setValue(1);

        cardRatingsRatingSpan.is().text("(1.0)");
//
//        cardRatingsRating.setValue(3);
//
//        cardRatingsRating.setValue(2);
//
//        cardRatingsRating.setValue(0.5);
        cardRatingsRating.is().value(1);
//
//        cardRatingsRatingSpan.is().text("(0.5)");

//        cardRatingsRating.hoverSetValue(2);
//        cardRatingsRating.is().value(2);
//        cardRatingsRatingCard.hover();
//        cardRatingsRating.is().value(0.5);
    }
}
