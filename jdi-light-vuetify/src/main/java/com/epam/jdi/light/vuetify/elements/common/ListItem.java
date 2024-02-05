package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.asserts.ListItemAssert;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * Represents list item Vuetify component on GUI.
 *
 * @see <a href="https://v2.vuetifyjs.com/en/api/v-list-item">List item Vuetify documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify">Vuetify test page</a>
 */
public class ListItem extends UIBaseElement<ListItemAssert> implements IsText, HasClick, HasIcon, HasTheme {

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
     * Gets the subtitle of the list item.
     *
     * @return subtitle as {@link Text}
     */
    @JDIAction("Get '{name}' subtitle")
    public Text subtitle() {
        return new Text().setCore(Text.class, core().find(".v-list-item__subtitle"));
    }

    /**
     * Gets the avatar of the list item.
     *
     * @return avatar as {@link Avatar}
     */
    @JDIAction("Get '{name}' avatar")
    public Avatar avatar() {
        return new Avatar().setCore(Avatar.class, core().find(".v-list-item-avatar"));
    }

    /**
     * Gets the content of the list item.
     *
     * @return avatar as {@link com.epam.jdi.light.elements.common.UIElement}
     */
    @JDIAction("Get '{name}' content")
    public UIElement content() {
        return core().find(".v-list-item__content");
    }

    /**
     * Gets the content of the list item.
     * @param <T> class to cast, should extends UIElement
     * @param clazz class to cast the content
     *
     * @return avatar as {@link com.epam.jdi.light.elements.common.UIElement}
     */
    @JDIAction("Get '{name}' content")
    public <T extends UIElement> T content(Class<T> clazz) {
        return this.content().with(clazz);
    }


    /**
     * Gets the item's action.
     *
     * @return action text as {@link com.epam.jdi.light.elements.common.UIElement}
     */
    @JDIAction("Get '{name}' action text")
    public UIElement action() {
        return core().find(".v-list-item__action");
    }

    /**
     * Gets the text next to action list item.
     *
     * @return action text as {@link Text}
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
    @JDIAction("Get if '{name}' is active")
    public boolean isActive() {
        return core().hasClass("v-list-item--active");
    }

    /**
     * Checks if the list item is expanded or not.
     *
     * @return {@code true} if the item is expanded, otherwise {@code false}
     */
    @JDIAction("Get if '{name}' is expanded")
    public boolean isExpanded() {
        return core().attr("aria-expanded").equalsIgnoreCase("true");
    }

    @JDIAction("Get if '{name}' has border")
    public boolean hasBorder() {
        return core().hasClass("border");
    }

    @Override
    @JDIAction("Get '{name}' theme")
    public String theme() {
        return core().classLike("theme--");
    }

    @JDIAction("Get if {name} is group header")
    public boolean isGroupHeader() {
        return core().hasClass("v-list-group__header");
    }

    @Override
    public String text() {
        if (content().isExist()) {
            return content().getText();
        } else {
            return title().getText();
        }
    }

    @Override
    public ListItemAssert is() {
        return new ListItemAssert().set(this);
    }
}
