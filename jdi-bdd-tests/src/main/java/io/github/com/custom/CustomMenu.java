package io.github.com.custom;

import com.epam.jdi.light.elements.complex.WebList;

public class CustomMenu extends WebList {
    @Override
    public WebList list() {
        return super.list().setUIElementName(ui -> ui.findFirst("span").getText());
    }
}
