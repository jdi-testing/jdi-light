package io.github.com.custom.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;

public class OrderLine extends Section {

    public UIElement message() {
        return find(".col-7");
    }

    public UIElement time() {
        return find(".text-right");
    }
}
