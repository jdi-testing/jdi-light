package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Link;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class HomePage extends WebPage {
    @Css("h3[name='main-title']") public static Label mainTitle;
    @Css(".main-txt") public static Text jdiText;
    @UI("['JDI Github']") public static Link githubLink;
}