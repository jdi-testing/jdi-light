package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

public class VirtualScrollerDataProvider {

    @DataProvider(name = "bench number")
    public static Object[][] benchNumberTestsData() {
        return new Object[][]{
                {1},
                {4},
                {9},
                {10},
                {30}
        };
    }

    @DataProvider(name = "bench number with scroll")
    public static Object[][] benchNumberWithScrollTestsData() {
        return new Object[][]{
                {1, "User Database Record ID 4"},
                {3, "User Database Record ID 10"},
                {9, "User Database Record ID 20"},
                {11, "User Database Record ID 34"},
                {35, "User Database Record ID 80"},
                {50, "User Database Record ID 110"}
        };
    }

    @DataProvider(name = "pixels to scroll down")
    public static Object[][] pixelsToScrollDownTestsData() {
        return new Object[][]{
                {64},
                {100},
                {500},
                {965},
                {113},
                {3000},
                {1054}
        };
    }

    @DataProvider(name = "pixels to scroll down and up")
    public static Object[][] pixelsToScrollDownAndUpTestsData() {
        return new Object[][]{
                {100, 40},
                {500, 10},
                {965, 300},
                {113, 59},
                {3000, 459},
                {1054, 890}
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
