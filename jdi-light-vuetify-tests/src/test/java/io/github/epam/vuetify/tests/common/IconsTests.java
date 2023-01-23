package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import io.github.com.dataproviders.IconsDataProvider;
import io.github.com.enums.MdiIcons;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.iconsPage;
import static io.github.com.enums.Colors.WHITE;
import static io.github.com.enums.MdiIcons.CHEVRON_RIGHT;
import static io.github.com.pages.IconsPage.buttonsIcons;
import static io.github.com.pages.IconsPage.clickIcon;
import static io.github.com.pages.IconsPage.colorIcons;
import static io.github.com.pages.IconsPage.disabledIcons;
import static io.github.com.pages.IconsPage.fontAwesomeIcons;
import static io.github.com.pages.IconsPage.iconsPageBody;
import static io.github.com.pages.IconsPage.materialDesignIconsSection;
import static io.github.com.pages.IconsPage.mdiSvgIconsSection;
import static io.github.com.pages.IconsPage.semanticIcons;

public class IconsTests extends TestsInit {

    @BeforeClass
    public void before() {
        iconsPage.open();
        waitCondition(() -> iconsPage.isOpened());
        iconsPage.checkOpened();
    }

    @Test(dataProvider = "colorIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void colorIconsTests(int number, String iconType, String iconName, String color,
                                Integer height, Integer width) {
        colorIcons.get(number).has().hasNoLabel();
        colorIcons.get(number).is().displayed();
        colorIcons.get(number).has().type(iconType);
        colorIcons.get(number).has().mdiIconName(iconName);
        colorIcons.get(number).has().color(color);
        colorIcons.get(number).has().height(height);
        colorIcons.get(number).has().width(width);
    }

