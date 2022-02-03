package io.github.epam.material.tests.displaydata;

import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.basicTable;
import static io.github.com.pages.displaydata.TablePage.collapsibleTable;
import static io.github.com.pages.displaydata.TablePage.dataTableCells;
import static io.github.com.pages.displaydata.TablePage.densePaddingSwitch;
import static io.github.com.pages.displaydata.TablePage.denseTable;
import static io.github.com.pages.displaydata.TablePage.purchaseTable;
import static io.github.com.pages.displaydata.TablePage.rowsPerPageButton;
import static io.github.com.pages.displaydata.TablePage.rowsPerPageValues;
import static io.github.com.pages.displaydata.TablePage.scrollButtons;
import static io.github.com.pages.displaydata.TablePage.selectedRowCounter;
import static io.github.com.pages.displaydata.TablePage.sortingSelectingTable;
import static io.github.com.pages.displaydata.TablePage.sortingSelectingTableTitle;
import static io.github.com.pages.displaydata.TablePage.spanningTable;
import static io.github.com.pages.displaydata.TablePage.virtualizedTable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Tables web element please visit
 * https://material-ui.com/components/tables/
 */

public class TableTests extends TestsInit {

    private static final List<String> EXPECTED_TABLE_HEADERS = new ArrayList<>(Arrays.asList("Dessert (100g serving)",
            "Calories", "Fat (g)", "Carbs (g)", "Protein (g)"));

    private final Timer timer = new Timer(16000L);

    @BeforeMethod
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
    }

    @Test
    public void basicTableTest() {
        basicTable.has().columns(EXPECTED_TABLE_HEADERS).and().size(13);
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

        scrollButtons.get(1).is().displayed().and().disabled();
        scrollButtons.get(2).is().displayed();
        scrollButtons.get(2).click();

        getDataTableCell(2, 3).has().text("Harvey");
    }

    private Button getDataTableCell(int row, int coll) {
        return dataTableCells.get((row - 1) * 6 + coll);
    }

    @Test
    public void denseTableTest() {
        denseTable.has().columns(EXPECTED_TABLE_HEADERS).and().size(5);
        denseTable.getCell(1, 1).has().text("159")
                .and().classValue(containsString("sizeSmall"));
        denseTable.getCell(2, 3).has().text("16")
                .and().classValue(containsString("sizeSmall"));
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

        scrollButtons.get(4).is().displayed().and().enabled();
        scrollButtons.get(4).hover();
        scrollButtons.get(4).click();
        scrollButtons.get(3).hover();
        scrollButtons.get(3).click();

        sortingSelectingTable.headerUI().get(2).find(".MuiTableSortLabel-root").click();
        rowsPerPageButton.click();
        rowsPerPageValues.get(2).click();
        rowsPerPageButton.has().text("10");

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
        timer.wait(() -> purchaseTable.getRow(1).get(1).has().text("11091700"));
        showSubTable.click();
        timer.wait(() -> purchaseTable.is().notVisible());
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
    public void virtualizedTableTest() {
        getTableCell(virtualizedTable, 1, 1).has().cssClass("ReactVirtualized__Table__rowColumn");
        assertThat(virtualizedTable.size(), equalTo(90));
    }

    private Text getTableCell(List<Text> tableCells, int row, int col) {
        return tableCells.get((row - 1) * 5 + col);
    }
}