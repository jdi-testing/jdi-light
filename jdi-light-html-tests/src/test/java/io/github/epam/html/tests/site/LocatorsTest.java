package io.github.epam.html.tests.site;

import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class LocatorsTest {
    // @Test
    public void cssTest() {
        openUrl("https://jdi-testing.github.io/jdi-light/");
        $("#user-icon").click();
        $("#name").sendKeys("Roman");
        $("#password").sendKeys("Jdi1234");
        $("#login-button").click();
        $("#user-name").has().text("ROMAN IOVLEV");

        $$(".sidebar-menu").select("Contact form");
        assertThat(getUrl(), containsString("/jdi-light/contacts.html"));
    }
    // @Test
    public void namedTest() {
        openUrl("https://jdi-testing.github.io/jdi-light/");
        $("User Icon").click();
        $("Name").sendKeys("Roman");
        $("Password").sendKeys("Jdi1234");
        $("Login Button").click();
        $("User Name").has().text("ROMAN IOVLEV");

        $$(".sidebar-menu").select("Contact form");
        checkUrl("contacts.html");
    }
    // @Test
    public void withText() {
        openUrl("https://jdi-testing.github.io/jdi-light/");
        $("#user-icon").click();
        $("#name").sendKeys("Roman");
        $("#password").sendKeys("Jdi1234");
        $("#login-button").click();
        $("#user-name").has().text("ROMAN IOVLEV");

        $("=Elements packs").click();
        $("['HTML 5']").is().displayed();
        $("*=Elements").click();
        $("['HTML 5']").is().hidden();
    }

}