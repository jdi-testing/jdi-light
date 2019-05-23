package io.github.com.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;

import java.util.List;

public class SearchPage extends BaseSelPage {
	@Css(".box") public UIList<SearchResult, Result> search;
	@Css(".box") public UIList<SearchResult, ?> search2;
	@Css(".box") public static List<SearchResult> search3;
	@Css(".box") public static UIList<SearchResult, ?> searchS;
	@Css(".box h3") public static JList<UIElement> searchTitle;
	@XPath("//*[@class='box']/h3[text()=\"%s\"]")
	public UIList<SearchResult, ?> searchT2;
}