package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.custom.annotations.JDIButtonWithDrawer;
import io.github.com.custom.elements.ButtonWithDrawer;

public class SwipeableDrawerPage extends WebPage {

    @JDIButtonWithDrawer(
            root = "//span[text() = 'left']/parent::button",
            drawer = ".MuiDrawer-paperAnchorLeft"
    )
    public static ButtonWithDrawer leftDrawerButton;

    @JDIButtonWithDrawer(
            root = "//span[text() = 'right']/parent::button",
            drawer = ".MuiDrawer-paperAnchorRight"
    )
    public static ButtonWithDrawer rightDrawerButton;

    @JDIButtonWithDrawer(
            root = "//span[text() = 'top']/parent::button",
            drawer = ".MuiDrawer-paperAnchorTop"
    )
    public static ButtonWithDrawer topDrawerButton;

    @JDIButtonWithDrawer(
            root = "//span[text() = 'bottom']/parent::button",
            drawer = ".MuiDrawer-paperAnchorBottom"
    )
    public static ButtonWithDrawer bottomDrawerButton;
}
