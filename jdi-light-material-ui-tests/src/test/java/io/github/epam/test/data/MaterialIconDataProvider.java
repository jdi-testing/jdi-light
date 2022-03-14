package io.github.epam.test.data;

import io.github.epam.enums.Colors;
import org.testng.annotations.DataProvider;

public class MaterialIconDataProvider {

    @DataProvider(name = "sizeAndColorTestDataProvider")
    public static Object[][] sizeAndColorTestData() {
        return new Object[][]{
                {1, "", ""},
                {2, "", "Large"},
                {3, Colors.SECONDARY.rgba(), ""}
        };
    }
}
