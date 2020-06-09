package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.complex.dropdown.DropdownExpand;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.complex.IsDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.MultiSelector;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import io.github.com.custom.CustomDropdown;

public class MetalAndColorsPage extends WebPage {
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;

	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
	   list = "li", expand = ".caret")
	public static DropdownExpand colors;

	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
		list = "li", expand = ".caret")
	public static Dropdown colors2;

	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
		list = "li", expand = ".caret")
	public static IsDropdown colors3;

	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
		list = "*root*//div[@ui='dropdown']//li", expand = ".caret")
	public static Dropdown colorsRoot;

	@JDropdown(value = "div[ui=dropdown] .filter-option",
	   list = "div[ui=dropdown] li")
	public static IsDropdown colors4;

	@UI("div[ui=dropdown]")
	public static DropdownExpand colors5;

	@UI("div[ui=dropdown]")
	public static CustomDropdown colorsCustom;

	@JDropdown(root = "div[ui=combobox]", value = "input",
		list = "li", expand = ".caret")
	public static Dropdown metals;

	@JDropdown(root = "div[ui=combobox]", value = "input",
		list = "*root*div[ui=combobox] li", expand = ".caret")
	public static Dropdown metals2;

	@Css("div[ui=droplist]")
	public static MultiSelector vegetables;
	@ByText("Calculate") public static Button calculate;
	@ByText("Submit") public static Button submit;

	@UI("[name=custom_radio_odd]")
	public static RadioButtons odds;

}