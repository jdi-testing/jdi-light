package io.github.epam.vuetify.tests.data;

import com.epam.jdi.light.vuetify.interfaces.HasImage;
import org.testng.annotations.DataProvider;


public class AvatarsTestsDataProvider {

    @DataProvider(name = "avatarsWithSizeTestData")
    public Object[][] avatarsWithSizeTestData() {
        return new Object[][] {
            {1, 36},
            {2, 48},
            {3, 62}
        };
    }

    @DataProvider(name = "slotAvatarsTestData")
    public Object[][] slotAvatarsTestData() {
        return new Object[][] {
                {1, false, true, null},
                {2, true, false, null},
                {3, false, false, "CJ"}
        };
    }

    @DataProvider(name = "combinationWithElementsTestData")
    public Object[][]combinationWithElementsTestData() {
        return new Object[][] {
                {1},
                {2},
                {3}
        };
    }
}
