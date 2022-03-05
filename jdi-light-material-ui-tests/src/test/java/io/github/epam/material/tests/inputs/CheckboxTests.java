package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import io.github.epam.test.data.CheckboxesDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.pages.inputs.CheckboxPage.displayErrorText;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.formGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoText;

public class CheckboxTests extends TestsInit {

    @BeforeMethod()
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    @Test(dataProvider = "labelCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelCheckboxesTests(Checkbox checkbox, String label) {
        checkbox.label().is().displayed().and().has().text(label);
    }

    @Test
    public void basicCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(1);
        checkbox.show();

        checkbox.is().checked();
        checkbox.uncheck();
        checkbox.is().unchecked();
    }

    @Test
    public void disabledCheckBoxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(5);
        checkbox.show();
        checkbox.is().disabled();
    }

    @Test
    public void customColorCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(7);
        checkbox.show();
        checkbox.has().color(Colors.GREEN_600.rgba());
    }

    @Test
    public void customSizeCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(9);
        checkbox.show();
        checkbox.has().iconSize(20, 20);
    }


    @Test(dataProvider = "labelPlacementCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelPlacementCheckboxesTests(Checkbox checkbox, Position position, String label) {
        checkbox.label().is().displayed().and().has().text(label);
        checkbox.show();
        checkbox.has().labelPosition(position);
    }

    @Test
    public void positiveFormGroupCheckboxesTests() {
        Checkbox checkbox = formGroupCheckboxes.get(1);
        Checkbox secondCheckbox = formGroupCheckboxes.get(2);

        pickTwoText.show();
        pickTwoText.has().css("color", Colors.ERROR.rgba());
        displayErrorText.show();
        displayErrorText.has().css("color", Colors.ERROR.rgba());

        checkbox.check();
        secondCheckbox.check();

        pickTwoText.show();
        pickTwoText.has().css("color", Colors.PRIMARY.rgba());
        displayErrorText.show();
        displayErrorText.has().css("color", Colors.DEFAULT_GREY.rgba());
    }

    @Test()
    public void negativeFormGroupCheckboxesTests() {
        Checkbox mirrorCheckbox = formGroupCheckboxes.get(1);
        Checkbox secondMirrorCheckbox = formGroupCheckboxes.get(2);
        Checkbox thirdCheckbox = formGroupCheckboxes.get(3);

        mirrorCheckbox.check();
        secondMirrorCheckbox.check();
        thirdCheckbox.check();

        pickTwoText.has().css("color", Colors.ERROR.rgba());
        displayErrorText.has().css("color", Colors.ERROR.rgba());
    }
}
