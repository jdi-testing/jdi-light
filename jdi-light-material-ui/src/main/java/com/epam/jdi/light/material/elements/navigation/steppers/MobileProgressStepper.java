package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;

public class MobileProgressStepper extends MobileProgress {

    @JProgress(root = ".MuiLinearProgress-root")
    public LinearProgress progress;

    @Override
    @JDIAction("Get '{name}' value")
    public int value() {
        return progress.getValueNow();
    }

    @Override
    @JDIAction("Get '{name}' max value")
    public int maxValue() {
        return progress.maxValue();
    }
}
