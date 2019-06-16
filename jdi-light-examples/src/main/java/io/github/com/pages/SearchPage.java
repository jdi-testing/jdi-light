package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;

import java.util.List;

public class SearchPage extends BaseSelPage {
	@Css(".box") public DataList<SearchResult, Result> search;
	@Css(".box") public DataList<SearchResult, ?> search2;
	@Css(".box") public static List<SearchResult> search3;
	@Css(".box") public static DataList<SearchResult, ?> searchS;
	@XPath("//*[@class='box']/h3[text()=\"%s\"]")
	public DataList<SearchResult, ?> searchT2;

	@Css(".box") public JList<SearchResult> jsearch2;
	@Css(".box") public static JList<SearchResult> jsearchS;
	@Css(".box h3") public static JList<UIElement> jsearchTitle;
	@XPath("//*[@class='box']/h3[text()=\"%s\"]")
	public JList<SearchResult> jsearchT2;
}