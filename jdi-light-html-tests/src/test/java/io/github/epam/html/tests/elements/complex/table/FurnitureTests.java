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
import static io.github.com.pages.SimpleTablePage.furniture;
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
        assertEquals(furniture.size(), 4);
        assertEquals(furniture.count(), 5);
        assertEquals(furniture.header(), asList("Name", "Type", "Cost", "Weight"));
    }

    @Test
    public void previewTest() {
        String value = furniture.preview();
        assertEquals(value.replaceAll(" ", ""),
                "NameTypeCost*#Chairfurniture3.52Tablefurniture3.53.5Sofafurniture22Kitchenkitchen400Robotrobo");
    }

    @Test
    public void valueTest() {
        String value = furniture.getValue();
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
        assertEquals(furniture.dataRow(2), TABLE);
    }

    @Test
    public void dataColumnNameTest() {
        assertEquals(furniture.dataRow("Table"), TABLE);
    }

    @Test
    public void dataFilterTest() {
        assertEquals(furniture.dataRow(d -> d.name.contains("Tab")), TABLE);
    }

    @Test
    public void allDataFilterTest() {
        List<Furniture> filteredData = furniture.dataRows(d -> d.name.contains("Tab"));
        assertEquals(filteredData.size(), 1);
        assertEquals(filteredData.get(0), TABLE);
    }

    @Test
    public void commonMatchersTest() {
        furniture.is().displayed();
        furniture.has().size(5);
        furniture.assertThat().size(greaterThan(3));
        furniture.is().notEmpty().size(lessThanOrEqualTo(5));
    }

    // Compare Matchers
    @Test
    public void rowMatcherTest() {
        furniture.has().row(d -> d.name.contains("Tab"));
    }

    @Test
    public void rowDataMatcherTest() {
        furniture.has().row(TABLE);
    }

    @Test
    public void rowTableMatcherTest() {
        furniture.has().rowThat(containsValue("furniture", inColumn("Type")),
                hasValue("Chair", inColumn("Name")));
    }

    @Test
    public void rowsAllTest() {
        furniture.assertThat().all().rows(d -> d.name.length() >= 4);
    }

    @Test
    public void noRowsTest() {
        furniture.assertThat().no().rows(d -> isBlank(d.name));
    }

    @Test
    public void atLeastTest() {
        furniture.assertThat().atLeast(3).rows(d -> d.type.contains("furniture"));
    }

    @Test
    public void exactMatcherTest() {
        furniture.assertThat().exact(2).rows(d -> d.cost.contains("3.5"));
    }

    @Test
    public void rowDataExactMatcherTest() {
        furniture.assertThat().exact(1).rows(TABLE);
    }

    @Test
    public void tableChainTest() {
        furniture.assertThat()
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
