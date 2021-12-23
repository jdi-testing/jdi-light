package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.ListItemAssert;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Material UI List Items are flexible elements collected in a List.
 *
 * List item has a 'primary area' which may contain an icon/avatar/checkbox,
 * primary and secondary text. It can also support a primary action
 * invoked by clicking on this area, like selecting the item.
 *
 * List item also might have a 'secondary area' containing a switch
 * or button used to invoke a distinct secondary action.
 */

public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick {
    protected final String SELECTED_CLASS = "Mui-selected";
    protected final String SECONDARY_BUTTON_LOCATOR = ".MuiListItemSecondaryAction-root button";
    protected final String SECONDARY_SWITCH_LOCATOR = ".MuiListItemSecondaryAction-root .MuiSwitch-root";
    protected final String PRIMARY_TEXT_LOCATOR = ".MuiListItemText-primary";
    protected final String SECONDARY_TEXT_LOCATOR = ".MuiListItemText-secondary";
    protected final String PRIMARY_CHECKBOX_LOCATOR = ".MuiCheckbox-root";
    protected final String AVATAR_LOCATOR = ".MuiAvatar-root";
    protected final String ICON_LOCATOR = ".MuiListItemIcon-root > .MuiSvgIcon-root";
    protected final String TEXT_LOCATOR = ".MuiTypography-root";

    @Override
    @JDIAction("Get '{name}'s text")
    public String getText() {
        if (finds(TEXT_LOCATOR).size() > 0) {
            return find(TEXT_LOCATOR).getText(); // normally this will get the primary text
        } else {
            return core().text(); // fallback for less complex list items
        }
    }

    // Works when the primary text sub-element is marked with a proper Material UI class, which is not always the case.
    @JDIAction("Get '{name}'s primary text")
    public Text getPrimaryText() {
        return new Text().setCore(Text.class, find(PRIMARY_TEXT_LOCATOR));
    }

    @JDIAction("Get '{name}'s secondary text")
    public Text getSecondaryText() {
        return new Text().setCore(Text.class, find(SECONDARY_TEXT_LOCATOR));
    }

    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(ICON_LOCATOR));
    }

    @JDIAction("Get '{name}'s avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(AVATAR_LOCATOR));
    }

    @JDIAction("Get '{name}'s checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(PRIMARY_CHECKBOX_LOCATOR));
    }

    @JDIAction("Check if '{name}' is selected")
    public boolean isSelected() {
        return hasClass(SELECTED_CLASS);
    }

    @JDIAction("Get '{name}'s secondary action button")
    public Button secondaryActionButton() {
        return new Button().setCore(Button.class, find(SECONDARY_BUTTON_LOCATOR));
    }

    @JDIAction("Get '{name}'s switch")
    public Switch secondaryActionSwitch() {
        return new Switch().setCore(Switch.class, find(SECONDARY_SWITCH_LOCATOR));
    }

    @Override
    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
