package io.github.epam.angular.tests.elements.complex.table;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tableSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

public class BasicTableTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void tableWithSelectionStructureTest() {
        tableSection.tableWithSelectionLink.hover();

        assertEquals(tableSection.tableWithSelection.size(), 5);
        assertEquals(tableSection.tableWithSelection.count(), 5);
        assertEquals(tableSection.tableWithSelection.header(), asList("", "No.", "Name", "Weight", "Symbol"));
        tableSection.tableWithSelection.is().size(5);
    }
}
