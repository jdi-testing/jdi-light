package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.enums.Colors.BLACK;
import static io.github.com.enums.Colors.BLACK_TRANSPARENT_02;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.INDIGO_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.enums.Colors.WHITE_TRANSPARENT_07;
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
        systemBarColoredPrimary.wiFiIcon().is().displayed();
        systemBarColoredPrimary.signalIcon().is().displayed();
        systemBarColoredPrimary.batteryIcon().is().displayed();
        systemBarColoredPrimary.has().time("12:30");
        systemBarColoredPrimary.has().backgroundColor(BLUE_DARKEN_2.value());
    }

    @Test
    public void systemBarColoredRedTests() {
        systemBarColoredRed.is().displayed();
        systemBarColoredRed.has().text("System bar color 2");
        systemBarColoredRed.wiFiIcon().is().displayed();
        systemBarColoredRed.signalIcon().is().displayed();
        systemBarColoredRed.batteryIcon().is().displayed();
        systemBarColoredRed.has().time("12:30");
        systemBarColoredRed.has().backgroundColor(RED_LIGHTEN_2.value());
    }

    @Test
    public void systemBarColoredIndigoTests() {
        systemBarColoredIndigo.is().displayed();
        systemBarColoredIndigo.has().text("System bar color 3");
        systemBarColoredIndigo.wiFiIcon().is().displayed();
        systemBarColoredIndigo.signalIcon().is().displayed();
        systemBarColoredIndigo.batteryIcon().is().displayed();
        systemBarColoredIndigo.has().time("12:30");
        systemBarColoredIndigo.has().backgroundColor(INDIGO_DARKEN_2.value());
    }

    @Test
    public void systemBarLightsOutLightTests() {
        systemBarLightsOutLight.is().displayed();
        systemBarLightsOutLight.wiFiIcon().is().displayed();
        systemBarLightsOutLight.signalIcon().is().displayed();
        systemBarLightsOutLight.batteryIcon().is().displayed();
        systemBarLightsOutLight.has().time("12:30");
        systemBarLightsOutLight.has().backgroundColor(WHITE_TRANSPARENT_07.value());
    }

    @Test
    public void systemBarLightsOutDarkTests() {
        systemBarLightsOutDark.is().displayed();
        systemBarLightsOutDark.wiFiIcon().is().displayed();
        systemBarLightsOutDark.signalIcon().is().displayed();
        systemBarLightsOutDark.batteryIcon().is().displayed();
        systemBarLightsOutDark.has().time("12:30");
        systemBarLightsOutDark.has().backgroundColor(BLACK_TRANSPARENT_02.value());
    }

    @Test
    public void systemBarWindowTests() {
        systemBarWindow.is().displayed();
        systemBarWindow.has().text("10 unread messages");
        systemBarWindow.messageIcon().is().displayed();
        systemBarWindow.minusIcon().is().displayed();
        systemBarWindow.blankCheckboxIcon().is().displayed();
        systemBarWindow.closeIcon().is().displayed();
        systemBarWindow.has().backgroundColor(BLACK.value());
    }

    @Test
    public void systemBarAbsolutePositionTests() {
        systemBarAbsolutePosition.is().displayed();
        systemBarAbsolutePosition.menuButton().is().displayed();
        systemBarAbsolutePosition.verticalDotsButton().is().displayed();
        systemBarAbsolutePosition.has().title();
        systemBarAbsolutePosition.has().textInTitle("System bar title");
        systemBarAbsolutePosition.has().position("absolute");
    }

    @Test
    public void systemBarAppTests() {
        systemBarApp.is().displayed();
        systemBarApp.menuButton().is().displayed();
        systemBarApp.verticalDotsButton().is().displayed();
        systemBarApp.heartButton().is().displayed();
        systemBarApp.has().title();
        systemBarApp.has().textInTitle("App system bar title");
        systemBarApp.has().position("fixed");
    }

    @Test
    public void systemBarHighTests() {
        systemBarHigh.is().displayed();
        systemBarHigh.menuButton().is().displayed();
        systemBarHigh.verticalDotsButton().is().displayed();
        systemBarHigh.has().title();
        systemBarHigh.has().textInTitle("System bar title");
    }
}
