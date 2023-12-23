package org.mytests.uiobjects.example.site.custom;


import com.epam.jdi.light.elements.common.UIElement;

public class MenuItem extends UIElement {
    @Override
    public boolean isSelected() {
        return core().hasClass("active") && attr("ui").equals("label");
    }
}
