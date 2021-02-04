package io.github.epam.angular.tests.elements.complex;

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

public class PaginatorTests extends TestsInit {
    private static final List<Integer> PAGESIZEOPTIONS = Arrays.asList(1, 5, 10, 25, 100, 500);
    private static final String OPTIONS =
            PAGESIZEOPTIONS
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
    private static final int TOTAL = 50;

    @BeforeMethod
    public void before() {
        getDriver().manage().window().setSize(new Dimension(1920, 1080));

        shouldBeLoggedIn();
        angularPage.shouldBeOpened();

        listLength.setValue(String.valueOf(TOTAL));
        pageSizeOptions.setValue(OPTIONS);
    }

    @Test
    public void labelPaginationTest() {
        paginator.has().label("Items per page:");
    }

    @Test
    public void basicPaginatorTest() {
        final int STEP = 10;
        paginator.select(STEP);

        paginator.is().range(1, STEP, TOTAL);
        paginator.is().previousDisabled();
        paginator.is().nextEnabled();
        paginator.next();

        for (int i = STEP + 1; i < TOTAL - STEP + 1; i += STEP) {
            paginator.is().range(i, i + STEP - 1, TOTAL);
            paginator.is().previousEnabled();
            paginator.is().nextEnabled();
            paginator.next();
        }

        paginator.is().range(TOTAL - STEP + 1, TOTAL, TOTAL);
        paginator.is().previousEnabled();
        paginator.is().nextDisabled();
        paginator.previous();

        for (int i = TOTAL - 2 * STEP + 1; i > 1; i -= STEP) {
            paginator.is().range(i, i + STEP - 1, TOTAL);
            paginator.is().previousEnabled();
            paginator.is().nextEnabled();
            paginator.previous();
        }

        paginator.is().range(1, STEP, TOTAL);
        paginator.is().previousDisabled();
        paginator.is().nextEnabled();
    }

    @Test
    public void navigationDisabledPaginatorTest() {
        listLength.setValue("0");

        paginator.has().range();
        paginator.has().previousDisabled();
        paginator.has().nextDisabled();

        listLength.setValue("100");
        paginator.select(100);
        paginator.has().previousDisabled();
        paginator.has().nextDisabled();
    }

    @Test
    public void pageSizeOptionsPaginatorTest() {
        paginator.has().itemsPerPageList(PAGESIZEOPTIONS);
    }

    @Test
    public void itemPerPagePaginatorTest() {
        for (Integer option : PAGESIZEOPTIONS) {
            paginator.select(option);
            paginator.has().itemsPerPageSelected(option);
            paginator.has().range(1, Math.min(option, TOTAL), TOTAL);
        }
    }
}
