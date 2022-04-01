package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.navigation.StepAssert;
import com.epam.jdi.light.material.interfaces.inputs.HasValidationError;

public class Step extends UIBaseElement<StepAssert> implements HasLabel, HasClick, HasValidationError {

    private static final String LABEL_TEXT_LOCATOR = ".//*[contains(@class, 'MuiStepLabel-labelContainer')]";

    @JDIAction("Check that '{name}' is completed")
    public boolean isCompleted() {
        return core().hasClass("MuiStep-completed");
    }

    //TODO: implement this method when example on test page will be added
    @Deprecated
    @JDIAction("Check that '{name}' is editable")
    public boolean isEditable() {
        return false;
    }

    @JDIAction("Check that '{name}' is optional")
    public boolean isOptional() {
        UIElement spanWithOptional = label().find(LABEL_TEXT_LOCATOR + "/span[2]");
        return spanWithOptional.isExist() && spanWithOptional.text().equals("Optional");
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !label().hasClass("Mui-disabled");
    }

    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, core().find(".MuiStepLabel-root"));
    }

    @Override
    @JDIAction("Get '{name}' label text")
    public String labelText() {
        return label().find(LABEL_TEXT_LOCATOR + "/span[1]").text();
    }

    @Override
    public StepAssert is() {
        return new StepAssert().set(this);
    }
}
