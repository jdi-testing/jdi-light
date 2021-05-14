package com.jditest.asserts;

import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.map.MapArray;
import com.jditest.JS;

public interface Condition extends JFunc1<JS, Boolean> {
    MapArray<Integer, String> NAMES = new MapArray<>();

    default Condition setName(String name) {
        NAMES.update(hashCode(), name);
        return this;
    }
    default String getName() {
        Integer hash = hashCode();
        return NAMES.has(hash) ? NAMES.get(hash) : "";
    }
    default String getName(JS element) {
        return getName().replace(" %not%", "")
            .replace(" %no%", "")
            .replace("%element%", "'" + element.getName() + "'");
    }
    @Override
    default Boolean execute(JS element) {
        try {
            return invoke(element);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
