package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

/**
 * Represents icon text field component on Vuetify.
 *
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify/text-fields">Text fields test page</a>
 */
public class IconTextField extends TextField {

    private static final String PREPEND_OUTER_ICON = ".v-input__prepend-outer";
    private static final String APPEND_OUTER_ICON = ".v-input__append-outer";
    private static final String APPEND_INNER_ICON = "div:last-child.v-input__append-inner";
    private static final String CLEAR_ICON = ".v-input__append-inner";

    /**
     * Get the icon inside the TextField by locator.
     *
     * @param locator the locator of the icons
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' icon by locator")
    protected Icon iconByLocator(String locator) {
        return new Icon().setCore(Icon.class, find(locator).find(".v-icon"));
    }

    /**
     * Get clear text icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' clear icons")
    public Icon clearIcon() {
        return iconByLocator(CLEAR_ICON);
    }

    /**
     * Get prepend outer icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' prepend outer icon")
    public Icon prependOuterIcon() {
        return iconByLocator(PREPEND_OUTER_ICON);
    }

    /**
     * Get append inner icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' append inner icons")
    public Icon appendInnerIcon() {
        return iconByLocator(APPEND_INNER_ICON);
    }

    /**
     * Get append outer icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' append outer icons")
    public Icon appendOuterIcon() {
        return iconByLocator(APPEND_OUTER_ICON);
    }
}
