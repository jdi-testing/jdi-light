package io.github.epam.material.tests.displaydata;

import io.github.epam.TestsInit;
import io.github.epam.test.data.IconsDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.iconsPage;
import static io.github.com.pages.displaydata.IconsPage.colorIcons;
import static io.github.com.pages.displaydata.IconsPage.differentSizesIcons;
import static io.github.com.pages.displaydata.IconsPage.simpleIcons;
import static io.github.com.pages.displaydata.IconsPage.simpleLastClick;
import static io.github.com.pages.displaydata.IconsPage.simpleLastHover;


public class IconsTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        iconsPage.open();
        iconsPage.isOpened();
    }

    @Test
    public void simpleIconsTest() {
        simpleIcons.get(1).is().displayed();
        simpleIcons.get(1).hover();
        simpleLastHover.has().text("Last hover: DeleteIcon");
        simpleIcons.get(2).click();
        simpleLastClick.has().text("Last click: DeleteForeverIcon");
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "colorIconsTestDataProvider")
    public void colorIconsTest(int coloredElementIndex, String color) {
        colorIcons.get(coloredElementIndex).is().displayed();
        colorIcons.get(coloredElementIndex).has().css("color", color);
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "differentSizesIconsTestDataProvider")
    public void differentSizesIconsTest(int elementIndex, int height, int width) {
        differentSizesIcons.forEach(icon -> icon.is().displayed());
        differentSizesIcons.get(elementIndex).has().height(height).and().width(width);
    }
}
