package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import io.github.com.custom.tables.FilterDataIterator;

public class DataIteratorsPage extends VuetifyPage {

    @UI("#DefaultTable")
    public static DataIterator defaultDataIterator;

    @UI("#DefaultTable .v-input--selection-controls")
    public static Switch defaultDataIteratorSingleSelect;

    @UI("#HeaderFooterTable")
    public static DataIterator headerFooterDataIterator;

    @UI("#FilterTable")
    public static FilterDataIterator filterDataIterator;
}
