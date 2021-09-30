package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;

import java.util.List;

public class ListBottomSheet extends BottomSheet {

    @UI("//div[@role = 'listitem']")
    protected List<UIElement> openInOptionsList;

    public List<UIElement> openInOptionsList() {
        return openInOptionsList;
    }
}
