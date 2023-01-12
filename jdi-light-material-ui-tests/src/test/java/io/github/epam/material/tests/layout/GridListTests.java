package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.gridListPage;
import static io.github.com.pages.layout.GridListPage.imageGridList;
import static io.github.com.pages.layout.GridListPage.singleLineGridList;
import static io.github.com.pages.layout.GridListPage.titleBarGridList;

import com.epam.jdi.light.material.elements.layout.GridListTile;
import io.github.epam.TestsInit;
import io.github.epam.test.data.GridListDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridListTests extends TestsInit {

    @BeforeClass
    public static void setup() {
        gridListPage.open();
        gridListPage.shouldBeOpened();
    }

    @Test(dataProviderClass = GridListDataProvider.class, dataProvider = "gridListItems")
    public static void imageGridListTest(int number, String name) {
        imageGridList.show();
        imageGridList.has().size(5);
        imageGridList.tile(number).has().alternativeImageText(name);
    }

    @Test(dataProviderClass = GridListDataProvider.class, dataProvider = "gridListItems")
    public static void singleLineGridTest(int number, String name) {
        singleLineGridList.show();
        singleLineGridList.has().size(5);
        GridListTile tile = singleLineGridList.tile(number);
        tile.has().alternativeImageText(name);
        tile.tileBar().has().title(name).and().hasAction();
    }

    @Test(dataProviderClass = GridListDataProvider.class, dataProvider = "titleBarGridListItems")
    public static void titleBarGridList(int number, String title, String subtitle) {
        titleBarGridList.show();
        titleBarGridList.has().size(6);
        titleBarGridList.tile(1).has().subheader("December");
        titleBarGridList.tile(number).tileBar().has().title(title)
                .and().subtitle(subtitle)
                .and().hasAction();
    }
}
