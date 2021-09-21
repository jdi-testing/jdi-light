package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.navigation.LinkAssert;

/**
 * To see an example of Links web element please visit
 * https://mui.com/components/links/
 */

public class Link extends UIBaseElement<LinkAssert> {
    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Is '{name}' color primary")
    public boolean isColorPrimary() {
        return core().hasClass("MuiTypography-colorPrimary");
    }

    @JDIAction("Is '{name}' color secondary")
    public boolean isColorSecondary() {
        return core().hasClass("MuiTypography-colorSecondary");
    }

    @JDIAction("Is '{name}' color text primary")
    public boolean isColorTextPrimary() {
        return core().hasClass("MuiTypography-colorTextPrimary");
    }

    @JDIAction("Is '{name}' color text secondary")
    public boolean isColorTextSecondary() {
        return core().hasClass("MuiTypography-colorTextSecondary");
    }

    @JDIAction("Is '{name}' color error")
    public boolean isColorError() {
        return core().hasClass("MuiTypography-colorError");
    }

    @JDIAction("Is '{name}' underline always")
    public boolean isUnderlineAlways() {
        return core().hasClass("MuiLink-underlineAlways");
    }

    @JDIAction("Is '{name}' MuiTypography body 2")
    public boolean isTypographyBody() {
        return core().hasClass("MuiTypography-body2");
    }

    @JDIAction("Is '{name}' color inherit")
    public boolean isColorInherit() {
        return core().hasClass("MuiTypography-colorInherit");
    }

    @JDIAction("Is '{name}' underline hover")
    public boolean isUnderlineHover() {
        return core().hasClass("MuiLink-underlineHover");
    }

    @Override
    public LinkAssert is() {
        return new LinkAssert().set(this);
    }

    public String getLinkText() {
        return core().getText();
    }
}
