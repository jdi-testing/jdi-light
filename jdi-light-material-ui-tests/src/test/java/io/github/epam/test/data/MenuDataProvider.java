package io.github.epam.test.data;

import com.google.common.collect.ImmutableSet;
import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.MenuType.SIMPLE;
import static com.epam.jdi.light.material.elements.utils.enums.MenuType.ICON;
import static com.epam.jdi.light.material.elements.utils.enums.MenuType.SELECTED;
import static com.epam.jdi.light.material.elements.utils.enums.MenuType.SCROLL;
public class MenuDataProvider {

    @DataProvider
    public Object[][] simpleMenuItemsTestData() {
        return new Object[][] {
            {SIMPLE, ImmutableSet.of("Profile", "My account", "Logout")},
            {ICON, ImmutableSet.of("Text with send icon", "Text with priority icon", "Text with drafts icon")},
            {SELECTED, ImmutableSet.of("Profile", "My account", "Logout")},
            {SCROLL, ImmutableSet.of("None", "Atria", "Callisto", "Dione", "Ganymede", "Hangouts Call", "Luna",
                "Oberon", "Phobos", "Pyxis", "Sedna", "Titania", "Triton", "Umbriel")},
        };
    }
}
