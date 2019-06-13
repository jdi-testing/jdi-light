package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.openqa.selenium.WebElement;

public class MetalAndColorsPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
			list = "li", expand = ".caret")
	public static Dropdown colors;
	@JDropdown(root = "//div[@ui='dropdown']", value = "//*[contains(@class, 'filter-option')]",
			list = "//li", expand = "//*[contains(@class, 'caret')]")
	public static Dropdown colorsXpath;
	@JDropdown(root = "div[ui=combobox]", value = "input",
			list = "li", expand = ".caret")
	public static Dropdown metals;
	/*@JDropdown(root = @FindBy(css ="div[ui=droplist]"),
			value = @FindBy(css ="button"),
			list = @FindBy(css ="li"),
			expand = @FindBy(css =".caret"),
			isselected = @FindBy(xpath ="././/input")
	) public static Droplist vegetables;*/
	@ByText("Calculate") public static WebElement calculate;
	@ByText("Submit") public static WebElement submit;

}