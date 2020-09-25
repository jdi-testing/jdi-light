package io.github.epam.html.tests.elements.complex.table;

import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.hasValue;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.furnitureTable;
import static io.github.com.pages.SimpleTablePage.simpleTable;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class FurnitureTests implements TestsInit {
    public Furniture TABLE = new Furniture().set(x -> {
        x.name = "Table"; x.type = "furniture"; x.cost = "3.5"; x.weight = "3.5";
    });
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.open();
    }

    @Test
    public void tableParamsTest() {
        assertEquals(furnitureTable.size(), 4);
        assertEquals(furnitureTable.count(), 5);
        assertEquals(furnitureTable.header(), asList("Name", "Type", "Cost", "Weight"));
    }
    @Test
    public void simpleTableParamsTest() {
        assertEquals(simpleTable.size(), 3);
        assertEquals(simpleTable.count(), 6);
        assertEquals(simpleTable.header(), asList("Drivers", "Selenium Custom", "JavaScript, Appium, WinAPI, Sikuli"));
    }
    @Test
    public void simpleTableInteractTest() {
        assertEquals(simpleTable.cell(1,1), "Drivers");
        assertEquals(simpleTable.cell(3,6), "Cucumber, Jbehave, Thucydides, SpecFlow");
    }

    @Test
    public void previewTest() {
        String value = furnitureTable.preview();
        assertEquals(value.replaceAll(" ", ""),
                "NameTypeCost*#Chairfurniture3.52Tablefurniture3.53.5Sofafurniture22Kitchenkitchen400Robotrobo");
    }

    @Test
    public void valueTest() {
        String value = furnitureTable.getValue();
        assertEquals(value,
            "||X||Name|Type|Cost|Weight||" + LINE_BREAK +
            "||1||Chair|furniture|3.5|2||" + LINE_BREAK +
            "||2||Table|furniture|3.5|3.5||" + LINE_BREAK +
            "||3||Sofa|furniture|2|2||" + LINE_BREAK +
            "||4||Kitchen|kitchen|400|||" + LINE_BREAK +
            "||5||Robot|robo||||" + LINE_BREAK);
    }

    @Test
    public void dataColumnTestIndex() {
        assertEquals(furnitureTable.dataRow(2), TABLE);
    }

    @Test
    public void dataColumnNameTest() {
        assertEquals(furnitureTable.dataRow("Table"), TABLE);
    }

    @Test
    public void dataFilterTest() {
        assertEquals(furnitureTable.dataRow(d -> d.name.contains("Tab")), TABLE);
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = furnitureTable.dataRows(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        furnitureTable.is().displayed();
        furnitureTable.has().size(5);
        furnitureTable.assertThat().size(greaterThan(3));
        furnitureTable.is().notEmpty().size(lessThanOrEqualTo(5));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        furnitureTable.has().row(d -> d.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        furnitureTable.has().row(TABLE);
    }

    @Test
    public void rowTableMatcherTest() {
        furnitureTable.has().rowThat(containsValue("furniture", inColumn("Type")),
                hasValue("Chair", inColumn("Name")));
    }

    @Test
    public void rowsAllTest() {
        furnitureTable.assertThat().all().rows(d -> d.name.length() >= 4);
    }

    @Test
    public void noRowsTest() {
        furnitureTable.assertThat().no().rows(d -> isBlank(d.name));
    }

    @Test
    public void atLeastTest() {
        furnitureTable.assertThat().atLeast(3).rows(d -> d.type.contains("furniture"));
    }

    @Test
    public void exactMatcherTest() {
        furnitureTable.assertThat().exact(2).rows(d -> d.cost.contains("3.5"));
    }

    @Test
    public void rowDataExactMatcherTest() {
        furnitureTable.assertThat().exact(1).rows(TABLE);
    }

    @Test
    public void tableChainTest() {
        furnitureTable.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty()
            .row(d -> d.name.contains("Tab"))
            .all().rows(d -> d.name.length() >= 4)
            .no().rows(d -> isBlank(d.name))
            .atLeast(3).rows(d -> d.type.contains("furniture"))
            .and().row(TABLE)
            .exact(2).rows(d -> d.cost.contains("3.5"))
            .exact(1).rows(TABLE);
    }
}
