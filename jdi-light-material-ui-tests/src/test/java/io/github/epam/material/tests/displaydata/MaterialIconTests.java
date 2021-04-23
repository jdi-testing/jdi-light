package io.github.epam.material.tests.displaydata;

import static io.github.com.pages.displaydata.MaterialIconPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static org.testng.Assert.assertTrue;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * To see an example of Button web element please visit https://material-ui.com/components/material-icons/
 */

public class MaterialIconTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Material Icons");
    }

    private void lastClickTextIs(String text) {
        lastClick.is().text(String.format("Last click:%s", text));
    }

    private void lastHoverTextIs(String text) {
        lastHover.is().text(String.format("Last hover:%s", text));
    }

    @Test
    public void sizeAndColorTest() {
        defaultAlarm.is().displayed();
        largeAlarm.is().displayed();
        secondaryAlarm.is().displayed();
        assertTrue(largeAlarm.hasClass("MuiSvgIcon-fontSizeLarge"));
        assertTrue(secondaryAlarm.hasClass("MuiSvgIcon-colorSecondary"));
    }

    @Test
    public void defaultMaterialIconTest() {
        lastClickTextIs("");
        lastHoverTextIs("");

        defaultAlarm.hover();
        lastClickTextIs("");
        lastHoverTextIs(" default");

        defaultAlarm.click();
        lastClickTextIs(" default");
        lastHoverTextIs(" default");

        largeAlarm.hover();
        lastClickTextIs(" default");
        lastHoverTextIs(" large");

        largeAlarm.click();
        lastClickTextIs(" large");
        lastHoverTextIs(" large");

        secondaryAlarm.hover();
        lastClickTextIs(" large");
        lastHoverTextIs(" secondary");

        secondaryAlarm.click();
        lastClickTextIs(" secondary");
        lastHoverTextIs(" secondary");
    }
}
