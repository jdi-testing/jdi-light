package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.contextMenuPage;
import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.ContextMenuPage.contextMenu;
import static io.github.com.pages.navigation.ContextMenuPage.contextMenuList;
import static io.github.com.pages.navigation.SimpleMenuPage.iconMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.menu;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.selectedMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.simpleMenuList;

public class MenuTests extends TestsInit {

    public static final List<String> CONTEXT_MENU_ITEMS = Arrays.asList("Copy", "Print", "Highlight", "Email");
    public static final List<String> SIMPLE_AND_SELECTED_MENU_ITEMS = Arrays.asList("Profile", "My account", "Logout");
    public static final List<String> ICON_MENU_ITEMS = Arrays.asList("Text with send icon",
            "Text with priority icon", "Text with drafts icon");
    public static final List<String> SCROLL_MENU_ITEMS = Arrays.asList("None", "Atria", "Callisto",
            "Dione", "Ganymede", "Hangouts Call", "Luna", "Oberon", "Phobos", "Pyxis", "Sedna",
            "Titania", "Triton", "Umbriel");

    @BeforeMethod
    public void before() {
        simpleMenuPage.open();
        simpleMenuPage.isOpened();
    }

    @Test
    public void simpleMenuTest() {
        menu.has().text("OPEN MENU");
        menu.click();
        simpleMenuList.is().displayed();
        menu.has().properMenuItems(simpleMenuList, SIMPLE_AND_SELECTED_MENU_ITEMS);
        simpleMenuList.selectItemByText("Profile");
        menu.is().displayed();
    }

    @Test
    public void scrollMenuTest() {
        scrollMenu.click();
        scrollMenu.has().properMenuItems(simpleMenuList, SCROLL_MENU_ITEMS);
        scrollMenu.scrollToMenuItem(simpleMenuList, "Umbriel");
        scrollMenu.has().displayedMenuItem(simpleMenuList, "Umbriel");
        simpleMenuList.selectItemByText("Triton");
        scrollMenu.is().displayed();
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selectedMenu.has().text("Selected Menu\nMy account");
        selectedMenu.click();
        selectedMenu.has().properMenuItems(simpleMenuList, SIMPLE_AND_SELECTED_MENU_ITEMS);
        simpleMenuList.selectItemByText("Logout");
        selectedMenu.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();
        contextMenu.rightClick();
        menu.has().properMenuItems(contextMenuList, CONTEXT_MENU_ITEMS);
        contextMenuList.selectItemByText("Print");
        contextMenu.isDisplayed();
    }

    @Test
    public void menuWithIconsTest() {
        iconMenu.is().displayedSvg();
        iconMenu.click();
        iconMenu.has().properMenuItems(simpleMenuList, ICON_MENU_ITEMS);
        simpleMenuList.selectItemByText("Logout");
        iconMenu.is().displayed();
    }
}
