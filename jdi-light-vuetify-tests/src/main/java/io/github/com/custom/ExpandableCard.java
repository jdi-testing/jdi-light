package io.github.com.custom;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.Card;
import io.github.com.custom.asserts.ExpandableCardAssert;

public class ExpandableCard extends Card {
    private UIElement expander() {
        return this.find("[class*='selection']");
    }

    @JDIAction("Get if '{name}' expanded")
    public boolean isExpanded() {
        if (expander().isExist()) {
            return this.find("input[role=switch]")
                    .attr("aria-checked")
                    .equalsIgnoreCase("true");
        } else {
            return false;
        }
    }

    @JDIAction("Get if '{name}' column empty")
    public boolean isItemsEmpty() {
        return items().isEmpty();
    }

    @JDIAction("Get '{name}' column")
    public WebList items() {
        return this.finds("[role = 'listitem']");
    }

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (!isExpanded() && expander().isExist()) {
            expander().click();
        }
    }

    @JDIAction("Collapse '{name}'")
    public void collapse() {
        if (isExpanded() && expander().isExist()) {
            expander().click();
        }
    }
    public ExpandableCardAssert is() {
        return new ExpandableCardAssert().set(this);
    }

    public ExpandableCardAssert has() {
        return this.is();
    }

}
