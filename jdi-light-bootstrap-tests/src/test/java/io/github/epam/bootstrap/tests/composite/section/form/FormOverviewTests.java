package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.pages.BootstrapPage.formCustomStyles;
import static io.github.com.pages.BootstrapPage.formOverview;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class FormOverviewTests extends TestsInit {

    private String emailPlaceholder = "Enter email";
    private String emailText = "Email address";
    private String emailHelp = "We'll never share your email with anyone else.";
    private String passwordValue = "Password";
    private String acceptLabelText = "Check me out";
    private String  submitText = "Submit";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();

    }
    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                //{formOverview.email, "test@test.com"},
                {formOverview.emailLabel, "Email address"},
                {formOverview.help, "We'll never share your email with anyone else."},
                //{formOverview.password, "Password"},
                {formOverview.passwordLabel, "Password"},
               // {formOverview.accept, "First name"},
                {formOverview.acceptLabel, "Check me out"},
                //{formOverview.submit, "Submit"}
        };
    }
/*    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formCustomStyles.name, "First name", "Mark"},
                {formCustomStyles.lastName, "Last name", "Otto"},
                {formCustomStyles.userName, "Username", ""},
                {formCustomStyles.city, "City", ""},
                {formCustomStyles.state, "State", ""},
                {formCustomStyles.zip, "Zip", ""}
        };
    }*/


@Test
public void isValidationTests() {
    formOverview.emailLabel.is()
            .displayed()
            .enabled()
            .core()
            .attr("for", "exampleInputEmail1")
    .text(emailText)
            .tag("label");

    formOverview.email.is()
            .displayed()
            .enabled()
            .core()
            .cssClass("form-control")
            .attr("type", "email")
            .attr("id", "exampleInputEmail1")
            .attr("aria-describedby", "emailHelp")
            .attr("placeholder", emailPlaceholder)
            .tag("input");

    formOverview.help.is()
            .displayed()
            .enabled()
            .core()
            .attr("id", "emailHelp")
            .cssClass("form-text text-muted")
            .text(emailHelp)
            .value(emailHelp)
            .tag("small");

    formOverview.passwordLabel.is()
            .displayed()
            .enabled()
            .core()
            .value(passwordValue)
            .text(passwordValue)
            .attr("for", "exampleInputPassword1")
            .tag("label");

    formOverview.password.is()
            .displayed()
            .enabled()
            .core()
            .cssClass("form-control")
            .attr("type", "password")
            .attr("id", "exampleInputPassword1")
            .attr("placeholder", passwordValue)
            .tag("input");

    formOverview.accept.is()
            .displayed()
            .enabled()
            .core()
            .cssClass("form-check-input")
            .attr("type", "checkbox")
            .attr("id", "exampleCheck1")
            .tag("input");

    formOverview.acceptLabel.is()
            .displayed()
            .enabled()
            .core()
            .text(acceptLabelText)
            .value(acceptLabelText)
            .cssClass("form-check-label")
            .attr("for", "exampleCheck1")
            .tag("label");

    formOverview.submit.is()
            .displayed()
            .enabled()
            .core()
            .cssClass("btn btn-primary")
            .attr("type", "submit")
            .text(submitText)
            .value(submitText)
            .tag("button");
}
/*    @Test(dataProvider = "listData")
    public void isValidationTests(TextField element, String label, String value) {
        element
                .is()
                .displayed()
                .enabled()
                .core()
                .value(value)
                .hasClass("form-control")
                .attr("type", "text")
                .attr("placeholder", label)
                .tag(is("input"));
        element.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .text(is(label));
    }*/

/*    @Test
    public void isValidationTests() {
        formCustomStyles.accept
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("form-check-input")
                .tag(is("input"));
        formCustomStyles.accept.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Agree to terms and conditions"))
                .tag(is("label"));
    }*/

 /*   @Test
    public void checkboxTests() {
        formCustomStyles.accept.check();
        formCustomStyles.accept.is().selected();
        formCustomStyles.accept.uncheck();
        formCustomStyles.accept.is().deselected();
    }*/

  /*  @Test
    public void fillTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }*/

 /*   @Test
    public void submitTextToContactFormTest() {
        formCustomStyles.submit("Roman");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }*/

  /*  @Test
    public void submitEntityToContactFormTest() {
        formCustomStyles.submit(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formCustomStyles.submit("Roman", "submit");
        formCustomStyles.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }*/

   /* @Test
    public void verifyMethodPositiveTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 0);
    }*/

   /* @Test
    public void verifyMethodNegativeTest() {
        formCustomStyles.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formCustomStyles.verify(DEFAULT_CONTACT);
        assertEquals(verified.size(), 1);
        assertTrue(verified.get(0).contains("Mark"));
    }*/

    /*@Test
    public void sendMethodTest() {
        formCustomStyles.fill(DEFAULT_CONTACT);
        formCustomStyles.send();
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

    /*@Test
    public void sendEntityMethodTest() {
        formCustomStyles.send(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

   /* @Test
    public void addEntityMethodTest() {
        formCustomStyles.add(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void publishMethodTest() {
        formCustomStyles.publish(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void saveMethodTest() {
        formCustomStyles.save(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

   /* @Test
    public void updateMethodTest() {
        formCustomStyles.update(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void cancelMethodTest() {
        formCustomStyles.cancel(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

   /* @Test
    public void closeMethodTest() {
        formCustomStyles.close(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void backMethodTest() {
        formCustomStyles.back(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void selectMethodTest() {
        formCustomStyles.select(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

  /*  @Test
    public void nextMethodTest() {
        formCustomStyles.next(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/

   /* @Test
    public void searchMethodTest() {
        formCustomStyles.search(DEFAULT_CONTACT);
        formCustomStyles.check(DEFAULT_CHECK);
    }*/
@Test
    private void checkContactFormSubmitted() {
        formCustomStyles.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}