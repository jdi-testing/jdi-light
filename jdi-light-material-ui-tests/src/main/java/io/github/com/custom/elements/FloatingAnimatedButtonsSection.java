package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.elements.navigation.Tabs;

public class FloatingAnimatedButtonsSection extends Section {

    @JDIAction("Get '{name}' title")
    public UIElement animatedLabel() {
        return core().find(".MuiTypography-root");
    }

    @JDIAction("Get '{name}' animated button")
    public UIElement animatedButton() {
        return core().find(".MuiFab-root");
    }

    @JDIAction("Get '{name}' tabs")
    public Tabs tabs() {
        return new Tabs().setCore(Tabs.class, core().find(".MuiTabs-root"));
    }
}
