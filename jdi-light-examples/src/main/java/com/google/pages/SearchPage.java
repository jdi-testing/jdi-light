package com.google.pages;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.google.custom.Result;
import com.google.custom.SearchResult;
import org.openqa.selenium.WebElement;

public class SearchPage extends WebPage {
    @Css(".srg>.g") public UIList<SearchResult, Result> jobsE;
    @Css(".srg>.g") public UIList<SearchResult, ?> jobs2;
    @UI("[*'test Framework for UI']") public WebElement gitHubJdi;

}
