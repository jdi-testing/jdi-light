package io.github.epam.angular.tests.unit;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.gridListPage;
import static io.github.com.pages.GridListPage.basicGridList;
import static io.github.com.pages.GridListPage.dynamicGridList;
import static org.testng.Assert.assertTrue;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GridListUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        gridListPage.open();
        waitCondition(() -> gridListPage.isOpened());
        gridListPage.checkOpened();
    }

    @Test
    public void isDisplayedTest() {
        assertTrue(basicGridList.isDisplayed());
        assertTrue(dynamicGridList.isDisplayed());
    }

    @Test
    public void isVisible() {
        assertTrue(basicGridList.isVisible());
        assertTrue(dynamicGridList.isVisible());
    }
}
