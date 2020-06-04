package io.github.epam.tests.selenium;

import org.testng.annotations.*;
import selenium.entities.User;
import selenium.site.*;

import static com.epam.jdi.light.elements.init.PageFactory.*;
import static selenium.seleniumPO.HomePage.*;
import static selenium.seleniumPO.SiteSelenium.*;
import static selenium.site.data.DefaultDataProvider.*;
import static selenium.site.pages.ContactPage.*;

public class SeleniumContactForm implements SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        initElements(SiteJdi.class);
        login(new User());
        leftNavigation.select("Contact form");
    }

    @Test
    public void contactFormTest() {
        seleniumContactForm.submit(ROMAN_CONTACT);
    }
}
