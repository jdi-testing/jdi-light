package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Link;

public class LinkPage extends WebPage {
    @UI("//a[text()='Link']")
    public static Link link;

    @UI("//a[text()='color=\"inherit\"']")
    public static Link inheritColorLink;

    @UI("//a[text()='variant=\"body2\"']")
    public static Link body2Link;

    @UI("//a[text()='Underlined link4']")
    public static Link underlinedLink;
}
