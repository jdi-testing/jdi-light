package org.mytests.uiobjects.example.site.custom;


import com.epam.jdi.light.elements.common.uiElement;

public class MenuItem extends uiElement {
    @Override
    public boolean isSelected() {
        return hasClass("active") && attr("ui").equals("label");
    }
}
