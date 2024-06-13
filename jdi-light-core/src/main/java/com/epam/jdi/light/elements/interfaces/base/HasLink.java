package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.jdiai.tools.LinqUtils.safeException;

public interface HasLink extends ICoreElement {
    @JDIAction("Get if there is link inside the button")
    default boolean hasLink() {
        return core().hasAttribute("href");
    }

    @JDIAction("Get '{name}' reference")
    default String ref() {
        return core().attr("href");
    }

    @JDIAction("Get '{name}' reference as URL")
    default URL url() {
        try {
            return new URL(ref());
        } catch (MalformedURLException ex) {
            throw runtimeException(safeException(ex));
        }
    }
}
