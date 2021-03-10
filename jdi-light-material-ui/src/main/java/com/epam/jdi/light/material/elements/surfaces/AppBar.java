package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.AppBarAssert;
import org.openqa.selenium.By;

public class AppBar extends UIBaseElement<AppBarAssert> {

    private UIElement isElementEnabled(){
        return core().find(".MuiButtonBase-root");
    }

    @JDIAction("Is '{name}' button enabled")
    public boolean isButtonMenuEnabled() {
        return isElementEnabled().isExist();
    }

    @JDIAction("Is '{name}' login enabled")
    public boolean isLoginEnabled() {
        return isElementEnabled().isExist();
    }

    @JDIAction("Click on '{name}' menu")
    public void appBarMenuClick() {
        core().find(".MuiIconButton-colorInherit.MuiIconButton-edgeStart").click();
    }

    @JDIAction("Click on '{name}' login")
    public void loginClick() {
        core().find(By.className("MuiButton-label")).click();
    }

    @Override
    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }
}
