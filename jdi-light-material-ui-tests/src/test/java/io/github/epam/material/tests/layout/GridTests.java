package io.github.epam.material.tests.layout;

import static io.github.com.StaticSite.defaultGridPage;
import static io.github.com.StaticSite.gridFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;



public class GridTests extends TestsInit {

    @Test
    public void mainGridTest() {
        defaultGridPage.open();
        gridFrame.rootGrid.is().displayed();
        gridFrame.rootGrid.is().attr("buttonitem", "[object Object]");
        gridFrame.rootGrid.is().attr("griditem", "[object Object]");
        gridFrame.firstButton.click();
        gridFrame.secondButton.click();
    }
}
