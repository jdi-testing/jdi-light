package org.mytests.tests.example;

import org.junit.jupiter.api.*;
import org.mytests.tests.TestsInit;
import org.mytests.uiobjects.example.custom.MarvelUser;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mytests.tests.states.States.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.UsersPage.*;

public class DataTableInteractTests extends TestsInit {

    @BeforeEach
    void before() {
        shouldBeLoggedIn();
        usersPage.shouldBeOpened();
    }

    @Test
    void lineByIndexTest() {
        MarvelUser line = users.line(2);
        validateUserRow(line);
    }
    @Test
    void lineByNameTest() {
        MarvelUser line = usersSetup.line("Sergey Ivan");
        validateUserRow(line);
    }
    @Test
    void lineFilterTest() {
        MarvelUser line = users.line(d -> d.user.contains("Ivan"));
        validateUserRow(line);
    }
    @Test
    void linesFilterTest() {
        List<MarvelUser> filteredData = users.lines(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        validateUserRow(filteredData.get(0));
    }

    static void validateUserRow(MarvelUser line) {
        line.type.select("Admin");
        assertEquals(line.type.getValue(), "Admin");
        line.type.select("User");
        line.number.assertThat().text(is("2"));
    }
}
