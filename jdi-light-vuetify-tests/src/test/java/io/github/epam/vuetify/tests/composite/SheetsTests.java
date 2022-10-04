package io.github.epam.vuetify.tests.composite;

import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SheetsTestsDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.sheetsPage;
import static io.github.com.pages.SheetsPage.elevationSheets;
import static io.github.com.pages.SheetsPage.defaultRoundedSheet;
import static io.github.com.pages.SheetsPage.roundedSheet;
import static io.github.com.pages.SheetsPage.xlRoundedSheet;
import static io.github.com.pages.SheetsPage.coloredSheets;
import static io.github.com.pages.SheetsPage.outlinedSheet;
import static io.github.com.pages.SheetsPage.shapedSheet;
import static io.github.com.pages.SheetsPage.tileSheet;

public class SheetsTests extends TestsInit {

    @BeforeClass
    public void before() {
        sheetsPage.open();
        waitCondition(() -> sheetsPage.isOpened());
        sheetsPage.checkOpened();
    }

    @Test(dataProvider = "elevationSheetsTestData", dataProviderClass = SheetsTestsDataProvider.class)
    public void elevationSheetsTest(int index, int elevation) {
        elevationSheets.get(index).show();
        elevationSheets.get(index).is().elevated().and().has().elevation(elevation);
    }

    @Test
    public void roundedSheetsTest() {
        defaultRoundedSheet.has().borderRadius(0);
        roundedSheet.is().rounded().and().has().borderRadius(4);
        xlRoundedSheet.is().rounded().and().has().borderRadius(24);
    }

    @Test(dataProvider = "colorSheetsTestData", dataProviderClass = SheetsTestsDataProvider.class)
    public void colorSheetsTest(int index, String color) {
        coloredSheets.get(index).show();
        coloredSheets.get(index).has().color(color);
    }

    @Test
    public void themeSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).is().lightTheme();
    }

    @Test
    public void heightSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).has().height(100);
    }

    @Test
    public void widthSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).has().width(100);
    }

    @Test
    public void outlinedSheetsTest() {
        outlinedSheet.show();
        outlinedSheet.is().outlined();
    }

    @Test
    public void shapedSheetsTest() {
        shapedSheet.show();
        shapedSheet.is().shaped();
    }

    @Test
    public void tileSheetsTest() {
        tileSheet.show();
        tileSheet.is().tile();
    }

    @Test
    public void textSheetsTest() {
        coloredSheets.get(1).show();
        coloredSheets.get(1).has().text("#1: (3r x 2c)");
    }
}
