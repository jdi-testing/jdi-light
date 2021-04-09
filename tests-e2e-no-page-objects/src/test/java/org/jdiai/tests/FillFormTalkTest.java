package org.jdiai.tests;

import org.jdiai.JS;
import org.jdiai.TestInit;
import org.jdiai.entities.MarvelHero;
import org.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.jdiai.JDI.*;
import static org.jdiai.asserts.Conditions.have;
import static org.jdiai.asserts.Conditions.text;
import static org.jdiai.entities.Contacts.Triss;
import static org.jdiai.entities.LoginUser.Roman;
import static org.jdiai.states.States.atHomePage;
import static org.jdiai.states.States.logout;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class FillFormTalkTest implements TestInit {
    JS userIcon = $("#user-icon");
    JS lastNameInLog = $(".lname-res");
    JS descriptionInLog = $(".descr-res");

    @Test
    public void simpleSearchTest() {
        openPage("https://jdi-testing.github.io/jdi-light");
        $("#user-icon").click();
        loginAs(Roman);
        $(".sidebar-menu li").select("Service", "User Table");
        MarvelHero spiderMan = $("#user-table tr").get(2).getEntity(MarvelHero.class);
        assertEquals(spiderMan.number, 2);
        assertEquals(spiderMan.heroName, "Spider Man");
        assertEquals(spiderMan.img, "https://jdi-testing.github.io/jdi-light/images/spider-man.jpg");
    }

    @Test
    public void loginPOTest() {
        logout();
        atHomePage();
        userIcon.click();
        loginAs(Roman);
        openPage("/contacts.html");
        submitForm("#contact-form", Triss);
        lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

    @Test
    public void loginPOFormTest() {
        logout();
        atHomePage();
        userIcon.click();
        $("#login-form").loginAs(Roman);
        openPage("/contacts.html");
        $("#contact-form").submit(Triss);
        lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

    @Test
    public void selectTest() {
        logout();
        atHomePage();
        userIcon.click();
        $("#login-form").loginAs(Roman);
        validateUrl("/index.html");
        $(".sidebar-menu li").select("Contact form");
        validateUrl("/contacts.html");
        $("//*[@class='sidebar-menu']/li//*[text()='%s']").select("Home");
        validateUrl("/index.html");
        $(".sidebar-menu", ".//li//*[text()='%s']").select("Contact form");
        validateUrl("/contacts.html");
    }
    private void validateUrl(String uri) {
        assertEquals(driver().getCurrentUrl(), "https://jdi-testing.github.io/jdi-light" + uri);
    }
}
