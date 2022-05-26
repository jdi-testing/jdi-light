package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class GridListDataProvider {

    @DataProvider
    public Object[][] gridListItems() {
        return new Object[][] {
            {1, "coffee"},
            {2, "fern"},
            {3, "hats"},
            {4, "bike"},
            {5, "camera"},
        };
    }

    @DataProvider
    public Object[][] titleBarGridListItems() {
        return new Object[][] {
            {2, "coffee"},
            {3, "fern"},
            {4, "hats"},
            {5, "bike"},
            {6, "camera"},
        };
    }
}
