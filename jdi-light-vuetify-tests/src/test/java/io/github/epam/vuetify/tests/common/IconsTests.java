package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.iconsPage;
import static io.github.com.pages.IconsPage.colorIcons;

public class IconsTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        iconsPage.open();
    }

    @Test
    public void colorIconsTests() {
        for(Icon icon: colorIcons) {
            icon.is().displayed();
        }
    }

}
