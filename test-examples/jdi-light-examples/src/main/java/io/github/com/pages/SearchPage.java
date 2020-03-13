package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.*;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import io.github.com.custom.*;

import java.util.List;

public class SearchPage extends BaseSelPage {
	@Css(".box") public DataList<SearchResult, Result> search;
	@Css(".box") public DataList<SearchResult, ?> search2;
	@Css(".box") public static List<SearchResult> search3;
	@Css(".box") @WaitTimeout(2)
	public static DataList<SearchResult, ?> searchS;
	@XPath("//*[@class='box']/h3[text()=\"%s\"]")
	public DataList<SearchResult, ?> searchT2;

	@Css(".box") public JList<SearchResult> jsearch2;
	@Css(".box") public static JList<SearchResult> jsearchS;
	@Css(".box h3") public static JList<UIElement> jsearchTitle;
	@XPath("//*[@class='box']/h3[text()=\"%s\"]")
	public JList<SearchResult> jsearchT2;
}