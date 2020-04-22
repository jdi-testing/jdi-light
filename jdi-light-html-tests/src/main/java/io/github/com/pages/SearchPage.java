package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.DataList;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitTimeout;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.Result;
import io.github.com.custom.SearchResult;

import java.util.List;

public class SearchPage extends BaseSelPage {
	@UI(".box") public DataList<SearchResult, Result> search;
	@UI(".box") public DataList<SearchResult, ?> search2;
	@UI(".box") public static List<SearchResult> search3;
	@UI(".box") @WaitTimeout(2)
	public static DataList<SearchResult, ?> searchS;
	@UI("//*[@class='box']/h3[text()=\"%s\"]")
	public DataList<SearchResult, ?> searchT2;

	@UI(".box") public JList<SearchResult> jsearch2;
	@UI(".box") public static JList<SearchResult> jsearchS;
	@UI(".box h3") public static JList<UIElement> jsearchTitle;
	@UI("//*[@class='box']/h3[text()=\"%s\"]")
	public JList<SearchResult> jsearchT2;
}