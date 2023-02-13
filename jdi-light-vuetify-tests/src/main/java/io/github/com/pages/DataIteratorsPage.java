package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import io.github.com.custom.ExpandableCard;
import io.github.com.custom.tables.CheckboxDataIterator;
import io.github.com.custom.tables.FilterDataIterator;

public class DataIteratorsPage extends VuetifyPage {

    @UI("#HeaderFooterTable .v-data-iterator")
    public static DataIterator<Card> headerFooterDataIterator;

    @UI("#DefaultTable .v-data-iterator")
    public static DataIterator<ExpandableCard> defaultDataIterator;

    @UI("#DefaultTable .v-input--selection-controls")
    public static Switch defaultDataIteratorSingleSelect;

    @UI("#FilterTable .v-data-iterator")
    public static FilterDataIterator filterDataIterator;

    @UI("#SingleSelectTableIterator .col:nth-child(2) .v-data-iterator")
    public static CheckboxDataIterator singleSelectTableIterator;

    @UI("#NoDataText .v-data-iterator")
    public static DataIterator<Card> noDataTextDataIterator;

    @UI("#LoadingText .v-data-iterator")
    public static DataIterator<Card> loadingTextDataIterator;

    @UI("#NoResultsText .v-data-iterator")
    public static DataIterator<Card> noResultsTextDataIterator;

    @UI("#NoResultsText")
    public static Input noResultsTextSearchField;
}
