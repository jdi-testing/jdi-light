package io.github.epam.html.tests.elements.complex;

import io.github.com.custom.MarvelUser;
import io.github.com.entities.MarvelUserInfo;
import io.github.com.entities.MarvelUserSimple;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.UsersPage.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.test.data.MarvelHeroes.SPIDER_MAN_SIMPLE;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class DataTableTestsNoRowEntity extends TestsInit {
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
        assertEquals(users2.size(), 4);
        assertEquals(users2.count(), 6);
        assertEquals(users2.header(), asList("Number", "Type", "User", "Description"));
    }

    @Test
    public void previewTest() {
        String value = users2.preview();
        assertEquals(value.replaceAll(" ", ""),
            "NumberTypeUserDesciption1AdminUserManagerRomanWolverineVip2AdminUserManagerSergeyIvanSpiderManVip3AdminUserManagerVladzimirPunisherVip4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip6AdminUserManagerGiovanniRovelliHulksomedescriptionVip");
    }

    @Test
    public void valueTest() {
        String value = users2.getValue().replaceAll("\r", "");
        assertEquals(value,
        "||X||Number|Type|User|Description||\n" +
            "||1||1|Admin\\n User\\n Manager|Roman|Wolverine\\nVip||\n" +
            "||2||2|Admin\\n User\\n Manager|Sergey Ivan|Spider Man\\nVip||\n" +
            "||3||3|Admin\\n User\\n Manager|Vladzimir|Punisher\\nVip||\n" +
            "||4||4|Admin\\n User\\n Manager|Helen Bennett|Captain America\\nsome description\\nVip||\n" +
            "||5||5|Admin\\n User\\n Manager|Yoshi Tannamuri|Cyclope\\nsome description\\nVip||\n" +
            "||6||6|Admin\\n User\\n Manager|Giovanni Rovelli|Hulk\\nsome description\\nVip||\n");
    }
    @Test
    public void dataColumnTestIndex() {
        assertEquals(users2.data(2), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void dataFilterTest() {
        assertEquals(users2.data(d -> d.user.contains("Ivan")), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void allDataFilterTest() {
        List<MarvelUserSimple> filteredData = users2.datas(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void commonMatchersTest() {
        users2.is().displayed();
        users2.has().size(6);
        users2.assertThat().size(greaterThan(3));
        users2.is().notEmpty().size(lessThanOrEqualTo(6));
    }
    @Test
    public void rowMatcherTest() {
        users2.has().row(d -> d.user.contains("Ivan"));
    }
    @Test
    public void rowsMatcherTest() {
        users2.assertThat().allRows(d -> d.user.length() > 4);
    }
    @Test
    public void noRowsMatcherTest() {
        users2.assertThat().noRows(d -> isBlank(d.user));
    }
    @Test
    public void atLeastMatcherTest() {
        users2.assertThat().atLeast(3).rows(d -> d.type.contains("User"));
    }
    @Test
    public void exactMatcherTest() {
        users2.assertThat().exact(3).rows(d -> d.description.contains("description"));
    }
    @Test
    public void rowDataMatcherTest() {
        users2.has().row(SPIDER_MAN_SIMPLE);
    }
    @Test
    public void rowDataExactMatcherTest() {
        users2.assertThat().exact(1).rows(SPIDER_MAN_SIMPLE);
    }
    @Test
    public void tableChainTest() {
        users2.assertThat()
            .displayed()
            .size(6)
            .size(greaterThan(3))
            .notEmpty()
            .row(d -> d.user.contains("Ivan"))
            .allRows(d -> d.user.length() > 4)
            .atLeast(3).rows(d -> d.type.contains("User"))
            .row(SPIDER_MAN_SIMPLE)
            .exact(3).rows(d -> d.description.contains("description"))
            .exact(1).rows(SPIDER_MAN_SIMPLE);
    }
    @Test
    public void assertDataTest() {
        users2.assertThat(not(empty()));
        users2.assertThat(hasItem(SPIDER_MAN_SIMPLE));
    }
}
