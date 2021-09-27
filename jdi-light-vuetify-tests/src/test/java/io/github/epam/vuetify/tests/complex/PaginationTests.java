package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.ui.html.elements.common.Button;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PaginationTests extends TestsInit {

    List<String> circle;
    List<String> disabled;
    List<String> icons;
    List<String> length;
    List<String> totalVisible;

    private List<String> initPages(int from, int to) {
        List<String> pages = new ArrayList<>(to - from + 1);
        for (int i = from; i <= to; i++) {
            pages.add(Integer.toString(i));
        }
        System.out.println(pages);
        return pages;
    }

    @BeforeClass
    public void before() {
        paginationPage.open();
    }

    @BeforeClass
    public void initData() {
        circle = initPages(1, 4);
        disabled = initPages(1, 3);
        icons = initPages(1, 4);
        length = initPages(1, 15);
        totalVisible = initPages(1, 15);
    }

    @Test
    public void circlePaginationTest() {
        circlePagination
                .is().notEmpty()
                .has().size(4)
                .enabled()
                .started();

        for (String page : circle) {
            circlePagination.select(page);
            circlePagination.has()
                    .selected(Integer.parseInt(page))
                    .selected(page)
                    .value(page)
                    .enabled(page);
        }
        circlePagination
                .is().ended()
                .has().values(circle);
    }

    @Test
    public void iconsPaginationTest() {
        iconsPagination
                .is().notEmpty()
                .has().size(4)
                .enabled()
                .started();

        for (Button button : iconsPagination.buttons()) {
            button.click();
            iconsPagination
                    .is().selected(button.getText())
                    .has().values(button.getText());
        }
        iconsPagination
                .has().values(icons)
                .is().ended();
    }

    @Test
    public void disabledPaginationTest() {
        disabledPagination
                .is().notEmpty()
                .has().size(3)
                .disabled();
    }

    @Test
    public void lengthPaginationTest() {
        lengthPagination
                .is().notEmpty()
                .has().size(11)
                .has().hiddenButtons()
                .enabled()
                .started();

        lengthPagination.select(2);
        lengthPagination
                .has().values("1", "2", "3", "4", "5", "6", "11", "12", "13", "14", "15")
                .has().selected("2")
                .has().selected(2);
        lengthPagination.select(7);
        lengthPagination
                .has().values("1", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")
                .has().selected("11")
                .has().selected(7);
        lengthPagination.select("15");
        lengthPagination
                .is().ended()
                .has().values("1", "2", "3", "4", "5", "6", "11", "12", "13", "14", "15")
                .has().selected("15")
                .has().selected(11);
    }


    @Test
    public void totalVisiblePaginationTest() {
        totalVisiblePagination
                .is().notEmpty()
                .has().size(6)
                .has().hiddenButtons()
                .enabled()
                .started();

        List<String> actualButtons = new ArrayList<>();
        ListIterator<String> it = totalVisiblePagination.listIterator();
        it.forEachRemaining(actualButtons::add);
        assertThat(actualButtons, equalTo(totalVisible));
        actualButtons.clear();

        int sizeOfPreviousCheck = 3;
        totalVisiblePagination.select(sizeOfPreviousCheck);
        while (it.hasPrevious()) {
            actualButtons.add(it.previous());
        }
        Collections.reverse(actualButtons);
        List<String> expected = totalVisible.stream()
                .limit(sizeOfPreviousCheck)
                .collect(Collectors.toList());
        assertThat(actualButtons, equalTo(expected));
        totalVisiblePagination
                .is().started();
    }

}
