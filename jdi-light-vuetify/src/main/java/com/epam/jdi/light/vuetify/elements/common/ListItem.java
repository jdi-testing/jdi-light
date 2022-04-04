package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.ListItemAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;

public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick, HasIcon {

    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, find(".v-list-item__title"));
    }

    @Override
    @JDIAction("Get '{name}' text")
    public String text() {
        return title().getText();
    }

    @JDIAction("Get '{name}' subtitle")
    public Text subtitle() {
        return new Text().setCore(Text.class, find(".v-list-item__subtitle"));
    }

    @JDIAction("Get '{name}' checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(".v-input--checkbox"));
    }

    @JDIAction("Get '{name}' avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(".v-avatar"));
    }

    @JDIAction("Get '{name}' action text")
    public Text actionText() {
        return new Text().setCore(Text.class, find(".v-list-item__action-text"));
    }

    @JDIAction("Check that '{name}' is active")
    public boolean isActive() {
        return attr("class").contains("active");
    }

    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return attr("aria-expanded").equalsIgnoreCase("true");
    }

    @Override
    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
