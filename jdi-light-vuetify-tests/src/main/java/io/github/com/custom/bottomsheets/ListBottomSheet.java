package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;

public class ListBottomSheet extends BottomSheet {

    private static final String ICON = "//*[text()='%s']/preceding-sibling::div//img";

    @JDIAction("Select option by click on icon")
    public void clickOption(String optionName) {
        find(String.format(ICON, optionName)).click();
    }
}
