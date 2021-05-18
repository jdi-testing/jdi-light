package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.insetDividerPage;
import static io.github.com.StaticSite.verticalDividerPage;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class DividerTests extends TestsInit {

    @Test
    public void insetDividerTest() {
        insetDividerPage.open();
        insetDividerPage.divider.is().inset();
    }

    @Test
    public void verticalDividerTest() {
        verticalDividerPage.open();
        verticalDividerPage.divider.is().vertical();
    }

}
