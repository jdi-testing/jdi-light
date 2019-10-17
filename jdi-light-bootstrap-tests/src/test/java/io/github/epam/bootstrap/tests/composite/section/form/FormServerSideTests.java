package io.github.epam.bootstrap.tests.composite.section.form;

import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.entities.FormUsers.ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.BLANK_CONTACT;
import static io.github.com.entities.FormUsers.DEFAULT_CHECK;
import static io.github.com.entities.FormUsers.DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.ONLY_NAME_FILLED_DEFAULT_CONTACT;
import static io.github.com.entities.FormUsers.clearBlankContact;
import static io.github.com.pages.BootstrapPage.formServerSide;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 11.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class FormServerSideTests extends TestsInit {

    private String name = "Dmitrii";
    private String lastName = "Pavlov";
    private String userName = "Delnote";
    private String city = "Saint-Petersburg";
    private String state = "North capital";
    private String zip = "190000";
    private String accept = "true";
    private String positiveTooltip = "Looks good!";
    private String negativeTooltip = "Please provide a valid";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formServerSide.name, "First name", "Mark"},
                {formServerSide.lastName, "Last name", "Otto"},
                {formServerSide.userName, "Username", ""},
                {formServerSide.city, "City", ""},
                {formServerSide.state, "State", ""},
                {formServerSide.zip, "Zip", ""}
        };
    }

    @Test(dataProvider = "listData")
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
    }

    @Test
    public void isValidationTests() {
        formServerSide.accept
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("form-check-input")
                .tag(is("input"));
        formServerSide.accept.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Agree to terms and conditions"))
                .tag(is("label"));
    }

    @Test
    public void tooltipTests() {
        checkContactFormSubmitted();
        formServerSide.feedbackName
                .is()
                .displayed()
                .core()
                .hasClass("valid-feedback")
                .text(is(positiveTooltip));
        formServerSide.feedbackLastName
                .is()
                .displayed()
                .core()
                .hasClass("valid-feedback")
                .text(is(positiveTooltip));
        formServerSide.feedbackUserName
                .is()
                .displayed()
                .core()
                .hasClass("invalid-feedback")
                .text(is("Please choose a username."));
        formServerSide.feedbackCity
                .is()
                .displayed()
                .core()
                .hasClass("invalid-feedback")
                .text(is(negativeTooltip + " city."));
        formServerSide.feedbackState
                .is()
                .displayed()
                .core()
                .hasClass("invalid-feedback")
                .text(is(negativeTooltip + " state."));
        formServerSide.feedbackZip
                .is()
                .displayed()
                .core()
                .hasClass("invalid-feedback")
                .text(is(negativeTooltip + " zip."));
        formServerSide.feedbackAccept
                .is()
                .displayed()
                .core()
                .hasClass("invalid-feedback")
                .text(is("You must agree before submitting."));
    }

    @Test
    public void checkboxTests() {
        formServerSide.accept.check();
        formServerSide.accept.is().selected();
        formServerSide.accept.uncheck();
        formServerSide.accept.is().deselected();
    }

    @Test
    public void fillTest() {
        formServerSide.fill(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void customFillingTest() {
        formServerSide.fill(BLANK_CONTACT.set(c -> c.name = name));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.lastName = lastName));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.userName = userName));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.city = city));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.state = state));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.zip = zip));
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT);
        formServerSide.fill(BLANK_CONTACT.set(c -> c.accept = accept));
        checkContactFormSubmitted();
        formServerSide.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void directFillingTest() {
        formServerSide.name.clear();
        formServerSide.lastName.clear();
        formServerSide.name.setValue(name);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.name = name));
        formServerSide.lastName.setValue(lastName);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.lastName = lastName));
        formServerSide.userName.sendKeys(userName);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.userName = userName));
        formServerSide.city.sendKeys(city);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.city = city));
        formServerSide.state.sendKeys(state);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.state = state));
        formServerSide.zip.sendKeys(zip);
        checkContactFormSubmitted();
        formServerSide.check(BLANK_CONTACT.set(c -> c.zip = zip));
        formServerSide.accept.setValue(accept);
        checkContactFormSubmitted();
        formServerSide.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void submitTextToContactFormTest() {
        formServerSide.submit("Roman");
        formServerSide.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formServerSide.submit(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formServerSide.submit("Roman", "submit");
        formServerSide.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formServerSide.fill(DEFAULT_CONTACT);
        List<String> verified = formServerSide.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formServerSide.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formServerSide.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formServerSide.fill(DEFAULT_CONTACT);
        formServerSide.send();
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formServerSide.send(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formServerSide.add(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formServerSide.publish(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formServerSide.save(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formServerSide.update(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formServerSide.cancel(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formServerSide.close(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formServerSide.back(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formServerSide.select(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formServerSide.next(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formServerSide.search(DEFAULT_CONTACT);
        formServerSide.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formServerSide.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
