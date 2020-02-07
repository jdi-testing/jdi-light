package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.mobile.elements.complex.table.Line;
import io.github.com.custom.MarvelUser;
import io.github.com.entities.MarvelUserSimple;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.mobile.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.mobile.elements.complex.table.Column.inColumn;
import static com.epam.jdi.mobile.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.mobile.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.UsersPage.users;
import static io.github.com.pages.UsersPage.usersRow;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static io.github.epam.test.data.MarvelHeroes.SPIDER_MAN_SIMPLE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class TableInteractTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        usersPage.shouldBeOpened();
    }

    @Test
    public void lineByIndexTest() {
        MarvelUser line = usersRow.line(1);
        line.type.select("User");
        assertEquals(typeSelected(),"User");
        line.type.select("Admin");
        assertEquals(typeSelected(),"Admin");
        line.description.vip.uncheck();
        assertFalse(isVip());
        line.description.vip.check();
        assertTrue(isVip());
    }
    private String typeSelected() {
        return new Select(getDriver().findElement(By.cssSelector("#user-table select")))
                .getFirstSelectedOption().getText();
    }
    private boolean isVip() {
        WebElement element = getDriver().findElement(By.cssSelector("#user-table input[type=checkbox]"));
        return element.isSelected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(users);
    }

    @Test
    public void tableParamsTest() {
        assertEquals(usersRow.size(), 4);
        assertEquals(usersRow.count(), 6);
        assertThat(usersRow.header(), hasItems("Number", "Type", "User", "Description"));
    }

    @Test
    public void previewTest() {
        String value = usersRow.preview();
        assertEquals(value.replaceAll(" ", ""),
        "NumberTypeUserDescription" +
            "1AdminUserManagerRomanWolverineVip" +
            "2AdminUserManagerSergeyIvanSpiderManVip" +
            "3AdminUserManagerVladzimirPunisherVip" +
            "4AdminUserManagerHelenBennettCaptainAmericasomedescriptionVip" +
            "5AdminUserManagerYoshiTannamuriCyclopesomedescriptionVip" +
            "6AdminUserManagerGiovanniRovelliHulksomedescriptionVip");
    }
    @Test
    public void valueTest() {
        String value = usersRow.getValue();
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
        assertEquals(usersRow.row(2)
                .asData(MarvelUserSimple.class), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void dataFilterTest() {
        assertEquals(usersRow.row(hasValue("Sergey Ivan", inColumn("User")),
                containsValue("User", inColumn("Type")))
                .asData(MarvelUserSimple.class), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void allDataFilterTest() {
        List<Line> filteredData = usersRow.rows(containsValue("Ivan", inColumn("User")));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0).asData(MarvelUserSimple.class), SPIDER_MAN_SIMPLE);
    }
    @Test
    public void commonMatchersTest() {
        usersRow.is().displayed();
        usersRow.has().size(6);
        usersRow.assertThat().size(greaterThan(3));
        usersRow.is().notEmpty().size(lessThanOrEqualTo(6));
    }
    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        usersRow.has().rowThat(containsValue("Ivan", inColumn("User")));
    }
    @Test
    public void rowsAllTest() {
        usersRow.assertThat().all().rows(containsValue("Vip", inColumn("Description")));
    }
    @Test
    public void noRowsTest() {
        usersRow.assertThat().no().rows(containsValue("Alex", inColumn("User")));
    }
    @Test
    public void atLeastTest() {
        usersRow.assertThat().atLeast(3).rows(containsValue(" ", inColumn("User")));
    }
    @Test
    public void exactMatcherTest() {
        usersRow.assertThat().exact(2).rows(containsValue("R", inColumn("User")));
    }
    @Test
    public void rowDataExactMatcherTest() {
        usersRow.assertThat().exact(1).rows(hasValue("Roman", inColumn("User")));
    }

    @Test
    public void tableChainTest() {
        usersRow.assertThat()
            .displayed().size(6).size(greaterThan(3)).notEmpty()
            .and().rowThat(containsValue("Ivan", inColumn("User")))
            .all().rows(containsValue("Vip", inColumn("Description")))
            .no().rows(containsValue("Alex", inColumn("User")))
            .atLeast(3).rows(containsValue(" ", inColumn("User")))
            .exact(2).rows(containsValue("R", inColumn("User")))
            .exact(1).rows(hasValue("Roman", inColumn("User")));
    }
}
