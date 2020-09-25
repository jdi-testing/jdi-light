package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.TableSection.*;
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
    }

    @Test
    public void footerTablesTest() {
        tableWithFooter.show();
    }
}
