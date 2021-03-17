package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Tab;

public class TabFrame extends Section {

    @UI(".MuiTabs-root")
    public Tab tabs;

}
