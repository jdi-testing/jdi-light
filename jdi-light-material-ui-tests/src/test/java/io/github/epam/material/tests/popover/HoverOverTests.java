package io.github.epam.material.tests.popover;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.hoverOverPopPage;
import static io.github.com.StaticSite.popOverFrame;

public class HoverOverTests extends TestsInit {

    @Test
    public void hoverOverTest() {
        hoverOverPopPage.shouldBeOpened();

        popOverFrame.hoverOverPop.hoverOver();
        popOverFrame.hoverOverPop.is().hoverOverIsOpened();
    }
}
