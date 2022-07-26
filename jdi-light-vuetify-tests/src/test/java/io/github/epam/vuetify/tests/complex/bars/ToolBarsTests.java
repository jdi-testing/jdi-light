package io.github.epam.vuetify.tests.complex.bars;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.toolbarsPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbarSelect;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;
import io.github.epam.TestsInit;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ToolBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        toolbarsPage.open();
        waitCondition(() -> toolbarsPage.isOpened());
        toolbarsPage.checkOpened();
    }

    @Test
    public void collapseToolbarTests() {
        collapseToolbar.show();
        collapseToolbar.is().displayed();
        collapseToolbar.is().collapsed();
    }

    @Test
    public void extendedToolbarTests() {
        extendedToolbar.show();
        extendedToolbar.is().displayed().and().expanded();
        extendedToolbar.has().text("Title");
        extendedToolbar.searchButton().is().displayed();
        extendedToolbar.heartButton().is().displayed();
        extendedToolbar.verticalDotsButton().is().displayed();
        extendedToolbar.has().classValue(containsString("extended"));
        extendedToolbar.has().attr("style", "height: 112px;");
    }

    @Test
    public void floatingWithSearchToolbarTests() {
        floatingWithSearchToolbar.show();
        floatingWithSearchToolbar.is().displayed();
        floatingWithSearchToolbar.searchField().input("City of London");
        floatingWithSearchToolbar.searchField().has().text(containsString("City of London"));
        floatingWithSearchToolbar.searchField().prependOuterIcon().is().displayed();
        floatingWithSearchToolbar.has().classValue(containsString("floating"))
                .and().classValue(containsString("dense"));
    }

    @Test
    public void contextActionToolbarTests() {
        contextActionToolbar.show();
        contextActionToolbar.is().displayed();
        contextActionToolbar.has().text("Photos");
        contextActionToolbar.has().color(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbarSelect.expand();
        contextActionToolbarSelect.is().expanded();
        contextActionToolbarSelect.select("Foo", "Bar", "Fizz", "Buzz");
        contextActionToolbar.has().color(GREY_DARKEN_4.value());
        contextActionToolbar.deleteButton().is().displayed();
        contextActionToolbar.closeButton().is().displayed();
        contextActionToolbar.has().text("4 selected");
        contextActionToolbarSelect.close();
        waitCondition(() -> !contextActionToolbarSelect.isExpanded());
        contextActionToolbarSelect.has().selected("Foo,Bar,Fizz,Buzz");
        contextActionToolbar.closeButton().click();
        contextActionToolbar.has().text("Photos");
        contextActionToolbarSelect.has().selected("");
    }
}
