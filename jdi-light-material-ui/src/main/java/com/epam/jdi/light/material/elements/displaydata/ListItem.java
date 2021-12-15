package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.ListItemAssert;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick, CanBeSelected {

    @JDIAction("Get '{name}'s primary text")
    public Text getPrimaryText() {
        return new Text().setCore(Text.class, find(".MuiListItemText-primary"));
    }

    @JDIAction("Get '{name}'s secondary text")
    public Text getSecondaryText() {
        return new Text().setCore(Text.class, find(".MuiListItemText-secondary"));
    }

    @Override
    @JDIAction("Get '{name}'s text")
    public String getText() {
        return getPrimaryText().getText();
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(".MuiListItemIcon-root > .MuiSvgIcon-root"));
    }

    @JDIAction("Get '{name}'s avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(".MuiAvatar-root"));
    }

    @JDIAction("Get '{name}'s button")
    public Button button() {
        return new Button().setCore(Button.class, find("button"));
    }

    @JDIAction("Get '{name}'s checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(".MuiCheckbox-root"));
    }

    @JDIAction("Get '{name}'s switch")
    public Switch getSwitch() {
        return new Switch().setCore(Switch.class, find(".MuiSwitch-root"));
    }

    @Override
    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
