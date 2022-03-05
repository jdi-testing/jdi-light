package io.github.epam.test.data;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.testng.annotations.DataProvider;

import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckboxes;

public class CheckboxesDataProvider {

    @DataProvider(name = "labelCheckboxesTestsDataProvider")
    public static Object[][] labelCheckboxesTestsData() {
        return new Object[][]{
                {formControlLabelCheckboxes.get(1), "Secondary"},
                {formControlLabelCheckboxes.get(5), "Disabled"},
                {formControlLabelCheckboxes.get(7), "Custom color"},
                {formControlLabelCheckboxes.get(9), "Custom size"}
        };
    }

    @DataProvider(name = "labelPlacementCheckboxesTestsDataProvider")
    public static Object[][] labelPlacementCheckboxesTestsData() {
        return new Object[][]{
                {labelPlacementCheckboxes.get(1), Position.TOP, "Top"},
                {labelPlacementCheckboxes.get(2), Position.START, "Start"},
                {labelPlacementCheckboxes.get(3), Position.BOTTOM, "Bottom"},
                {labelPlacementCheckboxes.get(4), Position.END, "End"}
        };
    }
}
