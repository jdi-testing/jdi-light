package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.enums.Colors.LIGHT_BLUE;
import static io.github.com.enums.Colors.LIGHT_GREEN;
import static io.github.com.enums.Colors.LIGHT_LILAC;
import static io.github.com.enums.Colors.LIGHT_PINK;
import static io.github.com.pages.AngularPage.gridListSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

// TODO Move to the new page
@Ignore
public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test(description = "Test checks basic grid's number of columns")
    public void basicGridListNumberOfColumnsTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().numberOfColumns("2");
    }

    @Test(description = "Test checks basic grid row's height")
    public void basicGridListRowHeightTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().rowHeight("2:1");
    }

    @Test(description = "Test checks basic grid cell's text")
    public void basicGridListTextTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().cellText(1, "1");
    }

    @Test(description = "Test checks basic grid cell's background color")
    public void basicGridListColorTest() {
        gridListSection.basicGridList.show();
        gridListSection.basicGridList.has().cellBackgroundColor(1, LIGHT_BLUE.value());
    }

    @Test(description = "Test checks dynamic grid's number of columns")
    public void dynamicGridListNumberOfColumnsTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has().numberOfColumns("4");
    }

    @Test(description = "Test checks dynamic grid row's height")
    public void dynamicGridListRowHeight() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has().rowHeight("100px");
    }

    @Test(description = "Test checks dynamic grid cell's text")
    public void dynamicGridListTextTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has().cellText(1, "One");
    }

    @Test(description = "Test checks dynamic grid cell's background color")
    public void dynamicGridListColorTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has()
                                       .cellBackgroundColor(1, LIGHT_BLUE.value())
                                       .cellBackgroundColor(2, LIGHT_GREEN.value())
                                       .cellBackgroundColor(3, LIGHT_PINK.value())
                                       .cellBackgroundColor(4, LIGHT_LILAC.value());
    }

    @Test(description = "Test checks dynamic grid's cell number of columns")
    public void dynamicGridListColumnsInCellTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has()
                                       .numberOfColumnsInCell(1, "3")
                                       .numberOfColumnsInCell(2, "1")
                                       .numberOfColumnsInCell(3, "1")
                                       .numberOfColumnsInCell(4, "2");
    }

    @Test(description = "Test checks dynamic grid's cell number of rows")
    public void dynamicGridListRowsInCellTest() {
        gridListSection.dynamicGridList.show();
        gridListSection.dynamicGridList.has()
                                       .numberOfRowsInCell(1, "1")
                                       .numberOfRowsInCell(2, "2")
                                       .numberOfRowsInCell(3, "1")
                                       .numberOfRowsInCell(4, "1");
    }
}
