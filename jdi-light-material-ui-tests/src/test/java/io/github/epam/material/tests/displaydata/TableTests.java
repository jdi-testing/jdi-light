package io.github.epam.material.tests.displaydata;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.basicTable;
import static io.github.com.pages.displaydata.TablePage.collapsibleTable;
import static io.github.com.pages.displaydata.TablePage.columnFilter;
import static io.github.com.pages.displaydata.TablePage.denseTable;
import static io.github.com.pages.displaydata.TablePage.filterButton;

import static io.github.com.pages.displaydata.TablePage.operatorFilter;
import static io.github.com.pages.displaydata.TablePage.preloader;
import static io.github.com.pages.displaydata.TablePage.showAllButton;
import static io.github.com.pages.displaydata.TablePage.valueFilter;
import static io.github.com.pages.displaydata.TablePage.westerosFilterMenu;
import static io.github.com.pages.displaydata.TablePage.westerosTable;
import static io.github.com.pages.displaydata.TablePage.densePaddingSwitch;
import static io.github.com.pages.displaydata.TablePage.rowsPerPageButton;
import static io.github.com.pages.displaydata.TablePage.rowsPerPageValues;
import static io.github.com.pages.displaydata.TablePage.scrollButtons;
import static io.github.com.pages.displaydata.TablePage.sortingSelectingTable;
import static io.github.com.pages.displaydata.TablePage.sortingSelectingTableTitle;
import static io.github.com.pages.displaydata.TablePage.spanningTable;
import static io.github.com.pages.displaydata.TablePage.virtualizedTable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.google.common.collect.ImmutableList;
import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * To see an example of Tables web element please visit
 * https://material-ui.com/components/tables/
 */

public class TableTests extends TestsInit {

    private static final List<String> EXPECTED_TABLE_HEADERS = ImmutableList.of("Dessert (100g serving)",
            "Calories", "Fat (g)", "Carbs (g)", "Protein (g)");

    @DataProvider
    private Object[][] dataBasic() {
        return new Object[][]{
                {1, 1, "305"},
                {2, 4, "6"},
                {3, 9, "65"},
                {4, 13, "4"}
        };
    }

    @BeforeMethod
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
        westerosTable.setStartIndex(0);
    }

    @Test
    public void basicTableTest() {
        basicTable.show();
        basicTable.has().exactHeader(EXPECTED_TABLE_HEADERS).and().has().size(13);
    }

    @Test(dataProvider = "dataBasic")
    public void basicTableDataTest(int colNum, int rowNum, String expectedData) {
        basicTable.getCell(colNum, rowNum).has().text(expectedData);
    }

    @Test
    public void dataTableHideTest() {
        UIElement firstHeader = westerosTable.headerUI().get(1);

        firstHeader.has().text("ID");
        westerosTable.headerUI().has().size(5);

        firstHeader.show();
        firstHeader.hover();

        filterButton.hover();
        filterButton.show();
        new Actions(tablePage.driver()).moveToElement(filterButton.core().getWebElement()).click().perform();

        westerosFilterMenu.show();
        westerosFilterMenu.item("Hide").click();

        firstHeader.has().text("First name");
        westerosTable.headerUI().has().size(4);
    }

    @Test
    public void dataTableAppearTest() {
        UIElement secondHeader = westerosTable.headerUI().get(1);
        secondHeader.show();
        secondHeader.hover();

        filterButton.hover();
        filterButton.show();
        new Actions(tablePage.driver()).moveToElement(filterButton.core().getWebElement()).click().perform();

        westerosFilterMenu.item("Hide").click();

        westerosTable.headerUI().has().size(4);

        secondHeader.show();
        secondHeader.hover();

        filterButton.hover();
        filterButton.show();
        new Actions(tablePage.driver()).moveToElement(filterButton.core().getWebElement()).click().perform();

        westerosFilterMenu.item("Show columns").click();

        showAllButton.show();
        showAllButton.click();

        westerosTable.headerUI().has().size(5);
    }

    @Test
    public void dataTableFilterTest() {
        UIElement thirdHeader = westerosTable.headerUI().get(3);
        thirdHeader.show();
        thirdHeader.hover();

        filterButton.hover();
        filterButton.show();
        new Actions(tablePage.driver()).moveToElement(filterButton.core().getWebElement()).click().perform();

        westerosFilterMenu.item("Filter").click();

        columnFilter.click();
        columnFilter.sendKeys("f");

        operatorFilter.click();
        operatorFilter.sendKeys("s");

        valueFilter.click();
        valueFilter.sendKeys("h");

        waitCondition(()-> preloader.isHidden());

        new Actions(tablePage.driver()).sendKeys(Keys.ESCAPE).perform();

        westerosTable.has().size(1);

        westerosTable.line(0).fullName.is().text("Harvey Roxie");
    }

    @Test
    public void denseTableTest() {
        denseTable.show();
        denseTable.has().columns(EXPECTED_TABLE_HEADERS).and().size(5);
        denseTable.getCell(1, 1).has().text("159")
                .and().classValue(containsString("sizeSmall"));
        denseTable.getCell(2, 3).has().text("16")
                .and().classValue(containsString("sizeSmall"));
    }

    @Test
    public void sortingAndSelectingTableTest() {
        sortingSelectingTableTitle.show();
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
        collapsibleTable.expandRow(1);
        collapsibleTable.expandRow(3);
        collapsibleTable.expandRow(5);

        collapsibleTable.innerTable(1).getCell(1, 1).has().text("2020-01-05");
        collapsibleTable.innerTable(3).getCell(3, 2).has().text("1");
        collapsibleTable.innerTable(5).getCell(4, 2).has().text("1.5");
    }

    @Test
    public void spanningTableTest() {
        spanningTable.show();
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
