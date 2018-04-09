package com.google;

import com.epam.jdi.light.elements.pageobjects.annotations.JPage;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.google.pages.HomePage;
import com.google.pages.SearchPage;

@JSite("http://google.com")
public class GoogleSite {
    @JPage(url = "/") public static HomePage homePage;
    @JPage(url = "/search") public static SearchPage searchPage;
}
