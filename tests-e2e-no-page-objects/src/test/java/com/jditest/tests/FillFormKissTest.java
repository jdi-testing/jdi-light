package com.jditest.tests;

import com.jditest.TestInit;
import com.jditest.entities.User;
import com.jditest.locators.By;
import com.jditest.testng.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jditest.JDI.$;
import static com.jditest.JDI.openPage;
import static com.jditest.entities.User.Triss;
import static com.jditest.states.States.atHomePage;
import static com.jditest.states.States.logout;
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
