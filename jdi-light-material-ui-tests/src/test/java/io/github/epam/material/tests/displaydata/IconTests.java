package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.displayDataDefaultMaterialIconPage;
import static io.github.com.StaticSite.displayDataLargeMaterialIconPage;
import static io.github.com.StaticSite.iconFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class IconTests extends TestsInit {

    @Test
    public void defaultMaterialIconTest() {
        displayDataDefaultMaterialIconPage.open();
        iconFrame.icon.is().visible();
    }

    @Test
    public void largeMaterialIconTest() {
        displayDataLargeMaterialIconPage.open();
        iconFrame.icon.is().visible();
        iconFrame.icon.is().largeSize();
    }
}
