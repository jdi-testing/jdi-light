package io.github.epam.html.tests.elements.complex.table;

import io.github.com.pages.TableWithPagesPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.tableWithPagesPage;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;

public class TableWithPagesTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        tableWithPagesPage.shouldBeOpened();
    }

    @Test
    public void searchInTable() {
        TableWithPagesPage tableWithPagesPage = new TableWithPagesPage();
        tableWithPagesPage.withPagesTable.is().visible().and().size(5);
        tableWithPagesPage.filterByColumn("Type");
        tableWithPagesPage.withPagesTable.getCell(1, 1).has().text("Test Runner");
        tableWithPagesPage.searchBy.sendKeys("Aj");
        tableWithPagesPage.withPagesTable.getCell(1, 1).has().text("ASP.NET");
    }
}
