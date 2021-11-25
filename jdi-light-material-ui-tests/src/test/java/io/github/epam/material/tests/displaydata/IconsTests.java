package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.material.elements.displaydata.Icon;
import io.github.epam.TestsInit;
import io.github.epam.test.data.IconsDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
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
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "validationTestDataProvider")
    public void validationTest(List<Icon> iconsList, int iconsListSize) {
        iconsList.forEach(el -> el.is().displayed());
        iconsList.forEach(el -> el.is().enabled());
        jdiAssert(iconsList.size(), Matchers.is(iconsListSize));
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "simpleIconsTestDataProvider")
    public void simpleIconsTest(int elementIndexForHover, String resultHoverFieldText,
                                int elementIndexForClick, String resultClickFieldText) {
        simpleIcons.get(elementIndexForHover).hover();
        simpleLastHover.has().text(resultHoverFieldText);
        simpleIcons.get(elementIndexForClick).click();
        simpleLastClick.has().text(resultClickFieldText);
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "colorIconsTestDataProvider")
    public void colorIconsTest(int notColoredElementIndex, int coloredElementIndex, String color) {
        colorIcons.get(notColoredElementIndex).is().notColored();
        colorIcons.get(coloredElementIndex).is().colored();
        colorIcons.get(coloredElementIndex).has().color(color);
    }

    @Test(dataProviderClass = IconsDataProvider.class, dataProvider = "differentSizesIconsTestDataProvider")
    public void differentSizesIconsTest(int elementIndex, int height, int width) {
        differentSizesIcons.get(elementIndex).has().height(height).and().width(width);
    }
}
