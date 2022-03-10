package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.elements.navigation.Tabs;

public class FloatingAnimatedButton extends Section {

    @JDIAction("Get '{name}'s title")
    public UIElement animatedLabel() {
        return core().find("//div[starts-with(@id,'action-tabpanel')]");
    }

    @JDIAction("Get '{name}'s animated button")
    public UIElement animatedButton() {
        return core().find("//div//button[contains(@class, 'MuiButtonBase-root MuiFab-root')]");
    }

    @JDIAction("Get '{name}'s tabs")
    public Tabs tabs() {
        return new Tabs().setCore(Tabs.class, new UIElement().setLocator(".MuiTabs-root"));
    }
}
