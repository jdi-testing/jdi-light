package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class TableDataProvider {
    @DataProvider(name = "basicTableDataTest")
    private Object[][] dataBasic() {
        return new Object[][]{
                {1, 1, "305"},
                {2, 4, "6"},
                {3, 9, "65"},
                {4, 13, "4"}
        };
    }
}
