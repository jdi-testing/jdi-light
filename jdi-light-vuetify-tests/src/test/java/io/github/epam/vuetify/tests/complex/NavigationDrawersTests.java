package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.StaticSite.navigationDrawersPage;
import static io.github.com.pages.NavigationDrawersPage.bottomDrawerNavigationAppBar;
import static io.github.com.pages.NavigationDrawersPage.bottomDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.coloredDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.combinedDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.expandOnHoverNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.imagesNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.miniVariantNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.permanentAndFloatingNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.rightNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawerContainer;

public class NavigationDrawersTests extends TestsInit {

    @BeforeClass
    public void before() {
        navigationDrawersPage.open();
    }

    @Test
    public void bottomDrawerNavigationDrawerTests() {
        bottomDrawerNavigationAppBar.has().textInTitle("My files");
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.is().opened();
        bottomDrawerNavigationDrawer.has().numberOfOptions(4);
        bottomDrawerNavigationDrawer.selectOptionByIndex(1);
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.has().optionSelected(1);
        bottomDrawerNavigationDrawer.has().optionNotSelected(2);
        bottomDrawerNavigationDrawer.has().optionNotSelected(3);
        bottomDrawerNavigationDrawer.has().optionNotSelected(4);
        bottomDrawerNavigationDrawer.selectOptionByIndex(2);
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.has().optionSelected(2);
        bottomDrawerNavigationDrawer.has().optionNotSelected(1);
        bottomDrawerNavigationDrawer.has().optionNotSelected(3);
        bottomDrawerNavigationDrawer.has().optionNotSelected(4);
    }

    @Test
    public void expandOnHoverNavigationDrawerTests() {
        expandOnHoverNavigationDrawer.is().displayed();
        expandOnHoverNavigationDrawer.is().collapsed();
        expandOnHoverNavigationDrawer.hover();
        expandOnHoverNavigationDrawer.is().expanded();
        expandOnHoverNavigationDrawer.has().numberOfOptions(5);
        expandOnHoverNavigationDrawer.has().optionClickable(2);
        expandOnHoverNavigationDrawer.has().optionClickable(3);
        expandOnHoverNavigationDrawer.has().optionClickable(4);
        expandOnHoverNavigationDrawer.has().optionClickable(5);
    }

    @Test
    public void imagesNavigationDrawerTests() {
        imagesNavigationDrawer.is().displayed();
        imagesNavigationDrawer.has().backgroundImage();
        imagesNavigationDrawer.has().numberOfOptions(3);
        imagesNavigationDrawer.has().optionClickable(1);
        imagesNavigationDrawer.has().optionClickable(2);
        imagesNavigationDrawer.has().optionClickable(3);
    }

    @Test
    public void miniVariantNavigationDrawerTests() {
        miniVariantNavigationDrawer.is().displayed();
        miniVariantNavigationDrawer.is().collapsed();
        miniVariantNavigationDrawer.click();
        miniVariantNavigationDrawer.is().expanded();
        miniVariantNavigationDrawer.has().numberOfOptions(4);
        miniVariantNavigationDrawer.has().optionClickable(2);
        miniVariantNavigationDrawer.has().optionClickable(3);
        miniVariantNavigationDrawer.has().optionClickable(4);
        miniVariantNavigationDrawer.collapse();
        miniVariantNavigationDrawer.is().collapsed();
    }

    @Test
    public void permanentAndFloatingNavigationDrawerTests() {
        permanentAndFloatingNavigationDrawer.is().displayed();
        permanentAndFloatingNavigationDrawer.has().numberOfOptions(2);
        permanentAndFloatingNavigationDrawer.has().optionClickable(1);
        permanentAndFloatingNavigationDrawer.has().optionClickable(2);
    }

    @Test
    public void rightNavigationDrawerTests() {
        rightNavigationDrawer.is().displayed();
        rightNavigationDrawer.is().onTheRightSide();
        rightNavigationDrawer.has().numberOfOptions(4);
        rightNavigationDrawer.has().allOptionsVisible();
    }

    @Test
    public void temporaryNavigationDrawerTests() {
        temporaryNavigationDrawer.is().closed();
        temporaryNavigationDrawerContainer.find("button").click();
        temporaryNavigationDrawer.is().opened();
        temporaryNavigationDrawer.has().numberOfOptions(3);
        temporaryNavigationDrawer.has().allOptionsVisible();
        temporaryNavigationDrawer.has().optionClickable(2);
        temporaryNavigationDrawer.has().optionClickable(3);
        temporaryNavigationDrawerContainer.find(".v-overlay").click();
        temporaryNavigationDrawer.is().closed();
    }

    @Test
    public void coloredDrawerNavigationDrawerTests() {
        coloredDrawerNavigationDrawer.is().displayed();
        coloredDrawerNavigationDrawer.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
        coloredDrawerNavigationDrawer.has().numberOfOptions(3);
        coloredDrawerNavigationDrawer.has().optionClickable(1);
        coloredDrawerNavigationDrawer.has().optionClickable(2);
        coloredDrawerNavigationDrawer.has().optionClickable(3);
        coloredDrawerNavigationDrawer.has().button();
    }

    @Test
    public void combinedDrawerNavigationDrawerTests() {
        combinedDrawerNavigationDrawer.is().displayed();
        combinedDrawerNavigationDrawer.has().numberOfOptions(6);
        combinedDrawerNavigationDrawer.has().optionClickable(4);
        combinedDrawerNavigationDrawer.has().optionClickable(5);
        combinedDrawerNavigationDrawer.has().optionClickable(6);
    }
}
