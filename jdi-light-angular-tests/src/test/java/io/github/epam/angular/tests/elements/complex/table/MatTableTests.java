package io.github.epam.angular.tests.elements.complex.table;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.tableSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static java.util.Arrays.asList;
import static org.testng.Assert.assertEquals;

// TODO Move to the new page
@Test(enabled = false)
public class MatTableTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        tableSection.sectionStart.hover();
    }

    @Test
    public void tableStructureTest() {
        assertEquals(tableSection.basicMatTable.size(), 4);
        assertEquals(tableSection.basicMatTable.count(), 5);
        assertEquals(tableSection.basicMatTable.header(), asList("No.", "Name", "Weight", "Symbol"));
        tableSection.basicMatTable.is().size(5);

    }
}
