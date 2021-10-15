package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.verticalDividerPage;
import static io.github.com.pages.displaydata.VerticalDividerPage.verticalDivider;

/**
 * To see an example of Vertical Divider web element please visit
 * https://material-ui.com/components/dividers/
 */

public class VerticalDividerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        verticalDividerPage.open();
        verticalDividerPage.isOpened();
    }

    @Test
    public void verticalDividerTest() {
        verticalDividerPage.open();
        verticalDivider.is().vertical();
    }
}
