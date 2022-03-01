package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.elements.navigation.Menu;

import static com.epam.jdi.light.material.elements.utils.enums.MenuType.*;

public class SimpleMenuPage extends WebPage {
    public static Menu simpleMenu = SIMPLE.menu();

    public static Menu iconMenu = ICON.menu();

    public static Menu selectedMenu = SELECTED.menu();

    public static Menu scrollMenu = SCROLL.menu();
}
