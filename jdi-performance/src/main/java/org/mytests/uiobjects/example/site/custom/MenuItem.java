package org.mytests.uiobjects.example.site.custom;


import com.epam.jdi.mobile.elements.common.UIElement;

public class MenuItem extends UIElement {
    @Override
    public boolean isSelected() {
        return hasClass("active") && attr("ui").equals("label");
    }
}
