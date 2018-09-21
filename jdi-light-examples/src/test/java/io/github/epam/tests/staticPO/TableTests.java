package io.github.epam.tests.staticPO;

import com.epam.jdi.light.elements.complex.table.Table;
import io.github.epam.StaticTestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.epam.tests.staticPO.steps.Preconditions.shouldBeLoggedIn;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static org.testng.Assert.assertEquals;
import static staticPageObject.StaticSite.tablePage;
import static staticPageObject.pages.PerformancePage.*;

public class TableTests extends StaticTestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }
    @Test
    public void tableTest() {
        out.println("==================");
        out.println("Table");
        tableTestScenario(users);
        out.println("==================");
        out.println("Fast Table");
        tableTestScenario(usersFast);
        out.println("==================");
    }
    private void tableTestScenario(Table table) {
        timeStart = currentTimeMillis();
        assertEquals(table.row(1).getValue(), "Burke Tucker,076 1971 1687,et.euismod.et@ut.edu,GozŽe");
        logTime("Get 1 row");
        String zacharyEmail = "ipsum.non.arcu@auctorullamcorper.ca";
        assertEquals(table.cell(3,4), zacharyEmail);
        logTime("Get cell(3,4)");
        assertEquals(table.cell("Email",4), zacharyEmail);
        logTime("Get cell(Email,4)");
        assertEquals(table.column(2).getValue().substring(0, 30),
                "076 1971 1687,(011307) 16843,0");
        logTime("Get column(1)");
        assertEquals(table.preview().substring(0,198),
                "Name Phone Email City\n" +
                        "Burke Tucker 076 1971 1687 et.euismod.et@ut.edu GozŽe\n" +
                        "Grady Brock (011307) 16843 cursus.et@commodo.org Alcobendas\n" +
                        "Harding Lloyd 0800 1111 neque.In.ornare@mauris.co.uk Beauvais\n");
        logTime("Preview");
        assertEquals(table.getValue().substring(0,230),
                "||X||Name|Phone|Email|City||\r\n" +
                        "||1||Burke Tucker|076 1971 1687|et.euismod.et@ut.edu|GozŽe||\r\n" +
                        "||2||Grady Brock|(011307) 16843|cursus.et@commodo.org|Alcobendas||\r\n" +
                        "||3||Harding Lloyd|0800 1111|neque.In.ornare@mauris.co.uk|Beauvais||\r\n");
        logTime("Get value");
    }

    private long timeStart;
    private void logTime(String description) {
        out.println(description + ": " + (currentTimeMillis() - timeStart) + "ms");
        timeStart = currentTimeMillis();
    }
}
