package io.github.epam.material.tests.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * To see an example of Tables web element please visit
 * https://material-ui.com/components/tables/
 */

public class TableTests extends TestsInit {

    private static final List<String> headElements = new ArrayList<>(Arrays.asList("Dessert (100g serving)",
            "Calories", "Fat (g)", "Carbs (g)", "Protein (g)"));

    private final Timer timer = new Timer(2000L);

    @BeforeMethod
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
    }

    @Test
    public void basicTableTest() {
        basicTable.has().columns(headElements);
        assertThat(basicTable.count(), equalTo(13));
        basicTable.getCell(1, 1).has().text("305");
    }

    @Test
    public void dataTableTest() {

        getDataTableCell(1, 3).click();
        getDataTableCell(3, 3).has().text("Arya");

        getDataTableCell(1, 1).click();
        selectedRowCounter.has().text(containsString("9"));
        getDataTableCell(3, 1).click();
        getDataTableCell(5, 1).click();
        selectedRowCounter.has().text(containsString("7"));
        getDataTableCell(2, 1).click();
        selectedRowCounter.has().text(containsString("6"));

        scrollButtons.get(1).is().displayed();
        scrollButtons.get(1).is().disabled();
        scrollButtons.get(2).is().displayed();
        scrollButtons.get(2).click();

        getDataTableCell(2, 3).has().text("Harvey");
    }

    @Test
    public void denseTableTest() {
        denseTable.has().columns(headElements);
        assertThat(denseTable.count(), equalTo(5));
        denseTable.getCell(1, 1).has().text("159");
        denseTable.getCell(2, 3).has().text("16");
    }

    @Test
    public void sortingAndSelectingTableTest() {

        sortingSelectingTableTitle.is().displayed();
        sortingSelectingTableTitle.has().text("Nutrition");

        sortingSelectingTable.headerUI().get(1).click();
        sortingSelectingTableTitle.has().text(containsString("13"));

        sortingSelectingTable.getRow(1).get(1).check();
        sortingSelectingTable.getRow(5).get(1).check();
        sortingSelectingTable.getRow(3).get(1).check();
        sortingSelectingTableTitle.has().text(containsString("10"));

        scrollButtons.get(4).is().displayed();
        scrollButtons.get(4).is().enabled();
        scrollButtons.get(4).hover();
        scrollButtons.get(4).click();
        scrollButtons.get(3).hover();
        scrollButtons.get(3).click();

        sortingSelectingTable.headerUI().get(2).check();
        rowsPerPageBtn.click();
        rowsPerPageValues.get(2).click();
        rowsPerPageBtn.has().text("10");

        sortingSelectingTable.getCell(2, 10).has().text("392");

        densePaddingSwitch.check();
        densePaddingSwitch.is().checked();
    }

    @Test
    public void collapsibleTableTest() {
        collapsibleTable.getRow(4).get(2).has().text("356");
        collapsibleTable.getColumn(2).get(1).has().text("159");
        collapsibleTable.getCell(3, 2).has().text("6");

        UIElement showSubTable = collapsibleTable.getRow(1).get(1).find(
                By.xpath("button[contains(@class, 'MuiIconButton-root')]"));
        showSubTable.is().displayed();
        showSubTable.hover();
        showSubTable.click();
        timer.wait(() -> purchaseTables.get(1).getRow(1).get(1).has().text("2020-01-05"));
        showSubTable.click();
        timer.wait(() -> assertThat(purchaseTables.size(), equalTo(0)));
    }

    @Test
    public void spanningTableTest() {
        spanningTable.headerUI().get(1).hasClass("MuiTableCell-alignCenter");
        spanningTable.headerUI().get(1).has().text("Details");
        spanningTable.getCell(2, 1).hasClass("MuiTableCell-alignRight");
        spanningTable.getCell(2, 1).has().text("100");
        spanningTable.getRow(4).get(1).has().attr("rowspan", "3");
    }

    @Test
    public void virtualizedTable() {
        getTableCell(virtualizedTable, 1, 1).hasClass("ReactVirtualized__Table__rowColumn");
        assertThat(virtualizedTable.size(), equalTo(90));
    }

    private Button getDataTableCell(int row, int coll) {
        return dataTableCells.get((row - 1) * 6 + coll);
    }

    private UIElement getTableCell(List<UIElement> tableCells, int row, int col) {
        return tableCells.get((row - 1) * 5 + col);
    }
}
