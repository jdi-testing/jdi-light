package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.MUIListItemAssert;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents Material UI list item.
 *
 * <p>List items are essential parts of the list.
 * Each list item has a 'primary area' which may contain an icon/avatar/checkbox,
 * primary and secondary text. It can also support a primary action
 * invoked by clicking on this area, like selecting the item.</p>
 *
 * <p>List item also might have a 'secondary area' containing a switch
 * or button used to invoke a distinct secondary action.</p>
 *
 * @see MUIList
 */
// TODO: ListItem can contain a lot of another elements, and this should be described by user
public class MUIListItem extends UIBaseElement<MUIListItemAssert> implements IsText, HasClick, CanBeDisabled {
    private static final String SELECTED_CLASS = "Mui-selected";
    private static final String SECONDARY_BUTTON_LOCATOR = ".MuiListItemSecondaryAction-root button";
    private static final String SECONDARY_SWITCH_LOCATOR = ".MuiListItemSecondaryAction-root .MuiSwitch-root";
    private static final String PRIMARY_TEXT_LOCATOR = ".MuiListItemText-primary";
    private static final String SECONDARY_TEXT_LOCATOR = ".MuiListItemText-secondary";
    private static final String PRIMARY_CHECKBOX_LOCATOR = ".MuiCheckbox-root";
    private static final String AVATAR_LOCATOR = ".MuiAvatar-root";
    private static final String ICON_LOCATOR = ".MuiListItemIcon-root > .MuiSvgIcon-root";
    private static final String TEXT_LOCATOR = ".MuiTypography-root";

    @Override
    @JDIAction("Get '{name}'s text")
    public String getText() {
        if (finds(TEXT_LOCATOR).size() > 0) {
            return find(TEXT_LOCATOR).getText(); // normally this will get the primary text
        } else {
            return core().text(); // fallback for less complex list items
        }
    }

    /**
     * Gets the primary text of this list item. Works when the primary text sub-element is marked with a proper
     * Material UI class, which is not always the case.
     *
     * @return primary text ot this list item as {@link Text}
     */
    @JDIAction("Get '{name}'s primary text")
    public Text getPrimaryText() {
        return new Text().setCore(Text.class, find(PRIMARY_TEXT_LOCATOR));
    }

    /**
     * Gets the secondary text of this list item.
     *
     * @return primary text ot this list item as {@link Text}
     */
    @JDIAction("Get '{name}'s secondary text")
    public Text getSecondaryText() {
        return new Text().setCore(Text.class, find(SECONDARY_TEXT_LOCATOR));
    }

    /**
     * Gets the icon of this list item.
     *
     * @return icon of this list item as {@link Icon}
     */
    @JDIAction("Get '{name}'s icon")
    public Icon icon() {
        return new Icon().setCore(Icon.class, find(ICON_LOCATOR));
    }

    /**
     * Gets the avatar of this list item.
     *
     * @return icon of this list item as {@link Avatar}
     */
    @JDIAction("Get '{name}'s avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, find(AVATAR_LOCATOR));
    }

    /**
     * Gets the checkbox of this list item.
     *
     * @return icon of this list item as {@link Checkbox}
     */
    @JDIAction("Get '{name}'s checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, find(PRIMARY_CHECKBOX_LOCATOR));
    }

    /**
     * Checks that this list item is selected or not. Relevant for selectable lists.
     *
     * @return {@code true} if this list item is selected, otherwise {@code false}
     */
    @JDIAction("Check if '{name}' is selected")
    public boolean isSelected() {
        return core().hasClass(SELECTED_CLASS);
    }

    /**
     * Gets the button of this list item.
     *
     * @return icon of this list item as {@link Button}
     */
    @JDIAction("Get '{name}'s secondary action button")
    public Button button() {
        return new Button().setCore(Button.class, find(SECONDARY_BUTTON_LOCATOR));
    }

    /**
     * Gets the switch of this list item.
     *
     * @return icon of this list item as {@link Switch}
     */
    @JDIAction("Get '{name}'s switch")
    public Switch getSwitch() {
        return new Switch().setCore(Switch.class, find(SECONDARY_SWITCH_LOCATOR));
    }

    @Override
    public MUIListItemAssert is() {
        return new MUIListItemAssert().set(this);
    }
}
