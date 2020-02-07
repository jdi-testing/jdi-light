package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.mobile.elements.common.UIElement;
import com.epam.jdi.mobile.elements.complex.Checklist;

public class MyCheckList extends Checklist {
    @Override
    public boolean selected(UIElement value) {
        return value.hasClass("active")
            && value.attr("ui").equals("label");
    }
}
