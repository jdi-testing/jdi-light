package com.epam.jdi.light.vuetify.elements.complex.textfields;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;
import java.util.stream.Collectors;

public class IconEventTextField extends TextField {
    private String prependOuter = ".v-input__prepend-outer";
    private String prependInner = ".v-input__prepend-inner";
    private String appendOuter = ".v-input__append-outer";
    private String appendInner = ".v-input__append-inner";

    protected List<Icon> getIconByLocator(String locator) {
        return finds(locator)
                .stream()
                .map(icon -> icon.find(".v-icon"))
                .map(icon -> new Icon().setCore(Icon.class, icon))
                .collect(Collectors.toList());
    }


    @JDIAction("Get '{name}' prepend outer icons")
    public List<Icon> prependOuterIcons() {
        return getIconByLocator(prependOuter);
    }

    @JDIAction("Get '{name}' prepend inner icons")
    public List<Icon> prependInnerIcons() {
        return getIconByLocator(prependInner);
    }

    @JDIAction("Get '{name}' append inner icons")
    public List<Icon> appendInnerIcons() {
        return getIconByLocator(appendInner);
    }

    @JDIAction("Get '{name}' append outer icons")
    public List<Icon> appendOuterIcons() {
        return getIconByLocator(appendOuter);
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
    public Icon getAppendInnerIcon() {
        return appendInnerIcons().get(0);
    }

    @JDIAction("Get '{name}' append outer icons")
    public Icon getAppendOuterIcon() {
        return appendOuterIcons().get(0);
    }
}
