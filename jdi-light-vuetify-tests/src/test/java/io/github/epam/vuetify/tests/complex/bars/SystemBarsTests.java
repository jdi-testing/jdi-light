package io.github.epam.vuetify.tests.complex.bars;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.systemBarsPage;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.pages.SystemBarsPage.windowSystemBar;
import static io.github.com.pages.SystemBarsPage.coloredSystemBars;
import static io.github.com.pages.SystemBarsPage.appSystemBar;
import static io.github.com.pages.SystemBarsPage.redColoredSystemBar;



import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SystemBarDataProvider;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SystemBarsTests extends TestsInit {

    @BeforeClass
    public void beforeTest() {
        systemBarsPage.open();
        waitCondition(() -> systemBarsPage.isOpened());
        systemBarsPage.checkOpened();
    }

    @Test
    public void systemBarColoredPrimaryTests() {
        appSystemBar.is().displayed();
        appSystemBar.has().text("App system bar title");
        appSystemBar.has().classValue(Matchers.containsString("fixed"));
        appSystemBar.has().color(GREEN.value());
        appSystemBar.menuButton().is().displayed();
        appSystemBar.heartButton().is().displayed();
        appSystemBar.verticalDotsButton().is().displayed();
    }

    @Test(dataProviderClass = SystemBarDataProvider.class,
          dataProvider = "coloredSystemBarsTestData")
    public void coloredSystemBarTests(int barNum, String barText, String barColor) {
        coloredSystemBars.get(barNum).is().displayed();
        coloredSystemBars.get(barNum).has().text(barText);
        coloredSystemBars.get(barNum).has().color(barColor);
    }

    @Test
    public void windowSystemBarTests() {
        windowSystemBar.show();
        windowSystemBar.systemBar().is().displayed();
        windowSystemBar.systemBar().has().classValue(Matchers.containsString("v-system-bar"));
        windowSystemBar.icons().get(1).has().classValue(Matchers.containsString("mdi-minus"));
        windowSystemBar.icons().get(2).has().classValue(Matchers.containsString("mdi-checkbox-blank-outline"));
        windowSystemBar.icons().get(3).has().classValue(Matchers.containsString("mdi-close"));
    }

    @Test
    public void iconBarTests() {
        redColoredSystemBar.show();
        redColoredSystemBar.wifiIcon().is().displayed();
        redColoredSystemBar.signalIcon().is().displayed();
        redColoredSystemBar.batteryIcon().is().displayed();
        redColoredSystemBar.timeSpan().has().text("12:30");
    }
}
