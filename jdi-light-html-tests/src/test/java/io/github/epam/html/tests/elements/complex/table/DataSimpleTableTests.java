package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.matchers.ValueMatcher;
import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.entities.MarvelUserSimple;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.matchers.ColumnMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.matchers.ColumnMatcher.hasValue;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.UsersPage.emptyTable;
import static io.github.com.pages.UsersPage.usersData;
import static io.github.epam.html.tests.elements.complex.table.TableTests.i;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.test.data.MarvelHeroes.SPIDER_MAN_SIMPLE;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.Assert.assertEquals;

public class DataSimpleTableTests implements TestsInit {
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
    public void screenshotTest() {
        // TODO
        //usersData.core().makePhoto();
    }
    @Test
    public void tableParamsTest() {
        WebPage.windowScreenshot();
        assertEquals(usersData.size(), 4);
        assertEquals(usersData.count(), 6);
        assertEquals(usersData.header(), asList("Number", "Type", "User", "Description"));
    }

    @Test
    public void previewTest() {
        String value = usersData.preview();
        assertEquals(value.replaceAll(" ", ""),
            "NumberTypeUserDescription1AdminUserManagerRomanWolverineVip2AdminUserManagerSergeyIvanSpiderManVip3AdminUserManagerVladzimirPunisherVip4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip6AdminUserManagerGiovanniRovelliHulksomedescriptionVip");
    }

    @Test
    public void valueTest() {
        String value = usersData.getValue().replaceAll("\r", "");
        assertEquals(value,
            "||X||Number|Type|User|Description||\n" +
            "||"+i(0)+"||1|Admin\\n User\\n Manager|Roman|Wolverine\\nVip||\n" +
            "||"+i(1)+"||2|Admin\\n User\\n Manager|Sergey Ivan|Spider Man\\nVip||\n" +
            "||"+i(2)+"||3|Admin\\n User\\n Manager|Vladzimir|Punisher\\nVip||\n" +
            "||"+i(3)+"||4|Admin\\n User\\n Manager|Helen Bennett|Captain America\\nsome description\\nVip||\n" +
            "||"+i(4)+"||5|Admin\\n User\\n Manager|Yoshi Tannamuri|Cyclope\\nsome description\\nVip||\n" +
            "||"+i(5)+"||6|Admin\\n User\\n Manager|Giovanni Rovelli|Hulk\\nsome description\\nVip||\n");
    }
    @Test
    public void dataColumnTestIndex() {
        assertEquals(usersData.dataRow(ELEMENT.startIndex + 1), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void dataFilterTest() {
        assertEquals(usersData.dataRow(d -> d.user.contains("Ivan")), SPIDER_MAN_SIMPLE);
    }

    @Test
    public void allDataFilterTest() {
        List<MarvelUserSimple> filteredData = usersData.dataRows(d -> d.user.contains("Ivan"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void commonMatchersTest() {
        usersData.is().displayed();
        usersData.has().size(6);
        usersData.assertThat().size(greaterThan(3));
        usersData.is().notEmpty().size(lessThanOrEqualTo(6));
    }
    @Test
    public void isEmptyTest() {
        emptyTable.is().empty();
    }
    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        usersData.has().row(d -> d.user.contains("Ivan"));
    }
    @Test
    public void rowDataMatcherTest() {
        usersData.has().row(SPIDER_MAN_SIMPLE);
    }
    @Test
    public void rowTableMatcherSingleTest() {
        usersData.has().rowThat(ValueMatcher.hasValue("Sergey Ivan"), inColumn("User"));
    }
    @Test
    public void rowTableMatcherTest() {
        usersData.has().rowThat(
            containsValue("User", inColumn("Type")),
            hasValue("Sergey Ivan", inColumn("User")));
    }
    @Test
    public void rowsAllTest() {
        usersData.assertThat().all().rows(d -> d.user.length() > 4);
    }
    @Test
    public void noRowsTest() {
        usersData.assertThat().no().rows(d -> isBlank(d.user));
    }
    @Test
    public void atLeastTest() {
        usersData.assertThat().atLeast(3).rows(d -> d.type.contains("User"));
    }
    @Test
    public void exactMatcherTest() {
        usersData.assertThat().exact(2).rows(d -> d.user.contains("R"));
    }
    @Test
    public void rowDataExactMatcherTest() {
        usersData.assertThat().exact(1).rows(SPIDER_MAN_SIMPLE);
    }
    //

    @Test
    public void tableChainTest() {
        usersData.assertThat()
            .displayed().size(6).size(greaterThan(3)).notEmpty()
            .row(d -> d.user.contains("Ivan"))
            .all().rows(d -> d.user.length() > 4)
            .no().rows(d -> isBlank(d.user))
            .atLeast(3).rows(d -> d.type.contains("User"))
            .and().row(SPIDER_MAN_SIMPLE)
            .exact(2).rows(d -> d.user.contains("R"))
            .exact(1).rows(SPIDER_MAN_SIMPLE);
    }
}
