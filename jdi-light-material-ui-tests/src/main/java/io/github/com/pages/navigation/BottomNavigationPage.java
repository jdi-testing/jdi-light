package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;

import java.util.List;

public class BottomNavigationPage extends WebPage {

    @UI(".MuiBottomNavigationAction-root")
    public static List<BottomNavigation> bottomNavigationItems;
}
