package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.displayDataDefaultMaterialIconPage;
import static io.github.com.StaticSite.displayDataLargeMaterialIconPage;
import static io.github.com.StaticSite.materialIconFrame;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

public class MaterialIconTests extends TestsInit {

    @Test
    public void defaultMaterialIconTest() {
        displayDataDefaultMaterialIconPage.open();
        materialIconFrame.materialIcon.is().visible();
    }

    @Test
    public void largeMaterialIconTest() {
        displayDataLargeMaterialIconPage.open();
        materialIconFrame.materialIcon.is().visible();
        materialIconFrame.materialIcon.is().checkSize("Large");
        materialIconFrame.materialIcon.is().checkColor("Secondary");
    }
}
