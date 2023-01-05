package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.ExpansionPanelsPage.accordionExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.focusableExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.insetExpansionPanels;
import static io.github.com.pages.ExpansionPanelsPage.popOutExpansionPanels;

public class ExpansionPanelsDataProviders {
    @DataProvider
    public static Object[][] simpleExpansionPanelsWithOnlyOneOpenPanelData() {
        return new Object[][]{
                {accordionExpansionPanels},
                {insetExpansionPanels},
                {focusableExpansionPanels},
                {popOutExpansionPanels}
        };
    }
}
