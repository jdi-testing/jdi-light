package com.jdiai.tests;

import com.jdiai.TestInit;
import com.jdiai.entities.User;
import com.jdiai.locators.By;
import com.jdiai.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.$;
import static com.jdiai.JDI.openPage;
import static com.jdiai.entities.User.Triss;
import static com.jdiai.states.States.atHomePage;
import static com.jdiai.states.States.logout;
import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestNGListener.class)
public class FillFormKissTest implements TestInit {
    @Test
    public void loginTest() {
        logout();
        atHomePage();

        $("#user-icon").click();
        $("#name").input("Roman");
        $("#password").input("Jdi1234");
        $(".fa-sign-in").click();

        openPage("/contacts.html");
        fillContacts(Triss);
        $(By.text("Submit")).click();

        String lastNameInLog = $(".lname-res").getText();
        String descriptionInLog = $(".descr-res").getText();
        assertEquals(lastNameInLog, "Last Name: " + Triss.lastName);
        assertEquals(descriptionInLog, "Description: " + Triss.description);
    }

    private void fillContacts(User user) {
        $("#first-name").input(user.name);
        $("#last-name").input(user.lastName);
        $("#passport").check(user.hasPassport);
        $("#gender").selectByName(user.gender);
        $("#religion-options").input(user.religion);
        $("#description").input(user.description);
    }
}
