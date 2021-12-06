package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class ChipDataProvider {

    @DataProvider(name = "basicChipsTestsDataProvider")
    public static Object[][] basicChipsTestsData() {
        return new Object[][] {
                {1, "Basic"},
                {2, "Disabled"},
                {3, "Clickable"},
                {4, "Deletable"},
                {5, "Clickable deletable"},
                {6, "Custom delete icon"},
                {8, "Primary clickable with face"},
                {9, "Deletable primary"},
                {10, "Deletable secondary"}
        };
    }

    @DataProvider(name = "outlinedChipsTestsDataProvider")
    public static Object[][] outlinedChipsTestsData() {
        return new Object[][] {
                {1, "Basic"},
                {2, "Disabled"},
                {3, "Clickable"},
                {4, "Deletable"},
                {5, "Clickable deletable"},
                {6, "Custom delete icon"},
                {7, "Primary clickable"},
                {8, "Primary clickable with face"},
                {9, "Deletable primary"},
                {10, "Deletable secondary"}
        };
    }

    @DataProvider(name = "linkChipsTestsDataProvider")
    public static Object[][] linkChipsTestsData() {
        return new Object[][] {
                {1, "Clickable Link", false, "https://jdi-testing.github.io/jdi-light/material/chips#chip"},
                {2, "Clickable link", true, "https://jdi-testing.github.io/jdi-light/material/chips#chip"}
        };
    }

    @DataProvider(name = "arrayChipsTestsDataProvider")
    public static Object[][] arrayChipsTestsData() {
        return new Object[][] {
                {1, "Angular"},
                {2, "jQuery"},
                {3, "Polymer"},
                {4, "React"},
                {5, "Vue.js"},
        };
    }

}
