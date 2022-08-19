package io.github.epam.vuetify.tests.data;

import io.github.com.enums.Colors;
import org.testng.annotations.DataProvider;

public class AvatarsTestsDataProvider {

    @DataProvider(name = "avatarsWithSizeTestData")
    public Object[][] avatarsWithSizeTestData() {
        return new Object[][] {
            {1, 36, Colors.INDIGO.value()},
            {2, 48, Colors.TEAL.value()},
            {3, 62, Colors.ORANGE.value()}
        };
    }

    @DataProvider(name = "slotAvatarsTestData")
    public Object[][] slotAvatarsTestData() {
        return new Object[][] {
                {1, false, true, null, Colors.INDIGO_RGB.value()},
                {2, true, false, null, Colors.BLACK_TRANSPARENT_087.value()},
                {3, false, false, "CJ", Colors.RED_RGB.value()}
        };
    }

    @DataProvider(name = "combinationWithElementsTestData")
    public Object[][]combinationWithElementsTestData() {
        return new Object[][] {
                {1, "John Leider", "Thank you for joining our community...", "Welcome to Vuetify!", null},
                {2, "Social", "(3)", "Twitter", "1 new"},
                {3, "Promos", "(4)", "Shop your way", "2 new"}
        };
    }
}
