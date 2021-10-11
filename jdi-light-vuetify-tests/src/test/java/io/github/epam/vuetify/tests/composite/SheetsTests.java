package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.composite.Sheet;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.sheetsPage;
import static io.github.com.pages.SheetsPage.defaultRoundedSheet;
import static io.github.com.pages.SheetsPage.elevation12Sheet;
import static io.github.com.pages.SheetsPage.elevation18Sheet;
import static io.github.com.pages.SheetsPage.elevation6Sheet;
import static io.github.com.pages.SheetsPage.roundedSheet;
import static io.github.com.pages.SheetsPage.xlRoundedSheet;

public class SheetsTests extends TestsInit {

    @BeforeClass
    public void before() {
        sheetsPage.open();
        sheetsPage.checkOpened();
    }

    @Test
    public void elevationPropertyTest() {
        elevation6Sheet.has().elevation(6);
        elevation12Sheet.has().elevation(12);
        elevation18Sheet.has().elevation(18);
    }

    @Test
    public void roundedPropertyTest() {
        defaultRoundedSheet.has().borderRadius(0);
        roundedSheet.is().rounded().and().has().borderRadius(4);
        xlRoundedSheet.is().rounded().and().has().borderRadius(24);
    }

    @Test
    public void colorSheetsTest() {

    }

}
