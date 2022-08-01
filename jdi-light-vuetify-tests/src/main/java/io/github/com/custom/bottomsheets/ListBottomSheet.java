package io.github.com.custom.bottomsheets;

import com.epam.jdi.light.common.*;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;

import java.util.List;

public class ListBottomSheet extends BottomSheet {

    private static final String ICON = "img";
    private static final String OPTION_TITLE = ".v-list-item__title";

    @UI("//div[@role = 'listitem']")
    protected List<UIElement> openInOptionsList;

    public List<UIElement> openInOptionsList() {
        return openInOptionsList;
    }

    @JDIAction("Select option by click on icon")
    public void clickOption(int position) {
        openInOptionsList.get(position).find(ICON).click();
    }

    @JDIAction("Get option title in options list")
    public void getOptionTitle(int position, String optionName) {
        openInOptionsList.get(position).find(OPTION_TITLE).has().text(optionName);
    }
}
