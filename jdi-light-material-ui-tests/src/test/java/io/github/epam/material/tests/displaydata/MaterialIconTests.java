package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.materialIconPage;
import static io.github.com.pages.displaydata.MaterialIconPage.iconsList;
import static io.github.com.pages.displaydata.MaterialIconPage.lastClick;
import static io.github.com.pages.displaydata.MaterialIconPage.lastHover;

import com.epam.jdi.light.material.elements.displaydata.Icon;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * To see an example of Material icons web element please visit
 * https://material-ui.com/components/material-icons/
 */

public class MaterialIconTests extends TestsInit {

    @DataProvider(name = "sizeAndColorTestDataProvider")
    public static Object[][] sizeAndColorTestData() {
        return new Object[][]{
                {iconsList.get(1), "", ""},
                {iconsList.get(2), "", "Large"},
                {iconsList.get(3), Colors.SECONDARY.rgba(), ""}
        };
    }

    @DataProvider(name = "defaultMaterialIconTestDataProvider")
    public static Object[][] defaultMaterialIconTestData() {
        return new Object[][]{
                {1, "default"},
                {2, "large"},
                {3, "secondary"},
        };
    }

    @BeforeMethod
    public void beforeTest() {
        materialIconPage.open();
        materialIconPage.isOpened();
    }

    @Test(dataProvider = "sizeAndColorTestDataProvider")
    public void sizeAndColorTest(Icon icon, String color, String sizeClass) {

        icon.is().visible();
        if (color.isEmpty()) {
            icon.is().notColored();
        } else {
            icon.is().colored().and().has().color(color);
        }
        icon.has().classValue(Matchers.containsString(sizeClass));
    }

    @Test(dataProvider = "defaultMaterialIconTestDataProvider")
    public void defaultMaterialIconTest(int elNum, String elType) {

        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover:");
        // TODO: Check hover and last click at the same time
        iconsList.get(elNum).click();
        lastClick.is().text("Last click: " + elType);
        iconsList.get(elNum).hover();
        lastHover.is().text("Last hover: " + elType);
    }
}

