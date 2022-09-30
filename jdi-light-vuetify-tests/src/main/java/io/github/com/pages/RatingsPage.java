package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.elements.complex.sliders.Slider;
import com.epam.jdi.light.vuetify.elements.complex.Rating;

public class RatingsPage extends VuetifyPage {

    @JDIRating(root = "#ColorRating .v-rating:nth-child(1)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingPurple;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(2)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingPink;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(3)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingOrange;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(4)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingGreen;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(5)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingRed;

    @JDIRating(root = "#ColorRating .v-rating:nth-child(6)",
            fullIcon = ".mdi-star"
    )
    public static Rating colorRatingIndigo;

    @JDIRating(root = "#LengthRating .v-rating",
            fullIcon = ".mdi-star"
    )
    public static Rating lengthRating;

    @UI("#LengthRating .v-slider")
    public static Slider lengthRatingSlider;

    @JDIRating(root = "#IncrementedRating .v-rating",
            halfIcon = ".mdi-star-half-full",
            fullIcon = ".mdi-star.yellow--text"
    )
    public static Rating incrementedRating;

    @UI("#IncrementedRating")
    public static UIElement incrementedRatingCard;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(1)",
            fullIcon = ".mdi-star"
    )
    public static Rating sizeRatingPurple;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(2)",
            fullIcon = ".mdi-star"
    )
    public static Rating sizeRatingPink;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(3)",
            fullIcon = ".mdi-star"
    )
    public static Rating sizeRatingGreen;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(4)",
            fullIcon = ".mdi-star"
    )
    public static Rating sizeRatingRed;

    @JDIRating(root = "#SizeRating .v-rating:nth-child(5)",
            fullIcon = ".mdi-star"
    )
    public static Rating sizeRatingIndigo;

    @JDIRating(root = "#ItemSlotRating .v-rating",
            fullIcon = ".mdi-star-circle"
    )
    public static Rating itemSlotRating;

    @JDIRating(root = "#AdvancedUsageRating .v-rating")
    public static Rating advancedUsageRating;

    @JDIRating(root = "#CardRatingsRating .v-rating",
            halfIcon = ".mdi-star-half-full",
            fullIcon = ".mdi-star"
    )
    public static Rating cardRatingsRating;

    @UI("#CardRatingsRating")
    public static UIElement cardRatingsRatingCard;

    @UI("#CardRatingsRating span")
    public static UIElement cardRatingsRatingSpan;
}
