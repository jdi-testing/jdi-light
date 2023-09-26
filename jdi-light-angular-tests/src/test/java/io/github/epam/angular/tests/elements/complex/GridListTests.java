package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.angular.elements.enums.Colors.LIGHT_BLUE_2;
import static com.epam.jdi.light.angular.elements.enums.Colors.LIGHT_GREEN_2;
import static com.epam.jdi.light.angular.elements.enums.Colors.LIGHT_LILAC;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;
import static io.github.com.pages.GridListPage.basicGridList;
import static io.github.com.pages.GridListPage.dynamicGridList;

public class GridListTests extends TestsInit {

    @BeforeClass
    public void before() {
        gridListPage.open();
        waitCondition(() -> gridListPage.isOpened());
        gridListPage.checkOpened();
    }

    @Test(description = "Test checks basic grid list attributes")
    public void basicGridListTest() {
        basicGridList.shouldBe().displayed();
        basicGridList.show();
        basicGridList.shouldBe().visible();

        basicGridList.has().numberOfColumnsInGridList("2")
                     .and().rowHeight("2:1")
                     .and().gutterSize("10px")

                     .and().cellText(1, "1")
                     .and().cellBackgroundColor(1, LIGHT_BLUE_2.value())
                     .and().numberOfColumnsInCell(1, "1")
                     .and().numberOfRowsInCell(1, "1");
    }

    @Test(description = "Test checks dynamic grid list attributes")
    public void dynamicGridListTest() {
        dynamicGridList.shouldBe().displayed();
        dynamicGridList.show();
        dynamicGridList.shouldBe().visible();

        dynamicGridList.has().numberOfColumnsInGridList("4")
                       .and().rowHeight("100px")
                       .and().gutterSize("10px")

                       .and().cellText(1, "One")
                       .and().cellText(4, "Four")

                       .and().cellBackgroundColor(2, LIGHT_GREEN_2.value())
                       .and().cellBackgroundColor(4, LIGHT_LILAC.value())

                       .and().numberOfColumnsInCell(1, "3")
                       .and().numberOfColumnsInCell(2, "1")
                       .and().numberOfColumnsInCell(4, "2")

                       .and().numberOfRowsInCell(1, "1")
                       .and().numberOfRowsInCell(2, "2");
    }
}
