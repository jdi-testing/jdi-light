package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIBreadcrumbs;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;

public class BreadcrumbsFrame extends Section {
    @JDIBreadcrumbs
    public Breadcrumbs breadcrumb;

    @UI(".MuiButtonBase-root")
    public Button collapsedButton;

}
