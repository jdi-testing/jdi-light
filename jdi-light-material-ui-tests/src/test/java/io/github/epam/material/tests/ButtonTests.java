package io.github.epam.material.tests;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.buttonDefaultPage;
import static io.github.com.StaticSite.buttonDisabledPage;
import static io.github.com.StaticSite.materialPageFrame;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.fail;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        buttonDefaultPage.shouldBeOpened();

        materialPageFrame.button.click();
        materialPageFrame.button.is().enabled();
        materialPageFrame.button.has().text(containsString("BUTTON"));
    }

    @Test
    public void disabledButtonTest() {
        buttonDisabledPage.shouldBeOpened();

        materialPageFrame.button.is().disabled();
        try {
            materialPageFrame.button.click();
            fail("Disabled button shouldn't work, but it does");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("Can't perform click. Element is disabled"));
        }
    }

}
