package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class UseMediaQueryPage extends WebPage {

    @UI("//span[contains(.,'min-width')]")
    public static Text useMediaQueryText;
}
