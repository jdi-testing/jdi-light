package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.verticalDividerPage;
import static io.github.com.pages.displaydata.VerticalDividerPage.verticalDivider;

public class VerticalDividerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        verticalDividerPage.open();
        verticalDividerPage.isOpened();
    }

    @Test
    public void verticalDividerTest() {
        verticalDivider.is().vertical();
    }
}
