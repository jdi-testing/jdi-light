package com.jditest.tests;

import com.jditest.TestInit;
import com.jditest.site.HomePage;
import com.jditest.site.JDISite;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jditest.JDI.loginAs;
import static com.jditest.asserts.Conditions.have;
import static com.jditest.asserts.Conditions.text;
import static com.jditest.entities.Contacts.Triss;
import static com.jditest.entities.LoginUser.Roman;
import static com.jditest.page.objects.PageFactory.initElements;
import static com.jditest.site.JDISite.contactPage;
import static com.jditest.site.JDISite.seleniumHomePage;
import static com.jditest.states.States.atHomePage;
import static com.jditest.states.States.logout;

@Listeners(TestNGListener.class)
public class PageObjectsInitTests implements TestInit {
    HomePage homePage = initElements(HomePage.class);

    @Test
    public void loginPOInClassTest() {
        loginScenario(homePage);
    }

    @Test
    public void loginPOInTest() {
        HomePage homePage = initElements(HomePage.class);
        loginScenario(homePage);
    }

    @Test
    public void loginPOInInitTest() {
        loginScenario(homePage());
    }

    @Test
    public void loginPOFromSiteTest() {
        loginScenario(JDISite.homePage);
    }

    @Test
    public void seleniumTest() {
        logout();
        atHomePage();
        seleniumHomePage.userIcon.click();
        loginAs(Roman);
        contactPage.open();
        contactPage.contactForm.submit(Triss);
        contactPage.lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        contactPage.descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

    @Test
    public void elementInSectionTest() {
        logout();
        atHomePage();
        homePage().userIcon.click();
        loginAs(Roman);
        contactPage.open();
        contactPage.contactForm.fill(Triss);
        contactPage.contacts.submitButton.click();
        contactPage.lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        contactPage.descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

    public void loginScenario(HomePage page) {
        logout();
        atHomePage();
        page.userIcon.click();
        loginAs(Roman);
        contactPage.open();
        contactPage.contactForm.submit(Triss);
        contactPage.lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        contactPage.descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

}
