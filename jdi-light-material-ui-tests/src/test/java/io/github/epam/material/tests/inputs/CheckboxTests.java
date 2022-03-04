package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import io.github.epam.enums.Colors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.checkboxPage;
import static io.github.com.pages.inputs.CheckboxPage.displayErrorText;
import static io.github.com.pages.inputs.CheckboxPage.formControlLabelCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.formGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.labelPlacementCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.mirrorFormGroupCheckboxes;
import static io.github.com.pages.inputs.CheckboxPage.pickTwoText;
import static io.github.epam.material.tests.inputs.CheckboxTests.LabelCheckbox.BASIC;
import static io.github.epam.material.tests.inputs.CheckboxTests.LabelCheckbox.DISABLED;
import static io.github.epam.material.tests.inputs.CheckboxTests.LabelCheckbox.CUSTOM_COLOR;
import static io.github.epam.material.tests.inputs.CheckboxTests.LabelCheckbox.CUSTOM_SIZE;
import static io.github.epam.material.tests.inputs.CheckboxTests.PositionCheckbox.TOP;

public class CheckboxTests extends TestsInit {

    enum LabelCheckbox {
        BASIC(1, "Secondary"),
        DISABLED(5, "Disabled"),
        CUSTOM_COLOR(7, "Custom color"),
        CUSTOM_SIZE(9, "Custom size");

        private final int index;
        private final String label;

        LabelCheckbox(int index, String label) {
            this.index = index;
            this.label = label;
        }
    }

    enum PositionCheckbox {
        TOP(1, Position.TOP),
        START(2, Position.START),
        BOTTOM(3, Position.BOTTOM),
        END(4, Position.END);

        private final int index;
        private final Position position;

        PositionCheckbox(int index, Position position) {
            this.index = index;
            this.position = position;
        }
    }

    @BeforeMethod()
    public void beforeTest() {
        checkboxPage.open();
        checkboxPage.shouldBeOpened();
    }

    @Test()
    public void labelCheckboxesTests() {
        for (LabelCheckbox labelCheckbox : LabelCheckbox.values()) {
            Checkbox checkbox = formControlLabelCheckboxes.get(labelCheckbox.index);
            checkLabel(checkbox, labelCheckbox.label);
        }

        Checkbox basicCheckbox = formControlLabelCheckboxes.get(BASIC.index);
        Checkbox disabledCheckbox = formControlLabelCheckboxes.get(DISABLED.index);
        Checkbox customColorCheckbox = formControlLabelCheckboxes.get(CUSTOM_COLOR.index);
        Checkbox customSizeCheckbox = formControlLabelCheckboxes.get(CUSTOM_SIZE.index);


        checkBasic(basicCheckbox);
        disabledCheckbox.is().disabled();

        customColorCheckbox.has().color(Colors.GREEN_600.rgba());

        customSizeCheckbox.has().iconSize(20, 20);
    }

    @Test()
    public void labelPlacementCheckboxesTests() {
        for (PositionCheckbox positionCheckbox : PositionCheckbox.values()) {
            Checkbox checkbox = labelPlacementCheckboxes.get(positionCheckbox.index);

            String label = positionCheckbox.position.getPosition();
            label = label.replace(label.charAt(0), Character.toUpperCase(label.charAt(0)));

            checkLabel(checkbox, label);
            checkbox.has().labelPosition(positionCheckbox.position);
        }

        checkBasic(labelPlacementCheckboxes.get(TOP.index));
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
