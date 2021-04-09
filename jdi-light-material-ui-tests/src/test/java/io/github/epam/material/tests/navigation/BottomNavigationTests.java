package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.navigation.BottomNavigationPage.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BottomNavigationTests extends TestsInit {

    @BeforeMethod
    public void before(){
        openSection("Button Navigation");
    }
    //TODO change Section name to Bottom Navigation (from Button Navigation)
    //TODO change Title name to Bottom Navigation (from Buttom Navigation)

    @Test
    public void defaultBottomNavigationTest(){

        favorites.is().enabled();
        assertTrue(favorites.core().text().contains("Favorites"));
        assertFalse(favorites.isSelected());
        favorites.core().click();
        assertTrue(currentPosition.getText().contains("Favorites"));
        favorites.is().selected();

    }

}