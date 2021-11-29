package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.complex.Tabs;
import com.epam.jdi.light.vuetify.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.ChipGroups;
import java.util.List;

public class ChipGroupsPage extends VuetifyPage {

    @UI("#ColumnChipGroup .v-chip")
    public static List<ChipGroups> columnChipGroup;

    @UI("#FilterResultsChipGroup .v-chip")
    public static List<ChipGroups> filterResultsChipGroup;

    @UI("#MandatoryChipGroup .v-chip")
    public static List<ChipGroups> mandatoryChipGroup;

    @UI("#MandatoryChipGroup .v-slide-group__next")
    public static Tabs mandatoryGroupButtonNext;

    @UI("#MandatoryChipGroup .v-slide-group__prev")
    public static Tabs mandatoryGroupButtonBack;

    @UI("#MultipleChipGroup .v-slide-group__wrapper .v-chip")
    public static List<ChipGroups> multipleChipGroup;

    @UI("#MultipleChipGroup .v-slide-group__next")
    public static Tabs multipleGroupButtonNext;

    @UI("#MultipleChipGroup .v-slide-group__prev")
    public static Tabs multipleGroupButtonBack;

    @UI("#ProductCardChipGroup .v-chip")
    public static List<ChipGroups> productCardChipGroup;

    @UI("#ProductCardChipGroup .v-btn")
    public static Button shirtBlouseAddToCartButton;

    @UI("#ProductCardChipGroup")
    public static Card shirtBlouseText;

    @UI("#ToothbrushCardChipGroup .v-chip")
    public static List<ChipGroups> toothbrushCardChipGroup;

    @UI("#ToothbrushCardChipGroup .v-btn")
    public static Button toothbrushAddToCardButton;

    @UI("#ToothbrushCardChipGroup")
    public static Card toothbrushText;

}
