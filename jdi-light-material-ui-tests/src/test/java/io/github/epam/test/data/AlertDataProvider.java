package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Severity;
import org.testng.annotations.DataProvider;

public class AlertDataProvider {

    @DataProvider
    public Object[][] alertsWithDescriptionTestData() {
        return new Object[][]{
                {1, "Error", "This is an error alert — check it out!", Severity.ERROR},
                {2, "Warning", "This is a warning alert — check it out!", Severity.WARNING},
                {3, "Info", "This is an info alert — check it out!", Severity.INFO},
                {4, "Success", "This is a success alert — check it out!", Severity.WARNING}
        };
    }

    @DataProvider
    public Object[][] alertsWitVariantsTestData() {
        return new Object[][]{
                {1, "This is an error alert — outlined", Severity.ERROR},
                {2, "This is a warning alert — outlined", Severity.WARNING},
                {3, "This is an info alert — filled", Severity.INFO},
                {4, "This is a success alert — filled", Severity.WARNING}
        };
    }
}
