package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.SlideGroup;

public class SlideGroupsPage extends VuetifyPage {

    @UI("#ActiveClassSlideGroup .v-item-group")
    public static SlideGroup activeClassSlideGroup;

    @UI("#CenterActiveSlideGroup .v-item-group")
    public static SlideGroup centerActiveSlideGroup;

    @UI("#CustomIconsSlideGroup .v-item-group")
    public static SlideGroup customIconsSlideGroup;

    @UI("#MultipleSlideGroup .v-item-group")
    public static SlideGroup multipleSlideGroup;

    @UI("#PseudoCarouselSlideGroup .v-item-group")
    public static SlideGroup pseudoCarouselSlideGroup;

}
