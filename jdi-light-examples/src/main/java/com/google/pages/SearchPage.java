package com.google.pages;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.google.custom.Result;
import com.google.custom.SearchResult;

import java.util.List;

public class SearchPage extends WebPage {
    @Css(".srg>.g") public UIList<SearchResult, Result> search;
    @Css(".srg>.g") public UIList<SearchResult, ?> search2;
    @XPath("//*[@class='srg']/*[@class='g']//h3[text()=\"%s\"]")
    public UIList<SearchResult, ?> searchT2;
    @Css(".srg>.g") public static UIList<SearchResult, ?> searchS;
    @Css(".srg>.g") public static List<SearchResult> search3;

}
