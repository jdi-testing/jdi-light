package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.paginatorSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class PaginatorTests extends TestsInit {

    private final List<Integer> PAGESIZEOPTIONS = Arrays.asList(1,5,10,25,100,500);
    private final String OPTIONS =
            PAGESIZEOPTIONS
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
    private final int TOTAL = 50;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();

        paginatorSection.listLength.setValue(String.valueOf(TOTAL));
        paginatorSection.pageSizeOptions.setValue(OPTIONS);
    }

    @Test
    public void labelPaginationTest() {
        paginatorSection.paginator.has().label("Items per page:");
    }

    @Test
    public void basicPaginatorTest() {
        final int STEP = 10;
        paginatorSection.paginator.select(STEP);

        paginatorSection.paginator.is().range(1, STEP, TOTAL);
        paginatorSection.paginator.is().previousDisabled();
        paginatorSection.paginator.is().nextEnabled();
        paginatorSection.paginator.next();

        for(int i = STEP + 1; i < TOTAL - STEP + 1; i += STEP) {
            paginatorSection.paginator.is().range(i, i + STEP - 1, TOTAL);
            paginatorSection.paginator.is().previousEnabled();
            paginatorSection.paginator.is().nextEnabled();
            paginatorSection.paginator.next();
        }

        paginatorSection.paginator.is().range(TOTAL - STEP + 1, TOTAL, TOTAL);
        paginatorSection.paginator.is().previousEnabled();
        paginatorSection.paginator.is().nextDisabled();
        paginatorSection.paginator.previous();

        for (int i = TOTAL - 2* STEP + 1; i > 1; i -= STEP) {
            paginatorSection.paginator.is().range(i, i + STEP - 1, TOTAL);
            paginatorSection.paginator.is().previousEnabled();
            paginatorSection.paginator.is().nextEnabled();
            paginatorSection.paginator.previous();
        }

        paginatorSection.paginator.is().range(1, STEP, TOTAL);
        paginatorSection.paginator.is().previousDisabled();
        paginatorSection.paginator.is().nextEnabled();
    }

    @Test
    public void navigationDisabledPaginatorTest() {
        paginatorSection.listLength.setValue("0");

        paginatorSection.paginator.has().range();
        paginatorSection.paginator.has().previousDisabled();
        paginatorSection.paginator.has().nextDisabled();

        paginatorSection.listLength.setValue("100");
        paginatorSection.paginator.select(100);
        paginatorSection.paginator.has().previousDisabled();
        paginatorSection.paginator.has().nextDisabled();
    }

    @Test
    public void pageSizeOptionsPaginatorTest() {
        paginatorSection.paginator.has().itemsPerPageList(PAGESIZEOPTIONS);
    }

    @Test
    public void itemPerPagePaginatorTest() {
        for(Integer option : PAGESIZEOPTIONS) {
            paginatorSection.paginator.select(option);
            paginatorSection.paginator.has().itemsPerPageSelected(option);
            paginatorSection.paginator.has().range(1, Math.min(option, TOTAL), TOTAL);
        }
    }
}
