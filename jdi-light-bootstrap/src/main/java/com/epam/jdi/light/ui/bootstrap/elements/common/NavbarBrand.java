package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.bootstrap.asserts.NavbarBrandAssert;

import java.net.MalformedURLException;
import java.net.URL;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class NavbarBrand extends UIBaseElement<NavbarBrandAssert>
        implements HasClick, IsText {

    @JDIAction(value = "Get '{name}' href", level = DEBUG)
    public String getRef() {
        return uiElement.attr("href");
    }

    public URL getUrl() {
        try {
            return new URL(getRef());
        } catch (MalformedURLException ex) {
            throw exception(safeException(ex));
        }
    }

    @JDIAction(value = "Get '{name}' image alt", level = DEBUG)
    public String getAlt() {
        return uiElement.attr("alt");
    }

    public String getText() {
        return uiElement.getText();
    }

    @Override
    public NavbarBrandAssert is() {
        return new NavbarBrandAssert().set(this);
    }

    //getChildren
    //getType of e
}
