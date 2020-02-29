package org.mytests.tests.example;

import org.mytests.tests.TestsInit;
import org.mytests.uiobjects.example.custom.MarvelUser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mytests.tests.states.States.shouldBeLoggedIn;
import static org.mytests.uiobjects.example.site.SiteJdi.usersPage;
import static org.mytests.uiobjects.example.site.pages.UsersPage.users;
import static org.mytests.uiobjects.example.site.pages.UsersPage.usersSetup;
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

}
