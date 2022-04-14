package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.elements.navigation.Tabs;

/**
 * Represents animated FAB (Floating Action Button) for multiple lateral screens (such as tabbed screens) component of MUI on GUI.
 *
 * @see <a href="https://mui.com/material-ui/react-floating-action-button/">FAB MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class FloatingAnimatedButtonsSection extends Section {

    /**
     * Gets the element containing the title of this animated FAB.
     * @return the element with the title of this animated FAB as {@link UIElement}
     */
    @JDIAction("Get '{name}' title")
    public UIElement animatedLabel() {
        return core().find(".MuiTypography-root");
    }

    /**
     * Gets the element containing this animated FAB.
     * @return the element with this animated FAB as {@link UIElement}
     */
    @JDIAction("Get '{name}' animated button")
    public UIElement animatedButton() {
        return core().find(".MuiFab-root");
    }

    /**
     * Gets the tabs of this animated FAB section.
     * @return the tabs of this animated FAB section as {@link Tabs}
     */
    @JDIAction("Get '{name}' tabs")
    public Tabs tabs() {
        return new Tabs().setCore(Tabs.class, core().find(".MuiTabs-root"));
    }
}
