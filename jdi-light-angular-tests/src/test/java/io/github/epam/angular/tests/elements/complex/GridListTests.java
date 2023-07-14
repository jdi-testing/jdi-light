package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;
import static io.github.com.pages.GridListPage.basicGridList;
import static io.github.com.pages.GridListPage.dynamicGridList;
import static com.epam.jdi.light.angular.elements.enums.GridListColors.LIGHT_BLUE;
import static com.epam.jdi.light.angular.elements.enums.GridListColors.LIGHT_GREEN;
import static com.epam.jdi.light.angular.elements.enums.GridListColors.LIGHT_LILAC;
import static com.epam.jdi.light.angular.elements.enums.GridListColors.LIGHT_PINK;

public class GridListTests extends TestsInit {

    @BeforeMethod
    public void before() {
        gridListPage.open();
        waitCondition(() -> gridListPage.isOpened());
        gridListPage.checkOpened();
    }

    @Test(description = "Test checks basic grid list's number of columns")
    public void basicGridListNumberOfColumnsTest() {
        basicGridList.shouldBe().displayed();
        basicGridList.show();
        basicGridList.shouldBe().visible();
        basicGridList.has().numberOfColumns("2");
    }

    @Test(description = "Test checks basic grid list row's height")
    public void basicGridListRowHeightTest() {
        basicGridList.shouldBe().displayed();
        basicGridList.show();
        basicGridList.shouldBe().visible();
        basicGridList.has().rowHeight("2:1");
    }

    @Test(description = "Test checks basic grid list cell's text")
    public void basicGridListTextTest() {
        basicGridList.shouldBe().displayed();
        basicGridList.show();
        basicGridList.shouldBe().visible();
        basicGridList.has().cellText(1, "1");
    }

    @Test(description = "Test checks basic grid list cell's background color")
    public void basicGridListColorTest() {
        basicGridList.shouldBe().displayed();
        basicGridList.show();
        basicGridList.shouldBe().visible();
        basicGridList.has().cellBackgroundColor(1, LIGHT_BLUE.value());
    }

    @Test(description = "Test checks dynamic grid list's number of columns")
    public void dynamicGridListNumberOfColumnsTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has().numberOfColumns("4");
    }

    @Test(description = "Test checks dynamic grid list row's height")
    public void dynamicGridListRowHeight() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has().rowHeight("100px");
    }

    @Test(description = "Test checks dynamic grid list cell's text")
    public void dynamicGridListTextTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has().cellText(1, "One");
    }

    @Test(description = "Test checks dynamic grid list cell's background color")
    public void dynamicGridListColorTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has()
                       .cellBackgroundColor(1, LIGHT_BLUE.value())
                       .cellBackgroundColor(2, LIGHT_GREEN.value())
                       .cellBackgroundColor(3, LIGHT_PINK.value())
                       .cellBackgroundColor(4, LIGHT_LILAC.value());
    }

    @Test(description = "Test checks dynamic grid list cell's number of columns")
    public void dynamicGridListColumnsInCellTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has()
                       .numberOfColumnsInCell(1, "3")
                       .numberOfColumnsInCell(2, "1")
                       .numberOfColumnsInCell(3, "1")
                       .numberOfColumnsInCell(4, "2");
    }

    @Test(description = "Test checks dynamic grid list cell's number of rows")
    public void dynamicGridListRowsInCellTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();
        dynamicGridList.has()
                       .numberOfRowsInCell(1, "1")
                       .numberOfRowsInCell(2, "2")
                       .numberOfRowsInCell(3, "1")
                       .numberOfRowsInCell(4, "1");
    }
}
