package io.github.epam.html.tests.elements.complex.table;

import io.github.com.custom.MarvelUser;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.UsersPage.users;
import static io.github.com.pages.UsersPage.usersSetup;
import static io.github.epam.html.tests.elements.BaseValidationsUtils.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class DataTableInteractTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        usersPage.shouldBeOpened();
    }

    @Test
    public void lineByIndexTest() {
        MarvelUser line = users.line(2);
        validateUserRow(line);
    }
    @Test
    public void lineByNameTest() {
        MarvelUser line = usersSetup.line("Sergey Ivan");
        validateUserRow(line);
    }
    @Test
    public void lineFilterTest() {
        MarvelUser line = users.line(d -> d.user.contains("Ivan"));
        validateUserRow(line);
    }
    @Test
    public void linesFilterTest() {
        List<MarvelUser> filteredData = users.lines(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        validateUserRow(filteredData.get(0));
    }

    public static void validateUserRow(MarvelUser line) {
        line.type.select("Admin");
        assertEquals(line.type.getValue(), "Admin");
        line.type.select("User");
        line.number.assertThat().text(is("2"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(users);
    }
}
