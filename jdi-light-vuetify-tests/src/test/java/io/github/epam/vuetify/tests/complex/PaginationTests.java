package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.apache.commons.lang3.RandomUtils;
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

    @Test(description = "Test checks circle pagination components: size, values, theme")
    public void circlePaginationTest() {
        List<String> circlePages = asList("1", "2", "3", "4");
        circlePagination.has().size(4);
        circlePagination.is().enabled();
        circlePagination.is().atStart();
        circlePagination.has().values(circlePages);

        for (String page : circlePages) {
            circlePagination.select(page);
            circlePagination.has().selected(page);
            circlePagination.has().selected(Integer.parseInt(page));
            circlePagination.has().value(page);
        }
        circlePagination.is().atEnd();
        circlePagination.is().circle();
        circlePagination.has().lightTheme();
        circlePagination.has().currentPageAriaLabel("Current Page");
        circlePagination.has().nextAriaLabel("Next page");
        circlePagination.has().previousAriaLabel("Previous page");
    }

    @Test(description = "Test checks icons pagination components: size, values, icons")
    public void iconsPaginationTest() {
        iconsPagination.has().size(4);
        iconsPagination.is().enabled();
        iconsPagination.is().atStart();
        iconsPagination.has().values(asList("1", "2", "3", "4"));

        int btn = RandomUtils.nextInt(1, iconsPagination.list().size() + 1);
        UIElement button = iconsPagination.get(btn);
        button.click();
        iconsPagination.has().selected(button.getText());
        iconsPagination.has().selected(btn);
        iconsPagination.has().value(button.getText());

        iconsPagination.select("4");
        iconsPagination.is().atEnd();
        iconsPagination.is().notCircle();
        iconsPagination.has().previousIcon("mdi-menu-left");
        iconsPagination.has().nextIcon("mdi-menu-right").and().totalVisible(4);
    }

    @Test(description = "Test checks disabled pagination components: size, values, can not be selected")
    public void disabledPaginationTest() {
        disabledPagination.has().size(3);
        disabledPagination.is().disabled();
        disabledPagination.has().values(asList("1", "2", "3"));
        disabledPagination.has().selected(nullValue(String.class));
    }

    @Test(description = "Test checks length pagination components: values, visible quantity")
    public void lengthPaginationTest() {
        lengthPagination.is().enabled();
        lengthPagination.is().atStart();

        List<String> actualButtonsFromStartToEnd = new ArrayList<>();
        actualButtonsFromStartToEnd.add(lengthPagination.selected());
        while (lengthPagination.hasNext()) {
            lengthPagination.next();
            actualButtonsFromStartToEnd.add(lengthPagination.selected());
        }
        jdiAssert(actualButtonsFromStartToEnd, equalTo(asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        )));

        lengthPagination.is().atEnd();
    }

    @Test(description = "Test checks visible pagination components")
    public void totalVisiblePaginationTest() {
        totalVisiblePagination.is().enabled();
        totalVisiblePagination.is().atStart();

        totalVisiblePagination.select("15");
        totalVisiblePagination.has().selected("15");
        totalVisiblePagination.is().atEnd();

        List<String> actualButtonsFromEndToStart = new ArrayList<>();
        actualButtonsFromEndToStart.add(totalVisiblePagination.selected());
        while (totalVisiblePagination.hasPrevious()) {
            totalVisiblePagination.back();
            actualButtonsFromEndToStart.add(totalVisiblePagination.selected());
        }
        jdiAssert(actualButtonsFromEndToStart, equalTo(asList(
                "15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1"
        )));
        totalVisiblePagination.is().atStart();
    }

    @Test(description = "Test checks dark pagination components: size, values, theme")
    public void darkPaginationTest() {
        darkPagination.has().size(4);
        darkPagination.is().enabled();
        darkPagination.is().atStart();
        darkPagination.has().values(asList("1", "2", "3", "4"));
        darkPagination.select("4");
        darkPagination.has().selected("4");
        darkPagination.is().atEnd();
        darkPagination.is().notCircle();
        darkPagination.has().darkTheme();
    }

    @Test(description = "Test checks color pagination components: size, values, theme, "
            + "color of active and inactive items")
    public void colorPaginationTest() {
        colorPagination.has().size(5);
        colorPagination.is().enabled();
        colorPagination.is().atStart();
        colorPagination.has().values(asList("1", "2", "3", "4", "5"));
        colorPagination.select("4");
        colorPagination.has().selected("4");
        colorPagination.has().lightTheme();
        colorPagination.selectedPage().has().backgroundColor(Colors.RED.value());
        colorPagination.page(2).has().backgroundColor(Colors.WHITE.value());
    }
}
