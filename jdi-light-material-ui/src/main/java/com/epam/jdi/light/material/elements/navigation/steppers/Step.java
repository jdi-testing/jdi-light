package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.asserts.navigation.StepAssert;

public class Step extends UIBaseElement<StepAssert> implements HasLabel, HasClick {

    protected final String labelRootLocator = ".MuiStepLabel-root";
    protected final String labelTextLocator = ".MuiStepLabel-labelContainer";

    @JDIAction("Check that step {0} in '{name}' is completed")
    public boolean isCompleted() {
        return core().hasClass("MuiStep-completed");
    }

    @Override
    @JDIAction(value = "Check that step {0} in '{name}' is enabled", timeout = 0)
    public boolean isEnabled() {
        return !label().hasClass("Mui-disabled");
    }

    @Override
    public Label label() {
        return new Label().setCore(Label.class, core().find(labelRootLocator));
    }

    @Override
    public String labelText() {
        return label().find(labelTextLocator).text();
    }

    @Override
    public StepAssert is() {
        return new StepAssert().set(this);
    }
}
