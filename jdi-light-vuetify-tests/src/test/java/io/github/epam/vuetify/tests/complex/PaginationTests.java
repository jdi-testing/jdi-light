package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.disabledPagination;
import static io.github.com.pages.PaginationPage.iconsPagination;
import static io.github.com.pages.PaginationPage.lengthPagination;
import static io.github.com.pages.PaginationPage.totalVisiblePagination;
import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class PaginationTests extends TestsInit {

    @BeforeClass
    public void before() {
        paginationPage.open();
        waitCondition(() -> paginationPage.isOpened());
        paginationPage.checkOpened();
    }

    @Test
    public void circlePaginationTest() {
        List<String> circlePages = asList("1", "2", "3", "4");
        circlePagination.has().size(4);
        circlePagination.is().enabled();
        circlePagination.is().started();
        circlePagination.has().values(circlePages);

        for (String page : circlePages) {
            circlePagination.select(page);
            circlePagination.has().selected(page);
            circlePagination.has().selected(Integer.parseInt(page));
            circlePagination.has().value(page);
        }
        circlePagination.is().ended();
    }

    @Test
    public void iconsPaginationTest() {
        iconsPagination.has().size(4);
        iconsPagination.is().enabled();
        iconsPagination.is().started();
        iconsPagination.has().values(asList("1", "2", "3", "4"));

        for (UIElement button : iconsPagination.list()) {
            button.click();
            iconsPagination.has().selected(button.getText());
            iconsPagination.has().selected(Integer.parseInt(button.getText()));
            iconsPagination.has().value(button.getText());
        }
        iconsPagination.is().ended();
    }

    @Test
    public void disabledPaginationTest() {
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
        disabledPagination.has().values(asList("1", "2", "3"));
        disabledPagination.has().selected(nullValue(String.class));
    }

    @Test
    public void lengthPaginationTest() {
        lengthPagination.is().enabled();
        lengthPagination.is().started();

        List<String> actualButtonsFromStartToEnd = new ArrayList<>();
        actualButtonsFromStartToEnd.add(lengthPagination.selected());
        while (lengthPagination.hasNext()) {
            lengthPagination.next();
            actualButtonsFromStartToEnd.add(lengthPagination.selected());
        }
        jdiAssert(actualButtonsFromStartToEnd, equalTo(asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        )));
        lengthPagination.is().ended();
    }

    @Test
    public void totalVisiblePaginationTest() {
        totalVisiblePagination.is().enabled();
        totalVisiblePagination.is().started();

        totalVisiblePagination.select("15");
        totalVisiblePagination.has().selected("15");
        totalVisiblePagination.is().ended();

        List<String> actualButtonsFromEndToStart = new ArrayList<>();
        actualButtonsFromEndToStart.add(totalVisiblePagination.selected());
        while (totalVisiblePagination.hasPrevious()) {
            totalVisiblePagination.back();
            actualButtonsFromEndToStart.add(totalVisiblePagination.selected());
        }
        jdiAssert(actualButtonsFromEndToStart, equalTo(asList(
            "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"
        )));
        totalVisiblePagination.is().started();
    }
}