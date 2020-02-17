package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static io.github.com.StaticSite.performancePage;
import static io.github.com.pages.PerformancePage.usersTableSetup;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TableExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        performancePage.shouldBeOpened();
    }

    @Test
    public void tableReceivingDataTest() {
        assertThat(usersTableSetup.column("City").getValue().substring(0,26), is("GozŽe;Alcobendas;Beauvais;"));
        assertThat(usersTableSetup.preview().substring(0,35), is("Name Phone Email CityBurke Tucker 0"));
        assertThat(usersTableSetup.cell(1,4), is("Zachary Hendrix"));
    }

    @Test
    public void rowMatcherTest() {
        usersTableSetup.has().rowThat(containsValue("Colby Young", inColumn("Name")));
        usersTableSetup.assertThat().all().rows(containsValue("0", inColumn("Phone")));
        usersTableSetup.assertThat().no().rows(containsValue("Australopithecus", inColumn("Name")));
        usersTableSetup.assertThat().atLeast(2).rows(containsValue("Sean", inColumn("Name")));
        usersTableSetup.assertThat().exact(15).rows(containsValue("0800 1111", inColumn("Phone")));
    }

    @Test
    public void tableChainTest() {
        usersTableSetup.assertThat()
                .rowThat(containsValue("Colby Young", inColumn("Name")))
                .all().rows(containsValue("0", inColumn("Phone")))
                .no().rows(containsValue("Australopithecus", inColumn("Name")))
                .atLeast(2).rows(containsValue("Sean", inColumn("Name")))
                .exact(15).rows(containsValue("0800 1111", inColumn("Phone")));
    }

    @Test
    public void tableParamTest() {
        usersTableSetup.is().size(4);
        usersTableSetup.is().count(400);
        usersTableSetup.is().columns(asList("Name", "Phone", "Email", "City"));
    }
}
