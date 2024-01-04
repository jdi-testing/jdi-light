package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.MenuAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit https://vuetifyjs.com/en/components/menus/
 */

public class Menu extends UIBaseElement<MenuAssert> implements HasClick, HasTheme {

    public static final String V_LIST_ITEM_TITLE_LOCATOR = ".v-list-item__title";
    public static final String V_LIST_ITEM_LOCATOR = ".v-list-item";

    @JDIAction("'{name}' has position from top")
    public int topPosition() {
        return Integer.parseInt(core().getCssValue("top").replace("px", ""));
    }

    @JDIAction("'{name}' has position from left")
    public int leftPosition() {
        return Integer.parseInt(core().getCssValue("left").replace("px", ""));
    }

    @JDIAction("'{name}' has number of options")
    public int countOfOptions() {
        return core().finds(".v-list-item").size();
    }

    @JDIAction("'{name}' has titles of options")
    public List<String> optionsTitles() {
        return core().finds(V_LIST_ITEM_TITLE_LOCATOR).stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }
    @JDIAction("Get '{name}'s list items")
    public List<ListItem> items() {
        return core().finds(V_LIST_ITEM_LOCATOR).stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Select option with title {0}")
    public void selectOptionByTitle(String value) {
        core().finds(V_LIST_ITEM_TITLE_LOCATOR).stream()
                .filter(e -> e.getText().equalsIgnoreCase(value))
                .findFirst().get().click();
    }

    @JDIAction("'{name}' has removed radius")
    public boolean hasRemovedRadius() {
        return core().getAttribute("class").contains("rounded-0");
    }

    @JDIAction("'{name}' has large radius")
    public boolean hasLargeRadius() {
        return core().getAttribute("class").contains("rounded-lg");
    }

    public MenuAssert is() {
        return new MenuAssert().set(this);
    }

    public MenuAssert has() {
        return is();
    }

    public void close() {
        press(Keys.ESCAPE);
    }
}
