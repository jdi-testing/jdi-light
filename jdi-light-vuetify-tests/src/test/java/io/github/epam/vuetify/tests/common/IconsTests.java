package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import io.github.com.dataproviders.IconsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.WHITE;
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
    }

    @Test(dataProvider = "colorIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void colorIconsTests(int number, String iconType, String color,
                                String height, String width) throws Exception {
        colorIcons.get(number).is().displayed();
        colorIcons.get(number).has().type(iconType);
        colorIcons.get(number).has().color(color);
        colorIcons.get(number).has().height(height);
        colorIcons.get(number).has().width(width);
    }

    @Test
    public void clickIconTests() throws Exception {
        clickIcon.is().displayed();
        clickIcon.is().clickable();
        clickIcon.has().type("mdi-chevron-right");
        clickIcon.has().height("36px");
        clickIcon.has().width("36px");
        clickIcon.click();
        clickIcon.has().alertOnIconClick("You clicked next!");
        clickIcon.handleAlert();
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void buttonsIconsTests(int number, String iconType, String color,
                                  String height, String width) throws Exception {
        buttonsIcons.get(number).is().displayed();
        buttonsIcons.get(number).is().clickable();
        buttonsIcons.get(number).has().type(iconType);
        buttonsIcons.get(number).has().color(color);
        buttonsIcons.get(number).has().height(height);
        buttonsIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "fontAwesomeIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void fontAwesomeIconsTests(int number, String iconType, String height, String width) throws Exception {
        fontAwesomeIcons.get(number).is().displayed();
        fontAwesomeIcons.get(number).has().type(iconType);
        fontAwesomeIcons.get(number).has().height(height);
        fontAwesomeIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "materialDesignIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void materialDesignIconsTests(int number, String iconType, String height, String width) throws Exception {
        materialDesignIcons.get(number).is().displayed();
        materialDesignIcons.get(number).has().type(iconType);
        materialDesignIcons.get(number).has().height(height);
        materialDesignIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "mdiSvgIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void mdiSvgIconsTests(int number, String height, String width) throws Exception {
        mdiSvgIcons.get(number).is().displayed();
        mdiSvgIcons.get(number).has().type("svg icon");
        mdiSvgIcons.get(number).has().height(height);
        mdiSvgIcons.get(number).has().width(width);

        mdiSvgIcons.get(4).has().color(WHITE.value());
    }
}
