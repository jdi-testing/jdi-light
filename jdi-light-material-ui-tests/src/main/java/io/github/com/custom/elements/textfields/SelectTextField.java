package io.github.com.custom.elements.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.material.elements.inputs.Select;
import com.epam.jdi.light.material.elements.inputs.TextField;

/**
 * Represents select text field MUI component on GUI. This text field uses the Select component internally.
 * Select text field might be of two types: select and native select.
 * Whereas native select text field uses HTML tags &lt;select&gt; and &lt;option&gt;,
 * default select text field uses &lt;ul&gt; and &lt;li&gt;.
 *
 * @see <a href="https://mui.com/components/text-fields/#select">Select Text Field MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class SelectTextField extends TextField {

    /**
     * Gets the inner Select component that uses HTML tags &lt;ul&gt; and &lt;li&gt;.
     * For native select use {@link SelectTextField#nativeSelect()}
     *
     * @return select component as {@link Select}
     */
    @JDIAction("Get '{name}' select")
    public Select select() {
        return new Select().setCore(Select.class, core().find(".MuiInputBase-root"));
    }

    /**
     * Gets the inner native Select component as {@link Dropdown} since native select looks like default
     * {@link Dropdown} element and uses HTML tags &lt;select&gt; and &lt;option&gt;.
     * It should be used for the native Select.
     *
     * @return native select component as {@link Dropdown}
     */
    @JDIAction("Get '{name}' dropdown")
    public Dropdown nativeSelect() {
        return new Dropdown().setCore(Dropdown.class, core().find(".MuiInputBase-root"));
    }
}
