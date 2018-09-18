package io.github.epam.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
	@Css("h3[name='main-title']") public WebElement mainTitle;
	@Css(".main-txt") public Text jdiText;
	@ByText("JDI Github") public WebElement githubLink;
}