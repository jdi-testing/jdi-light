package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.surfaces.AppBarAssert;
import org.openqa.selenium.By;

public class AppBar extends UIBaseElement<AppBarAssert> {

    @JDIAction("Is '{name}' button enabled")
    public boolean isButtonMenuEnabled() {
        return core().hasClass("MuiIconButton");
    }

    @JDIAction("Is '{name}' login enabled")
    public boolean isLoginEnabled() {
        return core().hasClass("MuiButton-label");
    }

    @JDIAction("Click on '{name}' menu")
    public void appBarMenuClick() {
        core().find(By.className("MuiIconButton")).click();
    }

    @JDIAction("Click on '{name}' login")
    public void loginClick() {
        core().find(By.className("MuiButton-label")).click();
    }
}
