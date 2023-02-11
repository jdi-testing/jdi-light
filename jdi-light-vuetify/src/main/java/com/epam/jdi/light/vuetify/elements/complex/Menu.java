package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.MenuAssert;
import com.epam.jdi.light.vuetify.elements.common.ListItem;

import java.util.List;
import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit https://vuetifyjs.com/en/components/menus/
 */

public class Menu extends UIBaseElement<MenuAssert> implements HasClick {

    @JDIAction("'{name}' has position")
    public String hasPosition() {
        return String.format("top: %s; left: %s", core().getCssValue("top"), core().getCssValue("left"));
    }

    @JDIAction("'{name}' has position from top")
    public int topPosition() {
        return Integer.parseInt(core().getCssValue("top").replace("px",""));
    }

    @JDIAction("'{name}' has position from left")
    public int leftPosition() {
        return Integer.parseInt(core().getCssValue("left").replace("px",""));
    }

    @JDIAction("'{name}' has number of options")
    public int hasNumberOfOptions() {
        return finds(".v-list-item").size();
    }

    @JDIAction("'{name}' has titles of options")
    public List<String> hasOptionsTitles() {
        return finds(".v-list-item__title").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
    }
    @JDIAction("Get '{name}'s list items")
    public List<ListItem> items() {
        return finds(".v-list-item").stream()
                .map(element -> new ListItem().setCore(ListItem.class, element))
                .collect(Collectors.toList());
    }

    @JDIAction("Get '{name}'s list items text")
    public List<String> getOptionsList() {
        return items().stream().map(IsText::getText).map(s->s.replaceAll("\n"," ")).collect(Collectors.toList());
    }

    @JDIAction("'{name}' has removed radius")
    public boolean hasRemovedRadius() {
        return core().getAttribute("class").contains("rounded-0");
    }

    @JDIAction("'{name}' has large radius")
    public boolean hasLargeRadius() {
        return core().getAttribute("class").contains("rounded-lg");
    }

    @JDIAction("'{name}' has custom radius")
    public boolean hasCustomRadius() {
        return core().getAttribute("class").contains("rounded-b-xl");
    }

    public MenuAssert is() {
        return new MenuAssert().set(this);
    }

    public MenuAssert has() {
        return is();
    }
}
