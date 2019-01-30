package com.google.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.ui.html.common.TextField;
import com.google.custom.JSearch;
import com.google.custom.Search;
import org.openqa.selenium.Keys;

public class HomePage extends WebPage {
    @Css("[name=q]") public TextField search;
    @JSearch(input = "[name=q]", list = "ul[role=listbox] li span")
    public static Search suggestion;

    public void search(String text) {
        search.clear();
        search.sendKeys(text + Keys.ENTER);
    }
}
