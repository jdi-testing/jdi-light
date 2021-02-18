package io.github.epam.material.tests.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.popOverFrame;
import static io.github.com.StaticSite.popOverPage;

public class PopOverTests extends TestsInit {

    @Test
    public void popOverTest() {
        popOverPage.shouldBeOpened();

        popOverFrame.popOver.is().isEnabled();
        popOverFrame.popOver.clickOn();
        popOverFrame.popOver.is().isOpened();
    }
}
