package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.dataFurnitureHidden;
import static io.github.epam.html.tests.elements.complex.table.TableDataProvider.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class DataGridHiddenTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void webCellsTest() {
        assertEquals(dataFurnitureHidden.webCells().size(), 20);
    }
    @Test
    public void sizeTest() {
        assertEquals(dataFurnitureHidden.size(), 4);
    }
    @Test
    public void countTest() {
        assertEquals(dataFurnitureHidden.count(), 5);
    }
    @Test
    public void columnsTest() {
        List<Line> columns = dataFurnitureHidden.columns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(0).size(), 5);
    }
    @Test
    public void rowsTest() {
        List<Line> rows = dataFurnitureHidden.rows();
        assertEquals(rows.size(), 5);
        assertEquals(rows.get(0).size(), 4);
    }
    @Test
    public void headerTest() {
        assertEquals(dataFurnitureHidden.header(), asList("Name", "Type", "Cost", "Weight"));
    }
    @Test
    public void rowHeaderTest() {
        assertEquals(dataFurnitureHidden.rowHeader(), asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void valueTest() {
        String value = dataFurnitureHidden.getValue();
        assertEquals(value,
        "Name Type Cost * Weight\n" +
            "Chair furniture 3.5 2\n" +
            "Table furniture 3.5 3.5\n" +
            "Sofa furniture 2 2\n" +
            "Kitchen kitchen 400\n" +
            "Robot robo");
    }
    @Test
    public void iterationTest() {
        int i = 0;
        for (Furniture furniture : dataFurnitureHidden) {
            assertThat(furniture.name, is(NAME_COLUMN[i++]));
        }
    }

    @Test
    public void dataRowTestIndex() {
        dataFurnitureHidden.has().row(CHAIR);
        dataFurnitureHidden.has().row(TABLE);
        dataFurnitureHidden.has().row(SOFA);
    }

    @Test
    public void dataColumnTestIndex() {
        assertThat(dataFurnitureHidden.column(2), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureHidden.column(3), hasItems(COST_COLUMN));
        assertThat(dataFurnitureHidden.column(4), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataColumnNameTest() {
        assertThat(dataFurnitureHidden.column("Type"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureHidden.column("Cost"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureHidden.column("Weight"), hasItems(WEIGHT_COLUMN));

        assertThat(dataFurnitureHidden.column("TYPE"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureHidden.column("COST *"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureHidden.column("WEIGHT "), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = dataFurnitureHidden.dataList(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        dataFurnitureHidden.is().displayed();
        dataFurnitureHidden.has().size(5);
        dataFurnitureHidden.assertThat().size(greaterThan(3));
        dataFurnitureHidden.is().notEmpty().size(lessThanOrEqualTo(7));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        dataFurnitureHidden.has().row(r -> r.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        dataFurnitureHidden.has().row(TABLE);
    }
    @Test
    public void rowsAllTest() {
        dataFurnitureHidden.has().all().rows(r -> r.name.length() >= 4);
    }
    @Test
    public void noRowsTest() {
        dataFurnitureHidden.has().no().rows(r -> isBlank(r.name));
    }
    @Test
    public void atLeastTest() {
        dataFurnitureHidden.has()
            .atLeast(3).rows(r -> r.type.contains("furniture"));
    }
    @Test
    public void exactMatcherTest() {
        dataFurnitureHidden.has().exact(2).rows(r -> r.cost.contains("3.5"));
    }
    @Test
    public void rowDataExactMatcherTest() {
        dataFurnitureHidden.has().exact(1).row(TABLE);
    }

    @Test
    public void tableChainTest() {
        dataFurnitureHidden.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty();
    }
}
