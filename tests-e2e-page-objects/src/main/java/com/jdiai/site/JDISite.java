package com.jdiai.site;

import com.jdiai.annotations.Site;
import com.jdiai.annotations.Url;

@Site("https://jdi-testing.github.io/jdi-light")
public class JDISite {
    @Url("/search.html")
    public static SearchPage searchPage;
    public static HomePage homePage;
    public static HomeBasePage homeBasePage;
    @Url("/contacts.html")
    public static ContactPage contactPage;

    public static SeleniumHomePage seleniumHomePage;
}
