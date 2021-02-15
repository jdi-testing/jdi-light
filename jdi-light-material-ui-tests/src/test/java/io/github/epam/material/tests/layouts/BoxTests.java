package io.github.epam.material.tests.layouts;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.fail;

public class BoxTests extends TestsInit {

    @Test
    public void containedBoxTest() {
        defaultBoxPage.open();

        boxFrame.containedBox.is().enabled();
        boxFrame.containedBox.click();
        boxFrame.containedBox.is().text(containsString("BUTTON"));
        }

    @Test
    public void outlinedBoxTest() {
        defaultBoxPage.open();

        boxFrame.outlinedBox.is().enabled();
        boxFrame.outlinedBox.click();
        boxFrame.outlinedBox.is().text(containsString("BUTTON"));
    }

    @Test
    public void disabledBoxTest() {
        defaultBoxPage.open();

        boxFrame.disabledBox.is().disabled();
        try {
            boxFrame.disabledBox.click();
            fail("Disabled button shouldn't work, but it does");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("Can't perform click. Element is disabled"));
        }
        boxFrame.disabledBox.is().text(containsString("BUTTON"));
    }

}
