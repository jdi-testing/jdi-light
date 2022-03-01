package io.github.epam.material.tests.navigation;

import static io.github.com.StaticSite.contextMenuPage;
import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.ContextMenuPage.contextList;
import static io.github.com.pages.navigation.ContextMenuPage.pageText;
import static io.github.com.pages.navigation.SimpleMenuPage.iconMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.simpleMenu;

import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.material.elements.utils.enums.MenuType;
import com.google.common.collect.ImmutableSet;
import io.github.epam.TestsInit;
import io.github.epam.test.data.MenuDataProvider;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MenuTests extends TestsInit {

    private static final Set<String> CONTEXT_MENU_ITEMS = ImmutableSet.of("Copy", "Print", "Highlight", "Email");

    @BeforeMethod
    public void before() {
        simpleMenuPage.open();
        simpleMenuPage.isOpened();
    }

    @Test(dataProvider = "simpleMenuItemsTestData", dataProviderClass = MenuDataProvider.class)
    public void simpleMenusItemsTest(MenuType menuType, Set<String> menuOptions) {
        Menu menu = menuType.menu();
        menu.button.is().displayed();

        menu.button.click();
        menu.list.is().displayed().and().itemsWithTexts(menuOptions);
    }

    @Test
    public void simpleMenuTest() {
        simpleMenu.button.show();
        simpleMenu.button.has().text("OPEN MENU");
        simpleMenu.button.click();

        String option = "Profile";
        simpleMenu.list.selectItemByText(option);
        simpleMenu.selectedText.has().text("Selected menu: " + option);
    }

    @Test
    public void menuWithIconsTest() {
        iconMenu.button.show();

        iconMenu.button.click();
        String option = "Text with send icon";
        iconMenu.list.itemIcon(option).is().displayed();

        iconMenu.list.selectItemByText(option);
        iconMenu.selectedText.has().text("Selected menu: " + option);
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selectedMenu.button.show();

        String defaultSelectedItem = "My account";
        selectedMenu.selectedText.has().text(defaultSelectedItem);

        selectedMenu.button.click();
        selectedMenu.list.getItemByText(defaultSelectedItem).is().selected();

        String option = "Logout";
        selectedMenu.list.selectItemByText(option);
        selectedMenu.selectedText.has().text(option);
    }

    @Test
    public void scrollMenuTest() {
        scrollMenu.button.show();
        scrollMenu.button.click();

        String option = "Callisto";
        scrollMenu.list.scrollToItem(option);
        scrollMenu.list.getItemByText(option).is().displayed();
        scrollMenu.list.selectItemByText(option);
        scrollMenu.selectedText.has().text("Selected menu: " + option);
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();
        contextMenuPage.isOpened();
        pageText.is().displayed();

        pageText.rightClick();
        contextList.is().displayed().and().has().itemsWithTexts(CONTEXT_MENU_ITEMS);
        contextList.selectItemByText("Print");
        contextList.is().hidden();
    }
}
