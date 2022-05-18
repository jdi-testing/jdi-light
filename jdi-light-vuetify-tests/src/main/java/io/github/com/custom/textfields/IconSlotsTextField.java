package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class IconSlotsTextField extends IconTextField {

    @JDIAction("Select menu item of '{name}'")
    public void selectMenuItemByText(String itemName) {
        String menuItem = "//button/span[contains(text(),'" + itemName + "')]";
        getAppendOuterIcon().click();
        $(menuItem).click();
    }

}
