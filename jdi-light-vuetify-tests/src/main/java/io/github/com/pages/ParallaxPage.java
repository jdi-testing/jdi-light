package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.Parallax;

public class ParallaxPage extends VuetifyPage {

    @UI("#ContentParallax")
    public static Parallax contentParallax;

    @UI("#CustomHeightParallax")
    public static Parallax customHeightParallax;
}
