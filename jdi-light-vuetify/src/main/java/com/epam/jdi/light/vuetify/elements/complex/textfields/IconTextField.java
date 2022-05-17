package com.epam.jdi.light.vuetify.elements.complex.textfields;

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


    protected List<Icon> getIconByLocator(String locator) {
        return finds(locator)
                .stream()
                .map(icon -> icon.find(".v-icon"))
                .map(icon -> new Icon().setCore(Icon.class, icon))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return getIconByLocator(PREPEND_OUTER_ICON);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return getIconByLocator(PREPEND_INNER_ICON);
    }

    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return getIconByLocator(APPEND_INNER_ICON);
    }

    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return getIconByLocator(APPEND_OUTER_ICON);
    }

    @JDIAction("Get '{name}' clear icons")
    public Icon getCLEAR_ICON() {
        return getIconByLocator(CLEAR_ICON).get(0);
    }

    @JDIAction("Get '{name}' prepend outer icon")
    public Icon getPrependOuterIcon() {
        return prependOuterIcons().get(0);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public Icon getPrependInnerIcon() {
        return prependInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append inner icons")
    public Icon getAPPEND_INNER_ICON() {
        return appendInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append outer icons")
    public Icon getAppendOuterIcon() {
        return appendOuterIcons().get(0);
    }
}
