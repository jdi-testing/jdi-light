package io.github.com.pages;

import com.epam.jdi.mobile.elements.complex.table.Table;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;

public class SimplePage extends WebPage {
    @UI("#simple-table") public static Table simpleTable;
}