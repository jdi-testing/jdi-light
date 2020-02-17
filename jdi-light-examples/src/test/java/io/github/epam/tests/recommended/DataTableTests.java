package io.github.epam.tests.recommended;

import com.epam.jdi.light.elements.complex.table.DataTable;
import io.github.epam.StaticTestsInit;
import io.github.epam.custom.UserRow;
import io.github.epam.entities.UserInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.PerformancePage.*;
import static io.github.epam.test.data.TableData.GRADY_BROCK;
import static io.github.epam.tests.recommended.steps.Preconditions.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataTableTests extends StaticTestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void dataTableTest() {
        dataTableValidation(usersData);
    }
    @Test
    public void jDataTableTest() {
        dataTableValidation(usersDataSetup);
    }
    @Test
    public void customDataTableTest() {
        dataTableValidation(customUsersDataSetup);
    }
    private void dataTableValidation(DataTable<UserRow, UserInfo> table) {
        assertEquals(table.size(), 4);
        assertEquals(table.count(), 400);
        assertEquals(table.header(), asList("Name", "Phone", "Email", "City"));
        String value = table.preview();
        assertEquals(value.substring(0,194),
        "Name Phone Email City" +
            "Burke Tucker 076 1971 1687 et.euismod.et@ut.edu GozŽe" +
            "Grady Brock (011307) 16843 cursus.et@commodo.org Alcobendas" +
            "Harding Lloyd 0800 1111 neque.In.ornare@mauris.co.uk Beauvais");
    }
    @Test
    public void filterDataTest() {
        assertEquals(usersDataTable.dataRow(2), GRADY_BROCK);
        assertEquals(usersDataTable.dataRow("Grady Brock"), GRADY_BROCK);
        assertEquals(usersDataTable.dataRow(d -> d.name.contains("Brock")), GRADY_BROCK);
        usersDataTable.assertThat().row(d -> d.equals(GRADY_BROCK));
        usersDataTable.has().row(GRADY_BROCK);
        // This is just useful example for small tables.
        // Execution takes too much time in case of 400 rows
        //
        //List<UserInfo> filteredData = usersDataTable.dataRows(d -> d.name.contains("Brock"));
        //assertEquals(filteredData.size(), 1);
        //assertEquals(filteredData.get(0), GRADY_BROCK);
    }

    @Test
    public void filterLinesTest() {
        UserRow line =  usersDataTable.line(2);
        validateUserRow(line);
        line =  usersDataTable.line("Grady Brock");
        validateUserRow(line);
        line =  usersDataTable.line(d -> d.name.contains("Brock"));
        validateUserRow(line);
        // This is just useful example for small tables.
        // Execution takes too much time in case of 400 rows
        //
        //List<UserRow> filteredData = usersDataTable.lines(d -> d.name.contains("Brock"));
        //assertEquals(filteredData.size(), 1);
        //validateUserRow(filteredData.get(0));
    }

    private void validateUserRow(UserRow line) {
        line.city.click();
        validateAlert(is(GRADY_BROCK.city));
        assertEquals(line.email.getText(), GRADY_BROCK.email);
    }
}
