package io.github.com.custom.elements;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class CollapsedBreadcrumbs extends Breadcrumbs {

    @UI(".MuiButtonBase-root")
    protected Button expandButton;

    @JDIAction("Expand '{name}'")
    public void expand() {
        if (isDisplayed()) {
            expandButton.click();
        }
    }

    @Override
    public boolean isDisplayed() {
        return expandButton.isDisplayed();
    }
}
