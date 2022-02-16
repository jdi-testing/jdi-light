package com.epam.jdi.light.material.elements.navigation.steppers;

import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;

public class MobileProgressStepper extends StepperWithProgress {

    @JProgress(root = ".MuiLinearProgress-root")
    public LinearProgress progress;

    @Override
    public int value() {
        return progress.getValueNow();
    }

    @Override
    public int maxValue() {
        return progress.maxValue();
    }
}
