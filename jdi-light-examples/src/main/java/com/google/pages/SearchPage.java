package com.google.pages;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.google.custom.Result;
import com.google.custom.SearchResult;

import java.util.List;

public class SearchPage extends WebPage {
    @Css(".srg>.g") public UIList<SearchResult, Result> jobsE;
    @Css(".srg>.g") public UIList<SearchResult, ?> jobs2;
    @Css(".srg>.g") public static List<SearchResult> jobs3;

}
