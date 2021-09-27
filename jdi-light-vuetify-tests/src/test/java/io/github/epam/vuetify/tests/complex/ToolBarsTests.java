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
        backgroundToolbar.has().properTitleText("Vuetify");
        backgroundToolbar.has().title();
        backgroundToolbar.has().exportButton();
        backgroundToolbar.has().backgroundImage();
    }

    @Test
    public void collapseToolbarTests() {
        collapseToolbar.is().displayed();
        collapseToolbar.has().searchButton();
        collapseToolbar.has().verticalDotsButton();
    }

    @Test
    public void denseToolbarTests() {
        denseToolbar.is().displayed();
        denseToolbar.has().menuButton();
        denseToolbar.has().title();
        denseToolbar.has().properTitleText("Title");
        denseToolbar.has().searchButton();
        denseToolbar.has().heartButton();
        denseToolbar.has().verticalDotsButton();
    }

    @Test
    public void extendedToolbarTests() {
        extendedToolbar.is().displayed();
        extendedToolbar.has().menuButton();
        extendedToolbar.has().title();
        extendedToolbar.has().properTitleText("Title");
        extendedToolbar.has().searchButton();
        extendedToolbar.has().heartButton();
        extendedToolbar.has().verticalDotsButton();    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.has().searchButton();
        floatingWithSearchToolbar.has().verticalDotsButton();
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.is().displayed();
        contextActionToolbar.has().menuButton();
        contextActionToolbar.has().title();
        contextActionToolbar.has().properTitleText("Photos");
        contextActionToolbar.has().verticalDotsButton();
    }

    @Test
    public void flexibleAndCardToolbarTests() {
        flexibleAndCardToolbar.is().displayed();
        flexibleAndCardToolbar.has().menuButton();
        flexibleAndCardToolbar.has().title();
        flexibleAndCardToolbar.has().properTitleText("Title");
        flexibleAndCardToolbar.has().searchButton();
        flexibleAndCardToolbar.has().verticalDotsButton();
    }
}
