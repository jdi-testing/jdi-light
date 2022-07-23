package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.AspectRatios;

public class AspectRatiosPage extends VuetifyPage {

    @UI(".v-responsive")
    public static AspectRatios aspectRatiosContainer;
}
