package io.github.epam.test.data;

import io.github.epam.enums.Colors;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.displaydata.MaterialIconPage.iconsList;

public class MaterialIconDataProvider {

    @DataProvider(name = "sizeAndColorTestDataProvider")
    public static Object[][] sizeAndColorTestData() {
        return new Object[][]{
                {iconsList.get(1), "", ""},
                {iconsList.get(2), "", "Large"},
                {iconsList.get(3), Colors.SECONDARY.rgba(), ""}
        };
    }
}
