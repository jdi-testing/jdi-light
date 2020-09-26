package io.github.epam.html.tests.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.Line;
import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.tools.LinqUtils.any;
import static com.epam.jdi.tools.LinqUtils.*;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.furnitureDoubleHidden;
import static io.github.epam.html.tests.elements.complex.table.TableDataProvider.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.jsoup.internal.StringUtil.isBlank;
import static org.testng.Assert.assertEquals;

public class GridDoubleHiddenTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tablePage.shouldBeOpened();
    }

    @Test
    public void webCellsTest() {
        assertEquals(furnitureDoubleHidden.webCells().size(), 20);
    }
    @Test
    public void sizeTest() {
        assertEquals(furnitureDoubleHidden.size(), 4);
    }
    @Test
    public void countTest() {
        assertEquals(furnitureDoubleHidden.count(), 5);
    }
    @Test
    public void columnsTest() {
        List<Line> columns = furnitureDoubleHidden.columns();
        assertEquals(columns.size(), 4);
        assertEquals(columns.get(0).size(), 5);
    }
    @Test
    public void rowsTest() {
        List<Line> rows = furnitureDoubleHidden.rows();
        assertEquals(rows.size(), 5);
        assertEquals(rows.get(0).size(), 4);
    }
    @Test
    public void headerTest() {
        assertEquals(furnitureDoubleHidden.header(), asList("Name", "Type", "Cost *", "Weight"));
    }
    @Test
    public void rowHeaderTest() {
        assertEquals(furnitureDoubleHidden.rowHeader(), asList("1", "2", "3", "4", "5"));
    }

    @Test
    public void valueTest() {
        String value = furnitureDoubleHidden.getValue();
        assertEquals(value,
        "Name Type Cost * Weight\n" +
            "Chair furniture 3.5 2\n" +
            "Table furniture 3.5 3.5\n" +
            "Sofa furniture 2 2\n" +
            "Kitchen kitchen 400\n" +
            "Robot robo");
    }

    @Test
    public void dataRowTestIndex() {
        assertEquals(furnitureDoubleHidden.row(1).asData(Furniture.class), CHAIR);
        assertEquals(furnitureDoubleHidden.row(2).asData(Furniture.class), TABLE);
        assertEquals(furnitureDoubleHidden.row(3).asData(Furniture.class), SOFA);
    }

    @Test
    public void dataRowNameTest() {
        assertThat(furnitureDoubleHidden.row("1").asData(Furniture.class), is(CHAIR));
        assertThat(furnitureDoubleHidden.row("2").asData(Furniture.class), is(TABLE));
        assertThat(furnitureDoubleHidden.row("3").asData(Furniture.class), is(SOFA));
    }
    @Test
    public void dataColumnTestIndex() {
        assertThat(furnitureDoubleHidden.column(2), hasItems(TYPE_COLUMN));
        assertThat(furnitureDoubleHidden.column(3), hasItems(COST_COLUMN));
        assertThat(furnitureDoubleHidden.column(4), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataColumnNameTest() {
        assertThat(furnitureDoubleHidden.column("Type"), hasItems(TYPE_COLUMN));
        assertThat(furnitureDoubleHidden.column("Cost"), hasItems(COST_COLUMN));
        assertThat(furnitureDoubleHidden.column("Weight"), hasItems(WEIGHT_COLUMN));

        assertThat(furnitureDoubleHidden.column("TYPE"), hasItems(TYPE_COLUMN));
        assertThat(furnitureDoubleHidden.column("COST *"), hasItems(COST_COLUMN));
        assertThat(furnitureDoubleHidden.column("WEIGHT "), hasItems(WEIGHT_COLUMN));
    }

    @Test
    public void dataFilterTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(rows, hasItem(TABLE));
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        List<Furniture> filteredData = filter(rows, d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        furnitureDoubleHidden.is().displayed();
        furnitureDoubleHidden.has().size(5);
        furnitureDoubleHidden.assertThat().size(greaterThan(3));
        furnitureDoubleHidden.is().notEmpty().size(lessThanOrEqualTo(7));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(first(rows, r -> r.name.contains("Tab")), not(nullValue()));
    }

    @Test
    public void rowDataMatcherTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(filter(rows, r -> r.equals(TABLE)), hasSize(1));
    }

    @Test
    public void rowsAllTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(all(rows, r -> r.name.length() >= 4), is(true));
    }

    @Test
    public void noRowsTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(any(rows, r -> isBlank(r.name)), is(false));
    }

    @Test
    public void atLeastTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(filter(rows, r -> r.type.contains("furniture")), hasSize(greaterThanOrEqualTo(3)));
    }

    @Test
    public void exactMatcherTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(filter(rows, r -> r.cost.contains("3.5")), hasSize(2));
    }

    @Test
    public void rowDataExactMatcherTest() {
        List<Furniture> rows = furnitureDoubleHidden.rowsAs(Furniture.class);
        assertThat(filter(rows, r -> r.equals(TABLE)), hasSize(1));
    }

    @Test
    public void tableChainTest() {
        furnitureDoubleHidden.assertThat()
            .displayed().size(5).size(greaterThan(3)).notEmpty();
    }
}
