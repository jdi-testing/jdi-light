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
        String options = "-1,0,1,5,10,25,100";
        paginatorSection.pageSizeOptions.setValue(options);

        String actual = String.join(",", paginatorSection.paginator.options());
        assertEquals(actual, options);
    }

    @Test
    public void verifyItemsPerPageSelectedTest() {
        String option = "5";
        paginatorSection.paginator.select(Integer.parseInt(option));

        assertEquals(paginatorSection.paginator.selected(), option);
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
        paginatorSection.paginator.select(STEP);

        String expected = String.format("1 – %d of %s", STEP, TOTAL);
        assertEquals(paginatorSection.paginator.range(), expected);
    }
}
