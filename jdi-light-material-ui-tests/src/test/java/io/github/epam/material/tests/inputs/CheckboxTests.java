package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import io.github.epam.test.data.CheckboxesDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.pages.inputs.CheckboxPage.basicCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.displayErrorText;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.formGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.mirrorFormGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoText;

public class CheckboxTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    @Test
    public void basicCheckboxTests() {
        for (Checkbox checkbox : basicCheckboxes) {
            if (checkbox.isDisabled()) {
                checkbox.is().notClickable();
            } else if (checkbox.isIndeterminate()) {
                checkIndeterminate(checkbox);
            } else {
                checkBasic(checkbox);
            }
        }
    }

    @Test(dataProvider = "labelCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelCheckboxesTests(int index, String labelText) {
        Checkbox checkbox = formControlLabelCheckboxes.get(index);
        checkbox.label().is().displayed().and().has().text(labelText);
        switch (labelText) {
            case ("Disabled"):
                checkbox.is().notClickable();
                break;

            case ("Indeterminate"):
                checkIndeterminate(checkbox);
                break;

            default:
                checkBasic(checkbox);
                break;
        }
    }

    @Test(dataProvider = "labelPlacementCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelPlacementCheckboxesTests(int index, String labelText, String labelPosition) {
        Checkbox checkbox = labelPlacementCheckboxes.get(index);
        checkbox.label().is().displayed().and().has().text(labelText);
        checkbox.has().labelPosition(labelPosition);
        checkBasic(checkbox);
    }

    @Test(dataProvider = "formGroupCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void formGroupCheckboxesTests(int index, String labelText) {
        Checkbox checkbox = formGroupCheckboxes.get(index);
        Checkbox mirrorCheckbox = mirrorFormGroupCheckboxes.get(index);

        checkbox.label().is().displayed().and().has().text(labelText);
        mirrorCheckbox.label().is().displayed().and().has().text(labelText);

        duoCheck(checkbox, mirrorCheckbox);

        int checkedSize = (int) formGroupCheckboxes.stream().filter(Checkbox::isChecked).count();

        if (checkedSize == 2) {
            pickTwoText.has().css("color", Colors.DEFAULT_GREY.rgba());
            displayErrorText.has().css("color", Colors.DEFAULT_GREY.rgba());
        } else {
            pickTwoText.has().css("color", Colors.ERROR.rgba());
            displayErrorText.has().css("color", Colors.ERROR.rgba());
        }
    }

    private void checkIndeterminate(Checkbox checkbox) {
        if (checkbox.isChecked()) {
            checkbox.has().color(Colors.SECONDARY.rgba());
            checkbox.uncheck();
            checkbox.is().unchecked();
            checkbox.has().color(Colors.DEFAULT_GREY.rgba());
        } else {
            checkbox.has().color(Colors.DEFAULT_GREY.rgba());
            checkbox.check();
            checkbox.is().checked();
            checkbox.has().color(Colors.SECONDARY.rgba());
        }
    }

    private void checkBasic(Checkbox checkbox) {
        if (checkbox.isChecked()) {
            checkbox.uncheck();
            checkbox.is().unchecked();
        } else {
            checkbox.check();
            checkbox.is().checked();
        }
    }

    private void duoCheck(Checkbox mainCheckbox, Checkbox mirrorCheckbox) {
        if (mainCheckbox.isChecked()) {
            mirrorCheckbox.is().checked();
            mainCheckbox.uncheck();
            mirrorCheckbox.is().unchecked();
        } else {
            mirrorCheckbox.is().unchecked();
            mainCheckbox.check();
            mirrorCheckbox.is().checked();
        }
    }
}
