package com.google.pages;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.google.custom.JSearch;
import com.google.custom.Search;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class HomePage extends WebPage {
    @Css("[name=q]") public WebElement search;
    @UI("[name=q]") public UIElement search2;
    @UI(".logo") public UIElement logo;
    @JSearch(input = "[name=q]", list = "ul[role=listbox] li span")
    public static Search suggestion;

    public void search(String text) {
        search.clear();
        search.sendKeys(text + Keys.ENTER);
    }
}
