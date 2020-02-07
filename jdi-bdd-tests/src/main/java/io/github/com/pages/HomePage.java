package io.github.com.pages;

import com.epam.jdi.mobile.elements.common.Label;
import com.epam.jdi.mobile.elements.composite.WebPage;
import com.epam.jdi.mobile.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.mobile.ui.html.elements.common.Link;
import com.epam.jdi.mobile.ui.html.elements.common.Text;

public class HomePage extends WebPage {
	@UI("h3[name='main-title']") public static Label mainTitle;
	@UI(".main-txt") public static Text jdiText;
	@UI("['JDI Github']") public static Link githubLink;
}