    @Test
    public void clickIconTests() {
        clickIcon.has().hasNoLabel();
        clickIcon.is().displayed();
        clickIcon.is().clickable();
        clickIcon.has().type("mdi-chevron-right");
        clickIcon.has().mdiIconName(CHEVRON_RIGHT.value());
        clickIcon.has().height(36);
        clickIcon.has().width(36);
        clickIcon.click();
        clickIcon.has().alertTextOnIconClick("You clicked next!");
        clickIcon.dismissAlert();
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void buttonsIconsTests(int number, String iconType, String iconName, String color,
                                  Integer height, Integer width) {
        buttonsIcons.get(number).has().hasNoLabel();
        buttonsIcons.get(number).is().displayed();
        buttonsIcons.get(number).has().type(iconType);
        buttonsIcons.get(number).has().mdiIconName(iconName);
        buttonsIcons.get(number).has().color(color);
        buttonsIcons.get(number).has().height(height);
        buttonsIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "fontAwesomeIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void fontAwesomeIconsTests(int number, String iconType, Integer height, Integer width) {
        fontAwesomeIcons.get(number).has().hasNoLabel();
        fontAwesomeIcons.get(number).is().displayed();
        fontAwesomeIcons.get(number).has().type(iconType);
        fontAwesomeIcons.get(number).has().height(height);
        fontAwesomeIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "materialDesignIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void materialDesignIconsTests(int number, String iconType, Integer height, Integer width) {
        List<Icon> materialDesignIcons = Icon.findAll(materialDesignIconsSection);
        materialDesignIcons.get(number).has().hasNoLabel();
        materialDesignIcons.get(number).is().displayed();
        materialDesignIcons.get(number).has().type(iconType);
        materialDesignIcons.get(number).has().height(height);
        materialDesignIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "mdiSvgIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class)
    public void mdiSvgIconsTests(int number, String iconName, Integer height, Integer width) {
        List<Icon> mdiSvgIcons = Icon.findAll(mdiSvgIconsSection);
        mdiSvgIcons.get(number).has().hasNoLabel();
        mdiSvgIcons.get(number).is().displayed();
        mdiSvgIcons.get(number).has().type("svg icon");
        mdiSvgIcons.get(number).has().mdiIconName(iconName);
        mdiSvgIcons.get(number).has().height(height);
        mdiSvgIcons.get(number).has().width(width);
        mdiSvgIcons.get(3).has().color(WHITE.value());
    }

    @Test(dataProvider = "findMdiIconTestDataProvider", dataProviderClass = IconsDataProvider.class)
    public void findMdiIconTest(MdiIcons iconName) {
        Icon icon = MdiIcons.find(iconsPageBody, iconName);
        icon.has().mdiIconName(iconName.value());
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
            description = "Test checks cursor type for ButtonsIcons: pointer cursor - on")
    public void pointerCursorButtonsIconsTest(int number, String iconType, String iconName, String color,
                                              Integer height, Integer width) {
        buttonsIcons.get(number).show();
        buttonsIcons.get(number).has().cursorTypePointer();
        buttonsIcons.get(number).has().cursorType("pointer");
    }

    @Test(description = "Test checks cursor type for MDI SVG Icon: pointer cursor - on")
    public void pointerCursorMdiSvgIconsTest() {
        List<Icon> mdiSvgIcons = Icon.findAll(mdiSvgIconsSection);
        mdiSvgIcons.get(3).show();
        mdiSvgIcons.get(3).has().cursorTypePointer();
        mdiSvgIcons.get(3).has().cursorType("pointer");
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
        mdiSvgIconsSection.show();
        List<Icon> mdiSvgIcons = Icon.findAll(mdiSvgIconsSection);
        mdiSvgIcons.get(3).has().leftAlignment();
    }

    @Test(description = "Test checks theme for Icons")
    public void themeIconsTest() {
        colorIcons.forEach(icon -> icon.has().lightTheme());

        clickIcon.has().lightTheme();

        buttonsIcons.get(1).has().darkTheme();
        buttonsIcons.get(2).has().darkTheme();
        buttonsIcons.get(3).has().darkTheme();
        buttonsIcons.get(4).has().darkTheme();
        buttonsIcons.get(5).has().darkTheme();
        buttonsIcons.get(6).has().darkTheme();

        buttonsIcons.get(7).has().lightTheme();
        buttonsIcons.get(8).has().lightTheme();

        fontAwesomeIcons.forEach(icon -> icon.has().lightTheme());

        materialDesignIconsSection.show();
        List<Icon> materialDesignIcons = Icon.findAll(materialDesignIconsSection);
        materialDesignIcons.get(0).has().lightTheme();
        materialDesignIcons.get(1).has().lightTheme();
        materialDesignIcons.get(2).has().lightTheme();
        materialDesignIcons.get(3).has().darkTheme();
        materialDesignIcons.get(4).has().darkTheme();
        materialDesignIcons.get(5).has().darkTheme();
        materialDesignIcons.get(6).has().lightTheme();
        materialDesignIcons.get(7).has().lightTheme();
        materialDesignIcons.get(8).has().lightTheme();
        materialDesignIcons.get(9).has().darkTheme();
        materialDesignIcons.get(10).has().darkTheme();
        materialDesignIcons.get(11).has().darkTheme();
        materialDesignIcons.get(12).has().lightTheme();
        materialDesignIcons.get(13).has().lightTheme();
        materialDesignIcons.get(14).has().lightTheme();
        materialDesignIcons.get(15).has().darkTheme();
        materialDesignIcons.get(16).has().darkTheme();
        materialDesignIcons.get(17).has().darkTheme();
        materialDesignIcons.get(18).has().lightTheme();
        materialDesignIcons.get(19).has().lightTheme();
        materialDesignIcons.get(20).has().lightTheme();
        materialDesignIcons.get(21).has().darkTheme();
        materialDesignIcons.get(22).has().darkTheme();
        materialDesignIcons.get(23).has().darkTheme();

        mdiSvgIconsSection.show();
        List<Icon> mdiSvgIcons = Icon.findAll(mdiSvgIconsSection);
        mdiSvgIcons.forEach(icon -> icon.has().lightTheme());

        semanticIcons.forEach(icon -> icon.has().lightTheme());

        disabledIcons.get(1).has().lightTheme();
    }

    @Test(description = "Test checks if Icons are enabled/disabled")
    public void disabledIconsTest() {
        colorIcons.forEach(icon -> icon.is().enabled());

        clickIcon.is().enabled();

        buttonsIcons.forEach(icon -> icon.is().enabled());

        fontAwesomeIcons.forEach(icon -> icon.is().enabled());

        materialDesignIconsSection.show();
        List<Icon> materialDesignIcons = Icon.findAll(materialDesignIconsSection);
        materialDesignIcons.forEach(icon -> icon.is().enabled());

        mdiSvgIconsSection.show();
        List<Icon> mdiSvgIcons = Icon.findAll(mdiSvgIconsSection);
        mdiSvgIcons.forEach(icon -> icon.is().enabled());

        semanticIcons.forEach(icon -> icon.is().enabled());

        disabledIcons.get(1).show();
        disabledIcons.get(1).is().disabled();
    }

    @Test(description = "Test checks visibility of Semantic Icons")
    public void visibilityIconsTest() {
        semanticIcons.get(1).show();
        semanticIcons.forEach(icon -> icon.is().visible());
    }
}
