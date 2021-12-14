package io.github.epam.material.tests.displaydata;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.materialIconPage;
import static io.github.com.pages.displaydata.MaterialIconPage.iconsList;
import static io.github.com.pages.displaydata.MaterialIconPage.lastClick;
import static io.github.com.pages.displaydata.MaterialIconPage.lastHover;
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

    @BeforeMethod
    public void beforeTest() {
        materialIconPage.open();
    }

    @Test
    public void sizeAndColorTest() {

        for (int elNum = 1; elNum <= 3; elNum++) {
            iconsList.get(elNum).is().visible();
            if (elNum == 3) {
                iconsList.get(3).has().color(Colors.SECONDARY.rgba());
            } else {
                iconsList.get(elNum).is().notColored();
            }
        }
        jdiAssert(iconsList.get(2).attr("class").contains("Large")
                ? "element has large size" : "element isn't large", Matchers.is("element has large size"));
    }

    @Test(dataProvider = "defaultMaterialIconTestDataProvider")
    public void defaultMaterialIconTest(int elNum, String elType) {

        lastClick.is().text("Last click:");
        lastHover.is().text("Last hover:");

        iconsList.get(elNum).click();
        lastClick.is().text("Last click: " + elType);
        iconsList.get(elNum).hover();
        lastHover.is().text("Last hover: " + elType);
    }

    @DataProvider(name = "defaultMaterialIconTestDataProvider")
    public static Object[][] defaultMaterialIconTestData() {
        return new Object[][]{
                {1, "default"},
                {2, "large"},
                {3, "secondary"},
        };
    }
}