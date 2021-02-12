package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDITransition;
import com.epam.jdi.light.material.elements.utils.Transition;

public class TransitionFrame extends Section {

    @JDITransition(
            root = "#root",
            switchBase = ".MuiSwitch-root",
            paper = ".MuiPaper-root")
    public Transition transition;

}
