package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.dataFurnitureSharp;
import static io.github.epam.html.tests.elements.complex.table.TableDataProvider.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class DataGridSharpHeaderTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void webCellsTest() {
        assertEquals(dataFurnitureSharp.webCells().size(), 20);
    }

    @Test
    public void sizeTest() {
        assertEquals(dataFurnitureSharp.size(), 4);
    }

    @Test
    public void countTest() {
        assertEquals(dataFurnitureSharp.count(), 5);
    }

    @Test
    public void columnsTest() {
        List<Line> columns = dataFurnitureSharp.columns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(0).size(), 5);
    }

    @Test
    public void rowsTest() {
        List<Line> rows = dataFurnitureSharp.rows();
        assertEquals(rows.size(), 5);
        assertEquals(rows.get(0).size(), 4);
    }

    @Test
    public void headerTest() {
        assertEquals(dataFurnitureSharp.header(), asList("Name", "Type", "Cost", "Weight"));
    }

    @Test
    public void rowHeaderTest() {
        assertEquals(dataFurnitureSharp.rowHeader(), asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void valueTest() {
        String value = dataFurnitureSharp.getValue();
        assertEquals(value,
                "Name Type Cost * #\n" +
                        "Chair furniture 3.5 2\n" +
                        "Table furniture 3.5 3.5\n" +
                        "Sofa furniture 2 2\n" +
                        "Kitchen kitchen 400\n" +
                        "Robot robo");
    }

    @Test
    public void iterationTest() {
        int i = 0;
        for (Furniture furniture : dataFurnitureSharp) {
            assertThat(furniture.name, is(NAME_COLUMN[i++]));
        }
    }

    @Test
    public void dataRowTestIndex() {
        dataFurnitureSharp.has().row(CHAIR);
        dataFurnitureSharp.has().row(TABLE);
        dataFurnitureSharp.has().row(SOFA);
    }

    @Test
    public void dataColumnTestIndex() {
        assertThat(dataFurnitureSharp.column(2), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureSharp.column(3), hasItems(COST_COLUMN));
        assertThat(dataFurnitureSharp.column(4), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataColumnNameTest() {
        assertThat(dataFurnitureSharp.column("Type"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureSharp.column("Cost"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureSharp.column("Weight"), hasItems(WEIGHT_COLUMN));

        assertThat(dataFurnitureSharp.column("TYPE"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureSharp.column("COST *"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureSharp.column("WEIGHT "), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = dataFurnitureSharp.dataList(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        dataFurnitureSharp.is().displayed();
        dataFurnitureSharp.has().size(5);
        dataFurnitureSharp.assertThat().size(greaterThan(3));
        dataFurnitureSharp.is().notEmpty().size(lessThanOrEqualTo(7));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        dataFurnitureSharp.has().row(r -> r.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        dataFurnitureSharp.has().row(TABLE);
    }

    @Test
    public void rowsAllTest() {
        dataFurnitureSharp.has().all().rows(r -> r.name.length() >= 4);
    }

    @Test
    public void noRowsTest() {
        dataFurnitureSharp.has().no().rows(r -> isBlank(r.name));
    }

    @Test
    public void atLeastTest() {
        dataFurnitureSharp.has()
            .atLeast(3).rows(r -> r.type.contains("furniture"));
    }

    @Test
    public void exactMatcherTest() {
        dataFurnitureSharp.has().exact(2).rows(r -> r.cost.contains("3.5"));
    }

    @Test
    public void rowDataExactMatcherTest() {
        dataFurnitureSharp.has().exact(1).row(TABLE);
    }

    @Test
    public void tableChainTest() {
        dataFurnitureSharp.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty();
    }
}
