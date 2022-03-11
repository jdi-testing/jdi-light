package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import io.github.epam.test.data.BottomNavigationDataProvider;
import org.testng.annotations.BeforeMethod;
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

    @Test(dataProvider = "bottomNavigationButtons", dataProviderClass = BottomNavigationDataProvider.class)
    public void defaultBottomNavigationTest(int index, String buttonText, String positionText) {
        bottomNavigationItems.select(index);
        bottomNavigationItems.has().selected(index);
        currentPosition.has().text(positionText);
        bottomNavigationItemsText.get(index).has().text(buttonText);
    }
}
