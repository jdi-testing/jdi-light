package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.elements.complex.Rating;
import com.epam.jdi.light.vuetify.elements.complex.Slider;

public class RatingsPage extends VuetifyPage {

    @JDIRating(root = "#ColorRating .v-rating:nth-child(1)")
    public static Rating colorRatingPurple;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(2)")
    public static Rating colorRatingPink;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(3)")
    public static Rating colorRatingOrange;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(4)")
    public static Rating colorRatingGreen;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(5)")
    public static Rating colorRatingRed;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(6)")
    public static Rating colorRatingIndigo;

    @JDIRating(root = "#LengthRating .v-rating")
    public static Rating lengthRating;

    @UI("#LengthRating .v-slider")
    public static Slider lengthRatingSlider;

    @JDIRating(root = "#IncrementedRating .v-rating",
            fullIcon = ".mdi-star.yellow--text"
    )
    public static Rating incrementedRating;

    @UI("#IncrementedRating")
    public static UIElement incrementedRatingCard;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(1)")
    public static Rating sizeRatingPurple;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(2)")
    public static Rating sizeRatingPink;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(3)")
    public static Rating sizeRatingGreen;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(4)")
    public static Rating sizeRatingRed;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(5)")
    public static Rating sizeRatingIndigo;

    @JDIRating(root = "#ItemSlotRating .v-rating",
            fullIcon = ".mdi-star-circle"
    )
    public static Rating itemSlotRating;

    @JDIRating(root = "#AdvancedUsageRating .v-rating")
    public static Rating advancedUsageRating;

    @JDIRating(root = "#CardRatingsRating .v-rating")
    public static Rating cardRatingsRating;

    @JDIRating(root = "//*[@id='ClearableRating']/following-sibling::div[contains(@class, 'v-rating')]")
    public static Rating clearableRating;
}
