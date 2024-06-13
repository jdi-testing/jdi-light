package io.github.epam.material.tests.navigation;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import io.github.epam.test.data.MenuDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.SimpleMenuPage.iconMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.menu;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenuIconItem;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedScrollMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedSelectedMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedSelectedMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedSimpleMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.simpleMenuButton;

public class MenuTests extends TestsInit {

    @BeforeMethod
    public void before() {
        simpleMenuPage.open();
        simpleMenuPage.isOpened();
    }

    @Test(dataProvider = "simpleMenuItemsTestData", dataProviderClass = MenuDataProvider.class)
    public void simpleMenusItemsTest(Button menuButton, List<String> menuOptions) {
        menuButton.is().displayed();
        menuButton.click();
        menu.is().displayed().and().has().itemsTexts(menuOptions);
    }

    @Test
    public void simpleMenuTest() {
        simpleMenuButton.show();
        simpleMenuButton.has().text("OPEN MENU");
        simpleMenuButton.click();

        String option = "Profile";
        menu.select(option);
        selectedSimpleMenuItem.has().text("Selected menu: " + option);
    }

    @Test
    public void menuWithIconsTest() {
        iconMenuButton.show();

        iconMenuButton.click();
        String option = "Text with send icon";
        menu.item(option).icon().is().displayed();

        menu.select(option);
        selectedMenuIconItem.has().text("Selected menu: " + option);
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selectedSelectedMenuButton.show();

        String defaultSelectedItem = "My account";
        selectedSelectedMenuItem.has().text(defaultSelectedItem);

        selectedSelectedMenuButton.click();
        menu.has().selected(defaultSelectedItem);

        String option = "Logout";
        menu.select(option);
        selectedSelectedMenuItem.has().text(option);
    }

    @Test
    public void scrollMenuTest() {
        scrollMenuButton.show();
        scrollMenuButton.click();

        String option = "Callisto";
        menu.scrollToItem(option);
        menu.item(option).is().displayed();
        menu.select(option);
        selectedScrollMenuItem.has().text("Selected menu: " + option);
    }
}
