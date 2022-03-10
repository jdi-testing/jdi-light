package io.github.com.custom.elements.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.material.elements.inputs.TextField;

public class SelectTextField extends TextField {

    @JDIAction("Get '{name}' select")
    public Select select() {
        return new Select().setCore(Select.class, find(".MuiInputBase-root"));
    }

    @JDIAction("Get '{name}' dropdown")
    public Dropdown dropdown() {
        return new Dropdown().setCore(Dropdown.class, find(".MuiInputBase-root"));
    }
}
