package io.github.com.pages;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.MultiSelector;

public class MetalAndColorsPage extends WebPage {
    // TODO simple html dropdowns
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@JDropdown(root = "div[ui=dropdown]", value = ".filter-option",
			   list = "li", expand = ".caret")
	public static Droplist colors;
	@JDropdown(root = "div[ui=combobox]", value = "input",
			list = "li", expand = ".caret")
	public static Droplist metals;
	@JDropdown(root = "div[ui=combobox]", value = "input",
			list = "*root*div[ui=combobox] li", expand = ".caret")
	public static Droplist metals2;
	@Css("div[ui=droplist]")
	public static MultiSelector vegetables;
	@ByText("Calculate") public static Button calculate;
	@ByText("Submit") public static Button submit;

}