package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.ui.html.aserts.LinkAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class Link extends UIBaseElement<LinkAssert> implements HasValue {
    // region Actions
    @JDIAction("Click on '{name}'")
    public void click() { element.click(); }
    @JDIAction("Get '{name}' text")
    public String getText() {
        return element.getText();
    }

    @JDIAction(value = "Get '{name}' text", level = DEBUG)
    public String ref() { return element.attr("href"); }

    public URL url() {
        try { return new URL(ref());
        } catch (MalformedURLException ex) { throw exception(ex.getMessage()); }
    }
    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String alt() { return element.attr("alt"); }
    // endregion

    // region Set and get value for Forms
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    public LinkAssert is() {
        return new LinkAssert().set(this);
    }
    // endregion
}
