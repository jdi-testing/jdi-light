package io.github.epam.material.tests.displaydata;

import static io.github.com.pages.displaydata.MaterialIconPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static org.testng.Assert.assertTrue;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * To see an example of Material icons web element please visit https://material-ui.com/components/material-icons/
 */

public class MaterialIconTests extends TestsInit {

    @BeforeTest
    public void beforeTest() {
        openSection("Material Icons");
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
        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover:");

        defaultAlarm.hover();
        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover: default");

        defaultAlarm.click();
        lastClick.is().text("Last click: default");
        lastHover.is().text("Last hover: default");

        largeAlarm.hover();
        lastClick.is().text("Last click: default");
        lastHover.is().text("Last hover: large");

        largeAlarm.click();
        lastClick.is().text("Last click: large");
        lastHover.is().text("Last hover: large");

        secondaryAlarm.hover();
        lastClick.is().text("Last click: large");
        lastHover.is().text("Last hover: secondary");

        secondaryAlarm.click();
        lastClick.is().text("Last click: secondary");
        lastHover.is().text("Last hover: secondary");
    }
}
