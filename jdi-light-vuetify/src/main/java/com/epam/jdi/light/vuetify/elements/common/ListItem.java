package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.ListItemAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;

/**
 * Represents list item Vuetify component on GUI.
 *
 * @see <a href="https://vuetifyjs.com/en/api/v-list-item">List item Vuetify documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify">Vuetify test page</a>
 */
public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick, HasIcon {

    /**
     * Gets the title of the list item.
     *
     * @return title as {@link Text}
     */
    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(".v-list-item__title"));
    }

    /**
     * Gets the title text of the list item.
     *
     * @return text as {@link String}
     */
    @Override
    @JDIAction("Get '{name}' text")
    public String text() {
        return title().getText();
    }

    /**
     * Gets the subtitle of the list item.
     *
     * @return subtitle as {@link Text}
     */
    @JDIAction("Get '{name}' subtitle")
    public Text subtitle() {
        return new Text().setCore(Text.class, core().find(".v-list-item__subtitle"));
    }

    /**
     * Gets the checkbox of the list item.
     *
     * @return checkbox as {@link Checkbox}
     */
    @JDIAction("Get '{name}' checkbox")
    public Checkbox checkbox() {
        return new Checkbox().setCore(Checkbox.class, core().find(".v-input--checkbox"));
    }

    /**
     * Gets the avatar of the list item.
     *
     * @return avatar as {@link Avatar}
     */
    @JDIAction("Get '{name}' avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(".v-avatar"));
    }

    /**
     * Gets the action text of the list item.
     *
     * @return actionText as {@link Text}
     */
    @JDIAction("Get '{name}' action text")
    public Text actionText() {
        return new Text().setCore(Text.class, core().find(".v-list-item__action-text"));
    }

    /**
     * Checks if the list item is active or not.
     *
     * @return {@code true} if the item is active, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is active")
    public boolean isActive() {
        return core().attr("class").contains("active");
    }

    /**
     * Checks if the list item is expanded or not.
     *
     * @return {@code true} if the item is expanded, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @Override
    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
