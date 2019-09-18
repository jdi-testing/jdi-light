package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.html.elements.complex.Checklist;

public class CheckList extends Checklist {
    @Override
    public boolean selected(UIElement value) {
        return value.hasClass("active")
            && value.attr("ui").equals("label");
    }
}
