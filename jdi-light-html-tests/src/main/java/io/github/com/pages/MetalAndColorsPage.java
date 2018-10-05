package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.ByText;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.complex.*;

public class MetalAndColorsPage extends WebPage {
    // TODO simple html dropdowns
	@Css(".uui-side-bar[name='log-sidebar']") public static LogSidebar logSidebar;
	@Css("div[ui=dropdown]")
	public static Dropdown colors;
	@Css("div[ui=combobox]")
	public static Combobox metals;
	@Css("div[ui=droplist]")
	public static MultiSelect vegetables;
	@ByText("Calculate") public static Button calculate;
	@ByText("Submit") public static Button submit;

}