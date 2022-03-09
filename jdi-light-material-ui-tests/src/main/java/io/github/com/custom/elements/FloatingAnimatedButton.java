package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.elements.navigation.Tabs;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class FloatingAnimatedButton extends Section {

    @JDIAction("Get '{name}'s title")
    public UIElement title() {
        return core().find("//div[starts-with(@id,'action-tabpanel')]");
    }

    @JDIAction("Get '{name}'s animated button")
    public Button animatedButton() {
        return new Button().setCore(Button.class, new UIElement().setLocator("//div[contains(@class, 'MuiButton-root')"));
    }

    @JDIAction("Get '{name}'s tabs")
    public Tabs tabs() {
        return new Tabs().setCore(Tabs.class, new UIElement().setLocator(".MuiTabs-root"));
    }
}
