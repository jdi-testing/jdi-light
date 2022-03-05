package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.google.common.collect.ImmutableMap;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static io.github.com.StaticSite.checkboxPage;
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

    @Test()
    public void labelCheckboxesTests() {
        int basicIndex = 1;
        int disabledIndex = 5;
        int customColorIndex = 7;
        int customSizeIndex = 9;

        Checkbox basicCheckbox = formControlLabelCheckboxes.get(basicIndex);
        Checkbox disabledCheckbox = formControlLabelCheckboxes.get(disabledIndex);
        Checkbox customColorCheckbox = formControlLabelCheckboxes.get(customColorIndex);
        Checkbox customSizeCheckbox = formControlLabelCheckboxes.get(customSizeIndex);

        checkLabel(basicCheckbox, "Secondary");
        checkLabel(disabledCheckbox, "Disabled");
        checkLabel(customColorCheckbox, "Custom color");
        checkLabel(customSizeCheckbox, "Custom size");

        checkBasic(basicCheckbox);
        disabledCheckbox.is().disabled();

        customColorCheckbox.has().color(Colors.GREEN_600.rgba());

        customSizeCheckbox.has().iconSize(20, 20);
    }

    @Test()
    public void labelPlacementCheckboxesTests() {
        int basicIndex = 1;
        Map<Position, Integer> checkboxes =
                ImmutableMap.of(Position.TOP, basicIndex, Position.START, 2, Position.BOTTOM, 3, Position.END, 4);


        for (Map.Entry<Position, Integer> entry : checkboxes.entrySet()) {
            int index = entry.getValue();
            Position position = entry.getKey();
            Checkbox checkbox = labelPlacementCheckboxes.get(index);

            String label = position.getPosition();
            label = label.replace(label.charAt(0), Character.toUpperCase(label.charAt(0)));

            checkLabel(checkbox, label);
            checkbox.has().labelPosition(position);
        }

        checkBasic(labelPlacementCheckboxes.get(basicIndex));
    }

    @Test()
    public void formGroupCheckboxesTests() {
        int firstCheckboxIndex = 1;
        int secondCheckboxIndex = 2;
        int thirdCheckboxIndex = 3;
        Checkbox checkbox = formGroupCheckboxes.get(firstCheckboxIndex);
        Checkbox mirrorCheckbox = mirrorFormGroupCheckboxes.get(firstCheckboxIndex);
        Checkbox secondMirrorCheckbox = mirrorFormGroupCheckboxes.get(secondCheckboxIndex);
        Checkbox thirdMirrorCheckbox = mirrorFormGroupCheckboxes.get(thirdCheckboxIndex);

        mirrorCheckbox.uncheck();
        checkbox.is().unchecked();

        checkError();

        mirrorCheckbox.check();
        secondMirrorCheckbox.check();

        pickTwoText.has().css("color", Colors.PRIMARY.rgba());
        displayErrorText.has().css("color", Colors.DEFAULT_GREY.rgba());

        thirdMirrorCheckbox.check();

        checkError();
    }

    private void checkError() {
        pickTwoText.has().css("color", Colors.ERROR.rgba());
        displayErrorText.has().css("color", Colors.ERROR.rgba());
    }

    private void checkLabel(Checkbox checkbox, String label) {
        checkbox.label().is().displayed().and().has().text(label);
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
}
