package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.dataDisplayInsetDividerPage;
import static io.github.com.StaticSite.dataDisplayVerticalDividerPage;
import static io.github.com.StaticSite.insetDividerFrame;
import static io.github.com.StaticSite.verticalDividerFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class DividerTests extends TestsInit {

    @Test
    public void insetDividerTest() {
        dataDisplayInsetDividerPage.open();
        insetDividerFrame.divider.is().inset();
    }

    @Test
    public void verticalDividerTest() {
        dataDisplayVerticalDividerPage.open();
        verticalDividerFrame.divider.is().vertical();
    }

}
