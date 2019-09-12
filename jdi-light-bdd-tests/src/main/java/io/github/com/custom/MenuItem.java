package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;

public class MenuItem extends UIElement {
    @Override
    public boolean isSelected() {
        return find("<<").hasClass("active");
    }
}
