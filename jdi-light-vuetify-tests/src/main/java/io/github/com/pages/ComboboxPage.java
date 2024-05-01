package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDICombobox;
import com.epam.jdi.light.vuetify.elements.complex.Combobox;
import io.github.com.custom.AdvancedCombobox;

public class ComboboxPage extends VuetifyPage {
    // @todo #5463 Check if JDICombobox annotation, now the root value is not correct
    @JDICombobox(
            root = "#AutofocusCombobox div[role ='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]//div[@class='v-list-item__title']")
    public static Combobox autofocusCombobox;
    @JDICombobox(
            root = "#DenseCombobox div[role ='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]//div[@class='v-list-item__title']")
    public static Combobox denseCombobox;
    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][1]//div[contains(@class, 'v-input')]",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][1]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleStringCombobox;
    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][2]//div[contains(@class, 'v-input')]",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][2]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleChipsCombobox;
    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][3]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][3]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleScopedCombobox;
    @JDICombobox(
            root = "//div[@id = 'MultipleCombobox']//div[contains(@class, 'col-12')][4]//div[@role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][4]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox multipleReadOnlyCombobox;
    @JDICombobox(
            root = "#NoDataWithChipsCombobox div[role ='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox noDataWithChipsCombobox;
    @JDICombobox(
            root = "//div[@id = 'AdvancedCustomOptionsCombobox']//div[@role = 'combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//span[@class='v-chip__content']")
    public static AdvancedCombobox advancedCustomOptionsCombobox;
    @JDICombobox(
            root = "#loadingCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//span[@class='v-chip__content']")
    public static Combobox loadingCombobox;
    @JDICombobox(
            root = "#SoloInvertedCombobox .col-6[1] [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][6]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox soloCombobox;
    @JDICombobox(
            root = "#SoloInvertedCombobox .col-6:nth-child(2) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')][6]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox soloInvertedCombobox;
    @JDICombobox(
            root = "#HideSelectedCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox hideSelectedCombobox;
    @JDICombobox(
            root = "#PlaceholderCombobox .col-6:nth-child(3) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox placeholderCombobox1;
    @JDICombobox(
            root = "#PlaceholderCombobox .col-6:nth-child(4) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox persistentPlaceholderCombobox1;
    @JDICombobox(
            root = "#DisabledCombobox .col-6:nth-child(4) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox disabledCombobox1;
    @JDICombobox(
            root = "#FlatCombobox .col-6:nth-child(4) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox flatCombobox;
    @JDICombobox(
            root = "#ErrorSuccessCombobox .col-4:nth-child(5) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox errorCombobox1;
    @JDICombobox(
            root = "#ErrorSuccessCombobox .col-4:nth-child(6) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox successCombobox1;
    @JDICombobox(
            root = "#HideDetailsCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox hideDetailsCombobox1;
    @JDICombobox(
            root = "#HideDetailsCombobox .col-6:nth-child(6) .v-select",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox errorMessageCombobox;
    @JDICombobox(
            root = "#CounterCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox counterCombobox1;
    @JDICombobox(
            root = "#CounterCombobox .col-4:nth-child(6) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox counterCombobox3;
    @JDICombobox(
            root = "#FullWidthCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox fullWidthCombobox;
    @JDICombobox(
            root = "#NoFilterCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox noFilterCombobox;
    @JDICombobox(
            root = "#CustomHeightCombobox .col-12:nth-child(3) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox customHeightCombobox;
    @JDICombobox(
            root = "#RoundedCombobox .col-6:nth-child(2) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox roundedCombobox;
    @JDICombobox(
            root = "#ShapedCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox shapedCombobox;
    @JDICombobox(
            root = "#CustomStyleCombobox [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox customStyleCombobox;
    @JDICombobox(
            root = "#PrefixSuffixCombobox .col-12:nth-child(3) [role='combobox']",
            listItems = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-autocomplete__content')]" +
                    "//div[@class='v-list-item__title']")
    public static Combobox prefixSuffixCombobox;
}
