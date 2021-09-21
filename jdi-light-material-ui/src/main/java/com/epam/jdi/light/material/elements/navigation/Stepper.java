package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.navigation.StepperAssert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Stepper web element please visit
 * https://mui.com/components/steppers/
 */

public class Stepper extends UIBaseElement<StepperAssert> {
    private final String listLocator = ".MuiStep-root";

    public List<Step> steps() {
        WebList list = core().finds(listLocator);
        return list
                .stream()
                .map(Step::new)
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' steps list")
    public List<String> asList() {
        return steps()
                .stream()
                .map(x -> x.label.text())
                .collect(Collectors.toList());
    }

    @Override
    public StepperAssert is() {
        return new StepperAssert().set(this);
    }

    public class Step extends UIBaseElement<StepperAssert.StepAssert> implements HasClick {
        private final String disabledClass = "Mui-disabled";
        private final String completedClass = "MuiStep-completed";

        private final String iconLocator = ".MuiStepIcon-root";
        private final String labelLocator = ".MuiStepLabel-labelContainer";
        private final String innerLocator = ".MuiStepLabel-root";

        private UIElement parent;
        private UIElement icon;
        private UIElement label;

        Step(UIElement e) {
            core().setCore(e.base());
            parent = e;

            icon = new UIElement();
            icon.setLocator(iconLocator);
            icon.setParent(e);

            label = new UIElement();
            label.setLocator(labelLocator);
            label.setParent(e);
        }

        @JDIAction("Get '{name}' text")
        public String text() {
            return label.text();
        }

        @Override
        @JDIAction(value = "Check that '{name}' is disabled", timeout = 0)
        public boolean isDisabled() {
            return parent.find(innerLocator).hasClass(disabledClass);
        }

        @Override
        @JDIAction(value = "Check that '{name}' is enabled", timeout = 0)
        public boolean isEnabled() {
            return !parent.find(innerLocator).hasClass(disabledClass);
        }

        @JDIAction("Check that '{name}' is completed")
        public boolean isCompleted() {
            return parent.hasClass(completedClass);
        }

        @Override
        public StepperAssert.StepAssert is() {
            return Stepper.this.is().new StepAssert().set(this);
        }
    }
}
