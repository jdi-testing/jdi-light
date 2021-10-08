package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.navigationDrawersPage;
import static io.github.com.pages.NavigationDrawersPage.bottomDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.coloredDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.combinedDrawerNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.expandOnHoverNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.imagesNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.miniVariantNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.permanentAndFloatingNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.rightNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawer;

public class NavigationDrawersTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        navigationDrawersPage.open();
    }

    @Test
    public void bottomDrawerNavigationDrawerTests() {
        bottomDrawerNavigationDrawer.is().displayed();
    }

    @Test
    public void expandOnHoverNavigationDrawerTests() {
        expandOnHoverNavigationDrawer.is().displayed();
    }

    @Test
    public void imagesNavigationDrawerTests() {
        imagesNavigationDrawer.is().displayed();
    }

    @Test
    public void miniVariantNavigationDrawerTests() {
        miniVariantNavigationDrawer.is().displayed();
    }

    @Test
    public void permanentAndFloatingNavigationDrawerTests() {
        permanentAndFloatingNavigationDrawer.is().displayed();
    }

    @Test
    public void rightNavigationDrawerTests() {
        rightNavigationDrawer.is().displayed();
    }

    @Test
    public void temporaryNavigationDrawerTests() {
        temporaryNavigationDrawer.is().displayed();
    }

    @Test
    public void coloredDrawerNavigationDrawerTests() {
        coloredDrawerNavigationDrawer.is().displayed();
    }

    @Test
    public void combinedDrawerNavigationDrawerTests() {
        combinedDrawerNavigationDrawer.is().displayed();
    }

}
