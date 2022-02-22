package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bottomNavigationPage;
import static io.github.com.pages.navigation.BottomNavigationPage.bottomNavigationItems;
import static io.github.com.pages.navigation.BottomNavigationPage.bottomNavigationItemsText;
import static io.github.com.pages.navigation.BottomNavigationPage.currentPosition;

public class BottomNavigationTests extends TestsInit {

    @BeforeMethod
    public void before() {
        bottomNavigationPage.open();
        bottomNavigationPage.checkOpened();
    }

    @DataProvider(name = "bottomNavigationButtons")
    public static Object[][] bottomNavigationButtons() {
        return new Object[][] {
                {1, "Recents", "isRecents(0)"},
                {2, "Favorites", "isFavorites(1)"},
                {3, "Nearby", "isNearby(2)"},
        };
    }

    @Test(dataProvider = "bottomNavigationButtons")
    public void defaultBottomNavigationTest(int index, String buttonText, String positionText) {
        bottomNavigationItems.select(index);
        bottomNavigationItems.has().selected(index);
        currentPosition.has().text("Current " + positionText);
        bottomNavigationItemsText.get(index).has().text(buttonText);
    }
}
