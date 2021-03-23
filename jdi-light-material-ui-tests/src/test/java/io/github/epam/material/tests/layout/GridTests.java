package io.github.epam.material.tests.layout;

import static io.github.com.pages.layouts.GridFrame.*;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.epam.States.shouldBeLoggedIn;


public class GridTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        defaultGridPage.shouldBeOpened();
    }

    @Test
    public void mainGridTest() {
        rootGrid.is().displayed();
        rootGrid.is().attr("buttonitem", "[object Object]");
        rootGrid.is().attr("griditem", "[object Object]");
        firstButton.click();
        secondButton.click();
    }


}
