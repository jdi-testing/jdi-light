package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class GridDataProvider {

    @DataProvider
    public Object[][] basicGridItems() {
        return new Object[][]{
                {1, "100%", "MuiGrid-grid-xs-12"},
                {2, "50%", "MuiGrid-grid-xs-6"},
                {3, "50%", "MuiGrid-grid-xs-6"},
                {4, "25%", "MuiGrid-grid-xs-3"},
                {5, "25%", "MuiGrid-grid-xs-3"},
                {6, "25%", "MuiGrid-grid-xs-3"},
                {7, "25%", "MuiGrid-grid-xs-3"},
        };
    }

    @DataProvider
    public Object[][] complexGridItems() {
        return new Object[][]{
                {2, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114\nRemove\n$19.00"},
                {3, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114\nRemove"},
                {4, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114"},
                {5, "Remove"},
                {6, "$19.00"},
        };
    }
}
