package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.paginationPage;
import static io.github.com.pages.PaginationPage.colorPagination;
import static io.github.com.pages.PaginationPage.circlePagination;
import static io.github.com.pages.PaginationPage.darkPagination;
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
        circlePagination.is().circle();
        circlePagination.is().lightTheme();
        circlePagination.has().currentPageAriaLabel();
        circlePagination.has().nextAriaLabel();
        circlePagination.has().previousAriaLabel();
        circlePagination.has().previousIcon("mdi-chevron-left");
        circlePagination.has().nextIcon("mdi-chevron-right");
        circlePagination.has().totalVisible(4);
        circlePagination.has().color("primary", true);
        circlePagination.has().pageAriaLabel();
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
        iconsPagination.is().notCircle();
        iconsPagination.is().lightTheme();
        iconsPagination.has().currentPageAriaLabel();
        iconsPagination.has().nextAriaLabel();
        iconsPagination.has().previousAriaLabel();
        iconsPagination.has().previousIcon("mdi-menu-left");
        iconsPagination.has().nextIcon("mdi-menu-right");
        iconsPagination.has().totalVisible(4);
        iconsPagination.has().pageAriaLabel();
    }

    @Test
    public void disabledPaginationTest() {
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
        disabledPagination.has().values(asList("1", "2", "3"));
        disabledPagination.has().selected(nullValue(String.class));
        disabledPagination.is().notCircle();
        disabledPagination.is().lightTheme();
        disabledPagination.has().nextAriaLabel();
        disabledPagination.has().previousAriaLabel();
        disabledPagination.has().previousIcon("mdi-chevron-left");
        disabledPagination.has().nextIcon("mdi-chevron-right");
        disabledPagination.has().totalVisible(3);
        disabledPagination.has().pageAriaLabel();
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
        lengthPagination.is().notCircle();
        lengthPagination.is().lightTheme();
        lengthPagination.has().currentPageAriaLabel();
        lengthPagination.has().nextAriaLabel();
        lengthPagination.has().previousAriaLabel();
        lengthPagination.has().previousIcon("mdi-chevron-left");
        lengthPagination.has().nextIcon("mdi-chevron-right");
        lengthPagination.has().totalVisible(12);
        lengthPagination.has().color("primary", true);
        lengthPagination.has().pageAriaLabel();
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
        totalVisiblePagination.is().notCircle();
        totalVisiblePagination.is().lightTheme();
        totalVisiblePagination.has().currentPageAriaLabel();
        totalVisiblePagination.has().nextAriaLabel();
        totalVisiblePagination.has().previousAriaLabel();
        totalVisiblePagination.has().previousIcon("mdi-chevron-left");
        totalVisiblePagination.has().nextIcon("mdi-chevron-right");
        totalVisiblePagination.has().totalVisible(7);
        totalVisiblePagination.has().color("primary", true);
        totalVisiblePagination.has().pageAriaLabel();
    }

    @Test
    public void darkPaginationTest() {
        darkPagination.has().size(4);
        darkPagination.is().enabled();
        darkPagination.is().started();
        darkPagination.has().values(asList("1", "2", "3", "4"));
        darkPagination.select("4");
        darkPagination.has().selected("4");
        darkPagination.is().ended();
        darkPagination.is().notCircle();
        darkPagination.is().darkTheme();
        darkPagination.has().currentPageAriaLabel();
        darkPagination.has().nextAriaLabel();
        darkPagination.has().previousAriaLabel();
        darkPagination.has().previousIcon("mdi-chevron-left");
        darkPagination.has().nextIcon("mdi-chevron-right");
        darkPagination.has().totalVisible(4);
        darkPagination.has().color("primary", true);
        darkPagination.has().pageAriaLabel();
    }

    @Test
    public void colorPaginationTest() {
        colorPagination.has().size(5);
        colorPagination.is().enabled();
        colorPagination.is().started();
        colorPagination.has().values(asList("1", "2", "3", "4", "5"));
        colorPagination.select("4");
        colorPagination.has().selected("4");
        colorPagination.is().ended();
        colorPagination.is().notCircle();
        colorPagination.is().lightTheme();
        colorPagination.has().currentPageAriaLabel();
        colorPagination.has().nextAriaLabel();
        colorPagination.has().previousAriaLabel();
        colorPagination.has().previousIcon("mdi-chevron-left");
        colorPagination.has().nextIcon("mdi-chevron-right");
        colorPagination.has().totalVisible(5);
        colorPagination.has().color("red", true);
        colorPagination.has().pageAriaLabel();
    }
}
