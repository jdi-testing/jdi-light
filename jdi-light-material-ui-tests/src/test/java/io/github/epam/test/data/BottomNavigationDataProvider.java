package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class BottomNavigationDataProvider {

    @DataProvider(name = "bottomNavigationButtons")
    public static Object[][] bottomNavigationButtons() {
        return new Object[][] {
                {1, "Recents", "Current isRecents(0)"},
                {2, "Favorites", "Current isFavorites(1)"},
                {3, "Nearby", "Current isNearby(2)"},
        };
    }
}
