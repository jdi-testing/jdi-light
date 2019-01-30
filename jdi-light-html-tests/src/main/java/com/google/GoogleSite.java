package com.google;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.google.pages.HomePage;
import com.google.pages.SearchPage;

import static com.epam.jdi.light.common.CheckTypes.CONTAINS;

@JSite("http://google.com")
public class GoogleSite {
    @Url(template = "google.com", validate = CONTAINS)
    public static HomePage homePage;
    @Url("/search") public static SearchPage searchPage;
}
