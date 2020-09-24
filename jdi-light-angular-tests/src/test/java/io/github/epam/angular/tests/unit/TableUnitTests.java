package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tableSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class TableUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyMatTablesTest() {
        tableSection.basicTable.show();
        assertEquals(tableSection.basicTable.is().name, "Basic Table");
        assertEquals(tableSection.flexTable.is().name, "Flex Table");
    }

    @Test
    public void checkMatTablesTest() {
        int row = 3;
        tableSection.basicTable.show();
        List<String> baseHeader = tableSection.basicTable.header();
        List<String> flexHeader = tableSection.flexTable.header();
        assertEquals(baseHeader,flexHeader);
        List<String> baseRow = tableSection.flexTable.getRow(row).getValuesFast();
        List<String> flexRow = tableSection.flexTable.getRow(row).getValuesFast();
        assertEquals(baseRow,flexRow);
    }
}
