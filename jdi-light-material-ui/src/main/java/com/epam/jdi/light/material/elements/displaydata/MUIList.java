package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.displaydata.MUIListAssert;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static java.lang.String.format;

/**
 * Represents list MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class MUIList extends UIBaseElement<MUIListAssert> {

    /**
     * Locator for complex list item which can contain some other interactable elements like buttons, checkboxes etc.
     */
    protected static final String LIST_ITEM_CONTAINER_LOCATOR = ".MuiListItem-container";

    /**
     * Locator for standard list item without other interactable elements like buttons, checkboxes etc.
     */
    protected static final String LIST_ITEM_LOCATOR = ".MuiListItem-root";

    /**
     * Locator for subheaders.
     */
    protected static final String SUBHEADER_LOCATOR = ".MuiListSubheader-root";

    /**
     * Gets items of this list.
     *
     * @return items of this list as {@link List}
     */
    @JDIAction("Get list of '{name}' items")
    public List<MUIListItem> items() {
        Function<String, List<MUIListItem>> function = locator -> finds(locator).stream()
                .map(listItem -> new MUIListItem().setCore(MUIListItem.class, listItem))
                .collect(Collectors.toList());
        if (!finds(LIST_ITEM_CONTAINER_LOCATOR).isEmpty()) {
            return function.apply(LIST_ITEM_CONTAINER_LOCATOR);
        } else {
            return function.apply(LIST_ITEM_LOCATOR);
        }
    }

    /**
     * Gets specific item of this list using its text (full equality is used by searching).
     *
     * @param itemText full text content of item to be found
     * @return item of this list as {@link MUIListItem}
     * @throws RuntimeException if no items found
     */
    @JDIAction("Get the first item in '{name}' with text '{0}'")
    public MUIListItem item(String itemText) {
        for (MUIListItem item : items()) {
            if (item.getText().equals(itemText)) {
                return item;
            }
        }
        throw runtimeException(format("The list has no item with text '%s'", itemText));
    }

    /**
     * Gets nested lists of this list if any. Targets only first layer of depth. If there are no nested lists, an
     * empty list is returned.
     *
     * @return nested lists of this list as {@link List}
     */
    @JDIAction("Get list of Material UI lists nested directly within '{name}'")
    public List<MUIList> nestedLists() {
        return finds(".//ul[not(parent::ul)]").stream() // targets only the first layer of nested lists
                .map(nestedList -> new MUIList().setCore(MUIList.class, nestedList))
                .collect(Collectors.toList());
    }

    /**
     * Gets size of this list (e.g. amount of its items).
     *
     * @return size of this list as {@code int}
     */
    @JDIAction("Get size of '{name}'")
    public int size() {
        return items().size();
    }

    /**
     * Checks if this list is empty or not (e.g. has items or not).
     *
     * @return {@code true} if this list is empty, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is empty")
    public boolean isEmpty() {
        return items().isEmpty();
    }

    /**
     * Gets subheaders of this list if any. If there are no subheaders lists, an empty list is returned.
     *
     * @return subheaders of this list as {@link List}
     */
    @JDIAction("Get list of '{name}' subheaders")
    public List<UIElement> subheaders() {
        return finds(SUBHEADER_LOCATOR).stream()
                .map(subheader -> new UIElement().setCore(UIElement.class, subheader)).collect(Collectors.toList());
    }

    @Override
    public MUIListAssert is() {
        return new MUIListAssert().set(this);
    }

}
