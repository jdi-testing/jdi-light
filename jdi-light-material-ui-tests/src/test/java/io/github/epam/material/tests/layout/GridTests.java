package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import io.github.epam.test.data.GridDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.gridPage;
import static io.github.com.pages.layout.GridPage.basicGrid;
import static io.github.com.pages.layout.GridPage.complexGrid;
import static io.github.com.pages.layout.GridPage.rootGrid;

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

    @Test(dataProviderClass = GridDataProvider.class, dataProvider = "basicGridItems")
    public void basicGridItemsTest(int itemIndex, String itemWidth, String itemClass) {
        rootGrid.is().displayed().and().has().cssClass("MuiContainer-maxWidthXl");
        basicGrid.show();
        basicGrid.is().displayed()
                .and().has().items(7);

        basicGrid.items().get(itemIndex)
                .has().cssClass(itemClass)
                .and().css("max-width", itemWidth);
    }

    @Test(dataProviderClass = GridDataProvider.class, dataProvider = "complexGridItems")
    public void complexGridItemsTest(int itemIndex, String itemText) {
        rootGrid.is().displayed().and().has().cssClass("MuiContainer-maxWidthXl");
        complexGrid.show();
        complexGrid.is().displayed()
                .and().has().items(6);

        complexGrid.items().get(itemIndex).has().text(itemText);
    }
}
