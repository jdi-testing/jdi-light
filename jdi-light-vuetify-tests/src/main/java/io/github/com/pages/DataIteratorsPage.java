package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.elements.complex.DataIterator;

public class DataIteratorsPage extends VuetifyPage {

    @UI("#DefaultTable .v-data-iterator")
    public static DataIterator defaultDataIterator;

    @UI("#DefaultTable .v-input--selection-controls__input")
    public static Button defaultDataIteratorExpandSingleItemButton;

    @UI("#HeaderFooterTable .v-data-iterator")
    public static DataIterator headerFooterDataIterator;

    @UI("#FilterTable .v-data-iterator")
    public static DataIterator filterDataIterator;
}
