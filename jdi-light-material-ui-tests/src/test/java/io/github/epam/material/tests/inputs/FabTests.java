package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.fabFrame;
import static io.github.com.StaticSite.inputFabDefaultPage;
import static io.github.com.StaticSite.inputFabDisabledPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.fail;

public class FabTests extends TestsInit {

    @Test
    public void defaultFabTest() {
        inputFabDefaultPage.open();

        fabFrame.fab.is().enabled();
        fabFrame.fab.click();
        fabFrame.fab.is().enabled();
    }

    @Test
    public void disabledFabTest() {
        inputFabDisabledPage.open();

        fabFrame.fab.is().disabled();
        try {
            fabFrame.fab.click();
            fail("Disabled button shouldn't work, but it does");
        } catch (ElementClickInterceptedException ex) {
            assertThat(safeException(ex),
                    containsString("element click intercepted"));
        }
    }

}
