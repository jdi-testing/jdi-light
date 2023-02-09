package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.IClickable;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SheetAssert;
import com.epam.jdi.light.vuetify.interfaces.*;

/**
 * To see an example of Sheet web element please visit https://jdi-testing.github.io/jdi-light/vuetify/sheets
 */
public class Sheet extends UIBaseElement<SheetAssert> implements IsText, IClickable, HasColor,
        HasElevation, HasTheme, IsOutlined, IsShaped, IsTile {

    @Override
    public void click() {
        core().click();
    }

    @Override
    public SheetAssert is() {
        return new SheetAssert().set(this);
    }

    @Override
    @JDIAction("Get 'name' color")
    public String color() {
        return core().css("background-color");
    }

    @JDIAction("Get '{name}' height")
    public int height() { return core().getRect().getHeight(); }

    @JDIAction("Get '{name}' width")
    public int width() { return core().getRect().getWidth(); }

    @JDIAction("Get '{name}' border-radius")
    public int borderRadius() {
        return Integer.parseInt(core().css("border-radius").replace("px", "")); }

    @JDIAction("Get if{name} is rounded")
    public boolean isRounded() {
        return core().attr("class").matches(".*rounded[^-0]*[-\\\\w]*.*");
    }
}
