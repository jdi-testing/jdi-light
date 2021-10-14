package io.github.com.dataproviders;

import org.testng.annotations.DataProvider;

public class ProgressBarsDataProvider {

    @DataProvider(name = "bufferValueProgressBarsTestsDataProvider")
    public static Object[][] bufferValueProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3}
        };
    }

    @DataProvider(name = "colorsProgressBarsTestsDataProvider")
    public static Object[][] colorsProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3}
        };
    }

    @DataProvider(name = "indeterminateProgressBarsTestsDataProvider")
    public static Object[][] indeterminateProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "reversedProgressBarsTestsDataProvider")
    public static Object[][] reversedProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3}
        };
    }

    @DataProvider(name = "roundedProgressBarsTestsDataProvider")
    public static Object[][] roundedProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "streamProgressBarsTestsDataProvider")
    public static Object[][] streamProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "stripedProgressBarsTestsDataProvider")
    public static Object[][] stripedProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }

    @DataProvider(name = "defaultProgressBarsTestsDataProvider")
    public static Object[][] defaultProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3}
        };
    }

    @DataProvider(name = "determinateProgressBarsTestsDataProvider")
    public static Object[][] determinateProgressBarsTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }
}
