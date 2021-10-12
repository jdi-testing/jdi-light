package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDIRating;
import com.epam.jdi.light.vuetify.elements.common.Rating;

import java.util.List;

public class RatingsPage extends VuetifyPage {

    @JDIRating(root = "#ColorRating .v-rating",
            emptyIcon = ".mdi-star-outline",
            fullIcon =  ".mdi-star"
    )
    public static Rating colorRating;
}
