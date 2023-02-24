package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.WithText;
import com.epam.jdi.light.vuetify.elements.common.Image;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.Text;

public class ImagesPage extends VuetifyPage {

    @UI("#AspectRatioImage .v-slider")
    public static Slider slider;

    @WithText("Aspect ratio image")
    public static Text aspectRatioImageContainer;

    @UI("#AspectRatioImage .v-image")
    public static Image aspectRatioImage;

    @WithText("Contain image")
    public static UIElement containImagesContainer;

    @UI("#ContainImage .v-image")
    public static JList<Image> containImages;

    @WithText("Gradients image")
    public static UIElement gradientsImagesContainer;

    @UI("#GradientsImage .v-image")
    public static JList<Image> gradientsImages;

    @WithText("Placeholder image")
    public static UIElement placeholderImageContainer;

    @UI("#PlaceholderImage .v-image")
    public static Image placeholderImage;

    @WithText("With alt text image")
    public static UIElement altImageContainer;

    @UI("#AltImage .v-image")
    public static Image altImage;
}
