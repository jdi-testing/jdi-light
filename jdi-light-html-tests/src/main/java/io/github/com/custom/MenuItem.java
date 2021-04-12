package io.github.com.custom;

import com.epam.jdi.light.elements.common.uiElement;

public class MenuItem extends uiElement {
    @Override
    public boolean isSelected() {
        return find("<<").hasClass("active");
    }
}
