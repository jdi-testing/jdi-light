package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.contextMenuPage;
import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.ContextMenuPage.pageText;
import static io.github.com.pages.navigation.ContextMenuPage.contextMenuList;
import static io.github.com.pages.navigation.SimpleMenuPage.menuItems;
import static io.github.com.pages.navigation.SimpleMenuPage.menuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedSimpleMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.items;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedScrollMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenuItem;
import static io.github.com.pages.navigation.SimpleMenuPage.iconMenuButton;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenuIconItem;

public class MenuTests extends TestsInit {

    private static final List<String> CONTEXT_MENU_ITEMS = Arrays.asList("Copy", "Print", "Highlight", "Email");
    private static final List<String> SIMPLE_AND_SELECTED_MENU_ITEMS = Arrays.asList("Profile", "My account", "Logout");
    private static final List<String> ICON_MENU_ITEMS = Arrays.asList("Text with send icon",
            "Text with priority icon", "Text with drafts icon");
    private static final List<String> SCROLL_MENU_ITEMS = Arrays.asList("None", "Atria", "Callisto",
            "Dione", "Ganymede", "Hangouts Call", "Luna", "Oberon", "Phobos", "Pyxis", "Sedna",
            "Titania", "Triton", "Umbriel");

    private static final String EXPECTED_MENU_TEXT_PART = "Selected menu: ";

    @BeforeMethod
    public void before() {
        simpleMenuPage.open();
        simpleMenuPage.isOpened();
    }

    @Test
    public void simpleMenuTest() {
        String expectedPart = "Profile";
        menuButton.show();
        menuButton.has().text("OPEN MENU");
        menuButton.click();
        items.is().displayed()
                .has().properMenuItems(menuItems, SIMPLE_AND_SELECTED_MENU_ITEMS);
        menuItems.selectItemByText(expectedPart);
        menuButton.is().displayed();
        selectedSimpleMenuItem.has().text(EXPECTED_MENU_TEXT_PART + expectedPart);
    }

    @Test
    public void scrollMenuTest() {
        String expectedPart = "Callisto";
        scrollMenuButton.show();
        scrollMenuButton.click();
        items.is().displayed()
                .has().properMenuItems(menuItems, SCROLL_MENU_ITEMS);
        items.scrollToMenuItem(menuItems, expectedPart);
        items.has().displayedMenuItem(menuItems, expectedPart);
        menuItems.selectItemByText(expectedPart);
        scrollMenuButton.is().displayed();
        selectedScrollMenuItem.has().text(EXPECTED_MENU_TEXT_PART + expectedPart);
    }

    @Test
    public void selectedVerticalPositioningTest() {
        String defaultSelectedItem = "My account";
        String expectedPart = "Logout";
        selectedMenuButton.show();
        selectedMenuItem.has().text(defaultSelectedItem);
        selectedMenuButton.click();
        menuItems.getItemByText(defaultSelectedItem).isSelected();
        items.is().displayed()
                .has().properMenuItems(menuItems, SIMPLE_AND_SELECTED_MENU_ITEMS);
        menuItems.selectItemByText(expectedPart);
        selectedMenuButton.is().displayed();
        selectedMenuItem.has().text(expectedPart);
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();
        pageText.rightClick();
        items.has().properMenuItems(menuItems, CONTEXT_MENU_ITEMS);
        contextMenuList.selectItemByText("Print");
        pageText.is().displayed();
    }

    @Test
    public void menuWithIconsTest() {
        String expectedPart = "Text with send icon";
        iconMenuButton.show();
        iconMenuButton.click();
        items.has().properMenuItems(menuItems, ICON_MENU_ITEMS)
                .has().displayedSvg();
        menuItems.selectItemByText(expectedPart);
        iconMenuButton.is().displayed();
        selectedMenuIconItem.has().text(EXPECTED_MENU_TEXT_PART + expectedPart);
    }
}
