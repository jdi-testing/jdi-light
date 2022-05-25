package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;
import java.util.stream.Collectors;

public class IconTextField extends TextField {

    private static final String PREPEND_OUTER_ICON = ".v-input__prepend-outer";
    private static final String PREPEND_INNER_ICON = ".v-input__prepend-inner";
    private static final String APPEND_OUTER_ICON = ".v-input__append-outer";
    private static final String APPEND_INNER_ICON = "div:last-child.v-input__append-inner";
    private static final String CLEAR_ICON = ".v-input__append-inner";

    /** Get the list icons inside the TextField by locator.
     *
     * @param locator the locator of the icons
     * @return list icons as {@link List}
     */
    @JDIAction("Get '{name}' list icons by locator")
    protected List<Icon> iconsByLocator(String locator) {
        return finds(locator).stream().map(icon -> icon.find(".v-icon")).map(icon -> new Icon().setCore(Icon.class, icon)).collect(Collectors.toList());
    }

    /** Get the icon inside the TextField by locator.
     *
     * @param locator the locator of the icons
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' icon by locator")
    protected Icon iconByLocator(String locator) {
        return new Icon().setCore(Icon.class, find(locator));
    }

    /** Get list prepend outer icons inside the TextField.
     *
     * @return icon as {@link List}
     */
    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return iconsByLocator(PREPEND_OUTER_ICON);
    }

    /** Get list prepend inner icons inside the TextField.
     *
     * @return icon as {@link List}
     */
    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return iconsByLocator(PREPEND_INNER_ICON);
    }

    /** Get list append inner icons inside the TextField.
     *
     * @return icon as {@link List}
     */
    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return iconsByLocator(APPEND_INNER_ICON);
    }

    /** Get list append outer icons inside the TextField.
     *
     * @return icon as {@link List}
     */
    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return iconsByLocator(APPEND_OUTER_ICON);
    }

    /** Get clear text icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' clear icons")
    public Icon clearIcon() {
        return iconByLocator(CLEAR_ICON);
    }

    /** Get prepend outer icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' prepend outer icon")
    public Icon prependOuterIcon() {
        return iconByLocator(PREPEND_OUTER_ICON);
    }

    /** Get prepend inner icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' prepend inner icons")
    public Icon prependInnerIcon() {
        return iconByLocator(PREPEND_INNER_ICON);
    }

    /** Get append inner icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' append inner icons")
    public Icon appendInnerIcon() {
        return iconByLocator(APPEND_INNER_ICON);
    }

    /** Get append outer icon inside the TextField.
     *
     * @return icon as {@link Icon}
     */
    @JDIAction("Get '{name}' append outer icons")
    public Icon appendOuterIcon() {
        return iconByLocator(APPEND_OUTER_ICON);
    }
}
