package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.fabFrame;
import static io.github.com.StaticSite.inputFabDefaultPage;
import static io.github.com.StaticSite.inputFabDisabledPage;

public class FabTests extends TestsInit {

    @Test
    public void defaultFabTest() {
        inputFabDefaultPage.open();

        fabFrame.fab.is().enabled();
        fabFrame.fab.click();
        fabFrame.fab.is().enabled();
    }
}
