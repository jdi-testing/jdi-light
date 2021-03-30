package io.github.epam.material.tests.layout;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.hasToString;

public class BoxTests extends TestsInit {

    @Test
    public void containedBoxTest() {
        defaultBoxPage.open();

        boxFrame.containedBox.is().enabled();
        boxFrame.containedBox.click();
        boxFrame.containedBox.is().text(hasToString("BUTTON"));

        boxFrame.rootContainedBox.is().attr("element1", "[object Object]");
        boxFrame.rootContainedBox.is().attr("element2", "[object Object]");
        boxFrame.rootContainedBox.is().attr("element3", "[object Object]");
        }

    @Test
    public void outlinedBoxTest() {
        defaultBoxPage.open();

        boxFrame.outlinedBox.is().enabled();
        boxFrame.outlinedBox.click();
        boxFrame.outlinedBox.is().text(hasToString("BUTTON"));
    }

    @Test(expectedExceptions = {RuntimeException.class},
            expectedExceptionsMessageRegExp = ".*(Can't perform click. Element is disabled)")
    public void disabledBoxTest() {
        defaultBoxPage.open();

        boxFrame.disabledBox.is().text(hasToString("BUTTON"));
        boxFrame.disabledBox.is().disabled();
        boxFrame.disabledBox.click();
    }
}
