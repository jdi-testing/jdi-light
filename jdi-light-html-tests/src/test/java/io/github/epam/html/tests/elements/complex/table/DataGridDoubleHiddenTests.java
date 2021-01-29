package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.dataFurnitureDoubleHidden;
import static io.github.epam.html.tests.elements.complex.table.TableDataProvider.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class DataGridDoubleHiddenTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void webCellsTest() {
        assertEquals(dataFurnitureDoubleHidden.webCells().size(), 20);
    }
    @Test
    public void sizeTest() {
        assertEquals(dataFurnitureDoubleHidden.size(), 4);
    }
    @Test
    public void countTest() {
        assertEquals(dataFurnitureDoubleHidden.count(), 5);
    }
    @Test
    public void columnsTest() {
        List<Line> columns = dataFurnitureDoubleHidden.columns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(0).size(), 5);
    }
    @Test
    public void rowsTest() {
        List<Line> rows = dataFurnitureDoubleHidden.rows();
        assertEquals(rows.size(), 5);
        assertEquals(rows.get(0).size(), 4);
    }
    @Test
    public void dataTest() {
        List<Furniture> rows = dataFurnitureDoubleHidden.allData();
        assertEquals(rows.size(), 5);
    }
    @Test
    public void headerTest() {
        assertEquals(dataFurnitureDoubleHidden.header(), asList("Name", "Type", "Cost", "Weight"));
    }
    @Test
    public void rowHeaderTest() {
        assertEquals(dataFurnitureDoubleHidden.rowHeader(), asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void valueTest() {
        String value = dataFurnitureDoubleHidden.getValue();
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
        for (Furniture row : dataFurnitureDoubleHidden) {
            assertThat(row.name, is(NAME_COLUMN[i++]));
        }
    }

    @Test
    public void dataRowTestIndex() {
        dataFurnitureDoubleHidden.has().row(CHAIR);
        dataFurnitureDoubleHidden.has().row(TABLE);
        dataFurnitureDoubleHidden.has().row(SOFA);
    }

    @Test
    public void dataColumnTestIndex() {
        assertThat(dataFurnitureDoubleHidden.column(2), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column(3), hasItems(COST_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column(4), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataColumnNameTest() {
        assertThat(dataFurnitureDoubleHidden.column("Type"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column("Cost"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column("Weight"), hasItems(WEIGHT_COLUMN));

        assertThat(dataFurnitureDoubleHidden.column("TYPE"), hasItems(TYPE_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column("COST *"), hasItems(COST_COLUMN));
        assertThat(dataFurnitureDoubleHidden.column("WEIGHT "), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void allDataFilterTest() {
        dataFurnitureDoubleHidden.has().row(d -> d.name.contains("Tab"));
    }

    @Test
    public void commonMatchersTest() {
        dataFurnitureDoubleHidden.is().displayed();
        dataFurnitureDoubleHidden.has().size(5);
        dataFurnitureDoubleHidden.assertThat().size(greaterThan(3));
        dataFurnitureDoubleHidden.is().notEmpty().size(lessThanOrEqualTo(7));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        dataFurnitureDoubleHidden.has().row(r -> r.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        dataFurnitureDoubleHidden.has()
            .exact(1).row(TABLE);
    }

    @Test
    public void rowsAllTest() {
        dataFurnitureDoubleHidden.has()
            .all().rows(r -> r.name.length() >= 4);
    }

    @Test
    public void noRowsTest() {
        dataFurnitureDoubleHidden.has()
            .no().rows(r -> isBlank(r.name));
    }

    @Test
    public void atLeastTest() {
        dataFurnitureDoubleHidden.has()
            .atLeast(3).rows(r -> r.type.contains("furniture"));
    }

    @Test
    public void exactMatcherTest() {
        dataFurnitureDoubleHidden.has()
            .exact(2).rows(r -> r.cost.contains("3.5"));
    }

    @Test
    public void rowDataExactMatcherTest() {
        dataFurnitureDoubleHidden.has()
            .exact(1).row(TABLE);
    }

    @Test
    public void tableChainTest() {
        dataFurnitureDoubleHidden.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty();
    }
}
