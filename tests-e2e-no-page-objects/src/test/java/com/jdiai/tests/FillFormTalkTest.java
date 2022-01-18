package com.jdiai.tests;

import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.*;
import static com.jdiai.asserts.Conditions.have;
import static com.jdiai.asserts.Conditions.text;
import static com.jdiai.entities.Contacts.Triss;
import static com.jdiai.entities.LoginUser.Roman;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;
import static org.testng.Assert.assertEquals;

@Listeners(TestNGListener.class)
public class FillFormTalkTest implements TestInit {
    JS userIcon = $("#user-icon");
    JS lastNameInLog = $(".lname-res");
    JS descriptionInLog = $(".descr-res");

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
        $(".sidebar-menu li a").select("Contact form");
        validateUrl("/contacts.html");
        $(".sidebar-menu li a").select("Service", "User Table");
        validateUrl("/user-table.html");
        $("//*[contains(@class, 'sidebar-menu')]/li//*[text()='%s']").select("Home");
        validateUrl("/index.html");
        $(".sidebar-menu", ".//li//*[text()='%s']").select("Contact form");
        validateUrl("/contacts.html");
        $(".sidebar-menu", ".//li//*[text()='%s']").select("Service", "User Table");
        validateUrl("/user-table.html");
    }

    @Test
    public void selectWithoutTemplateTest() {
        logout();
        atHomePage();
        userIcon.click();
        $("#login-form").loginAs(Roman);
        validateUrl("/index.html");
        $(".sidebar-menu li a").select("Contact form");
        validateUrl("/contacts.html");
        $(".sidebar-menu li a").select("Service", "User Table");
        validateUrl("/user-table.html");
        $(".sidebar-menu li a").select("Home");
        validateUrl("/index.html");
        $(".sidebar-menu li a").select("Contact form");
        validateUrl("/contacts.html");
        $(".sidebar-menu", "li a").select("Service", "User Table");
        validateUrl("/user-table.html");
    }

    @Test
    public void selectByAttributeTest() {
        logout();
        atHomePage();
        userIcon.click();
        $("#login-form").loginAs(Roman);
        validateUrl("/index.html");
        $(".sidebar-menu li a").setGetValueFunc("getAttribute('href')").select("contacts.html");
        validateUrl("/contacts.html");
        try {
            GET_TEXT_DEFAULT = "getAttribute('href')";
            $(".sidebar-menu li a").select("metals-colors.html");
            validateUrl("/metals-colors.html");
        } finally {
            GET_TEXT_DEFAULT = "innerText";
        }
    }

    private void validateUrl(String uri) {
        assertEquals(driver().getCurrentUrl(), "https://jdi-testing.github.io/jdi-light" + uri);
    }
}
