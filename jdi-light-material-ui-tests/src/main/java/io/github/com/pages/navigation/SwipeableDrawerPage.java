package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.custom.annotations.JButtonWithDrawer;
import io.github.com.custom.elements.ButtonWithDrawer;

public class SwipeableDrawerPage extends WebPage {

    @JButtonWithDrawer(
            root = "//span[text() = 'left']/parent::button",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorLeft')]]"
    )
    public static ButtonWithDrawer leftDrawerButton;

    @JButtonWithDrawer(
            root = "//span[text() = 'right']/parent::button",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorRight')]]"
    )
    public static ButtonWithDrawer rightDrawerButton;

    @JButtonWithDrawer(
            root = "//span[text() = 'top']/parent::button",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorTop')]]"
    )
    public static ButtonWithDrawer topDrawerButton;

    @JButtonWithDrawer(
            root = "//span[text() = 'bottom']/parent::button",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorBottom')]]"
    )
    public static ButtonWithDrawer bottomDrawerButton;
}
