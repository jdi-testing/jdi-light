package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
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
        colorIcons.get(number).has().hasNoLabel();
        colorIcons.get(number).is().displayed();
        colorIcons.get(number).has().type(iconType);
        colorIcons.get(number).has().iconName(iconName);
        colorIcons.get(number).has().color(color);
        colorIcons.get(number).has().height(height);
        colorIcons.get(number).has().width(width);
    }

    @Test(description = "Test checks that Icons are clickable")
    public void clickIconTests() {
        clickIcon.show();
        clickIcon.has().hasNoLabel();
        clickIcon.is().displayed();
        clickIcon.is().clickable();
        clickIcon.has().type("mdi-chevron-right");
        clickIcon.has().iconName(CHEVRON_RIGHT.value());
        clickIcon.has().height(36);
        clickIcon.has().width(36);
        clickIcon.click();
        clickIcon.has().alertOnIconClick("You clicked next!");
        clickIcon.dismissAlert();
    }

    @Test(dataProvider = "buttonsIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Button Icons label, type, measurement, color and display status")
    public void buttonsIconsTests(int number, String iconType, String iconName, String color,
        Integer height, Integer width) {
        buttonsIcons.get(number).has().hasNoLabel();
        buttonsIcons.get(number).is().displayed();
        buttonsIcons.get(number).has().type(iconType);
        buttonsIcons.get(number).has().iconName(iconName);
        buttonsIcons.get(number).has().color(color);
        buttonsIcons.get(number).has().height(height);
        buttonsIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "fontAwesomeIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Font Awesome Icons type, measurement and display status")
    public void fontAwesomeIconsTests(int number, String iconType, Integer height, Integer width) {
        fontAwesomeIcons.get(number).has().hasNoLabel();
        fontAwesomeIcons.get(number).is().displayed();
        fontAwesomeIcons.get(number).has().type(iconType);
        fontAwesomeIcons.get(number).has().height(height);
        fontAwesomeIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "materialDesignIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
        description = "Test checks Material Design Icons type, measurement and display status")
    public void materialDesignIconsTests(int number, String iconType, Integer height, Integer width) {
        materialDesignIcons.get(number).has().hasNoLabel();
        materialDesignIcons.get(number).is().displayed();
        materialDesignIcons.get(number).has().type(iconType);
        materialDesignIcons.get(number).has().height(height);
        materialDesignIcons.get(number).has().width(width);
    }

    @Test(dataProvider = "mdiSvgIconsTestsDataProvider", dataProviderClass = IconsDataProvider.class,
    description = "Test checks SVG Icons type, measurement, display and label statuses")
    public void mdiSvgIconsTests(int number, String iconName, Integer height, Integer width) {
        mdiSvgIcons.get(number).has().hasNoLabel();
        mdiSvgIcons.get(number).is().displayed();
        mdiSvgIcons.get(number).has().type("svg icon");
        mdiSvgIcons.get(number).has().height(height);
        mdiSvgIcons.get(number).has().width(width);
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
        mdiSvgIcons.forEach(ICoreElement::show);
        mdiSvgIcons.get(3).has().rightAlignment();
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

        materialDesignIcons.forEach(ICoreElement::show);
        materialDesignIcons.get(1).has().lightTheme();
        materialDesignIcons.get(2).has().lightTheme();
        materialDesignIcons.get(3).has().lightTheme();
        materialDesignIcons.get(4).has().darkTheme();
        materialDesignIcons.get(5).has().darkTheme();
        materialDesignIcons.get(6).has().darkTheme();
        materialDesignIcons.get(7).has().lightTheme();
        materialDesignIcons.get(8).has().lightTheme();
        materialDesignIcons.get(9).has().lightTheme();
        materialDesignIcons.get(10).has().darkTheme();
        materialDesignIcons.get(11).has().darkTheme();
        materialDesignIcons.get(12).has().darkTheme();
        materialDesignIcons.get(13).has().lightTheme();
        materialDesignIcons.get(14).has().lightTheme();
        materialDesignIcons.get(15).has().lightTheme();
        materialDesignIcons.get(16).has().darkTheme();
        materialDesignIcons.get(17).has().darkTheme();
        materialDesignIcons.get(18).has().darkTheme();
        materialDesignIcons.get(19).has().lightTheme();
        materialDesignIcons.get(20).has().lightTheme();
        materialDesignIcons.get(21).has().lightTheme();
        materialDesignIcons.get(22).has().darkTheme();
        materialDesignIcons.get(23).has().darkTheme();
        materialDesignIcons.get(24).has().darkTheme();

        mdiSvgIcons.forEach(ICoreElement::show);
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

        materialDesignIcons.forEach(ICoreElement::show);
        materialDesignIcons.forEach(icon -> icon.is().enabled());

        mdiSvgIcons.forEach(ICoreElement::show);
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
