package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
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
        bottomDrawerNavigationAppBar.has().properTitleText("My files");
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.is().opened();
        bottomDrawerNavigationDrawer.has().numberOfOptions(4);
        bottomDrawerNavigationDrawer.selectOption(1);
        bottomDrawerNavigationDrawer.is().closed();
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.has().optionSelected(1, true);
        bottomDrawerNavigationDrawer.has().optionSelected(2, false);
        bottomDrawerNavigationDrawer.has().optionSelected(3, false);
        bottomDrawerNavigationDrawer.has().optionSelected(4, false);
        bottomDrawerNavigationDrawer.selectOption(2);
        bottomDrawerNavigationAppBar.clickOnMenuButton();
        bottomDrawerNavigationDrawer.has().optionSelected(1, false);
        bottomDrawerNavigationDrawer.has().optionSelected(2, true);
        bottomDrawerNavigationDrawer.has().optionSelected(3, false);
        bottomDrawerNavigationDrawer.has().optionSelected(4, false);
    }

    @Test
    public void expandOnHoverNavigationDrawerTests() {
        expandOnHoverNavigationDrawer.is().displayed();
        expandOnHoverNavigationDrawer.is().collapsed();
        expandOnHoverNavigationDrawer.hover();
        expandOnHoverNavigationDrawer.is().expanded();
        expandOnHoverNavigationDrawer.has().numberOfOptions(5);
        expandOnHoverNavigationDrawer.is().optionClickable(2);
        expandOnHoverNavigationDrawer.is().optionClickable(3);
        expandOnHoverNavigationDrawer.is().optionClickable(4);
        expandOnHoverNavigationDrawer.is().optionClickable(5);
    }

    @Test
    public void imagesNavigationDrawerTests() {
        imagesNavigationDrawer.is().displayed();
        imagesNavigationDrawer.has().backgroundImage();
        imagesNavigationDrawer.has().numberOfOptions(3);
        imagesNavigationDrawer.is().optionClickable(1);
        imagesNavigationDrawer.is().optionClickable(2);
        imagesNavigationDrawer.is().optionClickable(3);
    }

    @Test
    public void miniVariantNavigationDrawerTests() {
        miniVariantNavigationDrawer.is().displayed();
        miniVariantNavigationDrawer.is().collapsed();
        miniVariantNavigationDrawer.click();
        miniVariantNavigationDrawer.is().expanded();
        miniVariantNavigationDrawer.has().numberOfOptions(4);
        miniVariantNavigationDrawer.is().optionClickable(2);
        miniVariantNavigationDrawer.is().optionClickable(3);
        miniVariantNavigationDrawer.is().optionClickable(4);
        miniVariantNavigationDrawer.collapse();
        miniVariantNavigationDrawer.is().collapsed();
    }

    @Test
    public void permanentAndFloatingNavigationDrawerTests() {
        permanentAndFloatingNavigationDrawer.is().displayed();
        permanentAndFloatingNavigationDrawer.has().numberOfOptions(2);
        permanentAndFloatingNavigationDrawer.is().optionClickable(1);
        permanentAndFloatingNavigationDrawer.is().optionClickable(2);
    }

    @Test
    public void rightNavigationDrawerTests() {
        rightNavigationDrawer.is().displayed();
        rightNavigationDrawer.has().location("right");
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
        temporaryNavigationDrawer.is().optionClickable(2);
        temporaryNavigationDrawer.is().optionClickable(3);
        temporaryNavigationDrawerContainer.find(".v-overlay").click();
        temporaryNavigationDrawer.is().closed();
    }

    @Test
    public void coloredDrawerNavigationDrawerTests() {
        coloredDrawerNavigationDrawer.is().displayed();
        coloredDrawerNavigationDrawer.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
        coloredDrawerNavigationDrawer.has().numberOfOptions(3);
        coloredDrawerNavigationDrawer.is().optionClickable(1);
        coloredDrawerNavigationDrawer.is().optionClickable(2);
        coloredDrawerNavigationDrawer.is().optionClickable(3);
        coloredDrawerNavigationDrawer.has().button();
    }

    @Test
    public void combinedDrawerNavigationDrawerTests() {
        combinedDrawerNavigationDrawer.is().displayed();
        combinedDrawerNavigationDrawer.has().numberOfOptions(6);
        combinedDrawerNavigationDrawer.is().optionClickable(4);
        combinedDrawerNavigationDrawer.is().optionClickable(5);
        combinedDrawerNavigationDrawer.is().optionClickable(6);
    }
}
