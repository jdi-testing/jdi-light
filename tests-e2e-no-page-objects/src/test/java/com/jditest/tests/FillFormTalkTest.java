package com.jditest.tests;

import com.jditest.JS;
import com.jditest.TestInit;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jditest.JDI.*;
import static com.jditest.asserts.Conditions.have;
import static com.jditest.asserts.Conditions.text;
import static com.jditest.entities.Contacts.Triss;
import static com.jditest.entities.LoginUser.Roman;
import static com.jditest.states.States.atHomePage;
import static com.jditest.states.States.logout;
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
        $(".sidebar-menu").select("Contact form");
        validateUrl("/contacts.html");
        $(".sidebar-menu").select("Service", "User Table");
        validateUrl("/user-table.html");
        $("//*[contains(@class, 'sidebar-menu')]/li//*[text()='%s']").select("Home");
        validateUrl("/index.html");
        $(".sidebar-menu", ".//li//*[text()='%s']").select("Contact form");
        validateUrl("/contacts.html");
    }
    private void validateUrl(String uri) {
        assertEquals(driver().getCurrentUrl(), "https://jdi-testing.github.io/jdi-light" + uri);
    }
}
