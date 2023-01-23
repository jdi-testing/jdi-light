package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import io.github.com.custom.tables.CheckboxDataIterator;
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

    @UI("#SingleSelectTableIterator .col:nth-child(2) .v-data-iterator")
    public static CheckboxDataIterator singleSelectTableIterator;

    @UI("#NoDataText > div > div")
    public static DataIterator noDataTextDataIterator;

    @UI("#NoResultsText > div > div")
    public static DataIterator noResultsTextDataIterator;

    @UI("#NoResultsText > div > div > div")
    public static WebList noResultsTextDataIteratorDataItemList;

    @UI("#NoResultsText")
    public static Input noResultsTextDataIteratorSearchField;
}
