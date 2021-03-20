package org.jdiai.tests;

import org.jdiai.TestInit;
import org.jdiai.WebPage;
import org.jdiai.site.HomePage;
import org.jdiai.site.JDISite;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.jdiai.JSTalk.loginAs;
import static org.jdiai.JSTalk.openPage;
import static org.jdiai.asserts.Conditions.have;
import static org.jdiai.asserts.Conditions.text;
import static org.jdiai.entities.Contacts.Triss;
import static org.jdiai.entities.LoginUser.Roman;
import static org.jdiai.page.objects.PageFactory.initElements;
import static org.jdiai.site.JDISite.contactPage;
import static org.jdiai.states.States.atHomePage;
import static org.jdiai.states.States.logout;

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

    public void loginScenario(HomePage homePage) {
        logout();
        atHomePage();
        homePage.userIcon.click();
        loginAs(Roman);
        contactPage.open();
        contactPage.contactForm.submit(Triss);
        contactPage.lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        contactPage.descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

}
