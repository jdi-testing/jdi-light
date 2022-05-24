package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.CanBeSelected;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class MUIContainerListItem extends UIElement implements CanBeDisabled, CanBeSelected {

    private final String SECONDARY_ACTION = ".MuiListItemSecondaryAction-root";
    private final String AVATAR = ".MuiListItemAvatar-root";
    private final String TEXT = ".MuiListItemText-root";

    private final String ICON = ".MuiListItemIcon-root";

    public MUIContainerListItem() {

    }

    public MUIContainerListItem(UIElement el) {
        setCore(el.base());
    }

    /**
     * Get item's text part
     *
     * @return text element as {@link Text}
     */
    @JDIAction(value = "Get '{name}' text element")
    public Text asText() {
        return new Text().setCore(Text.class, core().find(TEXT));
    }

    /**
     * Get item's avatar
     *
     * @return avatar element as {@link Avatar}
     */
    @JDIAction(value = "Get '{name}' avatar element")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(AVATAR));
    }

    /**
     * Get item's button
     *
     * @return button element as {@link Button}
     */
    @JDIAction(value = "Get '{name}' text element")
    public UIElement secondaryAction() {
        return core().find(SECONDARY_ACTION);
    }

    /**
     * Get item's icon
     *
     * @return icon element as {@link Icon}
     */
    @JDIAction(value = "Get '{name}' icon element")
    public Icon icon() {
        return new Icon().setCore(Icon.class, core().find(ICON));
    }

}
