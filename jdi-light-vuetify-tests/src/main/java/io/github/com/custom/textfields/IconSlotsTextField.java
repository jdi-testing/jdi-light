package io.github.com.custom.textfields;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class IconSlotsTextField extends IconTextField {

    /** Select item of menu by item name
     * @param itemName name of an item in the menu
     */
    @JDIAction("Select menu item of '{name}'")
    public void selectMenuItemByText(String itemName) {
        String menuItem = "//button/span[contains(text(),'" + itemName + "')]";
        appendOuterIcon().click();
        $(menuItem).click();
    }

}
