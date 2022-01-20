package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.ListItemAssert;

import static com.epam.jdi.light.common.Exceptions.exception;

public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick {

    @JDIAction("Get '{name}'s title")
    public Text title() {
        return new Text().setCore(Text.class, find(".v-list-item__title"));
    }

    @Override
    @JDIAction("Get '{name}'s text")
    public String text() {
        return title().getText();
    }

    @JDIAction("Get '{name}'s subtitle")
    public Text subTitle() {
        return new Text().setCore(Text.class, find(".v-list-item__subtitle"));
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find("i"));
    }

    @JDIAction("Get '{name}'s checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(".v-input--checkbox"));
    }

    @JDIAction("Get '{name}'s avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(".v-avatar"));
    }

    @JDIAction("Is '{name}' active")
    public boolean isActive() {
        return attr("class").contains("active");
    }

    @JDIAction("Does '{name}' have border")
    public boolean hasBorder() {
        if(isActive()) {
            return attr("class").contains("border");
        } else {
            throw exception("Element must be activated");
        }
    }

    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
