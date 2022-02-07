package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.insetDividerPage;
import static io.github.com.pages.displaydata.InsetDividerPage.insetDividers;

/**
 * To see an example of Inset Divider web element please visit
 * https://material-ui.com/components/dividers/
 */

public class InsetDividerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        insetDividerPage.open();
        insetDividerPage.isOpened();
    }

    @Test
    public void insetDividerTest() {
        // TODO: add count check
        insetDividers.forEach(d -> d.is().inset());
    }
}
