package io.github.epam.angular.tests.elements.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
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
import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class PaginatorTests extends TestsInit {
    private static final List<String> PAGE_SIZE_OPTIONS = Arrays.asList("1", "5", "10", "25", "100", "500");
    private static final String OPTIONS =
            PAGE_SIZE_OPTIONS
                    .stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
    private static final int STEP = 100;
    private static final int PAGE_SIZE = 10;
    private static final int LENGTH = STEP * PAGE_SIZE - new Random().nextInt(STEP);
    private static final String RANGE_PATTERN = "%d - %d / %d";

    @BeforeClass
    public void before() {
        paginatorPage.open();
        waitCondition(() -> paginatorPage.isOpened());
        paginatorPage.checkOpened();
    }

    @Test(description = "The test checks item per page label")
    public void labelPaginationTest() {
        paginatorConfigurable.has().pageSizeLabel("Items per page:");
        paginatorConfigurable.has().pageSizeLabelMatches(".*:");
    }

    @Test(description = "The test checks length and pageIndex for paginator")
    public void basicPaginatorTest() {
        waitCondition(() -> listLengthInput.isVisible());
        listLengthInput.setValue( String.valueOf(LENGTH) );
        paginatorConfigurable.selectItemPerPageOption(STEP);
        //First page
        paginatorConfigurable.has().pageIndexCurrent(0)
                .and().has().totalNumberOfPaginatedItems(LENGTH)
                .and().has().rangeLabel(format(RANGE_PATTERN, 1, Math.min(STEP, LENGTH), LENGTH))
                .and().has().nextPageButtonEnabled()
                .and().has().previousPageButtonDisabled();
        paginatorConfigurable.nextPage();

        //Go through each page sequentially:
        for (int pageIndex = 1; pageIndex < PAGE_SIZE - 1; pageIndex++) {
            final String rangeLabel = format(RANGE_PATTERN, pageIndex * STEP + 1, Math.min(pageIndex * STEP + STEP, LENGTH), LENGTH);

            paginatorConfigurable.has().pageIndexCurrent(pageIndex)
                    .and().has().totalNumberOfPaginatedItems(LENGTH)
                    .and().has().rangeLabel(rangeLabel)
                    .and().has().nextPageButtonEnabled()
                    .and().has().previousPageButtonEnabled();
            paginatorConfigurable.nextPage();
        }
        //Last page
        paginatorConfigurable.has().pageIndexCurrent(PAGE_SIZE - 1)
                .and().has().totalNumberOfPaginatedItems(LENGTH)
                .and().has().rangeLabel(format(RANGE_PATTERN, (PAGE_SIZE - 1) * STEP + 1, Math.min((PAGE_SIZE - 1) * STEP + STEP, LENGTH), LENGTH))
                .and().has().previousPageButtonEnabled()
                .and().has().nextPageButtonDisabled();
        paginatorConfigurable.previousPage();

        //Go through each page backwards
        for (int pageIndex = PAGE_SIZE - 2; pageIndex > 0; pageIndex--) {
            final String rangeLabel = format(RANGE_PATTERN, pageIndex * STEP + 1, Math.min(pageIndex * STEP + STEP, LENGTH), LENGTH);

            paginatorConfigurable.has().pageIndexCurrent(pageIndex)
                    .and().has().totalNumberOfPaginatedItems(LENGTH)
                    .and().has().rangeLabel(rangeLabel)
                    .and().has().nextPageButtonEnabled()
                    .and().has().previousPageButtonEnabled();
            paginatorConfigurable.previousPage();
        }
        //First page
        paginatorConfigurable.has().pageIndexCurrent(0)
                .and().has().totalNumberOfPaginatedItems(LENGTH)
                .and().has().rangeLabel(format(RANGE_PATTERN, 1, Math.min(STEP, LENGTH), LENGTH))
                .and().has().previousPageButtonDisabled()
                .and().has().nextPageButtonEnabled();

    }

    @Test(description = "The test checks first page and last page buttons labels for paginator")
    public void firstAndLastPageButtonPaginatorTest() {
        paginatorFirstLastButtons.has().firstLastButtonsShown(true)
                .and().has().firstPageLabel("test firstPageLabel")
                .and().has().lastPageLabel("test lastPageLabel")
                .and().has().firstPageButtonDisplayed(true)
                .and().has().lastPageButtonDisplayed(true);

        paginatorConfigurable.has().firstLastButtonsShown(false);
    }

    @Test(description = "The test checks color theme of the paginators")
    public void colorPaginatorTest() {
        paginatorColorPrimary.has().color(PRIMARY);
        paginatorColorPrimary.has().color("primary");
        paginatorColorWarn.has().color(WARN);
        paginatorColorAccent.has().color(ACCENT);
        paginatorConfigurable.has().color("rgb(103, 58, 183)");
    }

    @Test(description = "The test checks disabled paginator and disabled elements of the paginators")
    public void navigationDisabledPaginatorTest() {
        paginatorDisabledOption.is().disabled()
                .and().has().previousPageButtonDisabled()
                .and().has().nextPageButtonDisabled()
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

        for (String option : PAGE_SIZE_OPTIONS) {
            paginatorConfigurable.selectItemPerPageOption(parseInt(option));
            final String rangeLabel = format(RANGE_PATTERN, 1, Math.min(parseInt(option), LENGTH), LENGTH);
            paginatorConfigurable.has().itemsPerPageSelected(parseInt(option))
                    .and().has().rangeLabel(rangeLabel);
        }
    }
}
