package com.jdiai.tests;

import com.jdiai.TestInit;
import com.jdiai.site.HomeBasePage;
import com.jdiai.site.HomePage;
import com.jdiai.site.JDISite;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.loginAs;
import static com.jdiai.asserts.Conditions.have;
import static com.jdiai.asserts.Conditions.text;
import static com.jdiai.entities.Contacts.Triss;
import static com.jdiai.entities.LoginUser.Roman;
import static com.jdiai.page.objects.PageFactory.initElements;
import static com.jdiai.site.JDISite.contactPage;
import static com.jdiai.site.JDISite.seleniumHomePage;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;

@Listeners(TestNGListener.class)
public class PageObjectsInitTests implements TestInit {
    HomePage homePage = initElements(HomePage.class);
    HomeBasePage homeBasePage = initElements(HomeBasePage.class);

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
    public void loginPOBaseInClassTest() {
        loginScenario(homeBasePage);
    }

    @Test
    public void loginPOBaseInTest() {
        HomeBasePage homePage = initElements(HomeBasePage.class);
        loginScenario(homePage);
    }

    @Test
    public void loginPOBaseInInitTest() {
        loginScenario(homeBasePage());
    }

    @Test
    public void loginPOBaseFromSiteTest() {
        loginScenario(JDISite.homeBasePage);
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

    public void loginScenario(HomeBasePage page) {
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
