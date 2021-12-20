package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Container;

public class ContainerPage extends WebPage {

    @UI(".MuiContainer-root.MuiContainer-maxWidthSm")
    public static Container container;
}
