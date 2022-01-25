package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.toolbarsPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.pages.ToolBarsPage.backgroundToolbar;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.denseToolbar;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.flexibleAndCardToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;

public class ToolBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        toolbarsPage.open();
        waitCondition(() -> toolbarsPage.isOpened());
        toolbarsPage.checkOpened();
    }

    @Test
    public void backgroundToolbarTests() {
        backgroundToolbar.is().displayed();
        backgroundToolbar.menuButton().is().displayed();
        backgroundToolbar.title().is().displayed();
        backgroundToolbar.title().has().text("Vuetify");
        backgroundToolbar.exportButton().is().displayed();
        backgroundToolbar.backgroundImage().is().displayed();
    }

    @Test
    public void collapseToolbarTests() {
        collapseToolbar.is().displayed();
        collapseToolbar.searchButton().is().displayed();
        collapseToolbar.verticalDotsButton().is().displayed();
        collapseToolbar.has().collapsedHeader();
    }

    @Test
    public void denseToolbarTests() {
        denseToolbar.is().displayed();
        denseToolbar.menuButton().is().displayed();
        denseToolbar.title().is().displayed();
        denseToolbar.title().has().text("Title");
        denseToolbar.searchButton().is().displayed();
        denseToolbar.heartButton().is().displayed();
        denseToolbar.verticalDotsButton().is().displayed();
        denseToolbar.has().denseHeader();
        denseToolbar.has().heightOfHeader(48);
    }

    @Test
    public void extendedToolbarTests() {
        extendedToolbar.is().displayed();
        extendedToolbar.menuButton().is().displayed();
        extendedToolbar.title().is().displayed();
        extendedToolbar.title().has().text("Title");
        extendedToolbar.searchButton().is().displayed();
        extendedToolbar.heartButton().is().displayed();
        extendedToolbar.verticalDotsButton().is().displayed();
        extendedToolbar.has().extendedHeader();
        extendedToolbar.has().heightOfHeader(112);
    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.searchIcon().is().displayed();
        floatingWithSearchToolbar.verticalDotsButton().is().displayed();
        floatingWithSearchToolbar.gpsButton().is().displayed();
        floatingWithSearchToolbar.backgroundImage().is().displayed();
        floatingWithSearchToolbar.input().is().displayed();
        floatingWithSearchToolbar.input().is().notFocused();
        floatingWithSearchToolbar.input().clearAndTypeText("Find something");
        floatingWithSearchToolbar.input().is().focused();
        floatingWithSearchToolbar.verticalDotsButton().click();
        floatingWithSearchToolbar.input().is().notFocused();
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.is().displayed();
        contextActionToolbar.menuButton().is().displayed();
        contextActionToolbar.title().is().displayed();
        contextActionToolbar.title().has().text("Photos");
        contextActionToolbar.verticalDotsButton().is().displayed();
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.select().expand();
        contextActionToolbar.select().is().expanded();
        contextActionToolbar.select().select("Foo", "Bar", "Fizz", "Buzz");
        contextActionToolbar.has().headerColor(GREY_DARKEN_4.value());
        contextActionToolbar.deleteButton().is().displayed();
        contextActionToolbar.closeButton().is().displayed();
        contextActionToolbar.title().has().text("4 selected");
        contextActionToolbar.select().close();
        contextActionToolbar.select().is().collapsed();
        contextActionToolbar.select().has().selected("Foo,Bar,Fizz,Buzz");
        contextActionToolbar.closeButton().click();
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.title().has().text("Photos");
        contextActionToolbar.select().has().selected("");
        contextActionToolbar.has().hiddenButtons();
    }

    @Test
    public void flexibleAndCardToolbarTests() {
        flexibleAndCardToolbar.is().displayed();
        flexibleAndCardToolbar.menuButton().is().displayed();
        flexibleAndCardToolbar.title().is().displayed();
        flexibleAndCardToolbar.title().has().text("Title");
        flexibleAndCardToolbar.searchButton().is().displayed();
        flexibleAndCardToolbar.verticalDotsButton().is().displayed();
        flexibleAndCardToolbar.appsButton().is().displayed();
    }
}
