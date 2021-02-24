package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.func.JFunc1;

import static com.epam.jdi.light.elements.base.JDIBase.NAMES;

public interface Condition extends JFunc1<ICoreElement, Boolean> {
    default Condition setName(String name) {
        NAMES.update(hashCode(), name);
        return this;
    }
    default String getName() {
        Integer hash = hashCode();
        return NAMES.has(hash) ? NAMES.get(hash) : "";
    }
    @Override
    default Boolean execute(ICoreElement element) {
        return executes(getName().replace(" %not%", "")
            .replace(" %no%", "")
            .replace("%element%", "'"+element.getName()+"'"), element);
    }
    @JDIAction("Assert that {0}")
    default Boolean executes(String text, ICoreElement element) {
        try {
            return invoke(element);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
