package io.github.epam.vuetify.tests.complex.bars;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.systemBarsPage;
import static io.github.com.enums.Colors.BLUE_DARKEN_2;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.INDIGO_DARKEN_2;
import static io.github.com.enums.Colors.RED_LIGHTEN_2;
import static io.github.com.pages.SystemBarsPage.appSystemBar;
import static io.github.com.pages.SystemBarsPage.coloredSystemBars;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "coloredSystemBarsTestData")
    public void coloredSystemBarTests(int barNum, String barText, String barColor) {
        coloredSystemBars.get(barNum).is().displayed();
        coloredSystemBars.get(barNum).has().text(barText);
        coloredSystemBars.get(barNum).icons().getButtonByIndex(1).is().displayed();
        coloredSystemBars.get(barNum).icons().getButtonByIndex(2).is().displayed();
        coloredSystemBars.get(barNum).icons().getButtonByIndex(3).is().displayed();
        /*coloredSystemBars.get(barNum).wiFiIcon().is().displayed();
        coloredSystemBars.get(barNum).signalIcon().is().displayed();
        coloredSystemBars.get(barNum).batteryIcon().is().displayed();*/
        coloredSystemBars.get(barNum).has().color(barColor);
    }

    @DataProvider(name = "coloredSystemBarsTestData")
    public static Object[][] coloredSystemBarsTestData() {
        return new Object[][]{
                {1, "System bar color 1", BLUE_DARKEN_2.value()},
                {2, "System bar color 2", RED_LIGHTEN_2.value()},
                {3, "System bar color 3", INDIGO_DARKEN_2.value()}
        };
    }
}
