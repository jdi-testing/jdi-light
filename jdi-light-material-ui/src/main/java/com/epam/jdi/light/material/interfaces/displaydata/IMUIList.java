package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

import java.util.List;

public interface IMUIList<A extends UIElement> extends ICoreElement {

    List<A> items();

    default A item(int index) {
        return items().get(index);
    };

    default A item(String item) {
        return items().stream().filter(el -> el.text().equalsIgnoreCase(item))
                .findAny().orElse(null);
    };

    default boolean isEmpty() {
        return items().isEmpty();
    };

    default int size() {
        return items().size();
    }

    boolean hasHeader();


}
