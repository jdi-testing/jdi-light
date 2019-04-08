package org.mytests.uiobjects.example.site.custom;

import com.epam.jdi.light.ui.html.base.HtmlChecklist;
import com.epam.jdi.light.ui.html.base.HtmlElement;

public class Checklist extends HtmlChecklist {
    @Override
    public boolean isSelected(HtmlElement value) {
        return hasClass("active")
            && attr("ui").equals("label");
    }
}
