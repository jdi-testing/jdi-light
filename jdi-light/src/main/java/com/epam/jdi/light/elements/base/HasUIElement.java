package com.epam.jdi.light.elements.base;

import com.epam.jdi.light.elements.common.UIElement;

public interface HasUIElement extends HasUIBase {
    @Override
    UIElement element();
}
