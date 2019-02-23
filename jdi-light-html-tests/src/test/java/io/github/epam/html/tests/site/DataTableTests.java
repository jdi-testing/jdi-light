package io.github.epam.html.tests.site;

import io.github.com.custom.MarvelUser;
import io.github.com.entities.MarvelUserInfo;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.UsersPage.users;
import static io.github.com.pages.UsersPage.usersSetup;
import static io.github.epam.html.tests.elements.complex.DataTableInteractTests.validateUserRow;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static io.github.epam.test.data.MarvelHeroes.SPIDER_MAN;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.Assert.assertEquals;

public class DataTableTests extends TestsInit {
    private boolean firstTime = true;
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        if (firstTime) {
            usersPage.open();
            firstTime = false;
        }
    }

    @Test
    public void dataTableTest() {
        assertEquals(users.size(), 4);
        assertEquals(users.count(), 6);
        assertEquals(users.header(), asList("Number", "Type", "User", "Description"));

        String value = users.preview();
        assertEquals(value,
        "Number Type User Desciption1  Admin User Manager RomanWolverineVip2  Admin User Manager Sergey IvanSpider ManVip3  Admin User Manager VladzimirPunisherVip4  Admin User Manager Helen BennettCaptain Americasome descriptionVip5  Admin User Manager Yoshi TannamuriCyclopesome descriptionVip6  Admin User Manager Giovanni RovelliHulksome descriptionVip");
        value = users.getValue();
        assertEquals(value,
        "||X||Number|Type|User|Description||\r\n" +
            "||1||1|Admin|Roman|Wolverine:VIP||\r\n" +
            "||2||2|User|Sergey Ivan|Spider Man:Dude||\r\n" +
            "||3||3|Manager|Vladzimir|Punisher:VIP||\r\n" +
            "||4||4|User|Helen Bennett|Captain America\\nsome description:Dude||\r\n" +
            "||5||5|User|Yoshi Tannamuri|Cyclope\\nsome description:Dude||\r\n" +
            "||6||6|User|Giovanni Rovelli|Hulk\\nsome description:Dude||\r\n");
    }
    @Test
    public void filterDataTest() {
        assertEquals(users.data(2), SPIDER_MAN);
        assertEquals(usersSetup.data("Sergey Ivan"), SPIDER_MAN);
        assertEquals(users.data(d -> d.user.contains("Ivan")), SPIDER_MAN);

        List<MarvelUserInfo> filteredData = users.datas(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), SPIDER_MAN);
    }
    @Test
    public void tableAssertsTest() {
        users.is().displayed();
        users.has().size(6);
        users.assertThat().size(greaterThan(3));
        users.is().size(lessThanOrEqualTo(6));
        users.is().notEmpty();
        users.has().row(d -> d.user.contains("Ivan"));
        users.assertThat().allRows(d -> d.user.length() > 4);
        users.assertThat().atLeast(3).rows(d -> d.type.contains("User"));
        users.assertThat().exact(2).rows(d -> d.description.contains(":VIP"));
        users.has().row(SPIDER_MAN);
        users.assertThat().exact(1).rows(SPIDER_MAN);
    }

    @Test
    public void filterLinesTest() {
        MarvelUser line = users.line(2);
        validateUserRow(line);
        line = usersSetup.line("Sergey Ivan");
        validateUserRow(line);
        line =  users.line(d -> d.user.contains("Ivan"));
        validateUserRow(line);

        List<MarvelUser> filteredData = users.lines(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        validateUserRow(filteredData.get(0));
        usersPage.open();
    }
}
