package io.github.com.pages;

import com.epam.jdi.light.elements.complex.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.MultiSelect;

public class MetalAndColorsPage extends WebPage {
    // TODO simple html dropdowns
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
			   list = "li", expand = ".caret")
	public static Dropdown colors;
	@JDropdown(root = "div[ui=combobox]", value = "input",
			list = "li", expand = ".caret")
	public static Dropdown metals;
	@Css("div[ui=droplist]")
	public static MultiSelect vegetables;
	@ByText("Calculate") public static Button calculate;
	@ByText("Submit") public static Button submit;

}