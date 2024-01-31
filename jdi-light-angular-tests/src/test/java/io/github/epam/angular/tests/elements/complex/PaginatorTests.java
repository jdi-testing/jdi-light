package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.epam.jdi.light.angular.elements.enums.AngularColors.ACCENT;
import static com.epam.jdi.light.angular.elements.enums.AngularColors.PRIMARY;
import static com.epam.jdi.light.angular.elements.enums.AngularColors.WARN;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.paginatorPage;
import static io.github.com.pages.PaginatorPage.listLengthInput;
import static io.github.com.pages.PaginatorPage.pageSizeOptionsInput;
import static io.github.com.pages.PaginatorPage.paginatorColorAccent;
import static io.github.com.pages.PaginatorPage.paginatorColorPrimary;
import static io.github.com.pages.PaginatorPage.paginatorColorWarn;
import static io.github.com.pages.PaginatorPage.paginatorConfigurable;
import static io.github.com.pages.PaginatorPage.paginatorDisabledOption;
import static io.github.com.pages.PaginatorPage.paginatorFirstLastButtons;
import static io.github.com.pages.PaginatorPage.paginatorHideSizeOption;
import static java.lang.String.format;

public class PaginatorTests extends TestsInit {
    private static final List<Integer> PAGE_SIZE_OPTIONS = Arrays.asList(1, 5, 10, 25, 100, 500);
    private static final String OPTIONS =
            PAGE_SIZE_OPTIONS
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
    private static final int STEP = 100;
    private static final int PAGE_SIZE = 10;
    private static final int LENGTH = STEP * PAGE_SIZE - new Random().nextInt(STEP);
    private static final String RANGE_PATTERN = "%d - %d / %d";

    @BeforeMethod
    public void before() {
        paginatorPage.open();
        waitCondition(() -> paginatorPage.isOpened());
        paginatorPage.checkOpened();
    }

    @Test(description = "The test checks item per page label")
    public void labelPaginationTest() {
        paginatorConfigurable.has().itemPerPageLabel("Items per page:");
    }

    @Test(description = "The test checks length and pageIndex for paginator")
    public void basicPaginatorTest() {
        waitCondition(() -> listLengthInput.isVisible());
        listLengthInput.setValue(String.valueOf(LENGTH));
        paginatorConfigurable.select(STEP);

        //Go through each page sequentially:
        for (int pageIndex = 0; pageIndex < PAGE_SIZE - 1; pageIndex++) {
            final String rangeLabel = format(RANGE_PATTERN, pageIndex * STEP + 1, Math.min(pageIndex * STEP + STEP, LENGTH), LENGTH);

            paginatorConfigurable.has().pageIndexCurrent(pageIndex)
                    .and().has().totalNumberOfItems(LENGTH)
                    .and().has().rangeLabel(rangeLabel);
            paginatorConfigurable.nextPage();
        }

        //Go through each page backwards
        for (int pageIndex = PAGE_SIZE - 1; pageIndex > 0; pageIndex--) {
            final String rangeLabel = format(RANGE_PATTERN, pageIndex * STEP + 1, Math.min(pageIndex * STEP + STEP, LENGTH), LENGTH);

            paginatorConfigurable.has().pageIndexCurrent(pageIndex)
                    .and().has().totalNumberOfItems(LENGTH)
                    .and().has().rangeLabel(rangeLabel);
            paginatorConfigurable.previousPage();
        }
        paginatorConfigurable.has().pageIndexCurrent(0)
                .and().has().totalNumberOfItems(LENGTH)
                .and().has().rangeLabel(format(RANGE_PATTERN, 1, Math.min(STEP, LENGTH), LENGTH));

    }

    @Test(description = "The test checks first page and last page buttons labels for paginator")
    public void firstAndLastPageButtonPaginatorTest() {
        paginatorFirstLastButtons.has().firstLastButtonsShown(true)
                .and().has().firstPageLabel("test firstPageLabel")
                .and().has().lastPageLabel("test lastPageLabel")
                .and().has().firstPageDisplayed(true)
                .and().has().lastPageDisplayed(true);

        paginatorConfigurable.has().firstLastButtonsShown(false);
    }

    @Test(description = "The test checks color theme of the paginators")
    public void colorPaginatorTest() {
        paginatorColorPrimary.has().colorTheme(PRIMARY)
                .and().has().borderColor(PRIMARY)
                .and().has().selectedOptionColor(PRIMARY);

        paginatorColorPrimary.has().colorTheme("primary")
                .and().has().borderColor("rgb(103, 58, 183)")
                .and().has().selectedOptionColor("rgba(103, 58, 183, 1)");

        paginatorColorWarn.has().colorTheme(WARN)
                .and().has().borderColor(WARN)
                .and().has().selectedOptionColor(WARN);

        paginatorColorAccent.has().colorTheme(ACCENT)
                .and().has().borderColor(ACCENT)
                .and().has().selectedOptionColor(ACCENT);
    }

    @Test(description = "The test checks disabled paginator and disabled elements of the paginators")
    public void navigationDisabledPaginatorTest() {
        paginatorDisabledOption.is().disabled()
                .and().has().previousDisabled()
                .and().has().nextDisabled()
                .and().has().itemPerPageSelectorDisabled();

        paginatorHideSizeOption.is().enabled();
        paginatorColorWarn.is().enabled();
    }

    @Test(description = "The test checks Item per page selector is hidden/visible")
    public void hidePageSizePaginatorTest() {
        paginatorHideSizeOption.has().hiddenPageSize(true);
    }

    @Test(description = "The test checks page size dropdown options")
    public void pageSizeOptionsPaginatorTest() {
        pageSizeOptionsInput.setValue(OPTIONS);
        listLengthInput.focus();
        paginatorConfigurable.has().itemsPerPageList(PAGE_SIZE_OPTIONS);
    }

    @Test(description = "The test checks range label for page size dropdown options")
    public void itemPerPagePaginatorTest() {
        pageSizeOptionsInput.setValue(OPTIONS);
        listLengthInput.setValue(String.valueOf(LENGTH));

        for (Integer option : PAGE_SIZE_OPTIONS) {
            paginatorConfigurable.select(option);
            final String rangeLabel = format(RANGE_PATTERN, 1, Math.min(option, LENGTH), LENGTH);
            paginatorConfigurable.has().itemsPerPageSelected(option)
                    .and().has().rangeLabel(rangeLabel);
        }
    }
}
