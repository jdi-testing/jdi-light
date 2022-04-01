package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.annotations.JStepper;
import com.epam.jdi.light.material.asserts.navigation.MobileStepperAssert;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import com.epam.jdi.light.ui.html.elements.common.Button;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class MobileStepper extends Stepper<MobileStepperAssert> {

    private static final String DOT_LOCATOR = ".MuiMobileStepper-dot";

    private Button backButton;
    private Button nextButton;

    @Override
    public void setup(Field field) {
        JStepper j = basicSetup(field);
        if (j != null) {
            backButton = new Button().setCore(Button.class, find(".//span[text()='Back']/parent::button"));
            nextButton = new Button().setCore(Button.class, find(".//span[text()='Next']/parent::button"));
        }
    }

    @Override
    @JDIAction("Get '{name}' current step index")
    public int currentIndex() {
        IntSupplier dotSupplier = () -> {
            List<UIElement> dots = finds(DOT_LOCATOR).stream()
                    .map(dot -> new UIElement().setCore(UIElement.class, dot))
                    .collect(Collectors.toList());
            UIElement activeDot = dots.stream()
                    .filter(dot -> dot.hasClass("MuiMobileStepper-dotActive"))
                    .findFirst()
                    .orElseThrow(() -> Exceptions.runtimeException(String.format("No active dots found for stepper '%s'", this.getName())));
            return dots.indexOf(activeDot) + 1;
        };

        return getIndex(
                dotSupplier,
                () -> getLinearProgress().getValueNow(),
                () -> getIndexFromText(0)
        );
    }

    @Override
    @JDIAction("Get '{name}' max step index")
    public int maxIndex() {
        return getIndex(
                () -> finds(DOT_LOCATOR).size(),
                () -> getLinearProgress().maxValue(),
                () -> getIndexFromText(1)
        );
    }

    @JDIAction("Get '{name}' 'Back' button")
    public Button backButton() {
        return backButton;
    }

    @JDIAction("Get '{name}' 'Next' button")
    public Button nextButton() {
        return nextButton;
    }

    @Override
    public MobileStepperAssert is() {
        return new MobileStepperAssert().set(this);
    }

    private int getIndex(IntSupplier dotSupplier, IntSupplier progressSupplier, IntSupplier textSupplier) {
        if (find(DOT_LOCATOR).isExist()) {
            return dotSupplier.getAsInt();
        } else if (getLinearProgress().isExist()) {
            return progressSupplier.getAsInt();
        } else if (getCounterText().matches("[0-9] / [0-9]")) {
            return textSupplier.getAsInt();
        } else {
            throw Exceptions.runtimeException("No mobile stepper found on page");
        }
    }

    private LinearProgress getLinearProgress() {
        //using class field caused problems at runtime, so create new instance by each method call
        LinearProgress linearProgress = new LinearProgress() {
            @Override
            protected UIElement root() {
                return core();
            }
        };
        return linearProgress.setCore(LinearProgress.class, find(".MuiLinearProgress-root"));
    }

    private int getIndexFromText(int arrayIndex) {
        return Integer.parseInt(getCounterText().split("/")[arrayIndex].trim());
    }

    private String getCounterText() {
        return core().text().split("\\n")[1];
    }
}
