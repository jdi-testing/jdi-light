package io.github.epam.vuetify.tests.complex.bars;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SystemBarDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.systemBarsPage;
import static io.github.com.pages.SystemBarsPage.absolutePositionSystemBar;
import static io.github.com.pages.SystemBarsPage.appSystemBar;
import static io.github.com.pages.SystemBarsPage.coloredSystemBars;
import static io.github.com.pages.SystemBarsPage.darkLightsOutSystemBar;
import static io.github.com.pages.SystemBarsPage.highSystemBar;
import static io.github.com.pages.SystemBarsPage.lightLightsOutSystemBar;
import static io.github.com.pages.SystemBarsPage.redColoredSystemBar;
import static io.github.com.pages.SystemBarsPage.windowSystemBar;

public class SystemBarsTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        systemBarsPage.open();
        waitCondition(() -> systemBarsPage.isOpened());
        systemBarsPage.checkOpened();
    }

    @Test(dataProviderClass = SystemBarDataProvider.class, dataProvider = "coloredSystemBarsTestData",
            description = "Test checks that system bar has expected background color")
    public void colorSystemBarTests(int barNum, String barColor) {
        coloredSystemBars.get(barNum).is().displayed();
        coloredSystemBars.get(barNum).has().backgroundColor(barColor);
    }

    @Test(description = "Test checks that icons within system bar are displayed")
    public void iconBarTests() {
        redColoredSystemBar.show();
        redColoredSystemBar.wifiIcon().is().displayed();
        redColoredSystemBar.signalIcon().is().displayed();
        redColoredSystemBar.batteryIcon().is().displayed();
        redColoredSystemBar.timeSpan().has().text("12:30");
    }

    @Test(description = "Test checks light and dark theme of system bars")
    public void themeBarTest() {
        lightLightsOutSystemBar.show();
        lightLightsOutSystemBar.has().lightTheme();
        darkLightsOutSystemBar.has().darkTheme();
    }

    @Test(description = "Test checks height of system bar in different ways")
    public void heightBarTest() {
        highSystemBar.show();
        highSystemBar.has().heightGreaterThan(90)
                .and().heightLessThan(110)
                .and().height(100);
    }

    @Test(description = "Test checks lights out system bar")
    public void lightsOutBarTest() {
        lightLightsOutSystemBar.show();
        lightLightsOutSystemBar.is().lightsOut();
        darkLightsOutSystemBar.is().lightsOut();
        windowSystemBar.is().notLightsOut();
    }

    @Test(description = "Test checks window system bar")
    public void windowBarTest() {
        windowSystemBar.show();
        windowSystemBar.is().window();
        absolutePositionSystemBar.show();
        absolutePositionSystemBar.is().notWindow();
    }

    @Test(description = "Test checks that system bar has expected text")
    public void textBarTest() {
        absolutePositionSystemBar.show();
        absolutePositionSystemBar.title().has().text("System bar title");
        appSystemBar.show();
        appSystemBar.has().text("App system bar title");
    }
}
