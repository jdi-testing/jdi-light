package io.github.epam.vuetify.tests.complex;

import io.github.com.dataproviders.VirtualScrollerDataProvider;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.virtualScrollerPage;
import static io.github.com.pages.VirtualScrollerPage.*;
import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.CONTROL;

public class VirtualScrollerTests extends TestsInit {
    private static final int defaultNumberBenchItems = 5;
    private static final int defaultNumberUserItems = 6;
    private static final int defaultBenchNumber = 0;

    @BeforeClass
    public static void before() {
        virtualScrollerPage.open();
    }

    @Test
    public static void defaultRenderedBenchItemsTest() {
        benchScroller.is().displayed();
        benchScroller.show();
        benchScroller.has().items();

        totalBenched.sendKeys(CONTROL + "a");
        while (!totalBenched.getText().equals("")) {
            totalBenched.sendKeys(BACK_SPACE);
        }
        totalBenched.setValue(String.valueOf(defaultBenchNumber));

        benchScroller.has().renderedItems(defaultNumberBenchItems);
    }

    @Test(dataProvider = "bench number", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void changeRenderedBenchItemsTest(Integer benchNumber) {
        benchScroller.is().displayed();
        benchScroller.show();
        benchScroller.has().items();
        benchScroller.scrollToPosition(0);
        totalBenched.sendKeys(CONTROL + "a");
        totalBenched.sendKeys(BACK_SPACE + "" + BACK_SPACE);

        int newBenchNumber = benchNumber;
        totalBenched.sendKeys(String.valueOf(newBenchNumber));
        benchScroller.has().renderedItems(defaultNumberBenchItems + newBenchNumber);
    }

    @Test(dataProvider = "bench number with scroll", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void changeRenderedBenchItemsWithScrollTest( Integer benchNumber, String itemText) {
        benchScroller.is().displayed();
        benchScroller.show();
        benchScroller.has().items();
        totalBenched.sendKeys(CONTROL + "a");
        totalBenched.sendKeys(BACK_SPACE + "" + BACK_SPACE);

        int newItemsNumber = benchNumber;
        totalBenched.sendKeys(String.valueOf(newItemsNumber));

        benchScroller.scrollToElementWithText(itemText);
        benchScroller.has().renderedItems(defaultNumberBenchItems + 2 * newItemsNumber);
    }

    @Test(dataProvider = "pixels to scroll down", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollDownToPositionTest( Integer pixelsToScrollDown) {
        benchScroller.is().displayed();
        benchScroller.show();
        benchScroller.has().items();
        benchScroller.scrollToPosition(0);

        int startPosition = benchScroller.position();
        benchScroller.scrollToPosition(startPosition + pixelsToScrollDown);
        int endPosition = benchScroller.position();

        jdiAssert(endPosition, Matchers.greaterThan(startPosition));
        jdiAssert(endPosition, Matchers.lessThanOrEqualTo(startPosition + pixelsToScrollDown));

    }

    @Test(dataProvider = "pixels to scroll down and up", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollDownAndUpToPositionTest( Integer pixelsToScrollDown, Integer pixelsToScrollUp) {
        benchScroller.is().displayed();
        benchScroller.show();
        benchScroller.has().items();
        benchScroller.scrollToPosition(0);

        int startPosition = benchScroller.position();
        benchScroller.scrollToPosition(pixelsToScrollDown);
        int endPosition = benchScroller.position();
        jdiAssert(endPosition, Matchers.greaterThan(startPosition));

        startPosition = endPosition;
        benchScroller.scrollToPosition(startPosition - pixelsToScrollUp);
        endPosition = benchScroller.position();
        jdiAssert(endPosition, Matchers.lessThan(startPosition));
    }

    @Test(dataProvider = "bench items text", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void benchScrollToItemTest(String itemText) {
        benchScroller.is().displayed();
        benchScroller.show();

        benchScroller.scrollToElementWithText(itemText);
        jdiAssert(benchScroller.getItems().get(3).find(".v-list-item__content").text(),
                Matchers.equalTo(itemText));
    }

    @Test
    public static void defaultRenderedUserItemsTest() {
        userScroller.is().displayed();
        userScroller.show();
        userScroller.has().items();
        userScroller.has().renderedItems(defaultNumberUserItems);
    }

    @Test(dataProvider = "pixels to scroll down", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void userScrollDownToPositionTest( Integer pixelsToScrollDown) {
        userScroller.is().displayed();
        userScroller.has().items();
        userScroller.show();

        int startPosition = userScroller.position();
        userScroller.scrollToPosition(startPosition + pixelsToScrollDown);
        int endPosition = userScroller.position();
        jdiAssert(endPosition, Matchers.greaterThan(startPosition));
        jdiAssert(endPosition, Matchers.lessThanOrEqualTo(startPosition + pixelsToScrollDown));
    }

    @Test(dataProvider = "pixels to scroll down and up", dataProviderClass = VirtualScrollerDataProvider.class)
    public static void userScrollDownAndUpToPositionTest( Integer pixelsToScrollDown, Integer pixelsToScrollUp) {
        userScroller.is().displayed();
        userScroller.has().items();
        userScroller.show();

        int startPosition = userScroller.position();
        userScroller.scrollToPosition(startPosition+pixelsToScrollDown);
        int endPosition = userScroller.position();
        jdiAssert(endPosition, Matchers.greaterThan(startPosition));

        startPosition = endPosition;
        userScroller.scrollToPosition(startPosition - pixelsToScrollUp);
        endPosition = userScroller.position();
        jdiAssert(endPosition, Matchers.lessThan(startPosition));
    }
}
