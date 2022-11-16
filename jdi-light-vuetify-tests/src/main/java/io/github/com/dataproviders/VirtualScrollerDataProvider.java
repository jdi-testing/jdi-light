package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

public class VirtualScrollerDataProvider {

    @DataProvider(name = "benchNumberVirtualScroller")
    public static Object[][] benchNumberVirtualScrollerTestsData() {
        return new Object[][]{
                {1},
                {4},
                {9},
                {10},
                {30}
        };
    }

    @DataProvider(name = "bench items text")
    public static Object[][] benchItemsTestsData() {
        return new Object[][]{
                {"User Database Record ID 4"},
                {"User Database Record ID 19"},
                {"User Database Record ID 32"},
                {"User Database Record ID 55"},
        };
    }
}
