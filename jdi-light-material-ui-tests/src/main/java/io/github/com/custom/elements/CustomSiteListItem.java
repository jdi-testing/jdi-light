package io.github.com.custom.elements;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.CanBeSelected;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Represents custom element of MUIList
 *
 * @see com.epam.jdi.light.material.interfaces.displaydata.IMUIList
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */

public class CustomSiteListItem extends UIBaseElement<CustomSiteListItem.CustomSiteListItemAssert> implements CanBeDisabled, CanBeSelected {

    private static final String SECONDARY_ACTION = ".MuiListItemSecondaryAction-root";
    private static final String AVATAR = ".MuiListItemAvatar-root";
    private static final String TEXT = ".MuiListItemText-root";
    private static final String ICON = ".MuiListItemIcon-root";
    private static final String CHECKBOX = ".MuiCheckbox-root";

    /**
     * Constructor is used to work with {@code item.with(Class<A>)}
     *
     * @param el item to cast
     */
    public CustomSiteListItem(UIElement el) {
        setCore(CustomSiteListItem.class, el.base());
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

    @JDIAction(value = "Get '{name}' checkbox element")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, core().find(CHECKBOX));
    }

    @JDIAction(value = "Get '{name}' checkbox element")
    public Switch switcher() {
        return new Switch().setCore(Switch.class, this.secondaryAction().find(".MuiSwitch-root"));
    }

    @Override
    public CustomSiteListItemAssert is() {
        return new CustomSiteListItemAssert().set(this);
    }

    @Override
    public CustomSiteListItemAssert has() {
        return is();
    }

    /**
     * Assertions for {@link CustomSiteListItem}.
     */
    public static class CustomSiteListItemAssert extends UIAssert<CustomSiteListItemAssert, CustomSiteListItem> {

        /**
         * Checks that item is selected.
         */
        public CustomSiteListItemAssert selected() {
            jdiAssert(element().isSelected(), Matchers.is(true));
            return this;
        }

        /**
         * Checks that item is not selected.
         */
        public CustomSiteListItemAssert notSelected() {
            jdiAssert(element().isNotSelected(), Matchers.is(true));
            return this;
        }
    }

}
