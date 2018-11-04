package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.Css;
import org.mytests.uiobjects.example.site.pages.ContactFormPage;
import org.mytests.uiobjects.example.site.pages.HomePage;
import org.mytests.uiobjects.example.site.pages.JDIPerformancePage;
import org.mytests.uiobjects.example.site.sections.Header;
import org.openqa.selenium.WebElement;

@JSite("https://epam.github.io/JDI/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage jdiPerformancePage;
    public static ContactFormPage contactFormPage;

    @Css("header") public static Header header;

    @Css(".profile-photo") public static WebElement profilePhoto;
    @Css(".profile-photo [ui=label]") public static WebElement userName;

    @Css(".sidebar-menu [ui=label]")
    public static WebList navigation;

}
