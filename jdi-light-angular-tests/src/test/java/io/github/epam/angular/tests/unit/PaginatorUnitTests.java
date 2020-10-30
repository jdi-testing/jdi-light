package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.PaginatorSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class PaginatorUnitTests extends TestsInit {

    @BeforeMethod
    public void before() {
        getDriver().manage().window().setSize(new Dimension(1920, 1080));
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyLabelTest() {
        assertEquals(paginator.label(), "Items per page:");
    }

    @Test
    public void verifyItemsPerPageListTest() {
        final List<Integer> optionList = Arrays.asList(-1, 0, 1, 5, 10, 25, 100);
        final String options = optionList
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        pageSizeOptions.setValue(options);

        assertEquals(optionList, paginator.options());
    }

    @Test
    public void verifyItemsPerPageSelectedTest() {
        final int option = 5;
        paginator.select(option);

        assertEquals(paginator.selected(), option);
    }

    @Test
    public void verifyNavigationTest() {
        listLength.setValue("75");
        paginator.select(25);

        assertFalse(paginator.isPreviousEnabled());
        assertTrue(paginator.isNextEnabled());

        paginator.next();
        assertTrue(paginator.isPreviousEnabled());
        assertTrue(paginator.isNextEnabled());

        paginator.next();
        assertTrue(paginator.isPreviousEnabled());
        assertFalse(paginator.isNextEnabled());
    }

    @Test
    public void verifyEmptyRangeTest() {
        listLength.setValue("0");

        assertEquals(paginator.range(), "0 of 0");
    }

    @Test
    public void verifyRangeTest() {
        final String TOTAL = "50";
        final int STEP = 25;

        listLength.setValue(TOTAL);
        paginator.select(100);
        paginator.select(STEP);

        String expected = String.format("1 – %d of %s", STEP, TOTAL);
        assertEquals(paginator.range(), expected);
    }
}
