package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.navigation.StepAssert;
import com.epam.jdi.light.material.interfaces.inputs.HasValidationError;

/**
 * Step representation for {@link DesktopStepper}. Step is only part of stepper itself and has no access to the page
 * content.
 *
 * @see DesktopStepper
 */
public class Step extends UIBaseElement<StepAssert> implements HasLabel, HasClick, HasValidationError {

    private static final String LABEL_TEXT_LOCATOR = ".//*[contains(@class, 'MuiStepLabel-labelContainer')]";

    /**
     * Checks that this step is marked as completed or not.
     *
     * @return {@code true} this step is marked as completed, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is completed")
    public boolean isCompleted() {
        return core().hasClass("MuiStep-completed");
    }

    /**
     * Checks that this step is marked as optional or not.
     *
     * @return {@code true} this step is marked as optional, otherwise {@code false}
     */
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
