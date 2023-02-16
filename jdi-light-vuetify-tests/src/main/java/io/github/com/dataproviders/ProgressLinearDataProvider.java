package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

import static io.github.com.enums.Colors.BLUE_GREY;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.LIME;
import static io.github.com.enums.Colors.PINK_LIGHTEN_1;
import static io.github.com.enums.Colors.PINK_LIGHTEN_3;
import static io.github.com.enums.Colors.RED_ACCENT_2;

public class ProgressLinearDataProvider {

    @DataProvider(name = "colorsProgressLinearsTestsDataProvider")
    public static Object[][] colorsProgressLinearsTestsData() {
        return new Object[][] {
                {1, PINK_LIGHTEN_3.value(), PINK_LIGHTEN_1.value()},
                {2, BLUE_GREY.value(), LIME.value()},
                {3, GREEN.value(), RED_ACCENT_2.value()}
        };
    }
}
