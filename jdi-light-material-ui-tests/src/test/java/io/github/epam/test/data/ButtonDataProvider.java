package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class ButtonDataProvider {

    @DataProvider
    public Object[][] containedButtonTestData() {
        return new Object[][] {
                {1, "DEFAULT", true},
                {2, "PRIMARY", true},
                {3, "SECONDARY", true},
                {4, "DISABLED", false},
                {5, "LINK", true}
        };
    }

    @DataProvider
    public Object[][] textButtonTestData() {
            return new Object[][] {
                {1, "DEFAULT", true},
                {2, "PRIMARY", true},
                {3, "SECONDARY", true},
                {4, "DISABLED", false},
                {5, "LINK", true}
            };
    }

    @DataProvider
    public Object[][] iconLabelButtonTestData() {
        return new Object[][] {
                {1, "DELETE", true},
                {2, "SEND\nSEND", true},
                {3, "UPLOAD", true},
                {4, "TALK", false},
                {5, "SAVE", true},
                {6, "SAVE ALL", true}
        };
    }

    @DataProvider
    public Object[][] iconButtonTestData() {
        return new Object[][] {
                {1, true},
                {2, false},
                {3, true},
                {4, true}
        };
    }

    @DataProvider
    public Object[][] customizeButtonTestData() {
        return new Object[][] {
                {1, "CUSTOM CSS", true},
                {2, "THEME PROVIDER", true},
                {3, "Bootstrap", true},
        };
    }

    @DataProvider
    public Object[][] complexButtonTestData() {
        return new Object[][] {
                {1, "Breakfast", true},
                {2, "Burgers", true},
                {3, "Camera", true}
        };
    }
}
