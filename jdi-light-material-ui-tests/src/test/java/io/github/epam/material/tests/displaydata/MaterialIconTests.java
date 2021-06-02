package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.materialIconPage;
import static io.github.com.pages.displaydata.MaterialIconPage.*;
import static org.testng.Assert.assertTrue;

/**
 * To see an example of Material icons web element please visit
 * https://material-ui.com/components/material-icons/
 */

public class MaterialIconTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        materialIconPage.open();
    }

    @Test
    public void sizeAndColorTest() {
        iconsList.get(1).is().displayed();
        iconsList.get(2).is().displayed();
        iconsList.get(3).is().displayed();
        assertTrue(iconsList.get(2).hasClass("MuiSvgIcon-fontSizeLarge"));
        assertTrue(iconsList.get(3).hasClass("MuiSvgIcon-colorSecondary"));
    }

    @Test
    public void defaultMaterialIconTest() {
        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover:");

        iconsList.get(1).hover();
        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover: default");

        iconsList.get(1).click();
        lastClick.is().text("Last click: default");
        lastHover.is().text("Last hover: default");

        iconsList.get(2).hover();
        lastClick.is().text("Last click: default");
        lastHover.is().text("Last hover: large");

        iconsList.get(2).click();
        lastClick.is().text("Last click: large");
        lastHover.is().text("Last hover: large");

        iconsList.get(3).hover();
        lastClick.is().text("Last click: large");
        lastHover.is().text("Last hover: secondary");

        iconsList.get(3).click();
        lastClick.is().text("Last click: secondary");
        lastHover.is().text("Last hover: secondary");
    }
}
