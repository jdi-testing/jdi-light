package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.vuetify.asserts.VuetifyListAssert;
import com.epam.jdi.light.vuetify.elements.common.Divider;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.epam.jdi.light.vuetify.elements.common.Subheader;
import com.epam.jdi.light.vuetify.interfaces.HasElevation;
import com.epam.jdi.light.vuetify.interfaces.HasRounded;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;
import com.epam.jdi.light.vuetify.interfaces.IsDense;
import com.epam.jdi.light.vuetify.interfaces.IsFlat;
import com.epam.jdi.light.vuetify.interfaces.IsShaped;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents list Vuetify component on GUI. It is used to display information.
 * It can contain an avatar, content, actions, subheaders and much more.
 *
 * @see <a href="https://v2.vuetifyjs.com/en/components/lists">List Vuetify documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/vuetify">Vuetify test page</a>
 */
public class VuetifyList extends UIBaseElement<VuetifyListAssert> implements ICoreElement, HasTheme, HasElevation,
        IsDense, IsFlat, HasRounded, IsShaped {
    /*
     * @todo #5298 Check that it is comfortable to work with list with multiple list-groups
     */
    private final String groupLocator = ".v-list-group";
    private final String itemLocator = ".v-list-item";


    @Override
    public VuetifyListAssert is() {
        return new VuetifyListAssert().set(this);
    }
    /**
     * Gets specific item of this list using its index.
     *
     * @param index item index in the list of items
     * @return item as {@link ListItem}
     */
    @JDIAction("Get '{name}' item with index '{0}'")
    public ListItem item(int index) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(index));
    }

    /**
     * Gets specific item of this list using its title (full equality is used by searching).
     *
     * @param title full text content of item to be found
     * @return item as {@link ListItem}
     */
    @JDIAction("Get '{name}' item with title '{0}'")
    public ListItem item(String title) {
        return new ListItem().setCore(ListItem.class, itemsWebList().get(title));
    }

    /**
     * Gets list of items. Each element of the list is a {@link UIElement}.
     *
     * @return items as {@link WebList}
     */
    protected WebList itemsWebList() {
        return core().finds(itemLocator);
    }

    /**
     * Gets the subheader of the list using the subheader index.
     *
     * @param index subheader index in the list of subheaders
     * @return subheader as {@link Subheader}
     */
    @JDIAction("Get '{name}' subheader with index '{0}'")
    public Subheader subheader(int index) {
        return new Subheader().setCore(Subheader.class, core().finds(".v-subheader").get(index));
    }

    /**
     * Gets the dividers of the list using the divider index.
     *
     * @return dividers list as {@link WebList}
     */
    @JDIAction("Get '{name}' dividers")
    public WebList dividers() {
        return core().finds(".v-divider");
    }
    /**
     * Gets the divider of the list using the divider index.
     *
     * @param index divider index in the list of dividers
     * @return divider as {@link Divider}
     */
    @JDIAction("Get '{name}' divider with index '{0}'")
    public Divider divider(int index) {
        return new Divider().setCore(Divider.class, dividers().get(index));
    }

    /**
     * Gets list of items. Each element of the list is a {@link ListItem}.
     *
     * @return items as {@link List}
     */
    @JDIAction("Get '{name}' items")
    public List<ListItem> items() {
        return itemsWebList().stream()
            .map(webElement -> new ListItem().setCore(ListItem.class, webElement))
            .collect(Collectors.toList());
    }

    /**
     * Gets size of this list (e.g. amount of its items).
     *
     * @return size of this list as {@code int}
     */
    @JDIAction("Get '{name}' size")
    public int size() {
        return itemsWebList().size();
    }

    @JDIAction("Get '{name}' groups")
    public List<VuetifyListGroup> groups() {
        return core().finds(groupLocator).stream()
                .map(e -> new VuetifyListGroup().setCore(VuetifyListGroup.class, e))
                .collect(Collectors.toList());
    }
    @JDIAction("Get '{name}' group with '{0}' title ")
    public VuetifyListGroup group(String title) {
        return core().finds(groupLocator).stream()
                .map(e -> new VuetifyListGroup().setCore(VuetifyListGroup.class, e))
                .filter(e -> e.header().title().getText().equals(title)).findFirst().orElse(null);
    }

    @JDIAction("Get '{name}' group with '{0}' index ")
    public VuetifyListGroup group(int index) {
        return new VuetifyListGroup().
                setCore(VuetifyListGroup.class, core().finds(groupLocator).get(index));
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass("v-list--disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !this.isDisabled();
    }

    @Override
    @JDIAction("Get if '{name}' is rounded")
    public boolean isRounded() {
        return core().hasClass("v-list--rounded");
    }
}
