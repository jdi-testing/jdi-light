package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.annotations.JDICheckbox;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasCheck,
    HasAssert<CheckboxAssert>, ISetup {
    private String basicCheckbox;
    private String formControlLabelCheckbox;
    private String formGroupCheckbox;
    private String labelPlacement;
    private String formControlLabelText;
    private String formGroupCheckboxText;
    private String labelPlacementText;
    private String errorMessageText;

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDICheckbox.class, Checkbox.class))
            return;
        JDICheckbox j = field.getAnnotation(JDICheckbox.class);

        basicCheckbox = j.basicCheckbox();
        formControlLabelCheckbox = j.formControlLabelCheckbox();
        formGroupCheckbox = j.formGroupCheckbox();
        labelPlacement = j.labelPlacement();
        formControlLabelText = j.formControlLabelText();
        formGroupCheckboxText = j.formGroupText();
        labelPlacementText = j.labelPlacementText();
        errorMessageText = j.errorMessageText();
    }

    public UIElement getCheckBoxes(String section, int index) {
        String sectionSelector;
        switch (section) {
            case ("Basic"):
                sectionSelector = basicCheckbox;
                break;
            case ("FormControlLabel"):
                sectionSelector = formControlLabelCheckbox;
                break;
            case("FormGroup"):
                sectionSelector = formGroupCheckbox;
                break;
            case("labelPlacement"):
                sectionSelector = labelPlacement;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + section);
        }
        return this.finds(sectionSelector).get(index);
    }

    public String getText(String section, int index) {
        String sectionSelector;
        switch (section) {
            case ("FormControlLabel"):
                sectionSelector = formControlLabelText;
                break;
            case("FormGroup"):
                sectionSelector = formGroupCheckboxText;
                break;
            case("labelPlacement"):
                sectionSelector = labelPlacementText;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + section);
        }
        return this.finds(sectionSelector).get(index).getText();
    }

    @JDIAction("Is '{name}' checked")
    public boolean isChecked(String section, int index) {
        return getCheckBoxes(section, index).hasClass("Mui-checked");
    }

    @JDIAction()
    public boolean hasError() {
        System.out.println(errorMessageText);
        return this.finds(errorMessageText).get(2).hasClass("Mui-error");
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotChecked(String section, int index) {
        return !isChecked(section, index);
    }

    @JDIAction("Check '{name}'")
    public void check(String section, int index) {
        if (isNotChecked(section, index)) {
            getCheckBoxes(section, index).click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck(String section, int index) {
        if(isChecked(section, index)) {
            getCheckBoxes(section, index).click();
        }
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled(String section, int index) {
        return getCheckBoxes(section, index).hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled(String section, int index) {
        return !isDisabled(section, index);
    }

    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
