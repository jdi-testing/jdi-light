package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Carousel;

public class BootstrapPage extends WebPage {
    //region Simple Elements
    public static Button redButton, doubleButton;

    //endregion

    //region Complex Elements
    @UI("#carouselExampleSlidesOnly") public static Carousel carouselSlidesOnly;
    @UI("#carouselExampleControls") public static Carousel carouselControls;
    @UI("#carouselExampleIndicators") public static Carousel carouselIndicators;
    //endregion

}