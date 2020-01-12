package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class MenuItem extends UIElement {
    @Override
    public boolean isSelected() {
        return $("<<").hasClass("active");
    }
}
