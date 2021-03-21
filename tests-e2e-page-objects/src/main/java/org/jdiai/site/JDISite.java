package org.jdiai.site;

import org.jdiai.annotations.Site;
import org.jdiai.annotations.Url;

@Site("https://jdi-testing.github.io/jdi-light")
public class JDISite {
    public static HomePage homePage;
    @Url("/contacts.html")
    public static ContactPage contactPage;
    @Url("/search.html")
    public static SearchPage searchPage;

    public static SeleniumHomePage seleniumHomePage;
}
