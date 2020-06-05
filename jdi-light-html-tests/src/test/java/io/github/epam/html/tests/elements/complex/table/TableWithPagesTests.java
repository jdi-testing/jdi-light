package io.github.epam.html.tests.elements.complex.table;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tableWithPagesPage;
import static io.github.com.pages.TableWithPagesPage.withPagesTable;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class TableWithPagesTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tableWithPagesPage.shouldBeOpened();
    }

    @Test
    public void searchInTable() {
        withPagesTable.is().visible().and().size(5);
        withPagesTable.filterBy("Type");
        withPagesTable.getCell(1,1).has().text("Test Runner");
        withPagesTable.searchBy("Aj");
        withPagesTable.getCell(1,1).has().text("ASP.NET");
    }
}
