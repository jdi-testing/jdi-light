package io.github.epam.vuetify.tests.common;

import io.github.com.dataproviders.IconsDataProvider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.iconsPage;
import static io.github.com.enums.MdiIcons.CHEVRON_RIGHT;
import static io.github.com.pages.IconsPage.buttonsIcons;
import static io.github.com.pages.IconsPage.clickIcon;
import static io.github.com.pages.IconsPage.colorIcons;
import static io.github.com.pages.IconsPage.disabledIcons;
import static io.github.com.pages.IconsPage.fontAwesomeIcons;
import static io.github.com.pages.IconsPage.materialDesignIcons;
import static io.github.com.pages.IconsPage.mdiSvgIcons;
import static io.github.com.pages.IconsPage.semanticIcons;

public class IconsTests extends TestsInit {

    @BeforeClass
    public void before() {
        iconsPage.open();
        waitCondition(() -> iconsPage.isOpened());
        iconsPage.checkOpened();
    }

    @Test(dataProvider = "colorIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
    description = "Test checks Icon colors")
    public void colorIconsTests(int number, String iconType, String iconName, String color,
        Integer height, Integer width) {
        colorIcons.get(number).has().hasNoLabel()
                .and().displayed()
                .and().type(iconType)
                .and().iconName(iconName)
                .and().color(color)
                .and().height(height)
                .and().width(width);
    }

    @Test(description = "Test checks that Icons are clickable")
    public void clickIconTests() {
        clickIcon.show();
        clickIcon.has().hasNoLabel()
                .and().is().displayed()
                .and().clickable()
                .and().has().type("mdi-chevron-right")
                .and().iconName(CHEVRON_RIGHT.value())
                .and().height(36)
                .and().width(36);
        clickIcon.click();
        clickIcon.has().alertOnIconClick("You clicked next!");
        clickIcon.dismissAlert();
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Button Icons label, type, measurement, color and display status")
    public void buttonsIconsTests(int number, String iconType, String iconName, String color,
        Integer height, Integer width) {
        buttonsIcons.get(number).has().hasNoLabel()
                .and().is().displayed()
                .and().type(iconType)
                .and().has().iconName(iconName)
                .and().color(color)
                .and().height(height)
                .and().width(width);
    }

    @Test(dataProvider = "fontAwesomeIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Font Awesome Icons type, measurement and display status")
    public void fontAwesomeIconsTests(int number, String iconType, Integer height, Integer width) {
        fontAwesomeIcons.get(number).has().hasNoLabel()
                .and().is().displayed()
                .and().has().type(iconType)
                .and().height(height)
                .and().width(width);
    }

    @Test(dataProvider = "materialDesignIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Material Design Icons type, measurement and display status")
    public void materialDesignIconsTests(int number, String iconType, Integer height, Integer width) {
        materialDesignIcons.get(number).has().hasNoLabel()
                .and().is().displayed()
                .and().has().type(iconType)
                .and().height(height)
                .and().width(width);
    }

    @Test(dataProvider = "mdiSvgIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
    description = "Test checks SVG Icons type, measurement, display and label statuses")
    public void mdiSvgIconsTests(int number, String iconName, Integer height, Integer width) {
        mdiSvgIcons.get(number).has().hasNoLabel()
                .and().is().displayed()
                .and().type("svg icon")
                .and().height(height)
                .and().width(width);
    }

    @Test(description = "Test checks cursor type for MDI SVG Icon: pointer cursor - on")
    public void pointerCursorMdiSvgIconsTest() {
        mdiSvgIcons.get(4).show();
        mdiSvgIcons.get(4).has().cursorTypePointer();
        clickIcon.has().cursorTypePointer();
        clickIcon.has().cursorType("pointer");
    }

    @Test(description = "Test checks alignment for Buttons Icons")
    public void alignmentButtonsIconsTest() {
        buttonsIcons.get(1).show();
        buttonsIcons.get(1).has().rightAlignment();
        buttonsIcons.get(2).has().rightAlignment();
        buttonsIcons.get(3).has().leftAlignment();
        buttonsIcons.get(4).has().leftAlignment();
    }

    @Test(description = "Test checks theme for Icons")
    public void themeIconsTest() {
        colorIcons.forEach(icon -> icon.has().lightTheme());

        clickIcon.has().lightTheme();

        buttonsIcons.get(1).has().darkTheme();

        buttonsIcons.get(8).has().lightTheme();

        disabledIcons.get(1).has().lightTheme();
    }

    @Test(description = "Test checks if Icons are enabled/disabled")
    public void disabledIconsTest() {
        colorIcons.forEach(icon -> icon.is().enabled());

        clickIcon.is().enabled();

        buttonsIcons.forEach(icon -> icon.is().enabled());

        fontAwesomeIcons.forEach(icon -> icon.is().enabled());

        disabledIcons.get(1).show();
        disabledIcons.get(1).is().disabled();
    }

    @Test(description = "Test checks visibility of Semantic Icons")
    public void visibilityIconsTest() {
        semanticIcons.get(1).show();
        semanticIcons.forEach(icon -> icon.is().visible());
    }
}
