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
    public static void defaultRenderedBenchItemsTest() {
        benchScroller.is().displayed().and().has().items();
        clearTextField();

        totalBenched.setValue(String.valueOf(DEFAULT_BENCH_NUMBER));
        benchScroller.has().renderedItems(DEFAULT_NUMBER_BENCH_ITEMS);
    }

    @Test(dataProvider = "bench number",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void changeRenderedBenchItemsTest(Integer benchNumber) {
        benchScroller.is().displayed().and().has().items();
        benchScroller.scrollToPosition(0);
        clearTextField();

        totalBenched.sendKeys(String.valueOf(benchNumber));
        benchScroller.has().renderedItems(DEFAULT_NUMBER_BENCH_ITEMS + benchNumber);
    }

    @Test(dataProvider = "bench number with scroll",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void changeRenderedBenchItemsWithScrollTest(Integer benchNumber, String itemText) {
        benchScroller.is().displayed().and().has().items();
        clearTextField();

        totalBenched.sendKeys(String.valueOf(benchNumber));
        benchScroller.scrollToElementWithText(itemText);
        benchScroller.has().renderedItems(DEFAULT_NUMBER_BENCH_ITEMS + 2 * benchNumber);
    }

    @Test(dataProvider = "pixels to scroll down",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollDownToPositionTest(Integer pixelsToScrollDown) {
        benchScroller.is().displayed().and().has().items();
        benchScroller.scrollToPosition(0);

        int startPosition = benchScroller.position();
        benchScroller.scrollToPosition(startPosition + pixelsToScrollDown);
        benchScroller.has().positionBetween(startPosition, startPosition + pixelsToScrollDown);
    }

    @Test(dataProvider = "pixels to scroll down and up",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollDownAndUpToPositionTest(Integer pixelsToScrollDown, Integer pixelsToScrollUp) {
        benchScroller.is().displayed().and().has().items();
        benchScroller.scrollToPosition(0);

        int startPosition = benchScroller.position();
        benchScroller.scrollToPosition(pixelsToScrollDown);
        int endPosition = benchScroller.position();
        benchScroller.has().position(Matchers.greaterThan(startPosition));

        startPosition = endPosition;
        benchScroller.scrollToPosition(startPosition - pixelsToScrollUp);
        benchScroller.has().position(Matchers.lessThan(startPosition));
    }

    @Test(dataProvider = "bench items text",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollToItemTest(String itemText) {
        benchScroller.is().displayed().and().has().items();

        benchScroller.scrollToElementWithText(itemText);
        benchScroller.items().get(3).find(".v-list-item__content").has().text(itemText);
    }

    @Test
    public static void defaultRenderedUserItemsTest() {
        userScroller.is().displayed()
                .and().has().items()
                .and().renderedItems(DEFAULT_NUMBER_USER_ITEMS);
    }

    @Test(dataProvider = "pixels to scroll down",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void userScrollDownToPositionTest(Integer pixelsToScrollDown) {
        userScroller.is().displayed().and().has().items();

        int startPosition = userScroller.position();
        userScroller.scrollToPosition(startPosition + pixelsToScrollDown);
        userScroller.has().positionBetween(startPosition, startPosition + pixelsToScrollDown);
    }

    @Test(dataProvider = "pixels to scroll down and up",
            dataProviderClass = VirtualScrollerDataProvider.class)
    public static void userScrollDownAndUpToPositionTest(Integer pixelsToScrollDown, Integer pixelsToScrollUp) {
        userScroller.is().displayed().and().has().items();

        int startPosition = userScroller.position();
        userScroller.scrollToPosition(startPosition + pixelsToScrollDown);
        int endPosition = userScroller.position();
        userScroller.has().position(Matchers.greaterThan(startPosition));

        startPosition = endPosition;
        userScroller.scrollToPosition(startPosition - pixelsToScrollUp);
        userScroller.has().position(Matchers.lessThan(startPosition));
    }

    private static void clearTextField() {
        while (!totalBenched.getText().equals("")) {
            totalBenched.sendKeys(BACK_SPACE);
        }
    }
}
