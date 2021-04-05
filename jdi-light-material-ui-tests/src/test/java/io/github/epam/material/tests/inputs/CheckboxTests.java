package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.MaterialNavigator.openSection;

public class CheckboxTests extends TestsInit {

    private void checkboxTestLogic(String section, int index) {
        if (checkboxPage.checkbox.isEnabled(section, index)) {
            checkboxPage.checkbox.check(section, index);
            checkboxPage.checkbox.is().checked(section, index);
            checkboxPage.checkbox.uncheck(section, index);
            checkboxPage.checkbox.is().unChecked(section, index);
        } else
            checkboxPage.checkbox.is().disabled(section, index);
    }

    private void textTestLogic(String section, int index) {
        checkboxPage.checkbox.is().checkText(section, index);
    }

    private void groupTestLogic(String section, int index) {
        int secondIndex = (index + 3) / 7 > 0 ? (index + 3) % 7 + 1 : (index + 3) % 7;
        checkboxPage.checkbox.check(section, index);
        checkboxPage.checkbox.is().checked(section, index);
        checkboxPage.checkbox.is().checked(section, secondIndex);
        checkboxPage.checkbox.uncheck(section, index);
        checkboxPage.checkbox.is().unChecked(section, index);
        checkboxPage.checkbox.is().unChecked(section, secondIndex);
    }

    private void groupTestErrorLogic(String section) {
        checkboxPage.checkbox.check(section, 1);
        checkboxPage.checkbox.is().hasError();
        checkboxPage.checkbox.check(section, 2);
        checkboxPage.checkbox.is().hasNoError();
    }

    @Test
    public void BasicCheckboxTest() {
        openSection("Checkboxes");
        checkboxPage.shouldBeOpened();
        String section = "Basic";
        for (int i = 1; i < 9; i++)
            checkboxTestLogic(section, i);
    }

    @Test
    public void formControlLabelTest() {
        openSection("Checkboxes");
        checkboxPage.shouldBeOpened();
        String section = "FormControlLabel";
        for (int i = 1; i < 10; i++) {
            checkboxTestLogic(section, i);
            textTestLogic(section, i);
        }
    }

    @Test
    public void formGroupTest() {
        openSection("Checkboxes");
        checkboxPage.shouldBeOpened();
        String section = "FormGroup";
        for (int i = 1; i < 7; i++) {
            groupTestLogic(section, i);
            textTestLogic(section, i);
        }
        groupTestErrorLogic(section);
    }

    @Test
    public void labelPlacementTest() {
        openSection("Checkboxes");
        checkboxPage.shouldBeOpened();
        String section = "labelPlacement";
        for (int i = 1; i < 5; i++) {
            checkboxTestLogic(section, i);
            textTestLogic(section, i);
        }
    }
}
