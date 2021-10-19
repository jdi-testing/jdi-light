package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.vuetify.asserts.MenuAssert;

import java.util.List;
import java.util.stream.Collectors;

public class Menu extends UIBaseElement<MenuAssert> implements HasClick {

    @JDIAction("'{name}' has position")
    public String hasPosition() {
        return String.format("top: %s; left: %s", this.core().getCssValue("top"), this.core().getCssValue("left"));
    }

    @JDIAction("'{name}' has number of options")
    public int hasNumberOfOptions() {
        return this.finds(".v-list-item").size();
    }

    @JDIAction("'{name}' has titles of options")
    public List<String> hasOptionsTitles() {
        return this.finds(".v-list-item__title").stream()
                .map(UIElement::getText)
                .collect(Collectors.toList());
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
        return this.is();
    }
}
