package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.ratingsPage;
import static io.github.com.pages.RatingsPage.colorRating;

public class RatingTests extends TestsInit {

    @BeforeClass
    public void before() {
        ratingsPage.open();
        ratingsPage.checkOpened();
    }

    @Test
    public void colorRatingTest() {
        double rating = colorRating.getRating();
        double rating2 = colorRating.getRating();
    }
}
