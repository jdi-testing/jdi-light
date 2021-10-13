package com.epam.jdi.light.vuetify.elements.complex;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of Lists web element please visit
 * https://vuetifyjs.com/en/components/list-item-groups/
 */


public class ListItemGroups extends UIListBase<UISelectAssert<?, ?>> {

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String value) {
        list().select(value);
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        list().select(index);
    }

    @JDIAction(level = DEBUG)
    public UIElement get(String value) {
        return list().get(value);
    }

    @JDIAction(level = DEBUG)
    public UIElement get(int index) {
        return list().get(index);
    }

    @JDIAction("'{name}' is active")
    public boolean isActive(int elementIndex) {
        return list().get(elementIndex).attr("aria-selected").equalsIgnoreCase("true")
                || list().get(elementIndex).hasAttribute("--active");
    }

    @JDIAction("'{name}' is inactive")
    public boolean isInactivate(int elementIndex) {
        return !isActive(elementIndex);
    }

    @JDIAction("'{name}' has icon")
    public boolean hasIcon(int elementIndex) {
        UIElement icon = list().get(elementIndex).find(".v-icon");
        if (icon.isExist()) {
            return icon.attr("aria-hidden").equalsIgnoreCase("true");
        }
        return false;
    }

    @JDIAction("{name} has title")
    public boolean hasTitle(int elementIndex, String expectedTitle) {
        UIElement title = list().get(elementIndex).find(".v-list-item__title");
        if (title.isExist() || list().get(elementIndex).attr("aria-selected").equalsIgnoreCase("true")) {
            return title.getText().equals(expectedTitle);
        }
        return false;
    }
}


