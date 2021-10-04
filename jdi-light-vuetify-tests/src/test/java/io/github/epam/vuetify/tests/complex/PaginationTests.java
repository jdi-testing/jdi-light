package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;
import io.github.epam.TestsInit;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.disabledPagination;
import static io.github.com.pages.PaginationPage.iconsPagination;
import static io.github.com.pages.PaginationPage.lengthPagination;
import static io.github.com.pages.PaginationPage.totalVisiblePagination;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class PaginationTests extends TestsInit {

    @BeforeClass
    public void before() {
        paginationPage.open();
        paginationPage.isOpened();
    }

    /**
     * This method is required because at different sizes of the browser window
     * some pagination's buttons disappear from the pagination element.
     * All tests that using this method require all buttons to be visible.
     */
    private void skipIfPaginationHasHiddenButtons(Pagination pagination) {
        int hiddenButtonsSize = pagination.hiddenButtons();
        if (hiddenButtonsSize != 0) {
            paginationPage.windowScreenshotToAllure();
            throw new SkipException("Expected that " + pagination.getName() +
                    " would not contain hidden buttons, but found '" +
                    hiddenButtonsSize + "' hidden buttons");
        }
    }

    /**
     * This method is required because at different sizes of the browser window
     * the selected button disappear from the pagination element.
     * All tests that using this method require visible selected button.
     */
    private void skipIfPaginationSelectedButtonIsNotVisible(Pagination pagination) {
        if (pagination.selected() == null) {
            paginationPage.windowScreenshotToAllure();
            throw new SkipException("Expected that " + pagination.getName() +
                    " would have visible selected button, " +
                    "but selected button not found");
        }
    }

    @Test
    public void circlePaginationTest() {
        skipIfPaginationHasHiddenButtons(circlePagination);
        List<String> circlePages = Arrays.asList("1", "2", "3", "4");
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
        skipIfPaginationHasHiddenButtons(iconsPagination);
        List<String> iconsPages = Arrays.asList("1", "2", "3", "4");
        iconsPagination.has().size(4);
        iconsPagination.is().enabled();
        iconsPagination.is().started();
        iconsPagination.has().values(iconsPages);
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
        skipIfPaginationHasHiddenButtons(disabledPagination);
        List<String> disabledPages = Arrays.asList("1", "2", "3");
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
        disabledPagination.has().values(disabledPages);
        disabledPagination.has().selected(nullValue(String.class));
    }

    @Test
    public void lengthPaginationTest() {
        lengthPagination.is().enabled();
        lengthPagination.is().started();

        List<String> actualButtonsFromStartToEnd = new ArrayList<>();
        while (lengthPagination.hasNext()) {
            skipIfPaginationSelectedButtonIsNotVisible(lengthPagination);
            actualButtonsFromStartToEnd.add(lengthPagination.next());
        }
        lengthPagination.is().ended();
        assertThat(actualButtonsFromStartToEnd, equalTo(Arrays.asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        )));
    }

    @Test
    public void totalVisiblePaginationTest() {
        totalVisiblePagination.is().enabled();
        totalVisiblePagination.is().started();

        totalVisiblePagination.select("15");
        totalVisiblePagination.has().selected("15");
        totalVisiblePagination.is().ended();

        List<String> actualButtonsFromEndToStart = new ArrayList<>();
        while (totalVisiblePagination.hasPrevious()) {
            skipIfPaginationSelectedButtonIsNotVisible(totalVisiblePagination);
            actualButtonsFromEndToStart.add(totalVisiblePagination.previous());
        }
        totalVisiblePagination.is().started();
        assertThat(actualButtonsFromEndToStart, equalTo(Arrays.asList(
            "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"
        )));
    }

}
