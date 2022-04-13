package io.github.epam.material.tests.surfaces;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.scrollToBottom;
import static io.github.com.StaticSite.backToTopPage;
import static io.github.com.StaticSite.bottomAppBarPage;
import static io.github.com.StaticSite.elevateAppBarPage;
import static io.github.com.StaticSite.hideAppBarPage;
import static io.github.com.StaticSite.simpleAppBarPage;
import static io.github.com.pages.surfaces.AppBarPage.appBarMenu;
import static io.github.com.pages.surfaces.AppBarPage.appBarMenuItems;
import static io.github.com.pages.surfaces.AppBarPage.prominentMenu;
import static io.github.com.pages.surfaces.AppBarPage.simpleAppBar;
import static io.github.com.pages.surfaces.AppBarPage.userIconSwitch;
import static io.github.com.pages.surfaces.BackToTopPage.backToTopAppBar;
import static io.github.com.pages.surfaces.BackToTopPage.backToTopButton;
import static io.github.com.pages.surfaces.BottomAppBarPage.bottomAppBar;
import static io.github.com.pages.surfaces.ElevateAppBar.elevateAppBar;
import static io.github.com.pages.surfaces.HideAppBarPage.hideAppBar;

/**
 * To see an example of App Bar web element please visit
 * https://material-ui.com/components/app-bar/
 */

public class AppBarTests extends TestsInit {
    private final Timer timer = new Timer(16000L);

    @Test
    public void simpleAppBarTest() {
        simpleAppBarPage.open();
        simpleAppBarPage.shouldBeOpened();

        simpleAppBar.is().displayed();
        simpleAppBar.getNavigationButton().is().displayed();
        simpleAppBar.getTitle().has().text("News");
        simpleAppBar.getActionItems().get(1).is().displayed();

        appBarMenu.getNavigationButton().is().displayed();
        appBarMenu.getTitle().has().text("Photos");
        appBarMenu.getOverflowMenuButton().is().displayed();
        appBarMenu.getOverflowMenuButton().click();
        appBarMenuItems.get(1).has().text("Profile");
        appBarMenuItems.get(1).click();
        userIconSwitch.check();
        timer.wait(() -> appBarMenu.getOverflowMenuButton().is().visible());
        prominentMenu.getNavigationButton().is().displayed();
        prominentMenu.getTitle().has().text("Material-UI");
    }

    @Test
    public void bottomAppBarTest() {
        bottomAppBarPage.open();
        bottomAppBarPage.shouldBeOpened();
        bottomAppBar.is().displayed()
            .and().css("bottom", "0px");

        bottomAppBar.getNavigationButton().is().displayed();

        bottomAppBar.getActionItems().get(1).is().displayed();
        bottomAppBar.getActionItems().get(2).is().displayed();

        bottomAppBar.getOverflowMenuButton().is().displayed();
    }

    @Test
    public void hideAppBarTest() {
        hideAppBarPage.open();
        hideAppBarPage.shouldBeOpened();
        hideAppBar.is().displayed();
        hideAppBar.getTitle().has().text("Scroll to Hide App Bar");
        scrollToBottom();
        timer.wait(() -> hideAppBar.is().hidden());
    }

    @Test
    public void elevateAppBarTest() {
        elevateAppBarPage.open();
        elevateAppBarPage.shouldBeOpened();
        elevateAppBar.is().displayed();
        elevateAppBar.getTitle().has().text("Scroll to Elevate App Bar");
        elevateAppBar.isElevated();
        scrollToBottom();
        timer.wait(() -> elevateAppBar.isNotElevated());
    }

    @Test
    public void backToTopTest() {
        backToTopPage.open();
        backToTopPage.shouldBeOpened();
        backToTopAppBar.getTitle().has().text("Scroll to see button");
        backToTopButton.is().hidden();
        scrollToBottom();
        timer.wait(() -> backToTopButton.is().visible());
        backToTopButton.click();
        timer.wait(() -> backToTopButton.is().hidden());
    }
}
