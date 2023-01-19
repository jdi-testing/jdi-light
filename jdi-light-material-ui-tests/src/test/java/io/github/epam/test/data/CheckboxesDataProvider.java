package io.github.epam.test.data;

import org.testng.annotations.DataProvider;

import static com.epam.jdi.light.material.elements.utils.enums.Position.TOP;
import static com.epam.jdi.light.material.elements.utils.enums.Position.START;
import static com.epam.jdi.light.material.elements.utils.enums.Position.BOTTOM;
import static com.epam.jdi.light.material.elements.utils.enums.Position.END;

public class CheckboxesDataProvider {

    @DataProvider(name = "labelCheckboxesTestsDataProvider")
    public Object[][] labelCheckboxesTestsData() {
        return new Object[][]{
                {1, "Secondary"},
                {5, "Disabled"},
                {7, "Custom color"},
                {9, "Custom size"}
        };
    }

    @DataProvider(name = "labelPlacementCheckboxesTestsDataProvider")
    public Object[][] labelPlacementCheckboxesTestsData() {
        return new Object[][]{
                {1, TOP.toString(), "Top"},
                {2, START.toString(), "Start"},
                {3, BOTTOM.toString(), "Bottom"},
                {4, END.toString(), "End"}
        };
    }

    @DataProvider(name = "formGroupCheckboxesTestsDataProvider")
    public Object[][] formGroupCheckboxesTestsData() {
        return new Object[][]{
                {1, "Gilad Gray"},
                {2, "Jason Killian"},
                {3, "Antoine Llorca"},
        };
    }
}
