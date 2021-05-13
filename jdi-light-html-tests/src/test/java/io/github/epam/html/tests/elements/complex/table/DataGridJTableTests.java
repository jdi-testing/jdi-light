package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.dataProductsJTable;
import static io.github.epam.html.tests.elements.complex.table.TableDataProvider.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class DataGridJTableTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void webCellsTest() {
        assertEquals(dataProductsJTable.webCells().size(), 20);
    }
    @Test
    public void sizeTest() {
        assertEquals(dataProductsJTable.size(), 4);
    }
    @Test
    public void countTest() {
        assertEquals(dataProductsJTable.count(), 5);
    }
    @Test
    public void columnsTest() {
        List<Line> columns = dataProductsJTable.columns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(0).size(), 5);
    }
    @Test
    public void rowsTest() {
        List<Line> rows = dataProductsJTable.rows();
        assertEquals(rows.size(), 5);
        assertEquals(rows.get(0).size(), 4);
    }
    @Test
    public void headerTest() {
        assertEquals(dataProductsJTable.header(), asList("Name", "Type", "Cost", "Weight"));
    }
    @Test
    public void rowHeaderTest() {
        assertEquals(dataProductsJTable.rowHeader(), asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void valueTest() {
        String value = dataProductsJTable.getValue();
        assertEquals(value,
        "Name Type Cost Weight\n" +
            "Chair furniture 3.5 2\n" +
            "Table furniture 3.5 3.5\n" +
            "Sofa furniture 2 2\n" +
            "Kitchen kitchen 400\n" +
            "Robot robo");
    }

    @Test
    public void iterationTest() {
        int i = 0;
        for (Furniture furniture : dataProductsJTable) {
            assertThat(furniture.name, is(NAME_COLUMN[i++]));
        }
    }

    @Test
    public void dataRowTestIndex() {
        dataProductsJTable.has().row(CHAIR);
        dataProductsJTable.has().row(TABLE);
        dataProductsJTable.has().row(SOFA);
    }

    @Test
    public void dataColumnTestIndex() {
        assertThat(dataProductsJTable.column(2), hasItems(TYPE_COLUMN));
        assertThat(dataProductsJTable.column(3), hasItems(COST_COLUMN));
        assertThat(dataProductsJTable.column(4), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataColumnNameTest() {
        assertThat(dataProductsJTable.column("Type"), hasItems(TYPE_COLUMN));
        assertThat(dataProductsJTable.column("Cost"), hasItems(COST_COLUMN));
        assertThat(dataProductsJTable.column("Weight"), hasItems(WEIGHT_COLUMN));

        assertThat(dataProductsJTable.column("TYPE"), hasItems(TYPE_COLUMN));
        assertThat(dataProductsJTable.column("COST *"), hasItems(COST_COLUMN));
        assertThat(dataProductsJTable.column("WEIGHT "), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = dataProductsJTable.dataList(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        dataProductsJTable.is().displayed();
        dataProductsJTable.has().size(5);
        dataProductsJTable.assertThat().size(greaterThan(3));
        dataProductsJTable.is().notEmpty().size(lessThanOrEqualTo(7));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        dataProductsJTable.has().row(r -> r.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        dataProductsJTable.has().row(TABLE);
    }
    @Test
    public void rowsAllTest() {
        dataProductsJTable.has().all().rows(r -> r.name.length() >= 4);
    }
    @Test
    public void noRowsTest() {
        dataProductsJTable.has().no().rows(r -> isBlank(r.name));
    }
    @Test
    public void atLeastTest() {
        dataProductsJTable.has()
            .atLeast(3).rows(r -> r.type.contains("furniture"));
    }
    @Test
    public void exactMatcherTest() {
        dataProductsJTable.has().exact(2).rows(r -> r.cost.contains("3.5"));
    }
    @Test
    public void rowDataExactMatcherTest() {
        dataProductsJTable.has().exact(1).row(TABLE);
    }

    @Test
    public void tableChainTest() {
        dataProductsJTable.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty();
    }
}
