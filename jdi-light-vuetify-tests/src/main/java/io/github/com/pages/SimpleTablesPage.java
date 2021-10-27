package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Tables.SimpleTable;

public class SimpleTablesPage extends VuetifyPage {

    @UI("#DarkTable")
    public static SimpleTable darkTable;

    @UI("#DenseTable")
    public static SimpleTable denseTable;

    @UI("#FixedHeaderTable")
    public static SimpleTable fixedHeaderTable;

    @UI("#HeightTable")
    public static SimpleTable heightTable;
}
