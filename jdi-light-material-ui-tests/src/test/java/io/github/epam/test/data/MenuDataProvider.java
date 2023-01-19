package io.github.epam.test.data;

import static io.github.com.pages.navigation.SimpleMenuPage.iconMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedSelectedMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.simpleMenuButton;

import java.util.Arrays;
import org.testng.annotations.DataProvider;

public class MenuDataProvider {

    @DataProvider
    public Object[][] simpleMenuItemsTestData() {
        return new Object[][] {
            {simpleMenuButton, Arrays.asList("Profile", "My account", "Logout")},
            {iconMenuButton, Arrays.asList("Text with send icon", "Text with priority icon", "Text with drafts icon")},
            {selectedSelectedMenuButton, Arrays.asList("Profile", "My account", "Logout")},
            {scrollMenuButton, Arrays.asList("None", "Atria", "Callisto", "Dione", "Ganymede", "Hangouts Call", "Luna",
                "Oberon", "Phobos", "Pyxis", "Sedna", "Titania", "Triton", "Umbriel")},
        };
    }
}
