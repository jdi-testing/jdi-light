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
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoText;
import static io.github.epam.enums.Colors.GREY_600_TRANSPARENT;
import static io.github.epam.enums.Colors.INDIGO_500;
import static io.github.epam.enums.Colors.RED_500;

public class CheckboxTests extends TestsInit {

    @BeforeMethod
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    @Test(dataProvider = "labelCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelCheckboxesTests(int index, String label) {
        Checkbox checkbox = formControlLabelCheckboxes.get(index);
        checkbox.label().is().displayed().and().has().text(label);
    }

    @Test
    public void basicCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(1);
            checkbox.is().checked();
            checkbox.uncheck();
            checkbox.is().unchecked();
    }

    @Test
    public void disabledCheckBoxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(5);
        checkbox.is().disabled();
    }

    @Test
    public void customColorCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(7);
        checkbox.has().color(Colors.GREEN_600.rgba());
    }

    @Test
    public void customSizeCheckboxTest() {
        Checkbox checkbox = formControlLabelCheckboxes.get(9);
        checkbox.icon.has().width(20).and().height(20);
    }


    @Test(dataProvider = "labelPlacementCheckboxesTestsDataProvider", dataProviderClass = CheckboxesDataProvider.class)
    public void labelPlacementCheckboxesTests(int index, Position position, String label) {
        Checkbox checkbox = labelPlacementCheckboxes.get(index);
        checkbox.label().is().displayed().and().has().text(label);
        checkbox.has().labelPosition(position);
    }

    @Test(invocationCount = 100)
    public void positiveFormGroupCheckboxesTests() {
        Checkbox checkbox = pickTwoCheckboxes.get(1);
        Checkbox secondCheckbox = pickTwoCheckboxes.get(2);


        pickTwoText.has().css("color", RED_500.rgba());
        displayErrorText.has().css("color", RED_500.rgba());

        checkbox.check();
        secondCheckbox.check();
        pickTwoText.has().css("color", INDIGO_500.rgba());
        displayErrorText.has().css("color", GREY_600_TRANSPARENT.rgba());

    }

    @Test
    public void negativeFormGroupCheckboxesTests() {
        Checkbox mirrorCheckbox = pickTwoCheckboxes.get(1);
        Checkbox secondMirrorCheckbox = pickTwoCheckboxes.get(2);
        Checkbox thirdCheckbox = pickTwoCheckboxes.get(3);

        mirrorCheckbox.check();
        secondMirrorCheckbox.check();
        thirdCheckbox.check();

        pickTwoText.has().css("color", RED_500.rgba());
        displayErrorText.has().css("color", RED_500.rgba());
    }
}
