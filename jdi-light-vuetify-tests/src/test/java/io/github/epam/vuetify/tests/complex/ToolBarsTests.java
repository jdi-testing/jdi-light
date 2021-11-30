package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.StaticSite.toolbarsPage;
import static io.github.com.pages.ToolBarsPage.backgroundToolbar;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.denseToolbar;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.flexibleAndCardToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;
import static io.github.com.pages.ToolBarsPage.options;
import static io.github.com.pages.ToolBarsPage.optionsMenu;

public class ToolBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        toolbarsPage.open();
    }

    @Test
    public void backgroundToolbarTests() {
        backgroundToolbar.is().displayed();
        backgroundToolbar.menuButton().is().displayed();
        backgroundToolbar.has().textInTitle("Vuetify");
        backgroundToolbar.has().title();
        backgroundToolbar.has().exportButton();
        backgroundToolbar.has().backgroundImage();
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
        denseToolbar.has().title();
        denseToolbar.has().textInTitle("Title");
        denseToolbar.searchButton().is().displayed();
        denseToolbar.heartButton().is().displayed();
        denseToolbar.verticalDotsButton().is().displayed();
        denseToolbar.has().denseHeader();
        denseToolbar.has().heightOfHeader("48");
    }

    @Test
    public void extendedToolbarTests() {
        extendedToolbar.is().displayed();
        extendedToolbar.menuButton().is().displayed();
        extendedToolbar.has().title();
        extendedToolbar.has().textInTitle("Title");
        extendedToolbar.searchButton().is().displayed();
        extendedToolbar.heartButton().is().displayed();
        extendedToolbar.verticalDotsButton().is().displayed();
        extendedToolbar.has().extendedHeader();
        extendedToolbar.has().heightOfHeader("112");
    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.has().searchIcon();
        floatingWithSearchToolbar.verticalDotsButton().is().displayed();
        floatingWithSearchToolbar.has().gpsButton();
        floatingWithSearchToolbar.has().mapImage();
        floatingWithSearchToolbar.has().inputField();
        floatingWithSearchToolbar.has().notFocusedInputField();
        floatingWithSearchToolbar.sendTextToInputField("Find something");
        floatingWithSearchToolbar.has().focusedInputField();
        floatingWithSearchToolbar.verticalDotsButton().click();
        floatingWithSearchToolbar.has().notFocusedInputField();
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.is().displayed();
        contextActionToolbar.menuButton().is().displayed();
        contextActionToolbar.has().title();
        contextActionToolbar.has().textInTitle("Photos");
        contextActionToolbar.verticalDotsButton().is().displayed();
        contextActionToolbar.has().selectOptionsField();
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.clickOnSelectOptionsField();
        optionsMenu.is().displayed();
        for (UIElement element : options) {
            element.click();
        }
        contextActionToolbar.has().headerColor(GREY_DARKEN_4.value());
        contextActionToolbar.has().deleteButton();
        contextActionToolbar.has().closeButton();
        contextActionToolbar.has().textInTitle("4 selected");
        contextActionToolbar.verticalDotsButton().click();
        contextActionToolbar.has().selectedOptions("Foo,Bar,Fizz,Buzz");
        Timer.waitCondition(optionsMenu::isHidden);
        optionsMenu.is().hidden();
        contextActionToolbar.clickOnCloseButton();
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.has().textInTitle("Photos");
        contextActionToolbar.has().selectedOptions("");
        contextActionToolbar.has().hiddenButtons();
    }

    @Test
    public void flexibleAndCardToolbarTests() {
        flexibleAndCardToolbar.is().displayed();
        flexibleAndCardToolbar.menuButton().is().displayed();
        flexibleAndCardToolbar.has().title();
        flexibleAndCardToolbar.has().textInTitle("Title");
        flexibleAndCardToolbar.searchButton().is().displayed();
        flexibleAndCardToolbar.verticalDotsButton().is().displayed();
        flexibleAndCardToolbar.has().appsButton();
    }
}
