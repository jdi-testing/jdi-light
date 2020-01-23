package org.mytests.tests.example;

import com.epam.jdi.light.elements.complex.table.Single;
import org.mytests.tests.TestsInit;
import org.mytests.uiobjects.example.entities.MarvelUserInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.mytests.tests.states.States.shouldBeLoggedIn;
import static org.mytests.tests.test.data.MarvelHeroes.SPIDER_MAN;
import static org.mytests.uiobjects.example.site.SiteJdi.usersPage;
import static org.mytests.uiobjects.example.site.pages.UsersPage.users;
import static org.mytests.uiobjects.example.site.pages.UsersPage.usersSetup;
import static org.testng.Assert.assertEquals;

public class DataTableTests extends TestsInit {
    private boolean firstTime = true;
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        usersPage.shouldBeOpened();
        if (firstTime) {
            usersPage.open();
            firstTime = false;
        }
    }

    @Test
    public void tableParamsTest() {
        assertEquals(users.size(), 5);
        assertEquals(users.count(), 6);
        assertEquals(users.header(), asList("Number", "Type", "User", "Description"));
    }

    @Test
    public void previewTest() {
        String value = users.preview();
        assertEquals(value.replaceAll(" ", ""),
            "NumberTypeUserDescription1AdminUserManagerRomanWolverineVip2AdminUserManagerSergeyIvanSpiderManVip3AdminUserManagerVladzimirPunisherVip4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip6AdminUserManagerGiovanniRovelliHulksomedescriptionVip");
    }

    @Test
    public void valueTest() {
        String value = users.getValue();
        assertEquals(value,
        "||X||Number|Type|User|Description||" + LINE_BREAK +
            "||1||1|Admin|Roman|Wolverine:VIP||" + LINE_BREAK +
            "||2||2|User|Sergey Ivan|Spider Man:Dude||" + LINE_BREAK +
            "||3||3|Manager|Vladzimir|Punisher:VIP||" + LINE_BREAK +
            "||4||4|User|Helen Bennett|Captain America\\nsome description:Dude||" + LINE_BREAK +
            "||5||5|User|Yoshi Tannamuri|Cyclope\\nsome description:Dude||" + LINE_BREAK +
            "||6||6|User|Giovanni Rovelli|Hulk\\nsome description:Dude||" + LINE_BREAK);
    }
    @Test
    public void dataColumnTestIndex() {
        assertEquals(users.dataRow(2), SPIDER_MAN);
    }
    @Test
    public void dataColumnNameTest() {
        assertEquals(usersSetup.dataRow("Sergey Ivan"), SPIDER_MAN);
    }
    @Test
    public void dataFilterTest() {
        assertEquals(users.dataRow(d -> d.user.contains("Ivan")), SPIDER_MAN);
    }
    @Test
    public void allDataFilterTest() {
        List<MarvelUserInfo> filteredData = users.dataRows(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), SPIDER_MAN);
    }
    @Test
    public void commonMatchersTest() {
        users.is().displayed();
        users.has().size(6);
        users.assertThat().size(greaterThan(3));
        users.is().notEmpty().size(lessThanOrEqualTo(6));
    }
    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        users.has().row(d -> d.user.contains("Ivan"));
    }
    @Test
    public void rowDataMatcherTest() {
        users.has().row(SPIDER_MAN);
    }
    @Test
    public void rowTableMatcherSingleTest() {
        users.has().rowThat(Single.hasValue("Sergey Ivan"), inColumn("User"));
    }
    @Test
    public void rowTableMatcherTest() {
        users.has().rowThat(containsValue("User", inColumn("Type")),
                hasValue("Sergey Ivan", inColumn("User")));
    }
    @Test
    public void rowsAllTest() {
        users.assertThat().all().rows(d -> d.user.length() > 4);
    }
    @Test
    public void noRowsTest() {
        users.assertThat().no().rows(d -> isBlank(d.user));
    }
    @Test
    public void atLeastTest() {
        users.assertThat().atLeast(3).rows(d -> d.type.contains("User"));
    }
    @Test
    public void exactMatcherTest() {
        users.assertThat().exact(2).rows(d -> d.description.contains(":VIP"));
    }
    @Test
    public void rowDataExactMatcherTest() {
        users.assertThat().exact(1).rows(SPIDER_MAN);
    }
    //


    @Test
    public void tableChainTest() {
        users.assertThat()
            .displayed().size(6).size(greaterThan(3)).notEmpty()
            .row(d -> d.user.contains("Ivan"))
            .all().rows(d -> d.user.length() > 4)
            .no().rows(d -> isBlank(d.user))
            .atLeast(3).rows(d -> d.type.contains("User"))
            .and().row(SPIDER_MAN)
            .exact(2).rows(d -> d.description.contains(":VIP"))
            .exact(1).rows(SPIDER_MAN);
    }
}
