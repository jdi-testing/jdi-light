package io.github.epam.example.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static io.github.com.StaticSite.tablePagePerformance;
import static io.github.com.pages.PerformancePage.usersSetup;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TableExampleTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePagePerformance.shouldBeOpened();
    }

    @Test
    public void tableReceivingDataTest() {
        assertThat(usersSetup.column("City").getValue().substring(0,26), is("GozŽe;Alcobendas;Beauvais;"));
        assertThat(usersSetup.preview().substring(0,35), is("Name Phone Email CityBurke Tucker 0"));
        assertThat(usersSetup.cell(1,4), is("Zachary Hendrix"));
    }

    @Test
    public void rowMatcherTest() {
        usersSetup.has().rowThat(containsValue("Colby Young", inColumn("Name")));
        usersSetup.assertThat().all().rows(containsValue("0", inColumn("Phone")));
        usersSetup.assertThat().no().rows(containsValue("Australopithecus", inColumn("Name")));
        usersSetup.assertThat().atLeast(2).rows(containsValue("Sean", inColumn("Name")));
        usersSetup.assertThat().exact(15).rows(containsValue("0800 1111", inColumn("Phone")));
    }

    @Test
    public void tableChainTest() {
        usersSetup.assertThat()
                .rowThat(containsValue("Colby Young", inColumn("Name")))
                .all().rows(containsValue("0", inColumn("Phone")))
                .no().rows(containsValue("Australopithecus", inColumn("Name")))
                .atLeast(2).rows(containsValue("Sean", inColumn("Name")))
                .exact(15).rows(containsValue("0800 1111", inColumn("Phone")));
    }

    @Test
    public void tableParamTest() {
        usersSetup.is().size(4);
        usersSetup.is().count(400);
        usersSetup.is().columns(asList("Name", "Phone", "Email", "City"));
       /* assertThat(usersSetup.size(), is(4));
        assertThat(usersSetup.count(), is(400));
        assertThat(usersSetup.header(), hasItems("Name", "Phone", "Email", "City"));*/
    }
}
