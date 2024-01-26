package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Rating;
import com.epam.jdi.light.vuetify.elements.complex.Slider;

public class RatingsPage extends VuetifyPage {

    @UI("#ColorRating .v-rating:nth-child(1)")
    public static Rating colorRatingPurple;

    @UI("#ColorRating .v-rating:nth-child(2)")
    public static Rating colorRatingPink;

    @UI("#ColorRating .v-rating:nth-child(3)")
    public static Rating colorRatingOrange;

    @UI("#ColorRating .v-rating:nth-child(4)")
    public static Rating colorRatingGreen;

    @UI("#ColorRating .v-rating:nth-child(5)")
    public static Rating colorRatingRed;

    @UI("#ColorRating .v-rating:nth-child(6)")
    public static Rating colorRatingIndigo;

    @UI("#LengthRating .v-rating")
    public static Rating lengthRating;

    @UI("#LengthRating .v-input__slider")
    public static Slider lengthRatingSlider;

    @JDIRating(root = "#IncrementedRating .v-rating",
            fullIcon = ".mdi-star.yellow--text"
    )
    public static Rating incrementedRating;

    @UI("#IncrementedRating")
    public static Card incrementedRatingCard;

    @UI("#SizeRating .v-rating:nth-child(1)")
    public static Rating sizeRatingPurple;

    @UI("#SizeRating .v-rating:nth-child(2)")
    public static Rating sizeRatingPink;

    @UI("#SizeRating .v-rating:nth-child(3)")
    public static Rating sizeRatingGreen;

    @UI("#SizeRating .v-rating:nth-child(4)")
    public static Rating sizeRatingRed;

    @UI("#SizeRating .v-rating:nth-child(5)")
    public static Rating sizeRatingIndigo;

    @JDIRating(root = "#ItemSlotRating .v-rating",
            fullIcon = ".mdi-star-circle"
    )
    public static Rating itemSlotRating;

    @UI("#AdvancedUsageRating .v-rating")
    public static Rating advancedUsageRating;

    @UI("#CardRatingsRating .v-rating")
    public static Rating cardRatingsRating;

    @UI("//*[@id='ClearableRating']/following-sibling::div[contains(@class, 'v-rating')]")
    public static Rating clearableRating;
}
