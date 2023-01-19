package io.github.epam.test.data;

import io.github.epam.enums.Colors;
import org.testng.annotations.DataProvider;

public class IconsDataProvider {

    @DataProvider
    public Object[][] colorIconsTestDataProvider() {
        return new Object[][]{
                {1, Colors.DEFAULT.rgba()},
                {2, Colors.INDIGO_500.rgba()},
                {3, Colors.PINK_A400.rgba()},
                {4, Colors.GREY_600_TRANSPARENT.rgba()},
                {5, Colors.GREY_400.rgba()},
                {6, Colors.GREEN_500.rgba()},
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
