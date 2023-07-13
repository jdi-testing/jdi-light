package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.enums.Colors.LIGHT_GREEN;
import static io.github.com.enums.Colors.LIGHT_LILAC;
import static io.github.com.enums.Colors.LIGHT_PINK;

public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        gridListPage.open();
        waitCondition(() -> gridListPage.isOpened());
        gridListPage.checkOpened();
    }

    @Test(description = "Test checks basic grid list's number of columns")
    public void basicGridListNumberOfColumnsTest() {
        gridListPage.basicGridList.show();
        gridListPage.basicGridList.has().numberOfColumns("2");
    }

    @Test(description = "Test checks basic grid list row's height")
    public void basicGridListRowHeightTest() {
        gridListPage.basicGridList.show();
        gridListPage.basicGridList.has().rowHeight("2:1");
    }

    @Test(description = "Test checks basic grid list cell's text")
    public void basicGridListTextTest() {
        gridListPage.basicGridList.show();
        gridListPage.basicGridList.has().cellText(1, "1");
    }

    @Test(description = "Test checks basic grid list cell's background color")
    public void basicGridListColorTest() {
        gridListPage.basicGridList.show();
        gridListPage.basicGridList.has().cellBackgroundColor(1, LIGHT_BLUE.value());
    }

    @Test(description = "Test checks dynamic grid list's number of columns")
    public void dynamicGridListNumberOfColumnsTest() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has().numberOfColumns("4");
    }

    @Test(description = "Test checks dynamic grid list row's height")
    public void dynamicGridListRowHeight() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has().rowHeight("100px");
    }

    @Test(description = "Test checks dynamic grid list cell's text")
    public void dynamicGridListTextTest() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has().cellText(1, "One");
    }

    @Test(description = "Test checks dynamic grid list cell's background color")
    public void dynamicGridListColorTest() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has()
                                    .cellBackgroundColor(1, LIGHT_BLUE.value())
                                    .cellBackgroundColor(2, LIGHT_GREEN.value())
                                    .cellBackgroundColor(3, LIGHT_PINK.value())
                                    .cellBackgroundColor(4, LIGHT_LILAC.value());
    }

    @Test(description = "Test checks dynamic grid list cell's number of columns")
    public void dynamicGridListColumnsInCellTest() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has()
                                    .numberOfColumnsInCell(1, "3")
                                    .numberOfColumnsInCell(2, "1")
                                    .numberOfColumnsInCell(3, "1")
                                    .numberOfColumnsInCell(4, "2");
    }

    @Test(description = "Test checks dynamic grid list cell's number of rows")
    public void dynamicGridListRowsInCellTest() {
        gridListPage.dynamicGridList.show();
        gridListPage.dynamicGridList.has()
                                    .numberOfRowsInCell(1, "1")
                                    .numberOfRowsInCell(2, "2")
                                    .numberOfRowsInCell(3, "1")
                                    .numberOfRowsInCell(4, "1");
    }
}
