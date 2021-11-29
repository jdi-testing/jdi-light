package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.ExpansionPanelsPage.accordionExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.focusableExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.insetExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.popOutExpansionPanels;

public class ExpansionPanelsDataProviders {

    public static final String LOREM_IPSUM_TEXT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.";

    @DataProvider
    public static Object[][] simpleExpansionPanelsWithOnlyOneOpenPanelData() {
        return new Object[][]{
                {accordionExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {insetExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {focusableExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT},
                {popOutExpansionPanels, 5, "Item", LOREM_IPSUM_TEXT}
        };
    }
}
