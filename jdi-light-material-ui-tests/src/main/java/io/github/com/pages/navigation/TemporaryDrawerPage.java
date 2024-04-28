package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.com.custom.annotations.JButtonWithDrawer;
import io.github.com.custom.elements.ButtonWithDrawer;

public class TemporaryDrawerPage extends WebPage {

    @JButtonWithDrawer(
            root = "//button[.//*[text()='left']]",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorLeft')]]"
    )
    public static ButtonWithDrawer leftDrawerButton;

    @JButtonWithDrawer(
            root = "//button[.//*[text()='right']]",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorRight')]]"
    )
    public static ButtonWithDrawer rightDrawerButton;

    @JButtonWithDrawer(
            root = "//button[.//*[text()='top']]",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorTop')]]"
    )
    public static ButtonWithDrawer topDrawerButton;

    @JButtonWithDrawer(
            root = "//button[.//*[text()='bottom']]",
            drawer = "//div[contains(@class, 'MuiDrawer-root')][./div[contains(@class, 'MuiDrawer-paperAnchorBottom')]]"
    )
    public static ButtonWithDrawer bottomDrawerButton;

}
