package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_GREY_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.GREEN_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.ORANGE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.PURPLE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.TEAL_DARKEN_2;
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
    public void beforeTest() {
        iconsPage.open();
    }

    @Test
    public void colorIconsTests() throws Exception {
        colorIcons.get(1).is().displayed();
        colorIcons.get(1).has().type("mdi-domain");
        colorIcons.get(1).has().color(GREEN_DARKEN_2.value());
        colorIcons.get(1).has().height("36px");
        colorIcons.get(1).has().width("36px");

        colorIcons.get(2).is().displayed();
        colorIcons.get(2).has().type("mdi-message-text");
        colorIcons.get(2).has().color(BLUE_DARKEN_2.value());
        colorIcons.get(2).has().height("36px");
        colorIcons.get(2).has().width("36px");

        colorIcons.get(3).is().displayed();
        colorIcons.get(3).has().type("mdi-dialpad");
        colorIcons.get(3).has().color(PURPLE_DARKEN_2.value());
        colorIcons.get(3).has().height("36px");
        colorIcons.get(3).has().width("36px");

        colorIcons.get(4).is().displayed();
        colorIcons.get(4).has().type("mdi-email");
        colorIcons.get(4).has().color(TEAL_DARKEN_2.value());
        colorIcons.get(4).has().height("36px");
        colorIcons.get(4).has().width("36px");

        colorIcons.get(5).is().displayed();
        colorIcons.get(5).has().type("mdi-call-split");
        colorIcons.get(5).has().color(BLUE_GREY_DARKEN_2.value());
        colorIcons.get(5).has().height("36px");
        colorIcons.get(5).has().width("36px");

        colorIcons.get(6).is().displayed();
        colorIcons.get(6).has().type("mdi-arrow-up-bold-box-outline");
        colorIcons.get(6).has().color(ORANGE_DARKEN_2.value());
        colorIcons.get(6).has().height("36px");
        colorIcons.get(6).has().width("36px");
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

    @Test
    public void buttonsIconsTests() throws Exception {
        buttonsIcons.get(1).is().displayed();
        buttonsIcons.get(1).is().clickable();
        buttonsIcons.get(1).has().type("mdi-checkbox-marked-circle");
        buttonsIcons.get(1).has().color(WHITE.value());
        buttonsIcons.get(1).has().height("18px");
        buttonsIcons.get(1).has().width("18px");

        buttonsIcons.get(2).is().displayed();
        buttonsIcons.get(2).is().clickable();
        buttonsIcons.get(2).has().type("mdi-cancel");
        buttonsIcons.get(2).has().color(WHITE.value());
        buttonsIcons.get(2).has().height("18px");
        buttonsIcons.get(2).has().width("18px");

        buttonsIcons.get(3).is().displayed();
        buttonsIcons.get(3).is().clickable();
        buttonsIcons.get(3).has().type("mdi-minus-circle");
        buttonsIcons.get(3).has().color(WHITE.value());
        buttonsIcons.get(3).has().height("18px");
        buttonsIcons.get(3).has().width("18px");

        buttonsIcons.get(4).is().displayed();
        buttonsIcons.get(4).is().clickable();
        buttonsIcons.get(4).has().type("mdi-arrow-left");
        buttonsIcons.get(4).has().color(WHITE.value());
        buttonsIcons.get(4).has().height("18px");
        buttonsIcons.get(4).has().width("18px");

        buttonsIcons.get(5).is().displayed();
        buttonsIcons.get(5).is().clickable();
        buttonsIcons.get(5).has().type("mdi-wrench");
        buttonsIcons.get(5).has().color(WHITE.value());
        buttonsIcons.get(5).has().height("24px");
        buttonsIcons.get(5).has().width("24px");

        buttonsIcons.get(6).is().displayed();
        buttonsIcons.get(6).is().clickable();
        buttonsIcons.get(6).has().type("mdi-cloud-upload");
        buttonsIcons.get(6).has().color(WHITE.value());
        buttonsIcons.get(6).has().height("24px");
        buttonsIcons.get(6).has().width("24px");

        buttonsIcons.get(7).is().displayed();
        buttonsIcons.get(7).is().clickable();
        buttonsIcons.get(7).has().type("mdi-thumb-up");
        buttonsIcons.get(7).has().color(BLUE_LIGHTEN_2.value());
        buttonsIcons.get(7).has().height("24px");
        buttonsIcons.get(7).has().width("24px");

        buttonsIcons.get(8).is().displayed();
        buttonsIcons.get(8).is().clickable();
        buttonsIcons.get(8).has().type("mdi-thumb-down");
        buttonsIcons.get(8).has().color(RED_LIGHTEN_2.value());
        buttonsIcons.get(8).has().height("24px");
        buttonsIcons.get(8).has().width("24px");
    }

    @Test
    public void fontAwesomeIconsTests() throws Exception {
        fontAwesomeIcons.get(1).is().displayed();
        fontAwesomeIcons.get(1).has().type("fa-lock");
        fontAwesomeIcons.get(1).has().height("24px");
        fontAwesomeIcons.get(1).has().width("21px");

        fontAwesomeIcons.get(2).is().displayed();
        fontAwesomeIcons.get(2).has().type("fa-search");
        fontAwesomeIcons.get(2).has().height("24px");
        fontAwesomeIcons.get(2).has().width("24px");

        fontAwesomeIcons.get(3).is().displayed();
        fontAwesomeIcons.get(3).has().type("fa-list");
        fontAwesomeIcons.get(3).has().height("24px");
        fontAwesomeIcons.get(3).has().width("24px");

        fontAwesomeIcons.get(4).is().displayed();
        fontAwesomeIcons.get(4).has().type("fa-edit");
        fontAwesomeIcons.get(4).has().height("24px");
        fontAwesomeIcons.get(4).has().width("27px");

        fontAwesomeIcons.get(5).is().displayed();
        fontAwesomeIcons.get(5).has().type("fa-tachometer-alt");
        fontAwesomeIcons.get(5).has().height("24px");
        fontAwesomeIcons.get(5).has().width("27px");

        fontAwesomeIcons.get(6).is().displayed();
        fontAwesomeIcons.get(6).has().type("fa-circle-notchfa-spin");
        fontAwesomeIcons.get(6).has().height("24px");
        fontAwesomeIcons.get(6).has().width("24px");
    }

    @Test
    public void materialDesignIconsTests() throws Exception {
        materialDesignIcons.get(1).is().displayed();
        materialDesignIcons.get(1).has().type("home");
        materialDesignIcons.get(1).has().height("16px");
        materialDesignIcons.get(1).has().width("16px");

        materialDesignIcons.get(2).is().displayed();
        materialDesignIcons.get(2).has().type("event");
        materialDesignIcons.get(2).has().height("16px");
        materialDesignIcons.get(2).has().width("16px");

        materialDesignIcons.get(3).is().displayed();
        materialDesignIcons.get(3).has().type("info");
        materialDesignIcons.get(3).has().height("16px");
        materialDesignIcons.get(3).has().width("16px");

        materialDesignIcons.get(4).is().displayed();
        materialDesignIcons.get(4).has().type("folder_open");
        materialDesignIcons.get(4).has().height("16px");
        materialDesignIcons.get(4).has().width("16px");

        materialDesignIcons.get(5).is().displayed();
        materialDesignIcons.get(5).has().type("widgets");
        materialDesignIcons.get(5).has().height("16px");
        materialDesignIcons.get(5).has().width("16px");

        materialDesignIcons.get(6).is().displayed();
        materialDesignIcons.get(6).has().type("gavel");
        materialDesignIcons.get(6).has().height("16px");
        materialDesignIcons.get(6).has().width("16px");

        materialDesignIcons.get(7).is().displayed();
        materialDesignIcons.get(7).has().type("home");
        materialDesignIcons.get(7).has().height("24px");
        materialDesignIcons.get(7).has().width("24px");

        materialDesignIcons.get(8).is().displayed();
        materialDesignIcons.get(8).has().type("event");
        materialDesignIcons.get(8).has().height("24px");
        materialDesignIcons.get(8).has().width("24px");

        materialDesignIcons.get(9).is().displayed();
        materialDesignIcons.get(9).has().type("info");
        materialDesignIcons.get(9).has().height("24px");
        materialDesignIcons.get(9).has().width("24px");

        materialDesignIcons.get(10).is().displayed();
        materialDesignIcons.get(10).has().type("folder_open");
        materialDesignIcons.get(10).has().height("24px");
        materialDesignIcons.get(10).has().width("24px");

        materialDesignIcons.get(11).is().displayed();
        materialDesignIcons.get(11).has().type("widgets");
        materialDesignIcons.get(11).has().height("24px");
        materialDesignIcons.get(11).has().width("24px");

        materialDesignIcons.get(12).is().displayed();
        materialDesignIcons.get(12).has().type("gavel");
        materialDesignIcons.get(12).has().height("24px");
        materialDesignIcons.get(12).has().width("24px");

        materialDesignIcons.get(13).is().displayed();
        materialDesignIcons.get(13).has().type("home");
        materialDesignIcons.get(13).has().height("36px");
        materialDesignIcons.get(13).has().width("36px");

        materialDesignIcons.get(14).is().displayed();
        materialDesignIcons.get(14).has().type("event");
        materialDesignIcons.get(14).has().height("36px");
        materialDesignIcons.get(14).has().width("36px");

        materialDesignIcons.get(15).is().displayed();
        materialDesignIcons.get(15).has().type("info");
        materialDesignIcons.get(15).has().height("36px");
        materialDesignIcons.get(15).has().width("36px");

        materialDesignIcons.get(16).is().displayed();
        materialDesignIcons.get(16).has().type("folder_open");
        materialDesignIcons.get(16).has().height("36px");
        materialDesignIcons.get(16).has().width("36px");

        materialDesignIcons.get(17).is().displayed();
        materialDesignIcons.get(17).has().type("widgets");
        materialDesignIcons.get(17).has().height("36px");
        materialDesignIcons.get(17).has().width("36px");

        materialDesignIcons.get(18).is().displayed();
        materialDesignIcons.get(18).has().type("gavel");
        materialDesignIcons.get(18).has().height("36px");
        materialDesignIcons.get(18).has().width("36px");

        materialDesignIcons.get(19).is().displayed();
        materialDesignIcons.get(19).has().type("home");
        materialDesignIcons.get(19).has().height("40px");
        materialDesignIcons.get(19).has().width("40px");

        materialDesignIcons.get(20).is().displayed();
        materialDesignIcons.get(20).has().type("event");
        materialDesignIcons.get(20).has().height("40px");
        materialDesignIcons.get(20).has().width("40px");

        materialDesignIcons.get(21).is().displayed();
        materialDesignIcons.get(21).has().type("info");
        materialDesignIcons.get(21).has().height("40px");
        materialDesignIcons.get(21).has().width("40px");

        materialDesignIcons.get(22).is().displayed();
        materialDesignIcons.get(22).has().type("folder_open");
        materialDesignIcons.get(22).has().height("40px");
        materialDesignIcons.get(22).has().width("40px");

        materialDesignIcons.get(23).is().displayed();
        materialDesignIcons.get(23).has().type("widgets");
        materialDesignIcons.get(23).has().height("40px");
        materialDesignIcons.get(23).has().width("40px");

        materialDesignIcons.get(24).is().displayed();
        materialDesignIcons.get(24).has().type("gavel");
        materialDesignIcons.get(24).has().height("40px");
        materialDesignIcons.get(24).has().width("40px");
    }

    @Test
    public void mdiSvgIconsTests() throws Exception {
        mdiSvgIcons.get(1).is().displayed();
        mdiSvgIcons.get(1).has().type("svg icon");
        mdiSvgIcons.get(1).has().height("24px");
        mdiSvgIcons.get(1).has().width("24px");

        mdiSvgIcons.get(2).is().displayed();
        mdiSvgIcons.get(2).has().type("svg icon");
        mdiSvgIcons.get(2).has().height("24px");
        mdiSvgIcons.get(2).has().width("24px");

        mdiSvgIcons.get(3).is().displayed();
        mdiSvgIcons.get(3).has().type("svg icon");
        mdiSvgIcons.get(3).has().height("24px");
        mdiSvgIcons.get(3).has().width("24px");

        mdiSvgIcons.get(4).is().displayed();
        mdiSvgIcons.get(4).has().type("svg icon");
        mdiSvgIcons.get(4).has().color(WHITE.value());
        mdiSvgIcons.get(4).has().height("18px");
        mdiSvgIcons.get(4).has().width("18px");
    }
}
