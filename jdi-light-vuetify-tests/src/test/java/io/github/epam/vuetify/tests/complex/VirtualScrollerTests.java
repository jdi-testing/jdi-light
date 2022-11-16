package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.virtualScrollerPage;
import static io.github.com.pages.VirtualScrollerPage.benchScroller;
import static io.github.com.pages.VirtualScrollerPage.totalBenched;
import static io.github.com.pages.VirtualScrollerPage.userScroller;
import static org.openqa.selenium.Keys.BACK_SPACE;

import io.github.com.dataproviders.VirtualScrollerDataProvider;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class VirtualScrollerTests extends TestsInit {
    private static final int DEFAULT_NUMBER_BENCH_ITEMS = 5;
    private static final int DEFAULT_NUMBER_USER_ITEMS = 6;
    private static final int DEFAULT_BENCH_NUMBER = 0;

    @BeforeClass
    public static void before() {
        virtualScrollerPage.open();
        waitCondition(() -> virtualScrollerPage.isOpened());
        virtualScrollerPage.checkOpened();
    }

    @Test
    public static void renderedItemsVirtualScrollTest() {
        benchScroller.is().displayed().and().has().items();
        totalBenched.input(String.valueOf(DEFAULT_BENCH_NUMBER));
        benchScroller.has().renderedItems(DEFAULT_NUMBER_BENCH_ITEMS);
    }

    @Test
    public void textVirtualScrollerTest() {
        String[] virtualScrollerItems = {"User Database Record ID 1", "User Database Record ID 2",
                "User Database Record ID 3", "User Database Record ID 4", "User Database Record ID 5"};
        benchScroller.scrollToTop();
        benchScroller.show();
        benchScroller.has().text(virtualScrollerItems);
    }

    @Test(dataProvider = "benchNumberVirtualScroller", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void changeRenderedBenchItemsTest(Integer benchNumber) {
        benchScroller.show();
        benchScroller.scrollToTop();
        totalBenched.input(String.valueOf(benchNumber));
        benchScroller.has().renderedItems(DEFAULT_NUMBER_BENCH_ITEMS + benchNumber);
    }
}
