package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.navigationDrawersPage;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.pages.NavigationDrawersPage.imagesNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.bottomNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.bottomNavigationDrawerToolBar;
import static io.github.com.pages.NavigationDrawersPage.clippedNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.expandOnHoverNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.miniVariantNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.permanentAndFloatingNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.rightNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.temporaryNavigationDrawerButton;
import static io.github.com.pages.NavigationDrawersPage.coloredNavigationDrawer;

public class NavigationDrawersTests extends TestsInit {

    @BeforeClass
    public void before() {
        navigationDrawersPage.open();
        waitCondition(() -> navigationDrawersPage.isOpened());
        navigationDrawersPage.checkOpened();
    }

    @Test
    public void itemsTextNavigationDrawerTest() {
        List<String> expectedItems = Arrays.asList("Inbox", "Supervisors", "Clock-in");
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.is().displayed();
        imagesNavigationDrawer.has().text(expectedItems);
    }

    @Test
    public void itemsSizeNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().itemSize(3);
    }

    @Test
    public void absoluteNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.is().absolute();
    }

    @Test
    public void bottomNavigationDrawerTest() {
        bottomNavigationDrawer.show();
        bottomNavigationDrawer.is().closed();
        bottomNavigationDrawerToolBar.menuButton().click();
        bottomNavigationDrawer.is().opened();
        bottomNavigationDrawer.is().bottom();
        bottomNavigationDrawer.get(1).click();
        bottomNavigationDrawer.is().closed();
    }

    @Test
    public void clippedNavigationDrawerTest() {
        clippedNavigationDrawer.show();
        clippedNavigationDrawer.is().clipped();
    }

    @Test
    public void themeNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().darkTheme();
    }

    @Test
    public void expandOnHoverNavigationDrawerTest() {
        expandOnHoverNavigationDrawer.show();
        expandOnHoverNavigationDrawer.is().collapsed();
        expandOnHoverNavigationDrawer.is().expandedOnHover();
        expandOnHoverNavigationDrawer.hover();
        expandOnHoverNavigationDrawer.is().expanded();
    }

    @Test
    public void imagesNavigationDrawerTest() {
        String backgroundImageLink = "https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg";
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.backgroundImage().has().sourcePath(backgroundImageLink);
    }

    @Test
    public void miniVariantNavigationDrawerTest() {
        miniVariantNavigationDrawer.show();
        miniVariantNavigationDrawer.is().miniVariant();
    }

    @Test
    public void floatingNavigationDrawerTest() {
        permanentAndFloatingNavigationDrawer.show();
        permanentAndFloatingNavigationDrawer.is().floating();
    }

    @Test
    public void permanentNavigationDrawerTest() {
        permanentAndFloatingNavigationDrawer.show();
        permanentAndFloatingNavigationDrawer.is().permanent();
    }

    @Test
    public void heightNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().height(300);
    }

    @Test
    public void widthNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().width(300);
    }

    @Test
    public void rightNavigationDrawerTest() {
        rightNavigationDrawer.show();
        rightNavigationDrawer.is().right();
    }

    @Test
    public void overlayTemporaryNavigationDrawerTest() {
        temporaryNavigationDrawer.show();
        temporaryNavigationDrawer.is().closed();
        temporaryNavigationDrawerButton.click();
        temporaryNavigationDrawer.is().opened();
        temporaryNavigationDrawer.is().temporary();
        temporaryNavigationDrawer.has().overlay();
        temporaryNavigationDrawer.overlay().is().displayed();
        temporaryNavigationDrawer.overlay().has().color(TRANSPARENT.value());
        temporaryNavigationDrawer.overlay().has().opacity(0.46);
    }

    @Test
    public void noOverlayNavigationDrawerTest() {
        rightNavigationDrawer.show();
        rightNavigationDrawer.has().noOverlay();
    }

    @Test
    public void colorNavigationDrawerTest() {
        coloredNavigationDrawer.show();
        coloredNavigationDrawer.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
    }
}
