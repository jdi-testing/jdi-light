package io.github.com.pages.layout;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ContainerPage extends WebPage {
    @UI("//*[@id='__next']//div[contains(@class, 'MuiTypography-body1')]")
    public UIElement container;
}
