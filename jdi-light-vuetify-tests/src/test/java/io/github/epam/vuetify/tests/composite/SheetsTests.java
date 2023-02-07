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

    @Test(dataProvider = "elevationSheetsTestData", dataProviderClass = SheetsTestsDataProvider.class,
            description = "Test checks that sheet is elevated and has expected elevation")
    public void elevationSheetsTest(int index, int elevation) {
        elevationSheets.get(index).show();
        elevationSheets.get(index).is().elevated().and().has().elevation(elevation);
    }

    @Test(description = "Test checks that rounded sheet has expected borderRadius parameter")
    public void roundedSheetsTest() {
        defaultRoundedSheet.has().borderRadius(0);
        roundedSheet.is().rounded().and().has().borderRadius(4);
        xlRoundedSheet.is().rounded().and().has().borderRadius(24);
    }

    @Test(dataProvider = "colorSheetsTestData", dataProviderClass = SheetsTestsDataProvider.class,
            description = "Test checks that sheet has expected color")
    public void colorSheetsTest(int index, String color) {
        coloredSheets.get(index).show();
        coloredSheets.get(index).has().color(color);
    }

    @Test(description = "Test checks that sheet has light theme")
    public void themeSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).is().lightTheme();
    }

    @Test(description = "Test checks that sheet has expected height")
    public void heightSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).has().height(100);
    }

    @Test(description = "Test checks that sheet has expected width")
    public void widthSheetsTest() {
        elevationSheets.get(1).show();
        elevationSheets.get(1).has().width(100);
    }

    @Test(description = "Test checks that sheet has outlines")
    public void outlinedSheetsTest() {
        outlinedSheet.show();
        outlinedSheet.is().outlined();
    }

    @Test(description = "Test checks that sheet is shaped")
    public void shapedSheetsTest() {
        shapedSheet.show();
        shapedSheet.is().shaped();
    }

    @Test(description = "Test checks that sheet is a tile")
    public void tileSheetsTest() {
        tileSheet.show();
        tileSheet.is().tile();
    }

    @Test(description = "Test checks that sheet has expected text")
    public void textSheetsTest() {
        coloredSheets.get(1).show();
        coloredSheets.get(1).has().text("#1: (3r x 2c)");
    }
}
