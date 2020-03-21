package io.github.com.custom;

import com.epam.jdi.light.elements.complex.*;

public class CustomMenu extends Menu {
    @Override
    public WebList list() {
        return super.list().setUIElementName(ui -> ui.findFirst("span").getText());
    }
}
