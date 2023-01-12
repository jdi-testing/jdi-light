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
            {2, "coffee", "by: author"},
            {3, "fern", "by: author2"},
            {4, "hats", "by: author3"},
            {5, "bike", "by: author4"},
            {6, "camera", "by: author5"},
        };
    }
}
