package io.github.epam.example.complex;

import io.github.com.custom.UserRow;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.performancePage;
import static io.github.com.entities.TableData.GRADY_BROCK;
import static io.github.com.pages.PerformancePage.usersDataTable ;
import static io.github.com.pages.PerformancePage.usersDataTableSetup;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.apache.logging.log4j.util.Strings.isBlank;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataTableExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        performancePage.shouldBeOpened();
    }

    @Test
    public void filterDataTest() {
        assertEquals(usersDataTableSetup.dataRow("Grady Brock"), GRADY_BROCK);
        assertEquals(usersDataTableSetup.dataRow(2), GRADY_BROCK);
        usersDataTableSetup.assertThat().row(d -> d.name.contains("Brock"));
        usersDataTableSetup.has().row(GRADY_BROCK);
        usersDataTableSetup.assertThat().row(d -> d.equals(GRADY_BROCK));
    }

    @Test
    public void filterLinesTest() {
        UserRow line =  usersDataTable.line(2);
        validateUserRow(line);
        line =  usersDataTable.line("Grady Brock");
        validateUserRow(line);
        line =  usersDataTable.line(d -> d.name.contains("Brock"));
        validateUserRow(line);
    }

    private void validateUserRow(UserRow line) {
        line.city.click();
        validateAlert(is(GRADY_BROCK.city));
        assertEquals(line.email.getText(), GRADY_BROCK.email);
    }

    //following tests are disabled because of their long time of execution due to big amount of rows in the table
    @Test(enabled = false)
    public void rowMatcherTest() {
        usersDataTableSetup.assertThat().all().rows(d -> d.name.length() > 4);
        usersDataTableSetup.assertThat().no().rows(d -> isBlank(d.phone));
        usersDataTableSetup.assertThat().atLeast(2).rows(d -> d.name.contains("Sean"));
        usersDataTableSetup.assertThat().exact(15).rows(d -> d.phone.contains("0800 1111"));
        usersDataTableSetup.assertThat().exact(1).row(GRADY_BROCK);
    }

    @Test(enabled = false)
    public void rowMatcherChainTest() {
        usersDataTableSetup.assertThat()
                .all().rows(d -> d.name.length() > 4)
                .no().rows(d -> isBlank(d.phone))
                .atLeast(2).rows(d -> d.name.contains("Sean"))
                .exact(15).rows(d -> d.phone.contains("0800 1111"))
                .exact(1).row(GRADY_BROCK);
    }
}
