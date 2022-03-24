package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class AlertDataProvider {

    @DataProvider
    public Object[][] alertsWithDescriptionTestData() {
        return new Object[][] {
                {1, "Error", "This is an error alert — check it out!", "MuiAlert-standardError"},
                {2, "Warning", "This is a warning alert — check it out!", "MuiAlert-standardWarning"},
                {3, "Info", "This is an info alert — check it out!", "MuiAlert-standardInfo"},
                {4, "Success", "This is a success alert — check it out!", "MuiAlert-standardSuccess"}
        };
    }
}
