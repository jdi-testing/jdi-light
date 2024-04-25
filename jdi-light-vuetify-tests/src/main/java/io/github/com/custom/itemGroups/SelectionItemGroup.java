package io.github.com.custom.itemGroups;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;

public class SelectionItemGroup extends ItemGroup {

    @JDIAction("Get icon of item {0} in {name}")
    public Icon itemIcon(int index) {
        return new Icon().setCore(Icon.class, items().get(index).find(".v-icon"));
    }
}
