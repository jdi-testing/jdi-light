package io.github.com.custom;

import com.epam.jdi.mobile.elements.common.UIElement;

public class MenuItem extends UIElement {
    @Override
    public boolean isSelected() {
        return find("<<").hasClass("active");
    }
}
