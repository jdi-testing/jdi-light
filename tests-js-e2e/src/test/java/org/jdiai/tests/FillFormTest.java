package org.jdiai.tests;

import org.jdiai.TestInit;
import org.jdiai.entities.User;
import org.jdiai.locators.By;
import org.jdiai.testng.TestNGListener;
import org.jdiai.tools.JS;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.jdiai.asserts.Conditions.have;
import static org.jdiai.asserts.Conditions.text;
import static org.jdiai.entities.User.Triss;
import static org.jdiai.states.States.atHomePage;
import static org.jdiai.states.States.logout;
import static org.jdiai.tools.JSTalk.$;
import static org.jdiai.tools.JSTalk.openPage;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestNGListener.class)
public class FillFormTest implements TestInit {

    @Test
    public void loginTest() {
        logout();
        atHomePage();
        $("#user-icon").click();
        loginAs(User.Roman);
        openPage("/contacts.html");
        fillContacts(Triss);
        $(By.text("Submit")).click();
        String lastNameInLog = $(".lname-res").getText();
        String descriptionInLog = $(".descr-res").getText();
        assertEquals(lastNameInLog, "Last Name: " + Triss.lastName);
        assertEquals(descriptionInLog, "Description: " + Triss.description);
    }

    JS userIcon = $("#user-icon");
    JS submitButton = $(By.text("Submit"));
    JS lastNameInLog = $(".lname-res");
    JS descriptionInLog = $(".descr-res");
    @Test
    public void loginPOTest() {
        logout();
        atHomePage();
        userIcon.click();
        loginAs(User.Roman);
        openPage("/contacts.html");
        fillContacts(Triss);
        submitButton.click();
        lastNameInLog.should(have(text("Last Name: " + Triss.lastName)));
        descriptionInLog.should(have(text("Description: " + Triss.description)));
    }

    private void loginAs(User user) {
        $("#name").input(user.name);
        $("#password").input(user.password);
        $(".fa-sign-in").click();
    }
    private void fillContacts(User user) {
        $("#first-name").input(user.name);
        $("#last-name").input(user.lastName);
        if (user.hasPassport) {
            $("#passport").click();
        }
        $("#gender").selectByName(user.gender);
        $("#religion-options").input(user.religion);
        $("#description").input(user.description);
    }
}
