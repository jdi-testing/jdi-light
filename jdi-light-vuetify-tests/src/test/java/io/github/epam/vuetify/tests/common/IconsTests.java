package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.com.dataproviders.IconsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.StaticSite.iconsPage;
import static io.github.com.pages.IconsPage.buttonsIcons;
import static io.github.com.pages.IconsPage.clickIcon;
import static io.github.com.pages.IconsPage.colorIcons;
import static io.github.com.pages.IconsPage.fontAwesomeIcons;
import static io.github.com.pages.IconsPage.materialDesignIcons;
import static io.github.com.pages.IconsPage.mdiSvgIcons;

public class IconsTests extends TestsInit {

    @BeforeClass
    public void before() {
        iconsPage.open();
        waitCondition(() -> iconsPage.isOpened());
        iconsPage.checkOpened();
    }

    @Test(dataProvider = "colorIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void colorIconsTests(int number, String iconType, String color,
                                Integer height, Integer width) {
        colorIcons.get(number).is().displayed();
        colorIcons.get(number).has().type(iconType);
        colorIcons.get(number).has().color(color);
        colorIcons.get(number).has().height(height);
        colorIcons.get(number).has().width(width);
    }

    @Test
    public void clickIconTests() {
        clickIcon.is().displayed();
        clickIcon.is().clickable();
        clickIcon.has().type("mdi-chevron-right");
        clickIcon.has().height(36);
        clickIcon.has().width(36);
        clickIcon.click();
        clickIcon.has().alertOnIconClick("You clicked next!");
        clickIcon.handleAlert();
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void buttonsIconsTests(int number, String iconType, String color,
                                  Integer height, Integer width) {
        buttonsIcons.get(number).is().displayed();
        buttonsIcons.get(number).has().type(iconType);
        buttonsIcons.get(number).has().color(color);
        buttonsIcons.get(number).has().height(height);
        buttonsIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "fontAwesomeIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void fontAwesomeIconsTests(int number, String iconType, Integer height, Integer width) {
        fontAwesomeIcons.get(number).is().displayed();
        fontAwesomeIcons.get(number).has().type(iconType);
        fontAwesomeIcons.get(number).has().height(height);
        fontAwesomeIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "materialDesignIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void materialDesignIconsTests(int number, String iconType, Integer height, Integer width) {
        materialDesignIcons.get(number).is().displayed();
        materialDesignIcons.get(number).has().type(iconType);
        materialDesignIcons.get(number).has().height(height);
        materialDesignIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "mdiSvgIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void mdiSvgIconsTests(int number, Integer height, Integer width) {
        mdiSvgIcons.get(number).is().displayed();
        mdiSvgIcons.get(number).has().type("svg icon");
        mdiSvgIcons.get(number).has().height(height);
        mdiSvgIcons.get(number).has().width(width);

        mdiSvgIcons.get(4).has().color(WHITE.value());
    }
}
