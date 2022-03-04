package io.github.com.custom.elements.steppers;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class VerticalStep extends Step {

    @UI("p")
    public Text content;

    @UI("p + div")
    public ButtonGroup buttonGroup;
}
