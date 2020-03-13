package io.github.epam.tests.selenium;

import org.testng.annotations.*;
import selenium.entities.User;

import static selenium.seleniumPO.HomePage.*;
import static selenium.seleniumPO.SiteSelenium.*;
import static selenium.site.data.DefaultDataProvider.*;
import static selenium.site.pages.ContactPage.*;

public class SeleniumContactForm implements SimpleTestsInit {

    @BeforeMethod
    public void openPerformancePage() {
        homePage.open();
        login(new User());
        leftNavigation.select("Contact form");
    }

    @Test
    public void contactFormTest() {
        seleniumContactForm.submit(ROMAN_CONTACT);
    }
}
