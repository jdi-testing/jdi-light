package com.epam.jdi.light.material.elements.navigation;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.navigation.MenuAssert;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.stream.Collectors;

/**
 * To see an example of Menu web element please visit
 * https://mui.com/components/menus/
 */

public class Menu extends UIListBase<MenuAssert> {

    public Button button;

    public Text selectedText;

    public List list = new List(core().find(".MuiMenu-list"));

    public Menu(String button, String selectedArea) {
        this.button = new Button().setCore(Button.class, core().find(button));
        this.selectedText = new Text().setCore(Text.class, core().find(selectedArea));
    }

    @JDIAction("Get list of '{name}' items")
    public java.util.List<String> itemsTexts() {
        return list().stream().map(UIElement::getText).collect(Collectors.toList());
    }

    @Override
    public MenuAssert is() {
        return new MenuAssert().set(this);
    }
}
