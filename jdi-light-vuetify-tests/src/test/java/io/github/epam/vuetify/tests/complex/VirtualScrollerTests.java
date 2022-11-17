package io.github.epam.vuetify.tests.complex;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.virtualScrollerPage;
import static io.github.com.pages.VirtualScrollerPage.benchScroller;
import static io.github.com.pages.VirtualScrollerPage.totalBenched;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VirtualScrollerTests extends TestsInit {
    private static final int DEFAULT_NUMBER_BENCH_ITEMS = 5;

    @BeforeClass
    public void before() {
        virtualScrollerPage.open();
        waitCondition(() -> virtualScrollerPage.isOpened());
        virtualScrollerPage.checkOpened();
    }

    @Test
    public void renderedItemsVirtualScrollTest() {
        benchScroller.is().displayed().and().has().items();
        totalBenched.input("0");
        benchScroller.has().itemsCount(DEFAULT_NUMBER_BENCH_ITEMS);
        totalBenched.input("6");
        benchScroller.has().itemsCount(DEFAULT_NUMBER_BENCH_ITEMS + 6);
    }

    @Test
    public void textVirtualScrollerTest() {
        String[] virtualScrollerItems = {"User Database Record ID 1", "User Database Record ID 2",
                "User Database Record ID 3", "User Database Record ID 4", "User Database Record ID 5"};
        benchScroller.scrollToTop();
        benchScroller.show();
        benchScroller.has().text(virtualScrollerItems);
    }

    @Test
    public void measurementVirtualScrollerTest() {
        benchScroller.show();
        benchScroller.has().height(300);
        benchScroller.has().heightGreaterThan(200);
        benchScroller.has().heightLessThan(400);
        benchScroller.has().width(400);
        benchScroller.has().widthGreaterThan(300);
        benchScroller.has().widthLessThan(500);
        benchScroller.has().itemsHeight(64);
    }

    @Test
    public void scrollToItemVirtualScrollerTest() {
        String itemText = "User Database Record ID 14";
        benchScroller.show();
        benchScroller.scrollToElement(itemText);
        benchScroller.item(itemText).is().displayed();
    }
}
