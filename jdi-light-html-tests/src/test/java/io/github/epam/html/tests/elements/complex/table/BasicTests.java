package io.github.epam.html.tests.elements.complex.table;

import io.github.com.entities.Furniture;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.StringUtils.LINE_BREAK;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.SimpleTablePage.products;
import static io.github.epam.html.tests.elements.complex.table.TableTests.i;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class BasicTests implements TestsInit {
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
        assertEquals(products.size(), 4);
        assertEquals(products.count(), 5);
        assertEquals(products.header(), asList("Name", "Type", "Cost", "Weight"));
        String value = products.getValue();
        assertEquals(value,
        "||X||Name|Type|Cost|Weight||" + LINE_BREAK +
            "||"+i(0)+"||Chair|furniture|3.5|2||" + LINE_BREAK +
            "||"+i(1)+"||Table|furniture|3.5|3.5||" + LINE_BREAK +
            "||"+i(2)+"||Sofa|furniture|2|2||" + LINE_BREAK +
            "||"+i(3)+"||Kitchen|kitchen|400|||" + LINE_BREAK +
            "||"+i(4)+"||Robot|robo||||" + LINE_BREAK);
    }
    @Test
    public void basicByIndexTest() {
        assertThat(products.webRow(ELEMENT.startIndex).get(ELEMENT.startIndex+3).getText(), is("2"));
        assertThat(products.webRow(ELEMENT.startIndex + 4).get(ELEMENT.startIndex).getText(), is("Robot"));
        assertThat(products.webColumn(ELEMENT.startIndex).get(ELEMENT.startIndex+4).getText(), is("Robot"));
        assertThat(products.webColumn(ELEMENT.startIndex + 3).get(ELEMENT.startIndex + 1).getText(), is("3.5"));

        assertThat(products.line(ELEMENT.startIndex).name.getText(), is("Chair"));
        assertThat(products.line(ELEMENT.startIndex + 4).name.getText(), is("Robot"));

        assertThat(products.dataRow(ELEMENT.startIndex).name, is("Chair"));
        assertThat(products.dataRow(ELEMENT.startIndex + 4).name, is("Robot"));

        assertThat(products.cell(ELEMENT.startIndex, ELEMENT.startIndex), is("Chair"));
        assertThat(products.cell("Type", ELEMENT.startIndex + 1), is("furniture"));
        assertThat(products.cell(ELEMENT.startIndex + 2, "Sofa"), is("2"));
        assertThat(products.cell("Type", "Kitchen"), is("kitchen"));
    }
    @Test
    public void basicByNameTest() {
        assertThat(products.webRow("Chair").get(ELEMENT.startIndex + 3).getText(), is("2"));
        assertThat(products.webRow("Robot").get(ELEMENT.startIndex).getText(), is("Robot"));
        assertThat(products.webColumn("Name").get(ELEMENT.startIndex + 4).getText(), is("Robot"));
        assertThat(products.webColumn("Weight").get(ELEMENT.startIndex + 1).getText(), is("3.5"));

        assertThat(products.line("Chair").cost.getText(), is("3.5"));
        assertThat(products.line("Kitchen").cost.getText(), is("400"));

        assertThat(products.dataRow("Chair").type, is("furniture"));
        assertThat(products.dataRow("Robot").type, is("robo"));
    }
}
