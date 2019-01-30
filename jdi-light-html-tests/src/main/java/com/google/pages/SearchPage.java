package com.google.pages;

import com.epam.jdi.light.elements.complex.UIList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.google.custom.Result;
import com.google.custom.SearchResult;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends WebPage {
    @UI(".srg>.g") public UIList<SearchResult, Result> jobsE;
    @UI(".srg>.g") public UIList<SearchResult, ?> jobs2;
    @UI(".srg>.g") public static List<SearchResult> jobs3;

}
