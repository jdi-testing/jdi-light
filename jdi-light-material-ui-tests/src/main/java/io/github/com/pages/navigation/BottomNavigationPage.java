package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class BottomNavigationPage extends WebPage {

    @UI(".MuiBottomNavigationAction-root[2]")
    public static BottomNavigation favorites;

    @UI("#currentPosition")
    public static Text currentPosition;

}
