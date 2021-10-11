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
    private final Timer timer = new Timer(2000L);

    @Test
    public void simpleAppBarTest() {
        simpleAppBarPage.open();
        simpleAppBarPage.shouldBeOpened();

        simpleAppBar.isDisplayed();
        simpleAppBar.getNavigationButton().isDisplayed();
        simpleAppBar.getNavigationButton().click();
        simpleAppBar.getTitle().has().text("News");
        simpleAppBar.getActionItems().get(1).isDisplayed();
        simpleAppBar.getActionItems().get(1).click();

        appBarMenu.getNavigationButton().isDisplayed();
        appBarMenu.getNavigationButton().click();
        appBarMenu.getTitle().has().text("Photos");
        appBarMenu.getOverflowMenuButton().isDisplayed();
        appBarMenu.getOverflowMenuButton().click();
        appBarMenuItems.get(1).has().text("Profile");
        appBarMenuItems.get(1).click();
        userIconSwitch.check();
        timer.wait(() -> appBarMenu.getOverflowMenuButton().isNotDisplayed());

        prominentMenu.getNavigationButton().isDisplayed();
        prominentMenu.getNavigationButton().click();
        prominentMenu.getTitle().has().text("Material-UI");
        prominentMenu.getActionItems().get(1).click();
        prominentMenu.getOverflowMenuButton().click();
    }

    @Test
    public void bottomAppBarTest() {
        bottomAppBarPage.open();
        bottomAppBarPage.shouldBeOpened();
        bottomAppBar.isDisplayed();

        bottomAppBar.getNavigationButton().isDisplayed();
        bottomAppBar.getNavigationButton().click();

        bottomAppBar.getActionItems().get(1).isDisplayed();
        bottomAppBar.getActionItems().get(1).click();
        bottomAppBar.getActionItems().get(2).isDisplayed();
        bottomAppBar.getActionItems().get(2).click();

        bottomAppBar.getOverflowMenuButton().isDisplayed();
        bottomAppBar.getOverflowMenuButton().click();
    }

    @Test
    public void hideAppBarTest() {
        hideAppBarPage.open();
        hideAppBarPage.shouldBeOpened();
        hideAppBar.isDisplayed();
        hideAppBar.getTitle().has().text("Scroll to Hide App Bar");
        scrollToBottom();
        timer.wait(() -> hideAppBar.isHidden());
    }

    @Test
    public void elevateAppBarTest() {
        elevateAppBarPage.open();
        elevateAppBarPage.shouldBeOpened();
        elevateAppBar.isDisplayed();
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
        backToTopButton.isHidden();
        scrollToBottom();
        timer.wait(() -> backToTopButton.isVisible());
        backToTopButton.click();
        timer.wait(() -> backToTopButton.isHidden());
    }
}
