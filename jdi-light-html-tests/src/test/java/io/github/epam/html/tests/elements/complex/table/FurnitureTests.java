package io.github.epam.html.tests.elements.complex.table;

import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.complex.table.Column.inColumn;
import static com.epam.jdi.light.elements.complex.table.matchers.ColumnMatcher.containsValue;
import static com.epam.jdi.light.elements.complex.table.matchers.ColumnMatcher.hasValue;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.furnitureJ;
import static io.github.com.pages.SimpleTablePage.simpleTable;
import static io.github.epam.html.tests.elements.complex.table.TableTests.i;
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
        assertEquals(furnitureJ.header(), asList("Name", "Type", "Cost *", "Weight"));
        assertEquals(furnitureJ.size(), 4);
        assertEquals(furnitureJ.count(), 5);
    }

    @Test
    public void simpleTableParamsTest() {
        assertEquals(simpleTable.header(), asList("Drivers", "Selenium Custom", "JavaScript, Appium, WinAPI, Sikuli"));
        assertEquals(simpleTable.size(), 3);
        assertEquals(simpleTable.count(), 6);
    }
    @Test
    public void simpleTableInteractTest() {
        assertEquals(simpleTable.cell(ELEMENT.startIndex, ELEMENT.startIndex), "Drivers");
        assertEquals(simpleTable.cell(ELEMENT.startIndex + 2, ELEMENT.startIndex + 5), "Cucumber, Jbehave, Thucydides, SpecFlow");
    }

    @Test
    public void previewTest() {
        String value = furnitureJ.preview();
        assertEquals(value.replace(" ", ""),
            "NameTypeCost*WeightChairfurniture3.52Tablefurniture3.53.5Sofafurniture22Kitchenkitchen400Robotrobo");
    }

    @Test
    public void valueTest() {
        String value = furnitureJ.getValue();
        assertEquals(value,
            "||X||Name|Type|Cost *|Weight||" + LINE_BREAK +
            "||"+i(0)+"||Chair|furniture|3.5|2||" + LINE_BREAK +
            "||"+i(1)+"||Table|furniture|3.5|3.5||" + LINE_BREAK +
            "||"+i(2)+"||Sofa|furniture|2|2||" + LINE_BREAK +
            "||"+i(3)+"||Kitchen|kitchen|400|||" + LINE_BREAK +
            "||"+i(4)+"||Robot|robo||||" + LINE_BREAK);
    }

    @Test
    public void dataColumnTestIndex() {
        assertEquals(furnitureJ.dataRow(ELEMENT.startIndex + 1), TABLE);
    }

    @Test
    public void dataColumnNameTest() {
        assertEquals(furnitureJ.dataRow("Table"), TABLE);
    }

    @Test
    public void dataFilterTest() {
        assertEquals(furnitureJ.dataRow(d -> d.name.contains("Tab")), TABLE);
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = furnitureJ.dataRows(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        furnitureJ.is().displayed();
        furnitureJ.has().size(5);
        furnitureJ.assertThat().size(greaterThan(3));
        furnitureJ.is().notEmpty().size(lessThanOrEqualTo(5));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        furnitureJ.has().row(d -> d.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        furnitureJ.has().row(TABLE);
    }

    @Test
    public void rowTableMatcherTest() {
        furnitureJ.has().rowThat(containsValue("furniture", inColumn("Type")),
                hasValue("Chair", inColumn("Name")));
    }

    @Test
    public void rowsAllTest() {
        furnitureJ.assertThat().all().rows(d -> d.name.length() >= 4);
    }

    @Test
    public void noRowsTest() {
        furnitureJ.assertThat().no().rows(d -> isBlank(d.name));
    }

    @Test
    public void atLeastTest() {
        furnitureJ.assertThat().atLeast(3).rows(d -> d.type.contains("furniture"));
    }

    @Test
    public void exactMatcherTest() {
        furnitureJ.assertThat().exact(2).rows(d -> d.cost.contains("3.5"));
    }

    @Test
    public void rowDataExactMatcherTest() {
        furnitureJ.assertThat().exact(1).rows(TABLE);
    }

    @Test
    public void tableChainTest() {
        furnitureJ.assertThat()
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
