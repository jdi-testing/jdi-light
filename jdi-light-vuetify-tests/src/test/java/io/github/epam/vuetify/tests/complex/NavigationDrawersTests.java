package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.navigationDrawersPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.pages.NavigationDrawersPage.bottomNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.bottomNavigationDrawerToolBar;
import static io.github.com.pages.NavigationDrawersPage.clippedNavigationDrawer;
import static io.github.com.pages.NavigationDrawersPage.coloredNavigationDrawer;
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
        waitCondition(() -> navigationDrawersPage.isOpened());
        navigationDrawersPage.checkOpened();
    }

    @Test(description = "Test checks that drawer has expected text and expected number of options")
    public void itemsTextNavigationDrawerTest() {
        List<String> expectedItems = Arrays.asList("Inbox", "Supervisors", "Clock-in");
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.is().displayed();
        imagesNavigationDrawer.has().text(expectedItems);
        imagesNavigationDrawer.has().itemSize(3);
        imagesNavigationDrawer.is().absolute();
    }
    @Test(description = "Test checks bottom navigation drawer functionality")
    public void bottomNavigationDrawerTest() {
        bottomNavigationDrawer.show();
        bottomNavigationDrawer.is().closed();
        bottomNavigationDrawerToolBar.findIconButton("mdi-menu").click();
        bottomNavigationDrawer.is().opened();
        bottomNavigationDrawer.is().bottom();
        bottomNavigationDrawer.get("Bar").click();
        bottomNavigationDrawer.is().closed();
    }

    @Test(description = "Test checks that navigation drawer is clipped")
    public void clippedNavigationDrawerTest() {
        clippedNavigationDrawer.show();
        clippedNavigationDrawer.is().clipped();
    }

    @Test(description = "Test checks drawer has dark theme")
    public void themeNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().darkTheme();
    }

    @Test(description = "Test checks that drawer expands on hover upon element")
    public void expandOnHoverNavigationDrawerTest() {
        expandOnHoverNavigationDrawer.show();
        expandOnHoverNavigationDrawer.is().collapsed();
        expandOnHoverNavigationDrawer.is().expandedOnHover();
        expandOnHoverNavigationDrawer.hover();
        expandOnHoverNavigationDrawer.is().expanded();
    }

    @Test(description = "Test checks that drawer has expected image with correct path")
    public void imagesNavigationDrawerTest() {
        String backgroundImageLink = "https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg";
        imagesNavigationDrawer.show();
        waitCondition(() -> imagesNavigationDrawer.backgroundImage().isLoaded());
        imagesNavigationDrawer.backgroundImage().has().sourcePath(backgroundImageLink);
    }

    @Test(description = "Test checks that drawer appears as it's mini variant")
    public void miniVariantNavigationDrawerTest() {
        miniVariantNavigationDrawer.show();
        miniVariantNavigationDrawer.is().miniVariant();
    }

    @Test(description = "Test checks that drawer is floating")
    public void floatingNavigationDrawerTest() {
        permanentAndFloatingNavigationDrawer.show();
        permanentAndFloatingNavigationDrawer.is().floating();
    }

    @Test(description = "Test checks that drawer is permament")
    public void permanentNavigationDrawerTest() {
        permanentAndFloatingNavigationDrawer.show();
        permanentAndFloatingNavigationDrawer.is().permanent();
    }

    @Test(description = "Test checks that drawer has expected height and width")
    public void heightNavigationDrawerTest() {
        imagesNavigationDrawer.show();
        imagesNavigationDrawer.has().height(300).and().width(300);
    }

    @Test(description = "Test checks that drawer is at the right side")
    public void rightNavigationDrawerTest() {
        rightNavigationDrawer.show();
        rightNavigationDrawer.is().right();
    }

    @Test(description = "Test checks overlay drawer has expected parameters")
    public void overlayTemporaryNavigationDrawerTest() {
        temporaryNavigationDrawer.show();
        temporaryNavigationDrawer.is().closed();
        temporaryNavigationDrawerButton.click();
        temporaryNavigationDrawer.is().opened();
        temporaryNavigationDrawer.is().temporary();
        temporaryNavigationDrawer.has().overlay();
        temporaryNavigationDrawer.overlay().is().displayed();
        temporaryNavigationDrawer.overlay().has().backgroundColor(GREY_DARKEN_4.value());
        temporaryNavigationDrawer.overlay().has().opacity(0.46);
    }

    @Test(description = "Test checks that drawer is not overlay")
    public void noOverlayNavigationDrawerTest() {
        rightNavigationDrawer.show();
        rightNavigationDrawer.has().noOverlay();
    }

    @Test(description = "Test checks background color of a drawer")
    public void colorNavigationDrawerTest() {
        coloredNavigationDrawer.show();
        coloredNavigationDrawer.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
    }
}
