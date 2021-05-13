package io.github.com.pages.layout;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ContainerPage extends WebPage {
    @UI("//div[contains(@Class, 'MuiTypography-body1')]")
    public static UIElement container;
}
