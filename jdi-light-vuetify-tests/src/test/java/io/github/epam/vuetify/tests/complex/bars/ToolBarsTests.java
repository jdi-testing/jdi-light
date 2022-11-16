package io.github.epam.vuetify.tests.complex.bars;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.toolbarsPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbarSelect;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.flatToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;
import static org.hamcrest.Matchers.containsString;

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
        extendedToolbar.findIconButton("mdi-magnify").is().displayed();
        extendedToolbar.findIconButton("mdi-heart").is().displayed();
        extendedToolbar.findIconButton("mdi-dots-vertical").is().displayed();
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
        contextActionToolbar.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value());
        contextActionToolbarSelect.expand();
        contextActionToolbarSelect.is().expanded();
        contextActionToolbarSelect.select("Foo", "Bar", "Fizz", "Buzz");
        contextActionToolbar.has().backgroundColor(GREY_DARKEN_4.value());
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

    @Test
    public void flatToolBarTest() {
        flatToolbar.show();
        flatToolbar.is().flat();
        collapseToolbar.is().notFlat();
    }
}
