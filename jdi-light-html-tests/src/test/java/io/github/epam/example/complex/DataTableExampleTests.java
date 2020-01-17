package io.github.epam.example.complex;

import io.github.com.custom.PerformanceUserRow;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.tablePagePerformance;
import static io.github.com.entities.TableData.GRADY_BROCK;
import static io.github.com.pages.PerformancePage.usersData;
import static io.github.com.pages.PerformancePage.usersDataSetup;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataTableExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePagePerformance.shouldBeOpened();
    }

    @Test
    public void filterDataTest() {
        assertEquals(usersDataSetup.dataRow("Grady Brock"), GRADY_BROCK);
        assertEquals(usersDataSetup.dataRow(2), GRADY_BROCK);
        usersDataSetup.assertThat().row(d -> d.name.contains("Brock"));
        usersDataSetup.has().row(GRADY_BROCK);
        usersDataSetup.assertThat().row(d -> d.equals(GRADY_BROCK));
    }

    @Test
    public void filterLinesTest() {
        PerformanceUserRow line =  usersData.line(2);
        validateUserRow(line);
        line =  usersData.line("Grady Brock");
        validateUserRow(line);
        line =  usersData.line(d -> d.name.contains("Brock"));
        validateUserRow(line);
    }

    private void validateUserRow(PerformanceUserRow line) {
        line.city.click();
        validateAlert(is(GRADY_BROCK.city));
        assertEquals(line.email.getText(), GRADY_BROCK.email);
    }

    //following tests are disabled because of their long time of execution due to big amount of rows in the table
    @Test(enabled = false)
    public void rowMatcherTest() {
        usersDataSetup.assertThat().all().rows(d -> d.name.length() > 4);
        usersDataSetup.assertThat().no().rows(d -> isBlank(d.phone));
        usersDataSetup.assertThat().atLeast(2).rows(d -> d.name.contains("Sean"));
        usersDataSetup.assertThat().exact(15).rows(d -> d.phone.contains("0800 1111"));
        usersDataSetup.assertThat().exact(1).row(GRADY_BROCK);
    }

    @Test(enabled = false)
    public void rowMatcherChainTest() {
        usersDataSetup.assertThat()
                .all().rows(d -> d.name.length() > 4)
                .no().rows(d -> isBlank(d.phone))
                .atLeast(2).rows(d -> d.name.contains("Sean"))
                .exact(15).rows(d -> d.phone.contains("0800 1111"))
                .exact(1).row(GRADY_BROCK);
    }
}
