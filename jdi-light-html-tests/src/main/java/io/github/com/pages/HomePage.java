package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Label;
import com.epam.jdi.light.ui.html.common.Link;
import com.epam.jdi.light.ui.html.common.Text;
import static com.epam.jdi.light.settings.WebSettings.DOMAIN;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public static Label mainTitle;
	@Css(".main-txt") public static Text jdiText;
	@UI("['JDI Github']") public static Link githubLink;
	
	public static void open() {
		WebPage.openUrl(DOMAIN + "/index.html");
	}
}