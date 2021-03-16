package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bottomNavigationFrame;
import static io.github.com.StaticSite.bottomNavigationPage;
import static org.hamcrest.Matchers.hasToString;

public class BottomNavigationTests extends TestsInit {
    @Test
    public void defaultBottomNavigationTest(){
        bottomNavigationPage.open();

        bottomNavigationFrame.recents.is().enabled();
        bottomNavigationFrame.recents.toggle();
        bottomNavigationFrame.recents.is().text(hasToString("Recents"));

        bottomNavigationFrame.favorites.is().enabled();
        bottomNavigationFrame.favorites.toggle();
        bottomNavigationFrame.favorites.is().text(hasToString("Favorites"));

        bottomNavigationFrame.nearby.is().enabled();
        bottomNavigationFrame.nearby.toggle();
        bottomNavigationFrame.nearby.is().text(hasToString("Nearby"));
    }
}
