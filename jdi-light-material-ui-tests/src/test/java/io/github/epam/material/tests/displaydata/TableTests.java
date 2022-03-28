package io.github.epam.material.tests.displaydata;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.tablePage;
import static io.github.com.pages.displaydata.TablePage.basicTable;
import static io.github.com.pages.displaydata.TablePage.collapsibleTable;
import static io.github.com.pages.displaydata.TablePage.denseTable;
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
import io.github.com.pages.utils.UserInfo;
import io.github.epam.TestsInit;

import java.util.List;

import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * To see an example of Tables web element please visit
 * https://material-ui.com/components/tables/
 */

public class TableTests extends TestsInit {

    private static final List<String> EXPECTED_TABLE_HEADERS = ImmutableList.of("Dessert (100g serving)",
            "Calories", "Fat (g)", "Carbs (g)", "Protein (g)");

    private static final UserInfo JON_SNOW = new UserInfo().set(m -> {
        m.id = "1";
        m.firstName = "Jon";
        m.lastName = "Snow";
        m.age = "35";
        m.fullName = "Jon Snow";
    });

    @BeforeMethod
    public void beforeTest() {
        tablePage.open();
        tablePage.isOpened();
    }

    @Test
    public void basicTableTest() {
        basicTable.show();
        basicTable.has().exactHeader(EXPECTED_TABLE_HEADERS).and().has().size(13);
        basicTable.getCell(1, 1).has().text("305");
        basicTable.getCell(4, 13).has().text("4");
    }

    @Test
    public void fullRowDataTableTest() {
        westerosTable.has().row(JON_SNOW);
    }

    @Test
    public void dataTableHideTest() {
        UIElement firstHeader = westerosTable.headerUI().get(1);

        firstHeader.show();
        firstHeader.has().text("ID");
        westerosTable.headerUI().has().size(5);

        firstHeader.hover();

        westerosTable.filterButton.show();
        westerosTable.click(westerosTable.filterButton);

        waitCondition(() -> westerosTable.westerosFilterMenu.size() == 6);
        westerosTable.westerosFilterMenu.item("Hide").hover();
        westerosTable.westerosFilterMenu.item("Hide").click();

        firstHeader.has().text("First name");
        westerosTable.headerUI().has().size(4);
    }

    @Test
    public void dataTableAppearTest() {
        UIElement secondHeader = westerosTable.headerUI().get(1);
        secondHeader.show();
        secondHeader.hover();

        westerosTable.filterButton.hover();
        westerosTable.click(westerosTable.filterButton);

        waitCondition(() -> westerosTable.westerosFilterMenu.size() == 6);
        westerosTable.westerosFilterMenu.item("Hide").hover();
        westerosTable.westerosFilterMenu.item("Hide").click();

        westerosTable.headerUI().has().size(4);

        secondHeader.show();
        secondHeader.hover();

        westerosTable.filterButton.hover();
        westerosTable.click(westerosTable.filterButton);

        waitCondition(() -> westerosTable.westerosFilterMenu.size() == 6);
        westerosTable.westerosFilterMenu.item("Show columns").hover();
        westerosTable.westerosFilterMenu.item("Show columns").click();

        westerosTable.showAllButton.show();
        westerosTable.showAllButton.click();

        westerosTable.headerUI().has().size(5);
    }

    @Test
    public void dataTableFilterTest() {
        UIElement thirdHeader = westerosTable.headerUI().get(3);
        thirdHeader.show();
        thirdHeader.hover();

        westerosTable.filterButton.hover();
        westerosTable.filterButton.show();

        westerosTable.click(westerosTable.filterButton);

        waitCondition(() -> westerosTable.westerosFilterMenu.size() == 6);
        westerosTable.westerosFilterMenu.item("Filter").hover();
        westerosTable.westerosFilterMenu.item("Filter").click();

        westerosTable.columnFilter.click();
        westerosTable.columnFilter.sendKeys("full name");

        westerosTable.operatorFilter.click();
        westerosTable.operatorFilter.sendKeys("starts with");

        westerosTable.valueFilter.click();
        westerosTable.valueFilter.sendKeys("harvey");

        waitCondition(() -> westerosTable.preloader.isDisplayed());

        westerosTable.valueFilter.sendKeys(Keys.ESCAPE);

        westerosTable.has().size(1);

        westerosTable.line(1).fullName.is().text("Harvey Roxie");
    }

    @Test
    public void denseTableContentTest() {
        Assert.assertEquals(denseTable.preview().replaceAll(" ", ""),
                "Dessert(100gserving)CaloriesFat(g)Carbs(g)Protein(g)"
                        + "Frozenyoghurt1596244"
                        + "Icecreamsandwich2379374.3"
                        + "Eclair26216246"
                        + "Cupcake3053.7674.3"
                        + "Gingerbread35616493.9");
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
