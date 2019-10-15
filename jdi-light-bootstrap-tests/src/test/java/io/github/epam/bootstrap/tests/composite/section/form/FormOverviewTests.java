package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.com.entities.FormSignUp;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.formOverview;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class FormOverviewTests extends TestsInit {

    public static final String ATTR_NAME_TYPE = "type";
    public static final String ATTR_NAME_ID = "id";
    public static final String ATTR_NAME_ARIA_DESCRIBEDBY = "aria-describedby";
    public static final String ATTR_NAME_PLACEHOLDER = "placeholder";
    public static final String ATTR_NAME_EMAIL_HELP = "emailHelp";
    public static final String ATTR_NAME_FOR = "for";
    public static final String ATTR_VALUE_SUBMIT = "submit";
    public static final String ATTR_VALUE_EXAMPLE_CHECK_1 = "exampleCheck1";
    public static final String ATTR_VALUE_EXAMPLE_INPUT_PASSWORD_1 = "exampleInputPassword1";
    public static final String ATTR_VALUE_CHECKBOX = "checkbox";
    public static final String ATTR_VALUE_EMAIL = "email";
    public static final String ATTR_VALUE_EXAMPLE_INPUT_EMAIL_1 = "exampleInputEmail1";
    public static final String TAG_NAMR_SMALL = "small";
    public static final String TAG_NAME_LABEL = "label";
    public static final String TAG_NAME_INPUT = "input";
    public static final String TAG_NAME_BUTTON = "button";
    public static final String CLASS_NAME_FORM_CHECK_LABEL = "form-check-label";
    public static final String CLASS_NAME_BTN_BTN_PRIMARY = "btn btn-primary";
    public static final String CLASS_NAME_FORM_TEXT_TEXT_MUTED = "form-text text-muted";
    public static final String CLASS_NAME_FORM_CHECK_INPUT = "form-check-input";
    public static final String CLASS_NAME_FORM_CONTROL = "form-control";

    private static String emailPlaceholder = "Enter email";
    private static String emailText = "Email address";
    private static String emailHelp = "We'll never share your email with anyone else.";
    private static String passwordValue = "Password";
    private static String acceptLabelText = "Check me out";
    private static String submitText = "Submit";
    private static String emailSet = "email@example.com";
    private static String passwordSet = "password123";
    public static FormSignUp DEFAULT_CREDENTIALS = defaultUser();
    public static FormSignUp EMPTY_CONTACT = emptyUser();
    public static FormSignUp INCORRECT_EMAIL = defaultUser().set(c -> c.email = "wrong email");
    public static FormSignUp INCORRECT_PASS = defaultUser().set(c -> c.password = "wrong pass");
    public static FormSignUp INCORRECT_ACCEPT = defaultUser().set(c -> c.accept = false);
    public static FormSignUp ONLY_NAME_FILLED_DEFAULT_CONTACT = defaultUser().set(c -> {
        c.password = "";
        c.accept = false;
    });

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] fieldCheck() {
        return new Object[][]{
                {INCORRECT_EMAIL}, {INCORRECT_PASS}, {INCORRECT_ACCEPT}
        };
    }

    @Test
    public void isValidationTests() {
        formOverview.emailLabel.is()
                .displayed()
                .enabled()
                .core()
                .attr(ATTR_NAME_FOR, ATTR_VALUE_EXAMPLE_INPUT_EMAIL_1)
                .text(emailText)
                .tag(TAG_NAME_LABEL);

        formOverview.email.is()
                .displayed()
                .enabled()
                .core()
                .cssClass(CLASS_NAME_FORM_CONTROL)
                .attr(ATTR_NAME_TYPE, ATTR_VALUE_EMAIL)
                .attr(ATTR_NAME_ID, ATTR_VALUE_EXAMPLE_INPUT_EMAIL_1)
                .attr(ATTR_NAME_ARIA_DESCRIBEDBY, ATTR_NAME_EMAIL_HELP)
                .attr(ATTR_NAME_PLACEHOLDER, emailPlaceholder)
                .tag(TAG_NAME_INPUT);

        formOverview.help.is()
                .displayed()
                .enabled()
                .core()
                .attr(ATTR_NAME_ID, ATTR_NAME_EMAIL_HELP)
                .cssClass(CLASS_NAME_FORM_TEXT_TEXT_MUTED)
                .text(emailHelp)
                .value(emailHelp)
                .tag(TAG_NAMR_SMALL);

        formOverview.passwordLabel.is()
                .displayed()
                .enabled()
                .core()
                .value(passwordValue)
                .text(passwordValue)
                .attr(ATTR_NAME_FOR, ATTR_VALUE_EXAMPLE_INPUT_PASSWORD_1)
                .tag(TAG_NAME_LABEL);

        formOverview.password.is()
                .displayed()
                .enabled()
                .core()
                .cssClass(CLASS_NAME_FORM_CONTROL)
                .attr(ATTR_NAME_TYPE, passwordValue.toLowerCase())
                .attr(ATTR_NAME_ID, ATTR_VALUE_EXAMPLE_INPUT_PASSWORD_1)
                .attr(ATTR_NAME_PLACEHOLDER, passwordValue)
                .tag(TAG_NAME_INPUT);

        formOverview.accept.is()
                .displayed()
                .enabled()
                .core()
                .cssClass(CLASS_NAME_FORM_CHECK_INPUT)
                .attr(ATTR_NAME_TYPE, ATTR_VALUE_CHECKBOX)
                .attr(ATTR_NAME_ID, ATTR_VALUE_EXAMPLE_CHECK_1)
                .tag(TAG_NAME_INPUT);

        formOverview.acceptLabel.is()
                .displayed()
                .enabled()
                .core()
                .text(acceptLabelText)
                .value(acceptLabelText)
                .cssClass(CLASS_NAME_FORM_CHECK_LABEL)
                .attr(ATTR_NAME_FOR, ATTR_VALUE_EXAMPLE_CHECK_1)
                .tag(TAG_NAME_LABEL);

        formOverview.submit.is()
                .displayed()
                .enabled()
                .core()
                .cssClass(CLASS_NAME_BTN_BTN_PRIMARY)
                .attr(ATTR_NAME_TYPE, ATTR_VALUE_SUBMIT)
                .text(submitText)
                .value(submitText)
                .tag(TAG_NAME_BUTTON);
    }

    @Test
    public void checkboxTests() {
        formOverview.accept.check();
        formOverview.accept.is().selected();
        formOverview.accept.uncheck();
        formOverview.accept.is().deselected();
    }

    @Test
    public void fillTest() {
        formOverview.fill(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
        checkContactFormSubmitted();
    }

    @Test(dataProvider = "fieldCheck",
            expectedExceptions = {RuntimeException.class},
            expectedExceptionsMessageRegExp = ".*Check form failed:.*")
    public void fillNegativeTest(FormSignUp INCORRECT_CREDENTIALS) {

        formOverview.fill(DEFAULT_CREDENTIALS);
        formOverview.check(INCORRECT_CREDENTIALS);
        checkContactFormSubmitted();
    }

    @Test
    public void submitEntityToContactFormTest() {
        formOverview.submit(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void submitTextToContactFormTest() {
        refresh();
        formOverview.submit(emailSet);
        formOverview.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void emptyFormTest() {
        refresh();
        formOverview.check(EMPTY_CONTACT);
    }

    @Test
    public void verifyMethodTest() {
        formOverview.fill(DEFAULT_CREDENTIALS);
        List<String> verified = formOverview.verify(DEFAULT_CREDENTIALS);
        assertEquals(verified.size(), 0);
    }

    @Test
    public void sendMethodTest() {
        formOverview.fill(DEFAULT_CREDENTIALS);
        formOverview.send();
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void sendEntityMethodTest() {
        formOverview.send(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void addEntityMethodTest() {
        formOverview.add(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void publishMethodTest() {
        formOverview.publish(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void saveMethodTest() {
        formOverview.save(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    @Test
    public void updateMethodTest() {
        formOverview.update(DEFAULT_CREDENTIALS);
        formOverview.check(DEFAULT_CREDENTIALS);
    }

    private void checkContactFormSubmitted() {
        formOverview.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }

    private static FormSignUp defaultUser() {
        return new FormSignUp().set(c -> {
            c.email = emailSet;
            c.password = passwordSet;
            c.accept = true;
        });
    }

    private static FormSignUp emptyUser() {
        return new FormSignUp().set(c -> {
            c.email = "";
            c.password = "";
            c.accept = false;
        });
    }
}
