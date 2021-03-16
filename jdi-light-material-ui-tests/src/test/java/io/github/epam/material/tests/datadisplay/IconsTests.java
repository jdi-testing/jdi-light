package io.github.epam.material.tests.datadisplay;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class IconsTests  extends TestsInit {

    @Test
    public void simpleIconsTest() {
        simpleIconsPage.open();

        iconsFrame.filled1.is().displayed();
        iconsFrame.filled2.is().displayed();
        iconsFrame.oulined1.is().displayed();
    }

    @Test
    public void colorIconsTest() {
        colorIconsPage.open();

        iconsFrame.svg1.is().displayed();
        iconsFrame.svg2.is().displayed();
        iconsFrame.svg2.is().hasClass("MuiSvgIcon-colorPrimary");
    }

    @Test
    public void sizeIconsPage(){
        sizeIconsPage.open();

        iconsFrame.svg1.is().displayed();
        iconsFrame.svg1.is().hasClass("MuiSvgIcon-fontSizeSmall");
        iconsFrame.svg2.is().displayed();
    }
}
