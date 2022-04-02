package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import io.github.epam.test.data.MaterialIconDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.materialIconPage;
import static io.github.com.pages.displaydata.MaterialIconPage.iconsList;
import static io.github.com.pages.displaydata.MaterialIconPage.lastClick;
import static io.github.com.pages.displaydata.MaterialIconPage.lastHover;

/**
 * To see an example of Material icons web element please visit
 * https://material-ui.com/components/material-icons/
 */

public class MaterialIconTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        materialIconPage.open();
        materialIconPage.isOpened();
    }

    @Test(dataProviderClass = MaterialIconDataProvider.class, dataProvider = "sizeAndColorTestDataProvider")
    public void sizeAndColorTest(int iconIndex, String color, String sizeClass) {

        iconsList.get(iconIndex).is().visible();
        if (color.isEmpty()) {
            iconsList.get(iconIndex).is().notColored();
        } else {
            iconsList.get(iconIndex).is().colored().and().has().color(color);
        }
        iconsList.get(iconIndex).has().classValue(Matchers.containsString(sizeClass));
    }

    @Test
    public void defaultMaterialIconTest() {
        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover:");
        iconsList.get(1).click();
        lastClick.is().text("Last click: default");
        iconsList.get(1).hover();
        lastHover.is().text("Last hover: default");
        iconsList.get(2).hover();
        lastHover.is().text("Last hover: large");
        lastClick.is().text("Last click: default");
    }
}

