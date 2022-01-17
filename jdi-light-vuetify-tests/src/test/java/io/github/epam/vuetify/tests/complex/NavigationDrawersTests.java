package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.navigationDrawersPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.pages.NavigationDrawersPage.bottomDrawerNavigationToolBar;
import static io.github.com.pages.NavigationDrawersPage.bottomDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.coloredDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.combinedDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.expandOnHoverNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.imagesNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.miniVariantNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.permanentAndFloatingNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.rightNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawerButton;

public class NavigationDrawersTests extends TestsInit {

    @BeforeClass
    public void before() {
        navigationDrawersPage.open();
    }

    @Test
    public void bottomDrawerNavigationDrawerTests() {
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationToolBar.menuButton().click();
        bottomDrawerNavigationDrawer.is().opened();
        bottomDrawerNavigationDrawer.has().numberOfListItems(4);
        bottomDrawerNavigationDrawer.getListItemByIndex(1).click();
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationToolBar.menuButton().click();
        bottomDrawerNavigationDrawer.getListItemByIndex(1).is().active();
        bottomDrawerNavigationDrawer.getListItemByIndex(2).is().notActive();
        bottomDrawerNavigationDrawer.getListItemByIndex(3).is().notActive();
        bottomDrawerNavigationDrawer.getListItemByIndex(4).is().notActive();
        bottomDrawerNavigationDrawer.getListItemByIndex(2).click();
        bottomDrawerNavigationToolBar.menuButton().click();
        bottomDrawerNavigationDrawer.getListItemByIndex(2).is().active();
        bottomDrawerNavigationDrawer.getListItemByIndex(1).is().notActive();
        bottomDrawerNavigationDrawer.getListItemByIndex(3).is().notActive();
        bottomDrawerNavigationDrawer.getListItemByIndex(4).is().notActive();
    }

    @Test
    public void expandOnHoverNavigationDrawerTests() {
        expandOnHoverNavigationDrawer.is().displayed();
        expandOnHoverNavigationDrawer.is().collapsed();
        expandOnHoverNavigationDrawer.hover();
        expandOnHoverNavigationDrawer.is().expanded();
        expandOnHoverNavigationDrawer.has().numberOfListItems(5);
        expandOnHoverNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
        expandOnHoverNavigationDrawer.getListItemByIndex(1).avatar().is().displayed();
        expandOnHoverNavigationDrawer.getListItemByIndex(2).title().has().text("Sandra Adams");
        expandOnHoverNavigationDrawer.getListItemByIndex(2).subTitle().has().text("sandra_a88@gmail.com");
        expandOnHoverNavigationDrawer.getListItemByIndex(3).icon().is().displayed();
        expandOnHoverNavigationDrawer.getListItemByIndex(3).has().text("My Files");
        expandOnHoverNavigationDrawer.getListItemByIndex(4).icon().is().displayed();
        expandOnHoverNavigationDrawer.getListItemByIndex(4).has().text("Shared with me");
        expandOnHoverNavigationDrawer.getListItemByIndex(5).icon().is().displayed();
        expandOnHoverNavigationDrawer.getListItemByIndex(5).has().text("Starred");
    }

    @Test
    public void imagesNavigationDrawerTests() {
        String backgroundImageLink = "https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg";
        imagesNavigationDrawer.is().displayed();
        imagesNavigationDrawer.backgroundImage().has().sourcePath(backgroundImageLink);
        imagesNavigationDrawer.has().numberOfListItems(3);
        imagesNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
    }

    @Test
    public void miniVariantNavigationDrawerTests() {
        miniVariantNavigationDrawer.is().displayed();
        miniVariantNavigationDrawer.is().collapsed();
        miniVariantNavigationDrawer.click();
        miniVariantNavigationDrawer.is().expanded();
        miniVariantNavigationDrawer.has().numberOfListItems(4);
        miniVariantNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
        miniVariantNavigationDrawer.collapse();
        miniVariantNavigationDrawer.is().collapsed();
    }

    @Test
    public void permanentAndFloatingNavigationDrawerTests() {
        permanentAndFloatingNavigationDrawer.is().displayed();
        permanentAndFloatingNavigationDrawer.has().numberOfListItems(2);
        permanentAndFloatingNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
    }

    @Test
    public void rightNavigationDrawerTests() {
        rightNavigationDrawer.is().displayed();
        rightNavigationDrawer.is().onTheRightSide();
        rightNavigationDrawer.has().numberOfListItems(4);
        rightNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
    }

    @Test
    public void temporaryNavigationDrawerTests() {
        temporaryNavigationDrawer.is().closed();
        temporaryNavigationDrawerButton.click();
        temporaryNavigationDrawer.is().opened();
        temporaryNavigationDrawer.has().numberOfListItems(3);
        temporaryNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
        coloredDrawerNavigationDrawer.getListItemByIndex(1).click();
        temporaryNavigationDrawer.is().closed();
    }

    @Test
    public void coloredDrawerNavigationDrawerTests() {
        coloredDrawerNavigationDrawer.is().displayed();
        coloredDrawerNavigationDrawer.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
        coloredDrawerNavigationDrawer.has().numberOfListItems(3);
        coloredDrawerNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
        coloredDrawerNavigationDrawer.button().is().displayed();
    }

    @Test
    public void combinedDrawerNavigationDrawerTests() {
        combinedDrawerNavigationDrawer.is().displayed();
        combinedDrawerNavigationDrawer.has().numberOfListItems(6);
        combinedDrawerNavigationDrawer.listItems().forEach(listItem -> listItem.is().displayed());
    }
}
