package com.jdiai.asserts;

import com.jdiai.interfaces.HasCore;
import com.jdiai.interfaces.HasName;
import com.jdiai.tools.map.MapArray;

import java.util.function.Function;

public interface Condition extends Function<HasCore, Boolean>, HasName {
    MapArray<Integer, String> NAMES = new MapArray<>();

    default Condition setName(String name) {
        NAMES.update(hashCode(), name);
        return this;
    }

    default String getName() {
        Integer hash = hashCode();
        return NAMES.has(hash) ? NAMES.get(hash) : "";
    }

    default String getName(HasName element) {
        return getName().replace(" %not%", "")
            .replace(" %no%", "")
            .replace("%element%", "'" + element.getName() + "'");
    }

    default Boolean execute(HasCore element) {
        try {
            return apply(element);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
