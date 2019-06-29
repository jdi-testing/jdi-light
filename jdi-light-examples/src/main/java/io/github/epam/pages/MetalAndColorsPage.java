package io.github.epam.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import io.github.epam.sections.LogSidebar;
import org.openqa.selenium.WebElement;

public class MetalAndColorsPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public LogSidebar logSidebar;
	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
			list = "li", expand = ".caret")
	public Dropdown colors;
	@JDropdown(root = "div[ui=combobox]", value = "input",
			list = "li", expand = ".caret")
	public Dropdown metals;
	/*@JDropdown(root = @FindBy(css ="div[ui=droplist]"),
			value = @FindBy(css ="button"),
			list = @FindBy(css ="li"),
			expand = @FindBy(css =".caret"),
			isselected = @FindBy(xpath ="././/input")
	) public Droplist vegetables;*/
	@UI("['Calculate']") public WebElement calculate;
	@UI("['Submit']") public WebElement submit;

}