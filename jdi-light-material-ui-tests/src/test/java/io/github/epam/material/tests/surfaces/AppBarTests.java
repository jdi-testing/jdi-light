package io.github.epam.material.tests.surfaces;

import com.epam.jdi.light.material.elements.inputs.MUIButton;
import com.jdiai.tools.Timer;
import io.github.com.custom.CustomAppBarContent;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.scrollToBottom;
import static io.github.com.StaticSite.backToTopPage;
import static io.github.com.StaticSite.bottomAppBarPage;
import static io.github.com.StaticSite.elevateAppBarPage;
import static io.github.com.StaticSite.hideAppBarPage;
import static io.github.com.StaticSite.simpleAppBarPage;
import static io.github.com.pages.surfaces.BackToTopAppBarPage.backToTopAppBar;
import static io.github.com.pages.surfaces.BackToTopAppBarPage.backToTopButton;
import static io.github.com.pages.surfaces.BottomAppBarPage.bottomAppBar;
import static io.github.com.pages.surfaces.ElevateAppBarPage.elevateAppBar;
import static io.github.com.pages.surfaces.HideAppBarPage.hideAppBar;
import static io.github.com.pages.surfaces.SimpleAppBarPage.appBarMenuItems;
import static io.github.com.pages.surfaces.SimpleAppBarPage.appBarWithMenu;
import static io.github.com.pages.surfaces.SimpleAppBarPage.searchAppBar;
import static io.github.com.pages.surfaces.SimpleAppBarPage.userIconSwitch;

public class AppBarTests extends TestsInit {
    private final Timer timer = new Timer(16000L);

    @Test(enabled = false)
    public void menuAppBarTest() {
        simpleAppBarPage.open();
        simpleAppBarPage.shouldBeOpened();

        appBarWithMenu.is().displayed();
        CustomAppBarContent appContent = appBarWithMenu.content(CustomAppBarContent.class);
        appContent.has().text("Photos");
        appBarWithMenu.buttonGroup().is().displayed().and().has().size(2);
        // @todo #5341 MUIList doesn't work properly with types, we do not need to cast here
        ((MUIButton)appBarWithMenu.buttonGroup().item(2)).click();
        appBarMenuItems.get(1).has().text("Profile");
        appBarMenuItems.get(1).click();

        userIconSwitch.uncheck();
        appBarWithMenu.buttonGroup().has().size(1);

        searchAppBar.content(CustomAppBarContent.class).searchField().is().displayed();

    }

    // @todo #5341 Fix this test after AppBar refactoring
    @Test(enabled = false)
    public void bottomAppBarTest() {
        bottomAppBarPage.open();
        bottomAppBarPage.shouldBeOpened();

        bottomAppBar.is().displayed().and().has().css("bottom", "0px");
        bottomAppBar.buttonGroup().is().displayed().and().has().size(4);
    }

    @Test
    public void hideAppBarTest() {
        hideAppBarPage.open();
        hideAppBarPage.shouldBeOpened();

        hideAppBar.is().displayed();
        hideAppBar.content(CustomAppBarContent.class).title().has().text("Scroll to Hide App Bar");
        scrollToBottom();
        timer.wait(() -> hideAppBar.is().hidden());
    }

    @Test
    public void elevateAppBarTest() {
        elevateAppBarPage.open();
        elevateAppBarPage.shouldBeOpened();

        elevateAppBar.is().displayed();
        elevateAppBar.content(CustomAppBarContent.class).title().has().text("Scroll to Elevate App Bar");
        elevateAppBar.has().cssClass("MuiPaper-elevation0");
        scrollToBottom();
        timer.wait(() -> elevateAppBar.has().cssClass("MuiPaper-elevation4"));
    }

    @Test
    public void backToTopTest() {
        backToTopPage.open();
        backToTopPage.shouldBeOpened();

        backToTopAppBar.content(CustomAppBarContent.class).title().has().text("Scroll to see button");
        backToTopButton.is().hidden();
        scrollToBottom();
        timer.wait(() -> backToTopButton.is().visible());
        backToTopButton.click();
        timer.wait(() -> backToTopButton.is().hidden());
    }
}
