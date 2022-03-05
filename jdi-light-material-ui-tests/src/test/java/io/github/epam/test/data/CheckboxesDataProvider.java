package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

public class CheckboxesDataProvider {

    @DataProvider(name = "labelCheckboxesTestsDataProvider")
    public static Object[][] labelCheckboxesTestsData() {
        return new Object[][]{
                {1, "Secondary"},
                {5, "Disabled"},
                {7, "Custom color"},
                {9, "Custom size"}
        };
    }

    @DataProvider(name = "labelPlacementCheckboxesTestsDataProvider")
    public static Object[][] labelPlacementCheckboxesTestsData() {
        return new Object[][]{
                {1, Position.TOP, "Top"},
                {2, Position.START, "Start"},
                {3, Position.BOTTOM, "Bottom"},
                {4, Position.END, "End"}
        };
    }

    @DataProvider(name = "formGroupCheckboxesTestsDataProvider")
    public static Object[][] formGroupCheckboxesTestsData() {
        return new Object[][]{
                {1, "Gilad Gray"},
                {2, "Jason Killian"},
                {3, "Antoine Llorca"},
        };
    }
}
