package io.github.epam.vuetify.tests.complex.bars;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.toolbarsPage;
import static io.github.com.enums.Colors.DEEP_PURPLE_ACCENT_4;
import static io.github.com.enums.Colors.GREY_DARKEN_4;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.enums.MdiIcons.DOTS_VERTICAL;
import static io.github.com.enums.MdiIcons.HEART;
import static io.github.com.enums.MdiIcons.MAGNIFY;
import static io.github.com.pages.ToolBarsPage.backgroundToolbar;
import static io.github.com.pages.ToolBarsPage.collapseToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbar;
import static io.github.com.pages.ToolBarsPage.contextActionToolbarSelect;
import static io.github.com.pages.ToolBarsPage.denseToolbar;
import static io.github.com.pages.ToolBarsPage.extendedToolbar;
import static io.github.com.pages.ToolBarsPage.flatToolbar;
import static io.github.com.pages.ToolBarsPage.floatingWithSearchToolbar;
import static io.github.com.pages.ToolBarsPage.variousAttributesToolbar;
import static org.hamcrest.Matchers.containsString;

public class ToolBarsTests extends TestsInit {

    @BeforeClass
    public void before() {
        toolbarsPage.open();
        waitCondition(() -> toolbarsPage.isOpened());
        toolbarsPage.checkOpened();
    }

    @Test(description = "Test checks if toolbar is expanded or collapsed")
    public void collapseToolbarTests() {
        collapseToolbar.show();
        collapseToolbar.is().displayed().and().collapsed();
        extendedToolbar.show();
        extendedToolbar.is().displayed().and().expanded();
    }

    @Test(description = "Test checks toolbar's title text")
    public void titleTextToolbarTests() {
        extendedToolbar.show();
        extendedToolbar.has().text("Title");
        extendedToolbar.fields().get(1).has().text("Title");
    }

    @Test(description = "Test checks toolbar's icon-buttons")
    public void iconButtonsToolbarTests() {
        extendedToolbar.show();
        extendedToolbar.buttons().get(1).hasClass(MAGNIFY.mdi());
        extendedToolbar.findIconButton(MAGNIFY.mdi()).is().displayed();
        extendedToolbar.findIconButton(HEART.mdi()).is().displayed();
        extendedToolbar.findIconButton(DOTS_VERTICAL.mdi()).is().displayed();
    }

    @Test(description = "Test checks if toolbar is extended or not")
    public void extendedToolbarTests() {
        extendedToolbar.show();
        extendedToolbar.is().extended();
        floatingWithSearchToolbar.show();
        floatingWithSearchToolbar.is().notExtended();
    }

    @Test(description = "Test checks custom toolbar's search field")
    public void withSearchToolbarTests() {
        floatingWithSearchToolbar.show();
        floatingWithSearchToolbar.searchField().input("City of London");
        floatingWithSearchToolbar.searchField().has().text(containsString("City of London"));
        floatingWithSearchToolbar.searchField().prependOuterIcon().is().displayed();
    }

    @Test(description = "Test checks is toolbar is floating or not")
    public void floatingToolbarTests() {
        floatingWithSearchToolbar.show();
        floatingWithSearchToolbar.is().floating();
        contextActionToolbar.show();
        contextActionToolbar.is().notFloating();
    }

    @Test(description = "Test checks toolbar's items selection")
    public void contextActionToolbarTests() {
        contextActionToolbar.show();
        contextActionToolbarSelect.expand();
        contextActionToolbarSelect.is().expanded();
        contextActionToolbarSelect.select("Foo", "Bar", "Fizz", "Buzz");
        contextActionToolbar.has().backgroundColor(GREY_DARKEN_4.value())
                .and().text("4 selected");
        contextActionToolbarSelect.close();
        waitCondition(() -> !contextActionToolbarSelect.isExpanded());
        contextActionToolbarSelect.has().selected("Foo,Bar,Fizz,Buzz");
        contextActionToolbar.findIconButton("mdi-close").click();
        contextActionToolbarSelect.has().selected("");
    }

    @Test(description = "Test checks toolbar's color")
    public void colorToolbarTest() {
        contextActionToolbar.show();
        contextActionToolbar.has().backgroundColor(DEEP_PURPLE_ACCENT_4.value())
                .and().color(WHITE.value());
    }

    @Test(description = "Test checks if toolbar is flat or not")
    public void flatToolBarTest() {
        flatToolbar.show();
        flatToolbar.is().flat();
        collapseToolbar.show();
        collapseToolbar.is().notFlat();
    }

    @Test(description = "Test checks if toolbar is dense or not")
    public void denseToolBarTest() {
        denseToolbar.show();
        denseToolbar.is().dense();
        collapseToolbar.show();
        collapseToolbar.is().notDense();
    }

    @Test(description = "Test checks if toolbar is shaped or not")
    public void shapedToolBarTest() {
        variousAttributesToolbar.get(2).show();
        variousAttributesToolbar.get(2).is().shaped();
        variousAttributesToolbar.get(1).is().notShaped();
    }

    @Test(description = "Test checks if toolbar is outlined or not")
    public void outlinedToolBarTest() {
        variousAttributesToolbar.get(1).show();
        variousAttributesToolbar.get(1).is().outlined();
        variousAttributesToolbar.get(2).is().notOutlined();
    }

    @Test(description = "Test checks if toolbar is prominent or not")
    public void prominentToolBarTest() {
        backgroundToolbar.show();
        backgroundToolbar.is().prominent();
        collapseToolbar.show();
        collapseToolbar.is().notProminent();
    }

    @Test(description = "Test checks if toolbar is elevated or not")
    public void elevatedToolBarTest() {
        variousAttributesToolbar.get(2).show();
        variousAttributesToolbar.get(2).is().elevated()
                .and().has().elevation(10);
        variousAttributesToolbar.get(1).is().notElevated();
    }

    @Test(description = "Test checks if toolbar has background image or not")
    public void backgroundImageToolBarTest() {
        backgroundToolbar.show();
        backgroundToolbar.has().backgroundImage();
        collapseToolbar.show();
        collapseToolbar.has().notBackgroundImage();
    }

    @Test(description = "Test checks toolbar's theme")
    public void themeToolBarTest() {
        backgroundToolbar.show();
        backgroundToolbar.has().darkTheme();
        collapseToolbar.show();
        collapseToolbar.has().lightTheme();
    }
}