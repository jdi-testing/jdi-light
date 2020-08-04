package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.paginatorSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class PaginatorUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyLabelTest() {
        assertEquals(paginatorSection.paginator.label(), "Items per page:");
    }

    @Test
    public void verifyItemsPerPageListTest() {
        final String options = "-1,0,1,5,10,25,100";
        paginatorSection.pageSizeOptions.setValue(options);

        String actual = String.join(",", paginatorSection.paginator.options());
        assertEquals(actual, options);
    }

    @Test
    public void verifyItemsPerPageSelectedTest() {
        final String option = "5";
        paginatorSection.paginator.select(Integer.parseInt(option));

        assertEquals(paginatorSection.paginator.selected(), option);
    }

    @Test
    public void verifyNavigationTest() {
        paginatorSection.listLength.setValue("75");
        paginatorSection.paginator.select(25);

        assertFalse(paginatorSection.paginator.isPreviousEnabled());
        assertTrue(paginatorSection.paginator.isNextEnabled());

        paginatorSection.paginator.next();
        assertTrue(paginatorSection.paginator.isPreviousEnabled());
        assertTrue(paginatorSection.paginator.isNextEnabled());

        paginatorSection.paginator.next();
        assertTrue(paginatorSection.paginator.isPreviousEnabled());
        assertFalse(paginatorSection.paginator.isNextEnabled());
    }

    @Test
    public void verifyEmptyRangeTest() {
        paginatorSection.listLength.setValue("0");

        assertEquals(paginatorSection.paginator.range(), "0 of 0");
    }

    @Test
    public void verifyRangeTest() {
        final String TOTAL = "50";
        final int STEP = 25;

        paginatorSection.listLength.setValue(TOTAL);
        paginatorSection.paginator.select(100);
        paginatorSection.paginator.select(STEP);

        String expected = String.format("1 – %d of %s", STEP, TOTAL);
        assertEquals(paginatorSection.paginator.range(), expected);
    }
}
