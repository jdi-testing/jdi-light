package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * Represents Collapsed Breadcrumbs MUI component on GUI.
 * <p>Breadcrumbs allow users to make selections from a range of values.</p>
 *
 * @see Breadcrumbs
 * @see <a href="https://v4.mui.com/components/breadcrumbs/#collapsed-breadcrumbs">Collapsed breadcrumbs MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material/simple_breadcrumbs">MUI test page</a>
 */
public class CollapsedBreadcrumbs extends Breadcrumbs {

    @UI(".MuiButtonBase-root")
    protected Button expandButton;

    /**
     * Clicks to expand the Collapsed Breadcrumbs
     */
    @JDIAction("Expand '{name}'")
    public void expand() {
        if (this.expandButton.isDisplayed()) {
            this.expandButton.click();
        }
    }
}
