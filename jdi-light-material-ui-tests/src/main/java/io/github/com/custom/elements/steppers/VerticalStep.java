package io.github.com.custom.elements.steppers;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.navigation.steppers.Step;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class VerticalStep extends Step {

    @JDIAction("Get '{name}' content")
    public Text content() {
        return new Text().setCore(Text.class, core().find("p"));
    }

    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        return new ButtonGroup().setCore(ButtonGroup.class, core().find("p + div"));
    }
}
