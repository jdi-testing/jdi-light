package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLACK;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLACK_TRANSPARENT_02;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.BLUE_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.INDIGO_DARKEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.RED_LIGHTEN_2;
import static com.epam.jdi.light.vuetify.elements.enums.Colors.WHITE_TRANSPARENT_07;
import static io.github.com.StaticSite.systemBarsPage;
import static io.github.com.pages.SystemBarsPage.systemBarAbsolutePosition;
import static io.github.com.pages.SystemBarsPage.systemBarApp;
import static io.github.com.pages.SystemBarsPage.systemBarColoredIndigo;
import static io.github.com.pages.SystemBarsPage.systemBarColoredPrimary;
import static io.github.com.pages.SystemBarsPage.systemBarColoredRed;
import static io.github.com.pages.SystemBarsPage.systemBarHigh;
import static io.github.com.pages.SystemBarsPage.systemBarLightsOutDark;
import static io.github.com.pages.SystemBarsPage.systemBarLightsOutLight;
import static io.github.com.pages.SystemBarsPage.systemBarWindow;


public class SystemBarsTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        systemBarsPage.open();
    }

    @Test
    public void systemBarColoredPrimaryTests() {
        systemBarColoredPrimary.is().displayed();
        systemBarColoredPrimary.has().text("System bar color 1");
        systemBarColoredPrimary.has().wiFiIcon();
        systemBarColoredPrimary.has().signalIcon();
        systemBarColoredPrimary.has().batteryIcon();
        systemBarColoredPrimary.has().time("12:30");
        systemBarColoredPrimary.has().backgroundColor(BLUE_DARKEN_2.value());
    }

    @Test
    public void systemBarColoredRedTests() {
        systemBarColoredRed.is().displayed();
        systemBarColoredRed.has().text("System bar color 2");
        systemBarColoredRed.has().wiFiIcon();
        systemBarColoredRed.has().signalIcon();
        systemBarColoredRed.has().batteryIcon();
        systemBarColoredRed.has().time("12:30");
        systemBarColoredRed.has().backgroundColor(RED_LIGHTEN_2.value());
    }

    @Test
    public void systemBarColoredIndigoTests() {
        systemBarColoredIndigo.is().displayed();
        systemBarColoredIndigo.has().text("System bar color 3");
        systemBarColoredIndigo.has().wiFiIcon();
        systemBarColoredIndigo.has().signalIcon();
        systemBarColoredIndigo.has().batteryIcon();
        systemBarColoredIndigo.has().time("12:30");
        systemBarColoredIndigo.has().backgroundColor(INDIGO_DARKEN_2.value());
    }

    @Test
    public void systemBarLightsOutLightTests() {
        systemBarLightsOutLight.is().displayed();
        systemBarLightsOutLight.has().wiFiIcon();
        systemBarLightsOutLight.has().signalIcon();
        systemBarLightsOutLight.has().batteryIcon();
        systemBarLightsOutLight.has().time("12:30");
        systemBarLightsOutLight.has().backgroundColor(WHITE_TRANSPARENT_07.value());
    }

    @Test
    public void systemBarLightsOutDarkTests() {
        systemBarLightsOutDark.is().displayed();
        systemBarLightsOutDark.has().wiFiIcon();
        systemBarLightsOutDark.has().signalIcon();
        systemBarLightsOutDark.has().batteryIcon();
        systemBarLightsOutDark.has().time("12:30");
        systemBarLightsOutDark.has().backgroundColor(BLACK_TRANSPARENT_02.value());
    }

    @Test
    public void systemBarWindowTests() {
        systemBarWindow.is().displayed();
        systemBarWindow.has().text("10 unread messages");
        systemBarWindow.has().messageIcon();
        systemBarWindow.has().minusIcon();
        systemBarWindow.has().emptyCheckboxIcon();
        systemBarWindow.has().closeIcon();
        systemBarWindow.has().backgroundColor(BLACK.value());
    }

    @Test
    public void systemBarAbsolutePositionTests() {
        systemBarAbsolutePosition.is().displayed();
        systemBarAbsolutePosition.has().menuButton();
        systemBarAbsolutePosition.has().verticalDotsButton();
        systemBarAbsolutePosition.has().title();
        systemBarAbsolutePosition.has().properTitleText("System bar title");
        systemBarAbsolutePosition.has().position("absolute");
    }

    @Test
    public void systemBarAppTests() {
        systemBarApp.is().displayed();
        systemBarApp.has().menuButton();
        systemBarApp.has().verticalDotsButton();
        systemBarApp.has().heartButton();
        systemBarApp.has().title();
        systemBarApp.has().properTitleText("App system bar title");
        systemBarApp.has().position("fixed");
    }

    @Test
    public void systemBarHighTests() {
        systemBarHigh.is().displayed();
        systemBarHigh.has().menuButton();
        systemBarHigh.has().verticalDotsButton();
        systemBarHigh.has().title();
        systemBarHigh.has().properTitleText("System bar title");
    }
}
