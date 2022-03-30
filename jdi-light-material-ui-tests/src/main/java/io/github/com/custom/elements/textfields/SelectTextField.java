package io.github.com.custom.elements.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.material.elements.inputs.TextField;

/**
 * Represents select text field MUI component on GUI.
 * This text field uses the Select component internally.
 *
 * @see <a href="https://mui.com/components/text-fields/#select">Select Text Field MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class SelectTextField extends TextField {

    /**
     * Gets the inner Select component. It doesn't work for the native Select.
     * For native select you should use {@link SelectTextField#nativeSelect()}
     *
     * @return select component as {@link Select}
     */
    @JDIAction("Get '{name}' select")
    public Select select() {
        return new Select().setCore(Select.class, find(".MuiInputBase-root"));
    }

    /**
     * Gets the inner Native Select component. You should use it for the native Select.
     *
     * @return native select component as {@link Dropdown}
     */
    @JDIAction("Get '{name}' dropdown")
    public Dropdown nativeSelect() {
        return new Dropdown().setCore(Dropdown.class, find(".MuiInputBase-root"));
    }
}
