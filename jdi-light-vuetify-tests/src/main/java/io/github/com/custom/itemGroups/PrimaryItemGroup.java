package io.github.com.custom.itemGroups;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.elements.complex.ItemGroup;

public class PrimaryItemGroup extends ItemGroup {

    @Override
    @JDIAction("Is item '{0}' selected in {name}")
    public boolean selected(int index) {
        return items().get(index).hasClass("primary");
    }

    @Override
    @JDIAction("Is item '{0}' selected in {name}")
    public WebList selected() {
        return core().finds(".primary");
    }

}
