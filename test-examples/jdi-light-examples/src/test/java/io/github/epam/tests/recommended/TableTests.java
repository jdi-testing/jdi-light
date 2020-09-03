package io.github.epam.tests.recommended;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.complex.table.Table;
import io.github.epam.StaticTestsInit;
import io.github.epam.custom.UserRow;
import io.github.epam.entities.UserInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAndAcceptAlert;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.PerformancePage.users;
import static io.github.com.pages.PerformancePage.usersSetup;
import static io.github.epam.test.data.TableData.GRADY_BROCK;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class TableTests extends StaticTestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    // too long for regular run
    @Test
    public void tablePerformanceTest() {
        tablePerformance(users);
    }
    @Test
    public void jTablePerformanceTest() {
        tablePerformance(usersSetup);
    }
    
    private void tablePerformance(Table table) {
        assertEquals(table.size(), 4);
        assertEquals(table.count(), 400);
        assertEquals(table.header(), asList("Name", "Phone", "Email", "City"));
        start();
        assertEquals(table.row(1).getValue(),
                "Burke Tucker;076 1971 1687;et.euismod.et@ut.edu;GozŽe");
        logTime("Get 1 row");
        //assertEquals(table.row("Imphal").getValue(),
        //        "Yen Stevenson;07624 310007;in@Sedeu.edu;Imphal");
        assertEquals(table.row("Burke Tucker").getValue(),
                "Burke Tucker;076 1971 1687;et.euismod.et@ut.edu;GozŽe");
        logTime("Get 'Burke Tucker' row");

        String zacharyEmail = "ipsum.non.arcu@auctorullamcorper.ca";
        assertEquals(table.cell(3,4), zacharyEmail);
        logTime("Get cell(3,4)");
        assertEquals(table.cell("Email",4), zacharyEmail);
        logTime("Get cell(Email,4)");
        assertEquals(table.cell(3,"Zachary Hendrix"), zacharyEmail);
        logTime("Get cell(3,Zachary Hendrix)");
        assertEquals(table.cell("Email","Zachary Hendrix"), zacharyEmail);
        logTime("Get cell(Email,Zachary Hendrix)");

        assertEquals(table.jsColumn(2).get(1), "(011307) 16843");
        logTime("Get column(2)");

        assertEquals(table.jsColumn("Phone").get(1),"(011307) 16843");
        logTime("Get column(Phone)");

        String value = table.preview();
        assertThat(value, containsString("Name Phone Email City " +
            "Burke Tucker 076 1971 1687 et.euismod.et@ut.edu GozŽe " +
            "Grady Brock (011307) 16843 cursus.et@commodo.org Alcobendas " +
            "Harding Lloyd 0800 1111 neque.In.ornare@mauris.co.uk Beauv"));
        logTime("Preview");
        value = table.getValue();
        assertThat(value, containsString("||X||Name|Phone|Email|City||" + LINE_BREAK +
            "||1||Burke Tucker|076 1971 1687|et.euismod.et@ut.edu|GozŽe||" + LINE_BREAK +
            "||2||Grady Brock|(011307) 16843|cursus.et@commodo.org|Alcobendas||" + LINE_BREAK +
            "||3||Harding Lloyd|0800 1111|neque.In.ornare@mauris.co.uk|Beauvais||"));
        logTime("Get value");
    }

    @Test
    public void tableDataTest() {
        assertEquals(users.row(2).asData(UserInfo.class),
                GRADY_BROCK);
    }

    @Test
    public void tableEntityTest() {
        UserRow user = users.row(2).asLine(UserRow.class);
        user.name.click();
        Alerts.validateAndAcceptAlert(containsString("Brock"));
        user.city.click();
        Alerts.validateAndAcceptAlert(is("Alcobendas"));
    }

    private static long timeStart;
    static void start() {
        timeStart = currentTimeMillis();
    }
    static void logTime(String description) {
        out.println(description + ": " + (currentTimeMillis() - timeStart) + "ms");
        timeStart = currentTimeMillis();
    }
}
