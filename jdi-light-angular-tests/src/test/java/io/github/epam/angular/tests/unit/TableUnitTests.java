package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.tools.map.MapArray;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TableDynamicSection.dynamicTable;
import static io.github.com.pages.sections.TableDynamicSection.addButton;
import static io.github.com.pages.sections.TableDynamicSection.removeButton;
import static io.github.com.pages.sections.TableDynamicSection.shuffleButton;
import static io.github.com.pages.sections.TableFilteringSection.filter;
import static io.github.com.pages.sections.TableFilteringSection.filteringTable;
import static io.github.com.pages.sections.TableOverviewSection.overviewFilter;
import static io.github.com.pages.sections.TableOverviewSection.overviewTable;
import static io.github.com.pages.sections.TableOverviewSection.overviewPaginator;
import static io.github.com.pages.sections.TableSection.basicTable;
import static io.github.com.pages.sections.TableSection.flexTable;
import static io.github.com.pages.sections.TableSection.expandableRowsTable;
import static io.github.com.pages.sections.TableSection.tableWithFooter;
import static io.github.com.pages.sections.TableStickySection.stickyHeaderTable;
import static io.github.com.pages.sections.TableStickySection.stickyColumnsTable;
import static io.github.com.pages.sections.TableStickySection.stickyFooterTable;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TableUnitTests extends TestsInit {

    final static String[] chemElements = {"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen"};

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyMatTablesTest() {
        basicTable.show();
        assertEquals(basicTable.is().name, "Basic Table");
        assertEquals(flexTable.is().name, "Flex Table");
    }

    @Test
    public void checkMatTablesTest() {
        int row = 3;
        basicTable.show();
        assertEquals(basicTable.header(),flexTable.header());
        assertEquals(basicTable.getRow(row).getValuesFast(),flexTable.getRow(row).getValuesFast());
    }

    @Test
    public void dynamicTablesTest() {
        dynamicTable.show();
        List<String> headersBefore = dynamicTable.header();

        addButton.click();
        dynamicTable.is().shown();
        assertTrue(headersBefore.size()<dynamicTable.header().size());

        removeButton.click();
        dynamicTable.is().shown();
        assertEquals(headersBefore,dynamicTable.header());

        shuffleButton.click();
        dynamicTable.is().shown();
        assertNotEquals(headersBefore,dynamicTable.header());
    }

    @Test
    public void expandableRowsTableTest() {
       int idx = 2;
        expandableRowsTable.show();
        for (String nameElement: chemElements) {
            int row = expandableRowsTable.getRowIndexByName(nameElement);
            System.out.println(nameElement);
            expandableRowsTable.getRow(row).getFast().click();
            String[] info = expandableRowsTable.getRow(row+1).getValue().split("\n",5);
            assertEquals(info[idx],nameElement);
        }
    }

    @Test
    public void filteringTablesTest() {
        filteringTable.show();
        int primaryTableRows = filteringTable.getColumn(1).size();
        filter.sendKeys("en");
        filteringTable.is().shown();
        assertTrue(filteringTable.getColumn(1).size()<primaryTableRows);
    }

    @Test
    public void footerTablesTest() {
        tableWithFooter.show();
        String[] total = tableWithFooter.footerUI().getValue().split(" ",2);
        List<String> cost = tableWithFooter.getColumn(2).getValuesFast();
        assertEquals(cost.get(cost.size()-1),total[1]);
    }

    @Test
    public void sortingPaginationAndFilteringTest() {
        overviewTable.show();
        List<Integer> visiblePages = overviewPaginator.options();
        int linesTable = visiblePages.get(2);
        overviewFilter.sendKeys("Cora");
        overviewTable.is().shown();
        overviewPaginator.select(linesTable);
        overviewTable.is().shown();
        assertTrue(overviewTable.getColumn(1).size()<=linesTable);
    }

    @Test
    public void stickyHeaderTablesTest() {
        stickyHeaderTable.show();
        int rows = stickyHeaderTable.getColumn(1).size();
        assertTrue(stickyHeaderTable.headerUI().isDisplayed());
        stickyHeaderTable.getCell(stickyHeaderTable.getRow(rows).size(),rows).show();
        assertTrue(stickyHeaderTable.headerUI().isDisplayed());
    }

    @Test
    public void stickyColumnsTablesTest() {
        stickyColumnsTable.show();
        int rows = stickyColumnsTable.getColumn(1).size();
        assertTrue(stickyColumnsTable.headerUI().isDisplayed());
        stickyColumnsTable.getCell(stickyColumnsTable.getRow(rows).size()-1,rows).click();
        assertTrue(stickyColumnsTable.getColumn(1).isDisplayed());
    }

    @Test
    public void stickyFooterTablesTest() {
        stickyFooterTable.show();
        int rows = stickyFooterTable.getColumn(1).size();
        assertTrue(stickyFooterTable.footerUI().isDisplayed());
        stickyFooterTable.getCell(2,rows-1).show();
        assertTrue(stickyFooterTable.footerUI().isDisplayed());
    }
}
