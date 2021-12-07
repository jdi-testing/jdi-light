package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import io.github.epam.TestsInit;
import io.github.epam.test.data.CheckboxesDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.pages.inputs.CheckboxPage.assignResponsibilityText;
import static io.github.com.pages.inputs.CheckboxPage.basicCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.displayErrorText;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.formGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoText;
import static io.github.epam.enums.Colors.GREEN_600;

public class CheckboxTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    @Test
    public void basicCheckboxTests() {
        basicCheckboxes.forEach(this::basicCheckboxTestLogic);
    }

    @Test(dataProvider = "labelCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelCheckboxesTests(int index, String labelText) {
        formControlLabelCheckboxes.get(index).label().is().displayed();
        formControlLabelCheckboxes.get(index).label().has().text(labelText);
        basicCheckboxTestLogic(formControlLabelCheckboxes.get(index));
    }

    @Test
    public void customColorCheckboxTest() {
        formControlLabelCheckboxes.get(7).has().color(GREEN_600.rgba());
    }

    @Test(dataProvider = "labelPlacementCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelPlacementCheckboxesTests(int index, String labelText, String labelPosition) {
        labelPlacementCheckboxes.get(index).label().is().displayed();
        labelPlacementCheckboxes.get(index).has().labelPosition(labelPosition);
        labelPlacementCheckboxes.get(index).label().has().text(labelText);
        basicCheckboxTestLogic(labelPlacementCheckboxes.get(index));
    }

    @Test(dataProvider = "formGroupCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void formGroupCheckboxesTests(int index, String labelText) {
        formGroupCheckboxes.get(index).label().is().displayed();
        formGroupCheckboxes.get(index).label().has().text(labelText);
        basicCheckboxTestLogic(formGroupCheckboxes.get(index));
    }

    @Test
    public void formGroupErrorsTests() {
        Object[][] errorTestData = CheckboxesDataProvider.formGroupErrorTestsData();
        for (int i = 0; i <= 2; i++) {
            formGroupCheckboxes.get((Integer) errorTestData[i][0]).check();
            formGroupCheckboxes.get((Integer) errorTestData[i][0]).is().checked();
            formGroupCheckboxes.get((Integer) errorTestData[i][0] + 3).is().checked();
            assignResponsibilityText.has().css("color", (String) errorTestData[i][1]);
            pickTwoText.has().css("color", (String) errorTestData[i][2]);
            displayErrorText.has().css("color", (String) errorTestData[i][2]);
        }
    }

    private void basicCheckboxTestLogic(Checkbox checkbox) {
        if (checkbox.isDisabled()) {
            checkbox.is().disabled();
            if (checkbox.isChecked()) {
                checkbox.is().checked();
            } else {
                checkbox.is().unchecked();
            }
        } else {
            checkbox.is().enabled();
            if (checkbox.isUnchecked()) {
                checkbox.is().unchecked();
                checkbox.check();
                checkbox.is().checked();
            } else {
                checkbox.is().checked();
                checkbox.uncheck();
                checkbox.is().unchecked();
            }
        }
        if (checkbox.hasPrimaryColor()) {
            checkbox.has().primaryColor();
        }
        if (checkbox.hasSecondaryColor()) {
            checkbox.has().secondaryColor();
        }
        if (checkbox.isIndeterminate()) {
            checkbox.is().indeterminate();
        }
    }
}
