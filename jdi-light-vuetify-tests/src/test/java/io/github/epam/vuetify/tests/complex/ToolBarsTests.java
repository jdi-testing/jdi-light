package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREY_DARKEN_4;
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
    public void beforeTest() {
        toolbarsPage.open();
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
        collapseToolbar.is().collapsed();
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
        denseToolbar.is().dense();
        denseToolbar.has().height("48");
    }

    @Test
    public void extendedToolbarTests() {
        extendedToolbar.is().displayed();
        extendedToolbar.has().menuButton();
        extendedToolbar.has().title();
        extendedToolbar.has().properTitleText("Title");
        extendedToolbar.has().searchButton();
        extendedToolbar.has().heartButton();
        extendedToolbar.has().verticalDotsButton();
        extendedToolbar.is().extended();
        extendedToolbar.has().height("112");
    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.has().searchButton();
        floatingWithSearchToolbar.has().verticalDotsButton();
        floatingWithSearchToolbar.has().gpsButton();
        floatingWithSearchToolbar.has().mapImage();
        floatingWithSearchToolbar.has().input();
        floatingWithSearchToolbar.is().inputNotFocused();
        floatingWithSearchToolbar.getInput().select();
        floatingWithSearchToolbar.getInput().sendKeys("Find something");
        floatingWithSearchToolbar.is().inputFocused();
        floatingWithSearchToolbar.getGpsButton().click();
        floatingWithSearchToolbar.is().inputNotFocused();
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.is().displayed();
        contextActionToolbar.has().menuButton();
        contextActionToolbar.has().title();
        contextActionToolbar.has().properTitleText("Photos");
        contextActionToolbar.has().verticalDotsButton();
        contextActionToolbar.has().selectOptionsField();
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.getSelectOptionsField().click();
        Timer.waitCondition(optionsMenu::isDisplayed);
        optionsMenu.is().displayed();
        for (UIElement element : options) {
            element.click();
        }
        contextActionToolbar.has().headerColor(GREY_DARKEN_4.value());
        contextActionToolbar.has().deleteButton();
        contextActionToolbar.has().closeButton();
        contextActionToolbar.has().properTitleText("4 selected");
        contextActionToolbar.getVerticalDotsButton().click();
        contextActionToolbar.has().selectedOptions("Foo,Bar,Fizz,Buzz");
        optionsMenu.is().hidden();
        contextActionToolbar.getCloseButton().click();
        Timer.waitCondition(contextActionToolbar::isPurple);
        contextActionToolbar.has().headerColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbar.has().properTitleText("Photos");
        contextActionToolbar.has().selectedOptions("");
        contextActionToolbar.getCloseButton().is().hidden();
        contextActionToolbar.getDeleteButton().is().hidden();
    }

    @Test
    public void flexibleAndCardToolbarTests() {
        flexibleAndCardToolbar.is().displayed();
        flexibleAndCardToolbar.has().menuButton();
        flexibleAndCardToolbar.has().title();
        flexibleAndCardToolbar.has().properTitleText("Title");
        flexibleAndCardToolbar.has().searchButton();
        flexibleAndCardToolbar.has().verticalDotsButton();
        flexibleAndCardToolbar.has().appsButton();
    }
}
