package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

public class  CheckboxesDataProvider {

    @DataProvider(name = "labelCheckboxesTestsDataProvider")
    public static Object[][] labelCheckboxesTestsData() {
        return new Object[][]{
                {1, "Secondary"},
                {2, "Primary"},
                {3, "Uncontrolled"},
                {4, "Disabled"},
                {5, "Disabled"},
                {6, "Indeterminate"},
                {7, "Custom color"},
                {8, "Custom icon"},
                {9, "Custom size"}
        };
    }

    @DataProvider(name = "labelPlacementCheckboxesTestsDataProvider")
    public static Object[][] labelPlacementCheckboxesTestsData() {
        return new Object[][]{
                {1, "Top", "top"},
                {2, "Start", "start"},
                {3, "Bottom", "bottom"},
                {4, "End", "end"}
        };
    }

    @DataProvider(name = "formGroupCheckboxesTestsDataProvider")
    public static Object[][] formGroupCheckboxesTestsData() {
        return new Object[][]{
                {1, "Gilad Gray"},
                {2, "Jason Killian"},
                {3, "Antoine Llorca"}
        };
    }
}
