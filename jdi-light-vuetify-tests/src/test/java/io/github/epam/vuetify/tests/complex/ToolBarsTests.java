package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.toolBarsPage;
import static io.github.com.pages.ToolBarsPage.backgroundToolbar;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.denseToolbar;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.flexibleAndCardToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;

public class ToolBarsTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        toolBarsPage.open();
    }

    @Test
    public void backgroundToolbarTests() {
        backgroundToolbar.is().displayed();
        backgroundToolbar.has().menuButton();
        backgroundToolbar.has().properTitleText("Collapsing Bar");
        backgroundToolbar.has().title();
    }

    @Test
    public void collapseToolbarTests() {
        collapseToolbar.is().displayed();
        collapseToolbar.has().menuButton();
        collapseToolbar.has().properTitleText("Collapsing Bar");
        collapseToolbar.has().title();
    }

    @Test
    public void denseToolbarTests() {
        denseToolbar.is().displayed();
        denseToolbar.has().menuButton();
        denseToolbar.has().properTitleText("Collapsing Bar");
        denseToolbar.has().title();
    }

    @Test
    public void extendedToolbar() {
        extendedToolbar.is().displayed();
        extendedToolbar.has().menuButton();
        extendedToolbar.has().properTitleText("Collapsing Bar");
        extendedToolbar.has().title();
    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.has().menuButton();
        floatingWithSearchToolbar.has().properTitleText("Collapsing Bar");
        floatingWithSearchToolbar.has().title();
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.is().displayed();
        contextActionToolbar.has().menuButton();
        contextActionToolbar.has().properTitleText("Collapsing Bar");
        contextActionToolbar.has().title();
    }

    @Test
    public void flexibleAndCardToolbarTests() {
        flexibleAndCardToolbar.is().displayed();
        flexibleAndCardToolbar.has().menuButton();
        flexibleAndCardToolbar.has().properTitleText("Collapsing Bar");
        flexibleAndCardToolbar.has().title();
    }
}
