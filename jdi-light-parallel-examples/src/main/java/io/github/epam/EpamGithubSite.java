package io.github.epam;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import io.github.epam.pages.HomePage;
import io.github.epam.pages.PerformancePage;
import io.github.epam.sections.Header;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class EpamGithubSite {

    @Url("/index.html")
    public static HomePage homePage;

    @Url("/performance.html")
    @Title("Performance page")
    public static PerformancePage performancePage;

    @Css("[ui=label]")
    public static WebList navigation;

    @Css("header")
    public static Header header;

}