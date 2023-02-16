package io.github.com.custom.tables;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.annotations.JDIButtonGroup;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.ButtonGroup;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import com.epam.jdi.light.vuetify.elements.complex.Select;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;

public class FilterDataIterator extends DataIterator<Card> {
    protected Class<Card> contentClazz = Card.class;

    @UI("header .v-input")
    public Input filterDataSearchField;

    @JDropdown(root = "header .v-select",
            value = ".v-select__selection--comma",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list-item--link')]",
            expand = ".mdi-menu-down")
    public Select filterSortSelect;

    @JDIButtonGroup(root = "header .v-btn-toggle")
    public ButtonGroup filterSortOrder;

    @JDropdown(root = ".ml-2.v-btn",
            value = ".v-btn__content",
            list = "//ancestor::div[@id = 'app']//div[contains(@class, 'v-menu__content')]//div[contains(@class, 'v-list')]//div[contains(@class, 'v-list-item--link')]")
    public Dropdown itemsPerPage;

    @UI(".v-btn .mdi-chevron-left")
    public Button previousPage;

    @UI(".v-btn .mdi-chevron-right")
    public Button nextPage;


    public FilterDataIterator() {
        super(Card.class);
    }
    public FilterDataIterator(Class<Card> type) {
        super(type);
    }

    public void sortAsc() {filterSortOrder.get(1).click();}

    public void sortDesc() {filterSortOrder.get(2).click();}
}
