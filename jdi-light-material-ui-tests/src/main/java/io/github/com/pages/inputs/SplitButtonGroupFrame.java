package io.github.com.pages.inputs;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIButtonGroup;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;

public class SplitButtonGroupFrame extends Section {

    @JDIButtonGroup(
            root = "#root",
            mainButton = ".MuiButton-root[1]",
            expand = ".MuiButton-root[2]",
            list = ".MuiPaper-root #split-button-menu")
    public ButtonGroup buttonGroup;

}
