package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.bootstrap.asserts.LinkAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * To see an example of Link web element please visit https://getbootstrap.com/docs/4.3/utilities/stretched-link/
 */

public class Link extends UIBaseElement<LinkAssert>
        implements HasValue, HasClick, IsText {
    // region Actions

    @JDIAction(value = "Get '{name}' text", level = DEBUG)
    public String ref() { return uiElement.attr("href"); }

    public URL url() {
        try { return new URL(ref());
        } catch (MalformedURLException ex) { throw exception(safeException(ex)); }
    }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return uiElement.attr("alt"); }
    // endregion

    // region Set and get value for Forms
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    @Override
    public LinkAssert is() {
        return new LinkAssert().set(this);
    }
    // endregion
}
