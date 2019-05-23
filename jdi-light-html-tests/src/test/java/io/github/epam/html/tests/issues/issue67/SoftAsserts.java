package io.github.epam.html.tests.issues.issue67;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.usersPage;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.com.pages.UsersPage.users;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;


public class SoftAsserts extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void buttonSoftAssertTest() {
        redButton.is().hidden()
                .displayed()
                .disabled()
                .enabled()
                .disappear()
                .cssClass(is("uui-button red"))
                .text(is("Big Red *** Button-Input"))
                .text(containsString("Red Button"))
                .attr("type", is("button"))
                .tag(is("input"))
                .getResults();
    }

    @Test
    public void imageSoftAssertTest() {
        jdiLogo.is()
                .alt(is("Jdi Logo 777"))
                .src(containsString("jdi-logo.jpg777"))
                .height(is(100))
                .width(is(1000))
                .getResults();
    }

    @Test
    public void checkboxSoftAssertTest() {
        acceptConditions.is()
                .deselected()
                .selected()
                .disabled()
                .displayed()
                .getResults();
    }

    @Test
    public void dataTableSoftAssertTest(){
        usersPage.open();
        users.assertThat()
                .row(d -> d.user.contains("Ivannn"))
                .allRows(d -> d.user.length() > 4)
                .atLeast(3).rows(d -> d.type.contains("Userrr"))
                .getResults();
    }
}
