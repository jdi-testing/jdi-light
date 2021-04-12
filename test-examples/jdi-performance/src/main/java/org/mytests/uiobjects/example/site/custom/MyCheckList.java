package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.elements.complex.Checklist;

public class MyCheckList extends Checklist {
    @Override
    public boolean selected(com.epam.jdi.light.elements.common.uiElement value) {
        return value.hasClass("active")
            && value.attr("ui").equals("label");
    }
}
