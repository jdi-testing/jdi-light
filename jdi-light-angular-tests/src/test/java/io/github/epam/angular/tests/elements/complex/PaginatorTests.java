package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.paginatorSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class PaginatorTests extends TestsInit {

    private final String PAGESIZEOPTIONS = "1,5,10,25,100,500";
    private final int TOTAL = 50;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void labelPaginationTest() {
        paginatorSection.paginator.has().label("Items per page:");
    }

    @Test
    public void basicPaginatorTest() {
        final int STEP = 10;

        paginatorSection.listLength.setValue(String.valueOf(TOTAL));
        paginatorSection.pageSizeOptions.setValue(PAGESIZEOPTIONS);
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
        paginatorSection.pageSizeOptions.setValue(PAGESIZEOPTIONS);

        paginatorSection.listLength.setValue("0");

        paginatorSection.paginator.is().range();
        paginatorSection.paginator.is().previousDisabled();
        paginatorSection.paginator.is().nextDisabled();

        paginatorSection.listLength.setValue("100");
        paginatorSection.paginator.select(100);
        paginatorSection.paginator.is().previousDisabled();
        paginatorSection.paginator.is().nextDisabled();
    }

    @Test
    public void pageSizeOptionsPaginatorTest() {
        paginatorSection.pageSizeOptions.setValue(PAGESIZEOPTIONS);

        List<String> values = Arrays.asList(PAGESIZEOPTIONS.split(","));
        paginatorSection.paginator.has().itemsPerPageList(values);
    }

    @Test
    public void itemPerPagePaginatorTest() {
        paginatorSection.listLength.setValue(String.valueOf(TOTAL));
        paginatorSection.pageSizeOptions.setValue(PAGESIZEOPTIONS);

        String[] options = PAGESIZEOPTIONS.split(",");
        for(String option : options) {
            int i = Integer.parseInt(option);
            paginatorSection.paginator.select(i);
            paginatorSection.paginator.has().itemsPerPageSelected(i);
            paginatorSection.paginator.has().range(1, Math.min(i, TOTAL), TOTAL);
        }
    }
}
