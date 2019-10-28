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
import static io.github.com.pages.BootstrapPage.formBrowserDefaults;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 11.10.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class FormBrowserDefaultsTests extends TestsInit {

    private String name = "Dmitrii";
    private String lastName = "Pavlov";
    private String userName = "Delnote";
    private String city = "Saint-Petersburg";
    private String state = "North capital";
    private String zip = "190000";
    private String accept = "true";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @DataProvider
    public Object[][] listData() {
        return new Object[][]{
                {formBrowserDefaults.name, "First name", "Mark"},
                {formBrowserDefaults.lastName, "Last name", "Otto"},
                {formBrowserDefaults.userName, "Username", ""},
                {formBrowserDefaults.city, "City", ""},
                {formBrowserDefaults.state, "State", ""},
                {formBrowserDefaults.zip, "Zip", ""}
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
        formBrowserDefaults.accept
                .is()
                .displayed()
                .enabled()
                .core()
                //.attr("type", "checkbox")
                .hasClass("form-check")
                .tag(is("div"));
        formBrowserDefaults.accept.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Agree to terms and conditions"))
                .tag(is("label"));
    }

    @Test
    public void checkboxTests() {
        formBrowserDefaults.accept.check();
        formBrowserDefaults.accept.is().selected();
        formBrowserDefaults.accept.uncheck();
        formBrowserDefaults.accept.is().deselected();
    }

    @Test
    public void fillTest() {
        formBrowserDefaults.fill(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CONTACT);
        checkContactFormSubmitted();
    }

    @Test
    public void customFillingTest() {
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.name = name));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.lastName = lastName));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.userName = userName));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.city = city));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.state = state));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.zip = zip));
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT);
        formBrowserDefaults.fill(BLANK_CONTACT.set(c -> c.accept = accept));
        checkContactFormSubmitted();
        formBrowserDefaults.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void directFillingTest() {
        formBrowserDefaults.name.clear();
        formBrowserDefaults.lastName.clear();
        formBrowserDefaults.name.setValue(name);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.name = name));
        formBrowserDefaults.lastName.setValue(lastName);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.lastName = lastName));
        formBrowserDefaults.userName.sendKeys(userName);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.userName = userName));
        formBrowserDefaults.city.sendKeys(city);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.city = city));
        formBrowserDefaults.state.sendKeys(state);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.state = state));
        formBrowserDefaults.zip.sendKeys(zip);
        checkContactFormSubmitted();
        formBrowserDefaults.check(BLANK_CONTACT.set(c -> c.zip = zip));
        formBrowserDefaults.accept.setValue(accept);
        checkContactFormSubmitted();
        formBrowserDefaults.check(DEFAULT_CHECK);
        clearBlankContact();
    }

    @Test
    public void submitTextToContactFormTest() {
        formBrowserDefaults.submit("Roman");
        formBrowserDefaults.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void submitEntityToContactFormTest() {
        formBrowserDefaults.submit(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void submitTextToContactFormUsingCustomButtonTest() {
        formBrowserDefaults.submit("Roman", "submit");
        formBrowserDefaults.check(ONLY_NAME_FILLED_DEFAULT_CONTACT);
    }

    @Test
    public void verifyMethodPositiveTest() {
        formBrowserDefaults.fill(DEFAULT_CONTACT);
        List<String> verified = formBrowserDefaults.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(0));
    }

    @Test
    public void verifyMethodNegativeTest() {
        formBrowserDefaults.fill(ALL_EXCEPT_NAME_FILLED_DEFAULT_CONTACT);
        List<String> verified = formBrowserDefaults.verify(DEFAULT_CONTACT);
        jdiAssert(verified, hasSize(1));
        jdiAssert(verified.get(0), containsString("Mark"));
    }

    @Test
    public void sendMethodTest() {
        formBrowserDefaults.fill(DEFAULT_CONTACT);
        formBrowserDefaults.send();
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void sendEntityMethodTest() {
        formBrowserDefaults.send(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void addEntityMethodTest() {
        formBrowserDefaults.add(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void publishMethodTest() {
        formBrowserDefaults.publish(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void saveMethodTest() {
        formBrowserDefaults.save(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void updateMethodTest() {
        formBrowserDefaults.update(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void cancelMethodTest() {
        formBrowserDefaults.cancel(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void closeMethodTest() {
        formBrowserDefaults.close(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void backMethodTest() {
        formBrowserDefaults.back(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void selectMethodTest() {
        formBrowserDefaults.select(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void nextMethodTest() {
        formBrowserDefaults.next(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    @Test
    public void searchMethodTest() {
        formBrowserDefaults.search(DEFAULT_CONTACT);
        formBrowserDefaults.check(DEFAULT_CHECK);
    }

    private void checkContactFormSubmitted() {
        formBrowserDefaults.submit();
        validateAlert(is("Form filled and submitted successfully"));
    }
}
