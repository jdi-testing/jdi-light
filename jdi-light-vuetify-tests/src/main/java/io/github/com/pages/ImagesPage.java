package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.Slider;

import java.util.List;

public class ImagesPage extends VuetifyPage {

    @UI("#AspectRatioImage .v-slider")
    public static Slider slider;

    @UI("#AspectRatioImage .v-image")
    public static Image aspectRatioImage;

    @UI("#ContainImage .v-image")
    public static List<Image> containImages;

    @UI("#GradientsImage .v-image")
    public static List<Image> gradientsImages;

    @UI("#HeightImage .v-image")
    public static List<Image> heightImages;

    @UI("#PlaceholderImage .v-image")
    public static Image placeholderImage;

    @UI("#GridImage .v-image")
    public static List<Image> gridImages;


}
