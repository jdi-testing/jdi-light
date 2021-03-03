package org.jdiai.tests.jsdriver.flow;

import org.jdiai.entity.User;
import org.jdiai.tools.locators.By;
import org.testng.annotations.Test;

import static org.jdiai.entity.User.Roman;
import static org.jdiai.entity.User.Tris;
import static org.jdiai.tests.jsdriver.states.States.atHomePage;
import static org.jdiai.tests.jsdriver.states.States.logout;
import static org.jdiai.tools.JSTalk.$;
import static org.jdiai.tools.JSTalk.openPage;
import static org.testng.AssertJUnit.assertEquals;

public class FillFormTest implements FlowInit {

    @Test
    public void loginTest() {
        logout();
        atHomePage();
        $("#user-icon").click();
        loginAs(Roman);
        openPage("/contacts.html");
        fillContacts(Tris);
        $(By.text("Submit")).click();
        String lastNameInLog = $(".lname-res").getText();
        String descriptionInLog = $(".descr-res").getText();
        assertEquals(lastNameInLog, "Last Name: " + Tris.lastName);
        assertEquals(descriptionInLog, "Description: " + Tris.description);
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
