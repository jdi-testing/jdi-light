package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.gridPage;
import static io.github.com.pages.layout.GridPage.basicGrid;
import static io.github.com.pages.layout.GridPage.complexGrid;
import static io.github.com.pages.layout.GridPage.rootGrid;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * To see an example of Grid web element please visit
 * https://material-ui.com/components/grid/
 */

public class GridTests extends TestsInit {

    @BeforeMethod
    public void before() {
        gridPage.open();
        gridPage.shouldBeOpened();
    }

    @Test(dataProvider = "basicGridItems")
    public void basicGridItemsTest(int itemIndex, String itemWidth, String itemClass) {
        rootGrid.is().displayed().and().has().cssClass("MuiContainer-maxWidthXl");
        basicGrid.show();
        basicGrid.is().displayed()
                .and().has().items(7);

        basicGrid.items().get(itemIndex)
                .has().cssClass(itemClass)
                .and().css("max-width", itemWidth);
    }

    @Test(dataProvider = "complexGridItems")
    public void complexGridItemsTest(int itemIndex, String itemText) {
        rootGrid.is().displayed().and().has().cssClass("MuiContainer-maxWidthXl");
        complexGrid.show();
        complexGrid.is().displayed()
                .and().has().items(6);

        complexGrid.items().get(itemIndex).has().text(itemText);
    }

    @DataProvider
    public Object[][] basicGridItems() {
        return new Object[][]{
                {1, "100%", "MuiGrid-grid-xs-12"},
                {2, "50%", "MuiGrid-grid-xs-6"},
                {3, "50%", "MuiGrid-grid-xs-6"},
                {4, "25%", "MuiGrid-grid-xs-3"},
                {5, "25%", "MuiGrid-grid-xs-3"},
                {6, "25%", "MuiGrid-grid-xs-3"},
                {7, "25%", "MuiGrid-grid-xs-3"},
        };
    }

    @DataProvider
    public Object[][] complexGridItems() {
        return new Object[][]{
                {2, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114\nRemove\n$19.00"},
                {3, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114\nRemove"},
                {4, "Standard license\nFull resolution 1920x1080 • JPEG\nID: 1030114"},
                {5, "Remove"},
                {6, "$19.00"},
        };
    }
}
