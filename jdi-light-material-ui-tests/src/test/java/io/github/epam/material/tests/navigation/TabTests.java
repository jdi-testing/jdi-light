package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;

public class TabTests extends TestsInit {

    private final int itemOne = 1;
    private final int itemTwo = 2;
    private final int itemThree = 3;
    private final String itemThreeText = "Item Three";

    @Test
    public void defaultTabTest() {
        defaultTabPage.open();

        simpleTabFrame.tabs.is().enabled(itemOne);
        simpleTabFrame.tabs.is().selected(itemOne);
        simpleTabFrame.tabs.selectTab(itemTwo);
        simpleTabFrame.tabs.is().selected(itemTwo);
        simpleTabFrame.tabs.selectTab(itemThreeText);
        simpleTabFrame.tabs.is().selected(itemThreeText);
    }

    @Test
    public void disabledTabTest() {
        disabledTabPage.open();

        disabledTabFrame.tabs.is().enabled(itemOne);
        disabledTabFrame.tabs.is().disabled(itemTwo);
        disabledTabFrame.tabs.is().enabled(itemThree).selected(itemThree);
        disabledTabFrame.tabs.selectTab(itemOne);
        disabledTabFrame.tabs.is().selected(itemOne);
    }

    @Test
    public void scrollableTabTest() {
        scrollableTabPage.open();

        scrollableTabFrame.tabs.is().forwardScrollButtonEnabled();
        scrollableTabFrame.tabs.is().backScrollButtonDisabled();
        scrollableTabFrame.tabs.scrollForward();
        scrollableTabFrame.tabs.is().forwardScrollButtonDisabled();
        scrollableTabFrame.tabs.is().backScrollButtonEnabled();
        scrollableTabFrame.tabs.scrollBack();
        scrollableTabFrame.tabs.is().forwardScrollButtonEnabled();
        scrollableTabFrame.tabs.is().backScrollButtonDisabled();
    }

    @Test
    public void verticalTabTest() {
        verticalTabPage.open();

        verticalTabFrame.tabs.is().forwardScrollButtonEnabled();
        verticalTabFrame.tabs.is().backScrollButtonDisabled();
        verticalTabFrame.tabs.scrollForward();
        verticalTabFrame.tabs.is().forwardScrollButtonEnabled();
        verticalTabFrame.tabs.is().backScrollButtonEnabled();
        verticalTabFrame.tabs.scrollForward();
        scrollableTabFrame.tabs.is().forwardScrollButtonDisabled();
        scrollableTabFrame.tabs.is().backScrollButtonEnabled();
        verticalTabFrame.tabs.scrollBack();
        verticalTabFrame.tabs.is().forwardScrollButtonEnabled();
        verticalTabFrame.tabs.is().backScrollButtonEnabled();
        verticalTabFrame.tabs.scrollBack();
        verticalTabFrame.tabs.is().forwardScrollButtonEnabled();
        verticalTabFrame.tabs.is().backScrollButtonDisabled();
    }
}
