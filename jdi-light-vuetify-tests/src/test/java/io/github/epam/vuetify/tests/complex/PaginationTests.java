package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.disabledPagination;
import static io.github.com.pages.PaginationPage.iconsPagination;
import static io.github.com.pages.PaginationPage.lengthPagination;
import static io.github.com.pages.PaginationPage.totalVisiblePagination;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PaginationTests extends TestsInit {

    List<String> circlePages;
    List<String> disabledPages;
    List<String> iconsPages;
    List<String> lengthPages;
    List<String> totalVisiblePages;

    private List<String> initPages(int from, int to) {
        return Collections.unmodifiableList(
                IntStream.rangeClosed(from, to)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.toList())
        );
    }

    @BeforeClass
    public void before() {
        paginationPage.open();
    }

    @BeforeClass
    public void initData() {
        circlePages = initPages(1, 4);
        disabledPages = initPages(1, 3);
        iconsPages = initPages(1, 4);
        lengthPages = initPages(1, 15);
        totalVisiblePages = initPages(1, 15);
    }

    @Test
    public void circlePaginationTest() {
        circlePagination.is().notEmpty();
        circlePagination.has().size(4);
        circlePagination.is().enabled();
        circlePagination.is().started();
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
        iconsPagination.is().notEmpty();
        iconsPagination.has().size(4);
        iconsPagination.is().enabled();
        iconsPagination.is().started();
        for (Button button : iconsPagination.buttons()) {
            button.click();
            iconsPagination.is().selected(button.getText());
            iconsPagination.has().values(button.getText());
        }
        iconsPagination.has().values(iconsPages);
        iconsPagination.is().ended();
    }

    @Test
    public void disabledPaginationTest() {
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
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

        List<String> actualButtonsFromStartToEnd = new ArrayList<>();
        ListIterator<String> it = totalVisiblePagination.listIterator();
        while (it.hasNext()) {
            actualButtonsFromStartToEnd.add(it.next());
        }
        totalVisiblePagination.is().ended();
        assertThat(actualButtonsFromStartToEnd, equalTo(totalVisiblePages));

        int indexStartInReverseOrder = 3;
        List<String> actualButtonsFromIndexStart = new ArrayList<>();
        totalVisiblePagination.select(indexStartInReverseOrder);
        while (it.hasPrevious()) {
            actualButtonsFromIndexStart.add(it.previous());
        }
        Collections.reverse(actualButtonsFromIndexStart);
        List<String> expected = totalVisiblePages.stream()
                .limit(indexStartInReverseOrder)
                .collect(Collectors.toList());
        assertThat(actualButtonsFromIndexStart, equalTo(expected));
        totalVisiblePagination.is().started();
    }

}
