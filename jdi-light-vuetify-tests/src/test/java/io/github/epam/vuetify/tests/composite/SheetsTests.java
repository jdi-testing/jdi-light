package io.github.epam.vuetify.tests.composite;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.sheetsPage;
import static io.github.com.pages.SheetsPage.defaultRoundedSheet;
import static io.github.com.pages.SheetsPage.elevation12Sheet;
import static io.github.com.pages.SheetsPage.elevation18Sheet;
import static io.github.com.pages.SheetsPage.elevation6Sheet;
import static io.github.com.pages.SheetsPage.fifthColoredSheet;
import static io.github.com.pages.SheetsPage.firstColoredSheet;
import static io.github.com.pages.SheetsPage.fourthColoredSheet;
import static io.github.com.pages.SheetsPage.roundedSheet;
import static io.github.com.pages.SheetsPage.secondColoredSheet;
import static io.github.com.pages.SheetsPage.sixthColoredSheet;
import static io.github.com.pages.SheetsPage.thirdColoredSheet;
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
        firstColoredSheet.has().color(Colors.GREY_LIGHTEN_3);
        firstColoredSheet.has().cssClasses(Matchers.hasItems("grey", "lighten-3"));

        secondColoredSheet.has().color(Colors.GREEN_LIGHTEN_3);
        secondColoredSheet.has().cssClasses(Matchers.hasItems("green", "lighten-3"));

        thirdColoredSheet.has().color(Colors.YELLOW_LIGHTEN_3);
        thirdColoredSheet.has().cssClasses(Matchers.hasItems("yellow", "lighten-3"));

        fourthColoredSheet.has().color(Colors.TEAL_LIGHTEN_3);
        fourthColoredSheet.has().cssClasses(Matchers.hasItems("teal", "lighten-3"));

        fifthColoredSheet.has().color(Colors.RED_LIGHTEN_3);
        fifthColoredSheet.has().cssClasses(Matchers.hasItems("red", "lighten-3"));

        sixthColoredSheet.has().color(Colors.PURPLE_LIGHTEN_3);
        sixthColoredSheet.has().cssClasses(Matchers.hasItems("purple", "lighten-3"));
    }

}
