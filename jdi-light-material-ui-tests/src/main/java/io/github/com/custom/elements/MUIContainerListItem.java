package io.github.com.custom.elements;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.elements.displaydata.Avatar;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.CanBeSelected;
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

public class MUIContainerListItem extends UIBaseElement<MUIContainerListItem.MUIContainerListItemAssert> implements HasClick, CanBeDisabled, CanBeSelected {

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
    public MUIContainerListItem(UIElement el) {
        setCore(MUIContainerListItem.class, el.base());
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

    @Override
    public MUIContainerListItemAssert is() {
        return new MUIContainerListItemAssert().set(this);
    }

    @Override
    public MUIContainerListItemAssert has() {
        return is();
    }

    /**
     * Assertions for {@link MUIContainerListItem}.
     */
    public static class MUIContainerListItemAssert extends UIAssert<MUIContainerListItemAssert, MUIContainerListItem> {

        /**
         * Checks that item is selected.
         */
        public MUIContainerListItemAssert selected() {
            jdiAssert(element().isSelected(), Matchers.is(true));
            return this;
        }

        /**
         * Checks that item is not selected.
         */
        public MUIContainerListItemAssert notSelected() {
            jdiAssert(element().isNotSelected(), Matchers.is(true));
            return this;
        }
    }

}
