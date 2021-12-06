package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static io.github.com.pages.displaydata.IconsPage.colorIcons;
import static io.github.com.pages.displaydata.IconsPage.differentSizesIcons;
import static io.github.com.pages.displaydata.IconsPage.simpleIcons;

public class IconsDataProvider {

    @DataProvider
    public Object[][] validationTestDataProvider() {
        return new Object[][]{
                {simpleIcons, 13},
                {colorIcons, 6},
                {differentSizesIcons, 4},
        };
    }

    @DataProvider
    public Object[][] simpleIconsTestDataProvider() {
        return new Object[][]{
                {1, "Last hover: DeleteIcon", 2, "Last click: DeleteForeverIcon"},
        };
    }

    @DataProvider
    public Object[][] colorIconsTestDataProvider() {
        return new Object[][]{
                {1, 2, "rgba(63, 81, 181, 1)"},
                {1, 3, "rgba(245, 0, 87, 1)"},
                {1, 4, "rgba(0, 0, 0, 0.54)"},
                {1, 5, "rgba(0, 0, 0, 0.26)"},
                {1, 6, "rgba(76, 175, 80, 1)"},
        };
    }

    @DataProvider
    public Object[][] differentSizesIconsTestDataProvider() {
        return new Object[][]{
                {1, 20, 20},
                {2, 24, 24},
                {3, 35, 35},
                {4, 40, 40},
        };
    }
}
