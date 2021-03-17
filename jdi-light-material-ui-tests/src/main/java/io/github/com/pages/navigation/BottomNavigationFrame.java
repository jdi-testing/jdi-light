package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;

public class BottomNavigationFrame extends Section {
    @UI("//span[text()='Recents']")
    public BottomNavigation recents;

    @UI("//span[text()='Favorites']")
    public BottomNavigation favorites;

    @UI("//span[text()='Nearby']")
    public BottomNavigation nearby;
}
