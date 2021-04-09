package org.jdiai.tests;

import org.jdiai.JS;
import org.jdiai.TestInit;
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

}
