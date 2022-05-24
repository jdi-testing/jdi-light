package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents List MUI component on GUI.
 * <p>Lists are a continuous group of text or images.
 * They are composed of items containing primary and supplemental actions,
 * which are represented by icons and text.</p>
 *
 * @see <a href="https://v4.mui.com/components/lists/">List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_list">MUI test page</a>
 */
public interface IMUIList<A extends UIElement> extends ICoreElement {

    String subHeader = ".MuiListSubheader-root";

    List<A> items();

    /**
     * Get list item by index
     *
     * @param index item's index to get
     * @return item as {@link A}
     */
    @JDIAction(value = "Get '{name}' by index '{0}'")
    default A item(int index) {
        return items().get(index);
    };

    /**
     * Get list item by label
     *
     * @param item label to get
     * @return item as {@link A}
     */
    @JDIAction(value = "Get '{name}' by label '{0}'")
    default A item(String item) {
        return items().stream().filter(el -> el.text().equalsIgnoreCase(item))
                .findAny().orElse(null);
    };

    /**
     * Checks whether list is empty or not
     *
     * @return {@code true} if List contains no items
     */
    @JDIAction(value = "Check if '{name}' is empty")
    default boolean isEmpty() {
        return items().isEmpty();
    };

    /**
     * Get list size
     *
     * @return number of items as {@code int}
     */
    @JDIAction(value = "Get '{name}' size")
    default int size() {
        return items().size();
    }

    /**
     * Get list items as a list of custom objects
     * {@code Class<T>} should contain a constructor with {@link UIElement} as a parameter
     *
     * @param clazz {@code Class<T>} for returning object
     * @return list of items as {@code List<T>}
     */
    default  <T extends UIElement> List<T> items(Class<T> clazz) {
        return items().stream().map(el -> el.with(clazz)).collect(Collectors.toList());
    }

    /**
     * Get list headers
     *
     * @return headers as {@code List<UIElement>}
     */
    default List<UIElement> headers() {
        return  core().finds(subHeader);
    }

    /**
     * Check whether list has headers or not

     * @return {@code true} if list has headers
     */
    default boolean hasHeaders() {
        return !headers().isEmpty();
    };

}
