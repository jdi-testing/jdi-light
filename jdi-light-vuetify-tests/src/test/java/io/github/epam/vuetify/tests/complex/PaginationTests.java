package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.disabledPagination;
import static io.github.com.pages.PaginationPage.iconsPagination;
import static io.github.com.pages.PaginationPage.lengthPagination;
import static io.github.com.pages.PaginationPage.totalVisiblePagination;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class PaginationTests extends TestsInit {

    @BeforeClass
    public void before() {
        paginationPage.open();
    }

    @Test
    public void circlePaginationTest() {
        List<String> circlePages = Arrays.asList("1", "2", "3", "4");
        circlePagination.has().size(4);
        circlePagination.is().enabled();
        circlePagination.is().started();
        circlePagination.has().values(circlePages);
        for (String page : circlePages) {
            circlePagination.select(page);
            circlePagination.has().selected(Integer.parseInt(page));
            circlePagination.has().selected(page);
            circlePagination.has().value(page);
            circlePagination.has().enabled(page);
        }
        circlePagination.is().ended();
        circlePagination.has().values(circlePages);
    }

    @Test
    public void iconsPaginationTest() {
        List<String> iconsPages = Arrays.asList("1", "2", "3", "4");
        iconsPagination.has().size(4);
        iconsPagination.is().enabled();
        iconsPagination.is().started();
        circlePagination.has().values(iconsPages);
        for (UIElement button : iconsPagination.list()) {
            button.click();
            iconsPagination.is().selected(button.getText());
            iconsPagination.has().values(button.getText());
        }
        iconsPagination.has().values(iconsPages);
        iconsPagination.is().ended();
    }

    @Test
    public void disabledPaginationTest() {
        List<String> disabledPages = Arrays.asList("1", "2", "3");
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
        disabledPagination.has().values(disabledPages);
        assertThat(disabledPagination.selected(), is(nullValue()));
    }

    @Test
    public void lengthPaginationTest() {
        lengthPagination.has().size(11);
        lengthPagination.has().hiddenButtons();
        lengthPagination.is().enabled();
        lengthPagination.is().started();

        lengthPagination.select(2);
        lengthPagination.has().values("1", "2", "3", "4", "5", "6", "11", "12", "13", "14", "15");
        lengthPagination.has().selected("2");
        lengthPagination.has().selected(2);

        lengthPagination.select(7);
        lengthPagination.has().values("1", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15");
        lengthPagination.has().selected("11");
        lengthPagination.has().selected(7);

        lengthPagination.select("15");
        lengthPagination.is().ended();
        lengthPagination.has().values("1", "2", "3", "4", "5", "6", "11", "12", "13", "14", "15");
        lengthPagination.has().selected("15");
        lengthPagination.has().selected(11);
    }

    @Test
    public void totalVisiblePaginationTest() {
        totalVisiblePagination.has().size(6);
        totalVisiblePagination.has().hiddenButtons();
        totalVisiblePagination.is().enabled();
        totalVisiblePagination.is().started();

        totalVisiblePagination.select("15");
        totalVisiblePagination.is().ended();
        totalVisiblePagination.has().values("1", "2", "3", "13", "14", "15");
        totalVisiblePagination.has().selected("15");
        totalVisiblePagination.has().selected(6);

        List<String> actualButtonsFromEndToStart = new ArrayList<>();
        ListIterator<String> it = totalVisiblePagination.listIterator();
        while (it.hasPrevious()) {
            actualButtonsFromEndToStart.add(it.previous());
        }
        totalVisiblePagination.is().started();
        assertThat(actualButtonsFromEndToStart, equalTo(Arrays.asList(
            "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"
        )));
    }

}
