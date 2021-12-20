package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static io.github.epam.enums.Colors.DEFAULT_GREY;
import static io.github.epam.enums.Colors.ERROR;
import static io.github.epam.enums.Colors.PRIMARY;

public class CheckboxesDataProvider {

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
                {3, "Antoine Llorca"},
                {4, "Gilad Gray",},
                {5, "Jason Killian"},
                {6, "Antoine Llorca"}
        };
    }

    public static Object[][] formGroupErrorTestsData() {
        return new Object[][]{
                {1, DEFAULT_GREY.rgba(), ERROR.rgba()},
                {2, PRIMARY.rgba(), DEFAULT_GREY.rgba()},
                {3, PRIMARY.rgba(), ERROR.rgba()}
        };
    }
}
